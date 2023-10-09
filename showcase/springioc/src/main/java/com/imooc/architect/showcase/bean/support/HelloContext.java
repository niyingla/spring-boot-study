package com.imooc.architect.showcase.bean.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author jimmy
 */
@Slf4j
@Component
public class HelloContext extends HelloBean {

    public HelloContext() {
        super();
    }

    public HelloContext(String name) {
        super(name);
    }

    @Override
    @Autowired(required = false)
    public void setName(String name) {
        super.setName(name);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("执行@PreDestroy方法 = {}", beanName);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("执行@PostConstruct = {}", beanName);
    }
}
