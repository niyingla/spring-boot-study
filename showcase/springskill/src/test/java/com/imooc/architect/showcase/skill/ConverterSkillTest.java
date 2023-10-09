package com.imooc.architect.showcase.skill;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringJUnitConfig({ConverterSkill.class})
class ConverterSkillTest {

    @Autowired
    private ConversionService conversionService;

    @Test
    void conversionService() {
        Long v = conversionService.convert("123", Long.class);
        log.info("v = {}", v);
    }
}