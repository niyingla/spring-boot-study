package com.imooc.architect.showcase.aop;

import com.imooc.architect.showcase.bean.support.HelloBean;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class CustomMethodMatcherPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return method.getName().equals("sayHello");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return clazz.equals(HelloBean.class);
            }
        };
    }
}
