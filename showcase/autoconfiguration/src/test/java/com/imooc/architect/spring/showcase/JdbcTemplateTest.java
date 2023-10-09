package com.imooc.architect.spring.showcase;

import com.imooc.architect.spring.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@JdbcTest
public class JdbcTemplateTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ApplicationContext context;

    @Test
    public void testDataSource() {
        ContextUtils.printlnBeansClassName(context);
        log.info("jdbcTemplate = {}", jdbcTemplate);
        log.info("dataSource = {}", dataSource);
    }

}
