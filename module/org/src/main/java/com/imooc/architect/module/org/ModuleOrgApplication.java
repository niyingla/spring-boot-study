package com.imooc.architect.module.org;

import com.imooc.architect.spring.ContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jimmy
 */
@SpringBootApplication
public class ModuleOrgApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ModuleOrgApplication.class, args);
        ContextUtils.printlnBeansClassName(context);
    }
}
