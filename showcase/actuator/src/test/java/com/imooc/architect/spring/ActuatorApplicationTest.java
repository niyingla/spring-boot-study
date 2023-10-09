package com.imooc.architect.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ActuatorApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testContext(){
        ContextUtils.printlnBeansClassName(context);
    }
}