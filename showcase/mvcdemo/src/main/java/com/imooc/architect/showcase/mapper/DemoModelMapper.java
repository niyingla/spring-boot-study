package com.imooc.architect.showcase.mapper;

import com.imooc.architect.showcase.model.DemoModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoModelMapper {

    int deleteByPrimaryKey(Long id);

    DemoModel selectByPrimaryKey(Long id);

    List<DemoModel> findAll();

    int insert(DemoModel record);

    int updateByPrimaryKey(DemoModel record);
}
