package com.imooc.architect.spring.showcase;

import com.imooc.architect.spring.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@WebMvcTest
public class SpringMvcTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ApplicationContext context;

    @Test
    public void testContext(){
        ContextUtils.printlnBeansClassName(context);
        log.info("mockMvc = {}", mockMvc);
    }
}
