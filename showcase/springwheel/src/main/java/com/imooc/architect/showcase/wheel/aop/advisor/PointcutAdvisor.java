package com.imooc.architect.showcase.wheel.aop.advisor;

import com.imooc.architect.showcase.wheel.aop.pointcut.Pointcut;

public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}
