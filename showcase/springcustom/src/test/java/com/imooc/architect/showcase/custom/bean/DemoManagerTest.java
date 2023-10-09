package com.imooc.architect.showcase.custom.bean;

import com.imooc.architect.showcase.custom.factory.DemoServiceFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
class DemoManagerTest {
    @Configuration
    @ComponentScan(basePackageClasses = DemoModel.class)
    public static class ConfigBean {
        @Bean
        public DemoServiceFactoryBean demoServiceFactoryBean() {
            return new DemoServiceFactoryBean();
        }
    }


    @Test
    void createDemoModel() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigBean.class);
        context.refresh();

        DemoManager bean = context.getBean(DemoManager.class);
        log.info("bean = {}",bean);

    }
}