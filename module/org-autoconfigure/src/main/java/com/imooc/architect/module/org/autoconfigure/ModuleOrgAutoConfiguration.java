package com.imooc.architect.module.org.autoconfigure;

import com.imooc.architect.module.org.ModuleOrgApplication;
import com.imooc.architect.module.org.repository.OrganizationRepository;
import com.imooc.architect.module.org.autoconfigure.actuator.ModuleOrgEndpoint;
import com.imooc.architect.module.org.autoconfigure.actuator.ModuleOrgHealthIndicator;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author jimmy
 */
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackageClasses = ModuleOrgApplication.class)
@EnableJpaRepositories(basePackageClasses = ModuleOrgApplication.class)
@EntityScan(basePackageClasses = ModuleOrgApplication.class)
@AutoConfigureAfter(JpaRepositoriesAutoConfiguration.class)
public class ModuleOrgAutoConfiguration {

    @Bean
    public ModuleOrgHealthIndicator moduleOrgHealthIndicator(OrganizationRepository repository){
        return new ModuleOrgHealthIndicator(repository);
    }
    @Bean
    public ModuleOrgEndpoint moduleOrgEndpoint(OrganizationRepository repository){
        return new ModuleOrgEndpoint(repository);
    }

}
