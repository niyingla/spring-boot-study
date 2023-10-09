package com.imooc.architect.spring.showcase.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class MyAutoConfiguration {

    @Bean
    @MyConditional
    public Map<String,String> map (){
        return new HashMap<>();
    }
}
