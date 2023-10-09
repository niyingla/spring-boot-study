package com.imooc.architect.showcase.wheel.aop;

import com.google.common.collect.Lists;
import com.imooc.architect.showcase.wheel.aop.advisor.Advisor;
import com.imooc.architect.showcase.wheel.aop.advisor.PointcutAdvisor;
import com.imooc.architect.showcase.wheel.aop.pointcut.Pointcut;
import com.imooc.architect.showcase.wheel.ioc.BeanFactory;
import com.imooc.architect.showcase.wheel.ioc.BeanPostProcessor;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AopBeanPostProcessor implements BeanPostProcessor {
    private List<Advisor> advisors;
    private BeanFactory beanFactory;
    private AspectAnnotationParse aspectAnnotationParse;
    public AopBeanPostProcessor(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        this.advisors = new ArrayList<>();
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if(this.aspectAnnotationParse == null){
            this.aspectAnnotationParse = new AspectAnnotationParse(beanFactory,this);
        }
        List<Advisor> advisors = getMatchedAdvisors(bean, beanName);
        if (CollectionUtils.isNotEmpty(advisors)) {
            bean = this.createProxy(bean, advisors);
        }
        return bean;
    }
    private Object createProxy(Object bean, List<Advisor> advisors) {
        return new CglibAopProxy(bean, advisors, beanFactory).getProxy();
    }
    private List<Advisor> getMatchedAdvisors(Object bean, String beanName) {
        if (CollectionUtils.isEmpty(advisors)) {
            return null;
        }
        Class<?> beanClass = bean.getClass();
        List<Method> allMethods = this.getAllMethodForClass(beanClass);

        List<Advisor> matchAdvisors = new ArrayList<>();
        for (Advisor ad : this.advisors) {
            if (ad instanceof PointcutAdvisor) {
                if (isPointcutMatchBean((PointcutAdvisor) ad, beanClass, allMethods)) {
                    matchAdvisors.add(ad);
                }
            }
        }

        return matchAdvisors;
    }
    private boolean isPointcutMatchBean(PointcutAdvisor pointcutAdvisor, Class<?> beanClass, List<Method> methods) {
        Pointcut pointcut = pointcutAdvisor.getPointcut();

        if (!pointcut.matchClass(beanClass)) {
            return false;
        }

        for (Method method : methods) {
            if (pointcut.matchMethod(method, beanClass)) {
                return true;
            }
        }
        return false;
    }
    private List<Method> getAllMethodForClass(Class<?> beanClass) {

        Method[] declaredMethods = beanClass.getDeclaredMethods();

        return Lists.newArrayList(declaredMethods);
    }

    public void registerAdvisor(Advisor ad) {
        this.advisors.add(ad);
    }
}
