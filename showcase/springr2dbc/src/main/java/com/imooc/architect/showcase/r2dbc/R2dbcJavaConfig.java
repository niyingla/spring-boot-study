package com.imooc.architect.showcase.r2dbc;

import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

/**
 * @author jimmy
 */
@Configuration
public class R2dbcJavaConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        return H2ConnectionFactory.inMemory("testR2dbc");
    }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }
}
