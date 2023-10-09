package com.imooc.architect.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("dev")
@TestPropertySource(properties = {"showcase.tools.id:TestPropertySource"})
@Slf4j
@SpringBootTest(properties = {"showcase.tools.id:SpringBootTest"})
class ShowcaseConfigApplicationTests {
	@Autowired
	private ShowcaseToolsProperties properties;

	@Test
	void testPorpertiesOrder() {
		log.info("properties.id    = {}",properties.getId());
		log.info("properties.name  = {}",properties.getName());
		log.info("properties.status= {}",properties.getStatus());
		log.info("properties.desc  = {}",properties.getDescription());
	}

}
