package com.imooc.architect.showcase.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author jimmy
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution( * com.imooc.architect.showcase.bean.*.*(..))")
    public void aspect() {
    }

    @Around("aspect()")
    public Object around(JoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            log.info("=======before {}", joinPoint.getSignature().getName());
            Object proceed = ((ProceedingJoinPoint) joinPoint).proceed();
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

    @After("aspect()")
    public void after(JoinPoint joinPoint) throws Throwable {
        log.info("after");
    }

    @AfterReturning("aspect()")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
        log.info("afterReturning");
    }
}
