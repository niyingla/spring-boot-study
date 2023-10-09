package com.imooc.architect.showcase.wheel.demo;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;

/**
 * @author jimmy
 */
@ManagedBean
public class DemoManager {
    @Resource
    private DemoService demoService;

    public DemoModel createDemoModel(DemoModel model) {
        return demoService.createDemoModel(model);
    }

}
