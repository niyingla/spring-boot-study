package com.imooc.architect.spring.showcase.app;

import com.imooc.architect.spring.ContextUtils;
import com.imooc.architect.spring.showcase.autoconfigure.MyAutoConfiguration;
import com.imooc.architect.spring.showcase.autoconfigure.MyConditional;
import com.imooc.architect.spring.showcase.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jimmy
 */
@Slf4j
@SpringBootApplication
public class DemoApplication implements InitializingBean {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        ContextUtils.printlnBeansClassName(context);
    }


    @Bean
    @MyConditional
    public List<String> list() {
        List<String> list = new ArrayList<String>();
        return list;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        throw new MyException("test failure analyzer");
    }
}
