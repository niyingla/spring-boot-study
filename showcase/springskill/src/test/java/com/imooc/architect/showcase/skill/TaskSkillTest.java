package com.imooc.architect.showcase.skill;

import com.imooc.architect.showcase.skill.validation.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Slf4j
@SpringJUnitConfig(classes = {TaskSkill.class, UserService.class})
class TaskSkillTest {

    @Autowired
    private UserService userService;

    @Test
    public void testExecute() throws InterruptedException {
        log.info("start");
        userService.createUser("jim", 18);
        log.info("end");
        Thread.sleep(500l);
    }

    @Scheduled(fixedDelay = 100L)
    public void taskScheduled1() {
        log.info("task scheduled");
    }
}