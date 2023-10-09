package com.imooc.architect.showcase.aop;


import com.imooc.architect.showcase.bean.Hello;
import com.imooc.architect.showcase.bean.support.HelloBean;
import com.imooc.architect.showcase.bean.support.HelloContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author jimmy
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopJavaConfig {
    @Bean
    public Hello hello() {
        return new HelloContext();
    }
    @Bean
    public HelloBean helloBean() {
        return new HelloBean();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
