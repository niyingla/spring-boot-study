package com.imooc.architect.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jimmy
 */
@SpringBootApplication
public class DataApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DataApplication.class, args);
        ContextUtils.printlnBeansClassName(context);

    }
}
