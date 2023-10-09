package com.imooc.architect.showcase.aop;

import com.imooc.architect.showcase.bean.Hello;
import com.imooc.architect.showcase.bean.support.HelloBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig({AopJavaConfig.class})
class LogAspectTest {

    @Autowired
    private HelloBean helloBean;
    @Autowired
    private Hello hello;

    @Test
    public void testSayHello() {
        hello.sayHello();
    } @Test
    public void testHelloBean() {
        helloBean.sayHello();
    }
}