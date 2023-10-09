package com.imooc.architect.showcase.wheel.aop;

import com.imooc.architect.showcase.wheel.aop.advisor.AspectJPointcutAdvisor;
import com.imooc.architect.showcase.wheel.ioc.BeanFactory;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;
import java.util.Collection;

public class AspectAnnotationParse {
    private BeanFactory beanFactory;
    private AopBeanPostProcessor aopBeanPostProcessor;

    public AspectAnnotationParse(BeanFactory beanFactory, AopBeanPostProcessor aopBeanPostProcessor) {
        this.beanFactory = beanFactory;
        this.aopBeanPostProcessor = aopBeanPostProcessor;
        this.parse();
    }

    public void parse() {
        Collection<Class<?>> registerClass = beanFactory.getRegisterClass();
        for (Class<?> aClass : registerClass) {
            boolean present = aClass.isAnnotationPresent(Aspect.class);
            if (present) {
                parseAspect(aClass);
            }
        }
    }

    private void parseAspect(Class<?> aClass) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            boolean present = declaredMethod.isAnnotationPresent(Around.class);
            if (present) {
                Around annotation = declaredMethod.getAnnotation(Around.class);
                aopBeanPostProcessor.registerAdvisor(new AspectJPointcutAdvisor(BeanFactory.typeToBeanName(aClass), annotation.value()));
            }
        }
    }
}
