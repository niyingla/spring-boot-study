package com.imooc.architect.showcase.aop;

import com.imooc.architect.showcase.bean.Hello;
import com.imooc.architect.showcase.bean.support.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

@Slf4j
class CustomMethodMatcherPointcutTest {

    @Test
    public void testMethodInterceptor() {
        HelloBean helloBean = new HelloBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(helloBean);
        Advice advice = new CustomMethodInterceptor();
        //通过 pointcut 限制拦截的方法
        Pointcut pointcut = new CustomMethodMatcherPointcut();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
        proxyFactory.addAdvisor(advisor);

        Hello proxy = (Hello) proxyFactory.getProxy();
        log.info("proxy = {}", proxy.getClass());
        proxy.sayHello();
        proxy.toString();
    }
}