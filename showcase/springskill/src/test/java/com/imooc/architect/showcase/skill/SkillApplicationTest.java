package com.imooc.architect.showcase.skill;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Slf4j
class SkillApplicationTest {

    @Test
    public void testResource() throws IOException {
        Resource resource = new FileSystemResource("");
        String absolutePath = resource.getFile().getAbsolutePath();
        log.info("absolutePath = {}",absolutePath);
    }
}