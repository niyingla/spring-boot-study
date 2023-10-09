package com.imooc.architect.showcase.custom.factory;

import com.imooc.architect.showcase.custom.bean.DemoDao;
import com.imooc.architect.showcase.custom.bean.DemoDaoInMemory;
import com.imooc.architect.showcase.custom.bean.DemoService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoServiceFactoryBean implements FactoryBean<DemoService>, InitializingBean {
    private DemoService object;

    @Autowired(required = false)
    public void setDemoDao(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    private DemoDao demoDao;


    @Override
    public DemoService getObject() throws Exception {
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return DemoService.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(demoDao !=null){
            object = new DemoService(demoDao);
        }else{
            object = new DemoService(new DemoDaoInMemory());
        }
        object.setModuleName("createByFactoryBean");
    }
}
