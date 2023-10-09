package com.imooc.architect.showcase.bean.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * BeanPostProcessor Bean前后处理器
 * InstantiationAwareBeanPostProcessor 实例化前后处理
 * @author jimmy
 */
@Slf4j
public class CustomBeanPostProcessor implements BeanPostProcessor,
        InstantiationAwareBeanPostProcessor, DestructionAwareBeanPostProcessor {
    /**
     * 执行Before销毁 BeanPostProcessor.postProcessBeforeDestruction
     * @param bean
     * @param beanName
     * @throws BeansException
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        log.warn("执行Before销毁 BeanPostProcessor.postProcessBeforeDestruction  {}", beanName);
    }

    /**
     * 执行Before实例化 BeanPostProcessor.postProcessBeforeInstantiation
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.warn("执行Before实例化 BeanPostProcessor.postProcessBeforeInstantiation  {}", beanName);
        return null;
    }

    /**
     * 执行After实例化 BeanPostProcessor.postProcessAfterInstantiation
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.warn("执行After实例化 BeanPostProcessor.postProcessAfterInstantiation  {}", beanName);
        return true;
    }

    /**
     * 执行属性处理 BeanPostProcessor.postProcessProperties
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        log.warn("执行属性处理 BeanPostProcessor.postProcessProperties  {}", beanName);
        return null;
    }

    /**
     * 执行Before初始化 BeanPostProcessor.postProcessBeforeInitialization
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.warn("执行Before初始化 BeanPostProcessor.postProcessBeforeInitialization  {}", beanName);
        return bean;
    }

    /**
     * 执行After初始化 BeanPostProcessor.postProcessAfterInitialization
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.warn("执行After初始化 BeanPostProcessor.postProcessAfterInitialization  {}", beanName);
        return bean;
    }
}
