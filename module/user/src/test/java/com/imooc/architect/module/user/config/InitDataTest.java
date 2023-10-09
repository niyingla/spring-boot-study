package com.imooc.architect.module.user.config;

import com.imooc.architect.module.user.model.User;
import com.imooc.architect.module.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@DataJpaTest
@ActiveProfiles("dev")
@Import(InitData.class)
class InitDataTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        Page<User> userPage = userRepository.findAll(PageRequest.of(0, 50));

        for (User user : userPage) {
            log.info("user.html = {}", user);
        }
        Assertions.assertTrue(userPage.getTotalElements() == 50);
    }
}