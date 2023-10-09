package com.imooc.architect.showcase.jdbc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author jimmy
 */
@Repository
public class DemoModelDao implements ApplicationEventPublisherAware {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Autowired
    public PlatformTransactionManager transactionManager;

    @Autowired
    public TransactionTemplate transactionTemplate;

    private ApplicationEventPublisher applicationEventPublisher;

    public DemoModelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(readOnly = true)
    public List<DemoModel> findAll() {
        return jdbcTemplate.query("select id,name,status,description,create_time,last_modified_time " +
                "from t_demo_model limit 100", new BeanPropertyRowMapper<DemoModel>(DemoModel.class));
    }

    /**
     * 声明式事务
     *
     * @param model
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int save(DemoModel model) {

        int count = jdbcTemplate.update("insert into t_demo_model(name,status,description,create_time,last_modified_time)" +
                        "VALUES(?,?,?,?,?)",
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, model.getName());
                        ps.setInt(2, model.getStatus());
                        ps.setString(3, model.getDescription());
                        ps.setTimestamp(4, new Timestamp(model.getCreateTime().getTime()));
                        ps.setTimestamp(5,
                                new Timestamp(model.getLastModifiedTime().getTime()));
                    }
                });
        this.applicationEventPublisher.publishEvent(new CreateEvent(model));
        //todo mock 特定情况下抛出异常回滚
        if ("test1".equals(model.getName())) {
            throw new IllegalArgumentException("mock exception");
        }
        return count;
    }

    /**
     * 编程式手工管理事务
     *
     * @param model
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int updateName(DemoModel model) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("DemoModel.updateName");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        int count = -1;
        try {
            String sql = "update t_demo_model set name = ? where id = ?";
            count = jdbcTemplate.update(sql,
                    ps -> {
                        ps.setString(1, model.getName());
                        ps.setLong(2, model.getId());
                    });
        } catch (RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }
        transactionManager.commit(status);
        return count;
    }

    public Integer updateStatus(DemoModel model) {
        String sql = "update t_demo_model set status = ? where id = ?";
        return transactionTemplate.execute(status -> {
            return jdbcTemplate.update(sql,
                    ps -> {
                        ps.setLong(1, model.getStatus());
                        ps.setLong(2, model.getId());
                    });
        });
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
