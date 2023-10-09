package com.imooc.architect.showcase.aop;

import com.imooc.architect.showcase.bean.Hello;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class LogAspectXmlTest {
    @Test
    public void testAop() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("aop.xml");

        Hello hello = context.getBean(Hello.class);

        hello.sayHello();
    }

}