package com.imooc.architect.showcase.custom.bean;

//@Service
public class DemoService implements ModuleNameable {
//    @Autowired
    private DemoDao demoDao;

    public DemoService(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

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
