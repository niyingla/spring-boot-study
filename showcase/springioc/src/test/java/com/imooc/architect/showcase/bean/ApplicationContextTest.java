package com.imooc.architect.showcase.bean;

import com.imooc.architect.showcase.bean.javaconfig.JavaConfig;
import com.imooc.architect.showcase.bean.support.HelloContext;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    /**
     * 通过ClassPathXmlApplicationContext构建IOC容器
     */
    @org.junit.jupiter.api.Test
    void beanSayHello() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/hello-context.xml");
        HelloContext bean = context.getBean(HelloContext.class);
        Assertions.assertNotNull(bean);
        bean.sayHello();
        context.close();
    }

    /**
     * 通过AnnotationConfigApplicationContext 构建IOC容器
     */
    @org.junit.jupiter.api.Test
    void contextSayHello() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();
        HelloContext hello = context.getBean(HelloContext.class);
        Assertions.assertNotNull(hello);
        hello.sayHello();
        context.close();
    }
}
