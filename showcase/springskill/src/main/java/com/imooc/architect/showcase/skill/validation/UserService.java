package com.imooc.architect.showcase.skill.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jimmy
 */
@Slf4j
@Service
@Validated
public class UserService {
    @Async
    public UserVo createUser(@NotNull(message = "name not be null")
                             @Size(min = 3, max = 18, message = "name.length >=3 and <=18")
                                     String name,
                             @Min(value = 18, message = "age must >=18")
                                     int age) {
        log.info("createUser name = {},age = {}", name, age);
        return new UserVo(name, age);
    }
}
