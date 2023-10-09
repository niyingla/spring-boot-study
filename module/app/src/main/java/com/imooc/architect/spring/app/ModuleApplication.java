package com.imooc.architect.spring.app;

import com.imooc.architect.spring.ContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jimmy
 */
@SpringBootApplication
public class ModuleApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ModuleApplication.class, args);
        ContextUtils.printlnBeansClassName(context);

    }
}
