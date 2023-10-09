package com.imooc.architect.showcase.bean.javaconfig;

import com.imooc.architect.showcase.bean.support.HelloBean;
import com.imooc.architect.showcase.bean.support.HelloContext;
import com.imooc.architect.showcase.bean.lifecycle.CustomBeanFactoryPostProcessor;
import com.imooc.architect.showcase.bean.lifecycle.CustomBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

class JavaConfigTest {
    /**
     * 验证bean生命周期回调
     */
    @org.junit.jupiter.api.Test
    void sayHello() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfig.class);
        HelloBean bean = applicationContext.getBean(HelloBean.class);
        Assertions.assertNotNull(bean);
        bean.sayHello();
        applicationContext.close();
    }

    @Configuration
    @ImportResource("spring/hello-context.xml")
    static class JavaConfigXml {

    }

    @org.junit.jupiter.api.Test
    void sayHelloXml() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfigXml.class);
        HelloContext bean = applicationContext.getBean(HelloContext.class);
        Assertions.assertNotNull(bean);
        bean.sayHello();
        applicationContext.close();
    }

    @org.junit.jupiter.api.Test
    void testFactoryBeanPostProcessor() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addBeanFactoryPostProcessor(new CustomBeanFactoryPostProcessor());
        context.register(JavaConfig.class);
        context.refresh();
    }
}