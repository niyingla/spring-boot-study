package com.imooc.architect.showcase.wheel.aop;

import com.imooc.architect.showcase.wheel.demo.DemoDao;
import com.imooc.architect.showcase.wheel.demo.DemoModel;
import com.imooc.architect.showcase.wheel.ioc.ApplicationContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CglibAopProxyTest {
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