package com.imooc.architect.showcase.skill;

import com.imooc.architect.showcase.skill.validation.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author jimmy
 */
@Slf4j
@Configuration
public class ValidationSkill {



    /**
     * bean初始化化是验证 bean是否符合JSR-303规范
     *
     * @return
     */
    @Bean
    public BeanPostProcessor beanValidationPostProcessor() {
        return new BeanValidationPostProcessor();
    }

    /**
     * 方法执行时验证参数是否符合 JSR-303规范
     *
     * @return
     */
    @Bean
    public BeanPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }


    @Bean
    public UserService userService() {
        return new UserService();
    }

}
