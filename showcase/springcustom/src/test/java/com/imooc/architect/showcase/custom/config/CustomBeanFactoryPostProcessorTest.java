package com.imooc.architect.showcase.custom.config;

import com.imooc.architect.showcase.custom.bean.DemoModel;
import com.imooc.architect.showcase.custom.bean.ModuleNameable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
class CustomBeanFactoryPostProcessorTest {

    @Configuration
    @ComponentScan(basePackageClasses = DemoModel.class)
    public static class ConfigBean implements ModuleNameable {

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
        context.addBeanFactoryPostProcessor(new CustomBeanFactoryPostProcessor());
        context.register(ConfigBean.class);
        context.refresh();


    }
}