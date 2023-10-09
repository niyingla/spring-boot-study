package com.imooc.architect.showcase.bean.support;

import com.imooc.architect.showcase.bean.support.HelloContext;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class HelloContextTest {

    /**
     * 通过AnnotationConfigApplicationContext构建IOC容器
     *
     * 验证bean生命周期回调
     */
    @org.junit.jupiter.api.Test
    void sayHello() {
        String packageName = HelloContext.class.getPackage().getName();
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(packageName);
        HelloContext bean = context.getBean(HelloContext.class);
        Assertions.assertNotNull(bean);
        bean.sayHello();
        context.close();
    }
}