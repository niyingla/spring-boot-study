package com.imooc.architect.showcase.wheel.aop.advice;

import com.imooc.architect.showcase.wheel.aop.advice.Advice;

import java.lang.reflect.Method;

public interface MethodInterceptor extends Advice {
    Object invoke(Method method, Object[] args, Object target) throws Throwable;
}
