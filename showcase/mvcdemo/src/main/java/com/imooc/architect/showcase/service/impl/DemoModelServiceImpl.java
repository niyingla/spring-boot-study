package com.imooc.architect.showcase.service.impl;

import com.imooc.architect.showcase.mapper.DemoModelMapper;
import com.imooc.architect.showcase.model.DemoModel;
import com.imooc.architect.showcase.service.DemoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoModelServiceImpl implements DemoModelService {
    @Autowired
    private DemoModelMapper demoModelMapper;

    @Override
    public List<DemoModel> findAll() {
        return demoModelMapper.findAll();
    }
    @Override
    public DemoModel findById(Long id) {
        return demoModelMapper.selectByPrimaryKey(id);
    }


    @Override
    public DemoModel save(DemoModel model) {
        this.demoModelMapper.insert(model);
        return model;
    }

    @Override
    public DemoModel update(DemoModel model) {
        return model;
    }
}
