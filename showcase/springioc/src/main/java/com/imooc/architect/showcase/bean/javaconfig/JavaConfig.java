package com.imooc.architect.showcase.bean.javaconfig;

import com.imooc.architect.showcase.bean.support.HelloContext;
import com.imooc.architect.showcase.bean.lifecycle.CustomBeanFactoryPostProcessor;
import com.imooc.architect.showcase.bean.lifecycle.CustomBeanPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jimmy
 */
@Configuration
public class JavaConfig {

    @Bean
    public String name() {
        return "Jimmy";
    }

    @Bean
    public HelloContext HelloContext() {
        return new HelloContext("Tom");
    }

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new CustomBeanPostProcessor();
    }

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }
}
