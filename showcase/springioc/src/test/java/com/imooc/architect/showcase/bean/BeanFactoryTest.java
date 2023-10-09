package com.imooc.architect.showcase.bean;

import com.imooc.architect.showcase.bean.lifecycle.CustomBeanPostProcessor;
import com.imooc.architect.showcase.bean.support.HelloBean;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {
    /**
     * 通过DefaultListableBeanFactory手工构建IOC容器
     */
    @org.junit.jupiter.api.Test
    void sayHello() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        ClassPathResource resource = new ClassPathResource("spring/hello-bean.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);

        HelloBean bean = beanFactory.getBean(HelloBean.class);
        Assertions.assertNotNull(bean);
        bean.sayHello();
    }

    /**
     * 验证 bean生命周期 + BeanPostProcessor
     */
    @org.junit.jupiter.api.Test
    void sayHelloPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new CustomBeanPostProcessor());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        ClassPathResource resource = new ClassPathResource("spring/hello-bean.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);
        HelloBean bean = beanFactory.getBean("helloBean",HelloBean.class);
        Assertions.assertNotNull(bean);
        bean.sayHello();

        beanFactory.destroySingletons();

    }
}
