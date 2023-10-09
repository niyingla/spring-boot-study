package com.imooc.architect.showcase.custom.config;

import com.imooc.architect.showcase.custom.bean.DemoDaoInMemory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@Slf4j
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            Class<?> beanType = beanFactory.getType(name);
            log.info("bean = {}", beanType.getSimpleName());
            if (beanType != null) {
                if (DemoDaoInMemory.class.equals(beanType)) {
                    log.warn("bean {} only support use in dev", beanType.getSimpleName());
                }
            }
        }
    }
}
