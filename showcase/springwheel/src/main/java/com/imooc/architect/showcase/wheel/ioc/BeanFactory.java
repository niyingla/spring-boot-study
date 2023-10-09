package com.imooc.architect.showcase.wheel.ioc;

import com.imooc.architect.showcase.wheel.aop.AopBeanPostProcessor;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    private final Map<String, Object> beans = new ConcurrentHashMap<>();
    private final Map<String, Class<?>> classMap = new ConcurrentHashMap<>();
    private BeanPostProcessor beanPostProcessor;

    public BeanFactory() {
        this.beanPostProcessor = new AopBeanPostProcessor(this);
    }

    public Object getBean(String beanName) {
        Object bean = this.beans.get(beanName);
        if (bean != null) {
            return bean;
        }
        Class<?> aClass = this.classMap.get(beanName);
        if (aClass != null) {
            Object object = newInstance(aClass);
            processInject(object);
            if (beanPostProcessor !=null){
                object = beanPostProcessor.postProcessAfterInitialization(object, beanName);
            }
            this.beans.put(beanName, object);
            return object;
        }
        return null;
    }

    private void processInject(Object object) {
        Class<? extends Map> beansClass = beans.getClass();
        Field[] fields = beansClass.getDeclaredFields();
        if (ArrayUtils.isNotEmpty(fields)) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(Resource.class)) {
                    Class<?> fieldType = field.getType();
                    Object bean = getBean(fieldType);
                    if (bean != null) {
                        try {
                            field.setAccessible(true);
                            field.set(object, bean);
                        } catch (IllegalAccessException e) {
                            throw new IllegalStateException(e);
                        }
                    } else {
                        throw new IllegalStateException("not found bean :" + fieldType);
                    }
                }
            }
        }
    }

    private Object newInstance(Class<?> aClass) {
        try {
            return aClass.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> T getBean(Class<T> clazz) {
        Object bean = getBean(typeToBeanName(clazz));
        if(bean!=null){
            return (T) bean;
        }
        //
        Collection<Class<?>> classes = classMap.values();
        for (Class<?> aClass : classes) {
            Class<?>[] interfaces = aClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                if(clazz == anInterface){
                    return (T) getBean(aClass);
                }
            }
        }
        return null;
    }

    public void removeBean(String beanName) {

    }

    public void registerBean(String beanName, Object bean) {

    }

    public boolean containsBean(String beanName) {
        return false;
    }

    public void registerClass(Class<?> clazz) {
        String key = typeToBeanName(clazz);
        this.classMap.put(key, clazz);
    }

    public static String typeToBeanName(Class<?> clazz) {
        return clazz.getSimpleName();
    }

    public String[] getBeanNames() {
        return this.classMap.keySet().toArray(new String[0]);
    }

    public void close() {
        this.beans.clear();
        this.classMap.clear();
    }

    public int getBeanCount() {
        return this.classMap.size();
    }

    public Collection<Class<?>> getRegisterClass() {
        return this.classMap.values();
    }
}
