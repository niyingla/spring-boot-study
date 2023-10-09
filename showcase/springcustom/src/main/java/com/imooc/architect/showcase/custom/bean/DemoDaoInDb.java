package com.imooc.architect.showcase.custom.bean;

public class DemoDaoInDb implements DemoDao{
    @Override
    public DemoModel createDemoModel(DemoModel model) {
        throw new UnsupportedOperationException();
    }
}
