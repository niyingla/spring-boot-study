package com.imooc.architect.showcase.wheel.aop.pointcut;

import java.lang.reflect.Method;

public interface Pointcut {
    boolean matchClass(Class<?> targetClass);
    boolean matchMethod(Method method, Class<?> targetClass);

}
