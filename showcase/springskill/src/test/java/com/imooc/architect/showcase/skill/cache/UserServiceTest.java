package com.imooc.architect.showcase.skill.cache;

import com.imooc.architect.showcase.skill.CacheSkill;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Slf4j
@SpringJUnitConfig(CacheSkill.class)
class UserServiceTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    public void initData() {
        userService.createUser("Jimmy", 18);
        userService.createUser("Tom", 20);
    }

    @Test
    public void testFindUser() {

        UserVo user = userService.findUser("Jimmy");
        log.info("user = {}", user);
        UserVo user2 = userService.findUser("Jimmy");
        log.info("user2 = {}", user2);
    }

}