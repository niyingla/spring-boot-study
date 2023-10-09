package com.imooc.architect.showcase.wheel.aop.pointcut;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;

import java.lang.reflect.Method;

public class AspectJPointcut implements Pointcut{
    private static PointcutParser pointcutParser = PointcutParser
            .getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();


    public String expression;
    private PointcutExpression pointcutExpression;

    public AspectJPointcut(String expression) {
        this.expression = expression;
        this.pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }


    @Override
    public boolean matchClass(Class<?> targetClass) {
        return pointcutExpression.couldMatchJoinPointsInType(targetClass);
    }

    @Override
    public boolean matchMethod(Method method, Class<?> targetClass) {
        return pointcutExpression
                .matchesMethodExecution(method)
                .alwaysMatches();
    }
}
