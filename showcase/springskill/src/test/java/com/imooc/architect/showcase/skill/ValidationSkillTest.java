package com.imooc.architect.showcase.skill;

import com.imooc.architect.showcase.skill.validation.UserService;
import com.imooc.architect.showcase.skill.validation.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class ValidationSkillTest {

    @Configuration
    static class Config {
        @Bean
        public UserVo user() {
            return new UserVo("ji", 16);
        }
    }

    @Test
    public void testBeanInitValidation() {
        //org.springframework.beans.factory.BeanCreationException
        Exception exception = assertThrows(Exception.class, () -> {
            AnnotationConfigApplicationContext applicationContext =
                    new AnnotationConfigApplicationContext(ValidationSkill.class, Config.class);
        });
        log.info(exception.getMessage(), exception);
    }

    @Test
    public void testMethodValidation() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ValidationSkill.class);

        UserService userService = applicationContext.getBean(UserService.class);
        log.info("create User");

        //javax.validation.ConstraintViolationException
        Exception exception = assertThrows(Exception.class, () -> {
            UserVo user = userService.createUser("a", 16);
        });
        log.info(exception.getMessage(), exception);

    }

    @Test
    public void testValidation() {
        //获取Validator实例
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        UserVo user = new UserVo("a", 16);
        //手工验证user对象是否合法
        Set<ConstraintViolation<UserVo>> violationSet = validator.validate(user);
        for (ConstraintViolation<UserVo> violation : violationSet) {
            log.info("validation = {}", violation);
        }
    }

}