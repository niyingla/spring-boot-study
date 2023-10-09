package com.imooc.architect.module.user.repository;


import com.imooc.architect.module.user.config.InitData;
import com.imooc.architect.module.user.model.User;
import com.imooc.architect.spring.ContextUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@ActiveProfiles("dev")
@Import(InitData.class)
//@DataJpaTest
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ApplicationContext context;

    @Test
    public void testContext() {
        ContextUtils.printlnBeansClassName(context);
    }

    @Test
    public void getUser() {

        Optional<User> user = repository.findById(1L);
        Assertions.assertNotNull(user.get(), "user not null");

    }
}