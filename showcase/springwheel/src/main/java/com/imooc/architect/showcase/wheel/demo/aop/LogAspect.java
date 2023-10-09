package com.imooc.architect.showcase.wheel.demo.aop;

import com.imooc.architect.showcase.wheel.aop.advice.MethodInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.annotation.ManagedBean;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@ManagedBean
public class LogAspect implements MethodInterceptor {
    @Around("execution( * com.imooc.architect.showcase.wheel.demo.*.createDemoModel(..))")
    @Override
    public Object invoke(Method method, Object[] args, Object target) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            log.info("=======around before {}", method.getName());
            Object proceed = method.invoke(target,args );
            log.info("=======around after {}", method.getName());
            long end = System.currentTimeMillis();
            log.info("around " + method.getName() + "\tUse time : " + (end - start) + " ms!");
            return proceed;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            long end = System.currentTimeMillis();
            log.info("around " + method.getName() + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }
    }


}
