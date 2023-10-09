package com.imooc.architect.showcase.aop;

import com.imooc.architect.showcase.bean.Hello;
import com.imooc.architect.showcase.bean.support.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CustomMethodInterceptorTest {

    @Test
    public void testMethodInterceptor(){
        HelloBean helloBean= new HelloBean( );
        ProxyFactory proxyFactory = new ProxyFactory() ;
        proxyFactory.setTarget(helloBean);
        proxyFactory.addAdvice(new CustomMethodInterceptor());
        Hello proxy = (Hello) proxyFactory.getProxy();
        log.info("proxy = {}",proxy.getClass());
        proxy.sayHello();
        proxy.toString();
    }
}