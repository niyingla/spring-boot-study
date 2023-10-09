package com.imooc.architect.showcase.service;

import com.imooc.architect.showcase.model.DemoModel;

import java.util.List;

public interface DemoModelService {
    public List<DemoModel> findAll();


    public DemoModel findById(Long id);


    public DemoModel save(DemoModel model);


    public DemoModel update(DemoModel model);
}
