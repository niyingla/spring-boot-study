package com.imooc.architect.showcase.bean.support;

import com.imooc.architect.showcase.bean.lifecycle.CustomBeanPostProcessor;
import com.imooc.architect.showcase.bean.support.HelloBean;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

class HelloBeanTest {

    /**
     * 验证bean生命周期回调
     */
    @org.junit.jupiter.api.Test
    void sayHello() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        ClassPathResource resource = new ClassPathResource("spring/hello-bean.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);

        HelloBean bean = beanFactory.getBean("helloBean",HelloBean.class);
        Assertions.assertNotNull(bean);
        bean.sayHello();
        beanFactory.destroySingletons();
    }


}