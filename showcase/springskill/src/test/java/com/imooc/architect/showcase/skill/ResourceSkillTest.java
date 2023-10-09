package com.imooc.architect.showcase.skill;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@Slf4j
class ResourceSkillTest {

    private ResourceSkill resourceSkill = new ResourceSkill();

    @Test
    void resourceLoader() throws IOException {
        Resource resource = resourceSkill.resourceLoader()
                .getResource("logback.xml");
        log.info("resource = {}", resource);
        File file = resource.getFile();
        log.info("file.exists:{}", file.exists());
        log.info("file.getAbsolutePath:{}", file.getAbsolutePath());
    }

    @Test
    void resourceLoaderFileSystem() throws IOException {
        Resource resource = resourceSkill.resourceLoader()
                .getResource("file:pom.xml");
        log.info("resource = {}", resource);
        File file = resource.getFile();
        log.info("file.exists:{}", file.exists());
        log.info("file.getAbsolutePath:{}", file.getAbsolutePath());
    }

    @Test
    void fileSystemResourceLoader() throws IOException {
        Resource resource = resourceSkill.fileSystemResourceLoader().getResource("pom.xml");
        log.info("resource : {}", resource);
        File file = resource.getFile();
        log.info("file.exists:{}", file.exists());
        log.info("file.getAbsolutePath:{}", file.getAbsolutePath());
    }

    @Test
    void classRelativeResourceLoader() throws IOException {
        Resource resource = resourceSkill.classRelativeResourceLoader().getResource("");
        log.info("resource : {}", resource);
        File file = resource.getFile();
        log.info("file.exists:{}", file.exists());
        log.info("file.getAbsolutePath:{}", file.getAbsolutePath());

    }


    @Test
    void resourcePatternResolver() throws IOException {
//        ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
        Resource[] resources = resourceSkill.resourcePatternResolver()
                .getResources("classpath*:/spring/hello-bean.xml");
        for (Resource resource : resources) {
            log.info("resource = {}", resource);
        }
    }


}