package com.imooc.architect.showcase.wheel.aop.advice;

import com.imooc.architect.showcase.wheel.aop.advice.Advice;

import java.lang.reflect.Method;

public interface AfterReturningAdvice extends Advice {
    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;
}
