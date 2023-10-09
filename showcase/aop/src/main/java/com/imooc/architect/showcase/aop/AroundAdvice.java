package com.imooc.architect.showcase.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author jimmy
 */
@Slf4j
public class AroundAdvice {

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            log.info("=======before {}", joinPoint.getSignature().getName());
            Object proceed = joinPoint.proceed();
            log.info("=======after {}", joinPoint.getSignature().getName());
            long end = System.currentTimeMillis();
            log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
            return proceed;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            long end = System.currentTimeMillis();
            log.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }
    }
}
