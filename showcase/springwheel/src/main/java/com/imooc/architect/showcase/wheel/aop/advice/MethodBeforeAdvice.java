package com.imooc.architect.showcase.wheel.aop.advice;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice extends Advice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
