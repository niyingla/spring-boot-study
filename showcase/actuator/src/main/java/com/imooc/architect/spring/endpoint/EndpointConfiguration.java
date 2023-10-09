package com.imooc.architect.spring.endpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jimmy
 */
@Configuration(proxyBeanMethods = false)
public class EndpointConfiguration {
    @Bean
    public ShowcaseEndpoint showcaseEndpoint(){
        return new ShowcaseEndpoint();
    }

    @Bean
    public ShowcaseHealthIndicator showcaseHealthIndicator(){
        return new ShowcaseHealthIndicator();
    }
}
