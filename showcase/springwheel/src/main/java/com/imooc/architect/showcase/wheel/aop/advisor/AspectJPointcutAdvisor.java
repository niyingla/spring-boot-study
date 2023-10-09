package com.imooc.architect.showcase.wheel.aop.advisor;

import com.imooc.architect.showcase.wheel.aop.pointcut.AspectJPointcut;
import com.imooc.architect.showcase.wheel.aop.pointcut.Pointcut;

public class AspectJPointcutAdvisor implements PointcutAdvisor{
    private String adviceBeanName;

    private String expression;

    private AspectJPointcut pointcut;

    public AspectJPointcutAdvisor(String adviceBeanName, String expression) {
        super();
        this.adviceBeanName = adviceBeanName;
        this.expression = expression;
        this.pointcut = new AspectJPointcut(this.expression);
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public String getAdviceBeanName() {
        return this.adviceBeanName;
    }

    @Override
    public String getExpression() {
        return this.expression;
    }
}
