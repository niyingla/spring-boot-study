package com.imooc.architect.showcase.jdbc.demo;

import com.imooc.architect.showcase.jdbc.JdbcJavaConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringJUnitConfig({JdbcJavaConfig.class})
class DemoModelDaoTest {

    @Autowired
    private DemoModelDao demoModelDao;

    @Test
    void findAll() {
        List<DemoModel> list = demoModelDao.findAll();
        Assertions.assertTrue(list.size() == 4);
        for (DemoModel demoModel : list) {
            log.info(demoModel.toString());
        }
        log.info("list = {}", list.size());

    }
    @Test
    void save() {

        for (DemoModel demoModel : demoModelDao.findAll()) {
            try {
//                demoModel.setName("U_" + demoModel.getName());
                demoModelDao.save(demoModel);
            } catch (Exception e) {
//                log.error(e.getMessage(), e);
            }
        }
        List<DemoModel> list = demoModelDao.findAll();
        for (DemoModel demoModel : list) {
            log.info(demoModel.toString());
        }
        log.info("list = {}", list.size());

    }
    @Test
    void updateName() {

        for (DemoModel demoModel : demoModelDao.findAll()) {
            try {
                demoModel.setName("U_" + demoModel.getName());
                demoModelDao.updateName(demoModel);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        List<DemoModel> list = demoModelDao.findAll();
        for (DemoModel demoModel : list) {
            log.info(demoModel.toString());
        }
        log.info("list = {}", list.size());

    }
}