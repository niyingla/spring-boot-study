package com.imooc.architect.showcase.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *
 * @author jimmy
 */
@Slf4j
public class CustomMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            log.info("=======before {}", invocation.getMethod().getName());
            Object proceed = invocation.proceed();
            log.info("=======after {}", invocation.getMethod().getName());
            long end = System.currentTimeMillis();
            log.info("CustomMethodInterceptor " + invocation.getMethod().getName() + "\tUse time : " + (end - start) + " ms!");
            return proceed;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            long end = System.currentTimeMillis();
            log.info("CustomMethodInterceptor " + invocation.getMethod().getName() + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }
    }
}
