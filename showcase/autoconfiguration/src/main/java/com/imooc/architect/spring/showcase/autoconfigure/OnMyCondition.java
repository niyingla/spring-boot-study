package com.imooc.architect.spring.showcase.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author jimmy
 */
public class OnMyCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        Boolean property = environment.getProperty("showcase.enable", Boolean.class, true);
        if (property) {
            return ConditionOutcome.match("showcase.enable is true");
        } else {
            return ConditionOutcome.noMatch("showcase.enable is false");
        }
    }
}
