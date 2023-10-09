package com.imooc.architect.showcase.skill;

import com.imooc.architect.showcase.skill.validation.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Slf4j
class SpELSkillTest {

    @Test
    public void testSimpleExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(
                "('Hello' + ' World').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!");
        String value = (String)expression.getValue(context);
        Assertions.assertEquals("Hello World!",value);
    }


    @Test
    public void testSimpleVarExpression() {

        ExpressionParser parser = new SpelExpressionParser();
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        Assertions.assertEquals("Hello World", helloWorld);
        double dubboValue = (Double) parser.parseExpression("1.024E+3").getValue();
        Assertions.assertEquals(1.024E+3, dubboValue);
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        Assertions.assertEquals(0x7FFFFFFF, maxValue);
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        Assertions.assertEquals(true, trueValue);
        Object nullValue = parser.parseExpression("null").getValue();
        Assertions.assertNull(nullValue);
    }


    @Test
    public void testVarExpression() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        String name = "Jimmy";
        context.setVariable("myName", name);
        ExpressionParser parser = new SpelExpressionParser();
        String value = parser.parseExpression("#myName").getValue(context, String.class);
        log.info("value = {}", value);

        String strValue = parser.parseExpression("new String('Jimmy')").getValue(String.class);
        log.info("strValue = {}", strValue);
    }

    @Configuration
    static class Config {
        @Bean
        public UserVo user() {
            return new UserVo("Jimmy", 18);
        }
    }

    @Test
    public void testBeanVarExpression() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        BeanFactoryResolver beanFactoryResolver = new BeanFactoryResolver(applicationContext);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(beanFactoryResolver);

        ExpressionParser parser = new SpelExpressionParser();
        String value = parser.parseExpression("@user.name").getValue(context, String.class);
        log.info("value = {}", value);

    }
}