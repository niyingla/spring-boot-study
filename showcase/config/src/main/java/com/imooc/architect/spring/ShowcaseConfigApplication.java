package com.imooc.architect.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author jimmy
 */
@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(ShowcaseToolsProperties.class)
public class ShowcaseConfigApplication {

    @Autowired
    private ShowcaseToolsProperties properties;

    @Bean
    public ApplicationRunner runner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                log.info("properties = {}", properties);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ShowcaseConfigApplication.class, args);
    }

}
