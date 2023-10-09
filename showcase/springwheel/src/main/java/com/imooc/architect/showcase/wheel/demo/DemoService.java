package com.imooc.architect.showcase.wheel.demo;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;

@ManagedBean
public class DemoService implements ModuleNameable {
    @Resource
    private DemoDao demoDao;


    public DemoModel createDemoModel(DemoModel model) {
        return demoDao.createDemoModel(model);
    }

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
