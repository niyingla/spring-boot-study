package com.imooc.architect.showcase.custom.config;

import com.imooc.architect.showcase.custom.bean.DemoModel;
import com.imooc.architect.showcase.custom.bean.ModuleNameable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
class CustomBeanPostProcessorTest {

    @Configuration
    @ComponentScan(basePackageClasses = DemoModel.class)
    public static class ConfigBean implements ModuleNameable{
//        @Bean
//        public CustomBeanPostProcessor customBeanPostProcessor(){
//            return new CustomBeanPostProcessor();
//        }

        private String moduleName;
        @Override
        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        @Override
        public String getModuleName() {
            return this.moduleName;
        }
    }

    @Test
    public void testBeanPost(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.addBeanPostProcessor(new CustomBeanPostProcessor());

        context.register(ConfigBean.class);
        context.refresh();

        String[] names = context.getBeanNamesForType(ModuleNameable.class);
        for (String name : names) {
            ModuleNameable bean = context.getBean(name, ModuleNameable.class);
            log.info("bean = {} , moduleName = {}",bean.getClass().getSimpleName(),bean.getModuleName());
        }

    }
}