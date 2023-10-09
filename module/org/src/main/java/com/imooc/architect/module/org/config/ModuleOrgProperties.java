package com.imooc.architect.module.org.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "module.org")
public class ModuleOrgProperties {

    private int initDataCount = 50;
    private boolean enabled = true;
}
