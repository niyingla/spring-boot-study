package com.imooc.architect.showcase.wheel.demo;


import javax.annotation.ManagedBean;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jimmy
 */
@ManagedBean
public class DemoDaoInMemory implements ModuleNameable, DemoDao {
    private transient Map<String,DemoModel> store = new ConcurrentHashMap<>();


    @Override
    public DemoModel createDemoModel(DemoModel model){
        return store.put(model.getName(),model);
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
