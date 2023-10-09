package com.imooc.architect.showcase.mvc.web;

import com.imooc.architect.showcase.mvc.JavaConfig;
import com.imooc.architect.showcase.mvc.conf.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringJUnitConfig({JavaConfig.class, WebConfig.class})
@WebAppConfiguration
class DemoControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetByName() throws Exception {
        log.info("run");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/demo/getByName")
                .param("name", "Jimmy")
                .accept(MediaType.APPLICATION_JSON);

        ResultActions resultActions = this.mockMvc.perform(requestBuilder);

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                        .value("Jimmy"))
                .andDo(print());
        log.info("end");
    }

    @Test
    public void testCreateUser() throws Exception {
        log.info("run");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/demo/createUser")
                .param("name", "Ji")
                .accept(MediaType.APPLICATION_JSON);

        ResultActions resultActions = this.mockMvc.perform(requestBuilder);

        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.name")
//                        .value("Jimmy"))
                .andDo(print());
        log.info("end");
    }


}