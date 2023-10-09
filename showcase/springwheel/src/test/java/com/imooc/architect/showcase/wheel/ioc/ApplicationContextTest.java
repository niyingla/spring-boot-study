package com.imooc.architect.showcase.wheel.ioc;

import com.imooc.architect.showcase.wheel.demo.DemoDao;
import com.imooc.architect.showcase.wheel.demo.DemoModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ApplicationContextTest {

    @Test
    public void testContext() {
        ApplicationContext context = new ApplicationContext("com.imooc.architect.showcase.wheel.demo");
        int beanCount = context.getBeanCount();
        log.info("beanCount = {}", beanCount);
        Object bean = context.getBean("DemoService");
        log.info("bean = {}", bean.getClass().getSimpleName());

    }

    @Test
    public void testContextStep() {
        ApplicationContext context = new ApplicationContext();
        context.registerPackage("com.imooc.architect.showcase.wheel.demo");
        context.refresh();
        int beanCount = context.getBeanCount();
        log.info("beanCount = {}", beanCount);
        Object bean = context.getBean("DemoService");
        log.info("bean = {}", bean.getClass().getSimpleName());
        context.close();

    }
    @Test
    public void testAopContext() {
        ApplicationContext context = new ApplicationContext();
        context.registerPackage(DemoModel.class.getPackage().getName());
        context.refresh();

        log.info("beanCount = {}", context.getBeanCount());

        DemoDao demoDao = context.getBean(DemoDao.class);
        DemoModel model = new DemoModel();
        model.setName("demo1");
        demoDao.createDemoModel(model);
    }
}