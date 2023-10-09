package com.imooc.architect.showcase.custom.config;

import com.imooc.architect.showcase.custom.bean.DemoDaoInMemory;
import com.imooc.architect.showcase.custom.bean.ModuleNameable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author jimmy
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DemoDaoInMemory){
            return new DemoDaoInMemory();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ModuleNameable){
            ((ModuleNameable) bean).setModuleName("springCustomModule");
        }
        return bean;
    }
}
