package com.imooc.architect.module.user.web;

import com.imooc.architect.module.user.model.User;
import com.imooc.architect.module.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class WelcomeControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService service;

    @Test
    void findById() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("TestUser");

        given(this.service.findById(1L)).willReturn(user);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/welcome/byId")
                .param("id", "1")
                .accept(MediaType.APPLICATION_JSON);

        ResultActions resultActions = this.mvc.perform(requestBuilder);

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                        .value("TestUser"))
                .andExpect(content().
                        string(containsString("TestUser")))
                .andDo(print());


    }
}