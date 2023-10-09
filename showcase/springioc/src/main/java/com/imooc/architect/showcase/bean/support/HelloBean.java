package com.imooc.architect.showcase.bean.support;

import com.imooc.architect.showcase.bean.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author jimmy
 */
@Slf4j
public class HelloBean implements Hello, InitializingBean, DisposableBean, BeanNameAware {
    protected String name;
    protected String beanName;

    public HelloBean() {
        log.info("执行构造方法 HelloBean()");
    }

    public HelloBean(String name) {
        log.info("执行构造方法 HelloBean({})", name);
        this.name = name;
    }

    public void setName(String name) {
        log.info("执行set注入方法 setName = {}", name);
        this.name = name;
    }


    @Override
    public void sayHello() {
        log.info("执行业务方法 sayHello = {}", name);
    }

    @Override
    public void setBeanName(String beanName) {
        log.info("执行Aware方法 setBeanName = {}", beanName);
        this.beanName = beanName;
    }

    @Override
    public void destroy() throws Exception {
        log.info("执行DisposableBean方法 destroy = {}", beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("执行InitializingBean方法 afterPropertiesSet = {}", beanName);
    }

    public void initMethod() throws Exception {
        log.info("执行配置初始化方法 initMethod = {}", beanName);
    }

    public void destroyMethod() throws Exception {
        log.info("执行配置销毁方法 destroyMethod = {}", beanName);
    }
}
