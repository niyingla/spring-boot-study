package com.imooc.architect.showcase.custom.factory;

import com.imooc.architect.showcase.custom.bean.DemoModel;
import com.imooc.architect.showcase.custom.bean.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
class DemoServiceFactoryBeanTest {
    @Configuration
    @ComponentScan(basePackageClasses = DemoModel.class)
    public static class ConfigBean {
        @Bean
        public DemoServiceFactoryBean demoServiceFactoryBean() {
            return new DemoServiceFactoryBean();
        }
    }

    @Test
    public void testBeanPost() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConfigBean.class);
        context.refresh();

        DemoService bean = context.getBean(DemoService.class);
        log.info("moduleName = {}",bean.getModuleName());

    }
}