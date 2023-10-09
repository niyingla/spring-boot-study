package com.imooc.architect.showcase.wheel.ioc;

public interface BeanPostProcessor {
    public default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    public default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
