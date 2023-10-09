package com.imooc.architect.showcase.bean.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author jimmy
 */
@Slf4j
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor,
        BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.error("执行BeanFactoryPostProcessor.postProcessBeanFactory; beans count = {}", beanFactory.getBeanDefinitionCount());
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.error("执行BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry; beans count = {}", registry.getBeanDefinitionCount());
    }
}
