package com.imooc.architect.showcase.custom.bean;

import com.imooc.architect.showcase.custom.annoation.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jimmy
 */
@MyComponent
public class DemoManager {
    @Autowired
    private DemoService demoService;

    public DemoModel createDemoModel(DemoModel model) {
        return demoService.createDemoModel(model);
    }

}
