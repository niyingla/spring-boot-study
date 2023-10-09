package com.imooc.architect.spring.showcase;

import com.imooc.architect.spring.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootConfiguration
@SpringBootTest(properties = "")
class DemoApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testContext(){
        ContextUtils.printlnBeansClassName(context);
    }
}