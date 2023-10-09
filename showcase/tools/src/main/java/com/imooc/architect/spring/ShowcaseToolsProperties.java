package com.imooc.architect.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "showcase.tools")
public class ShowcaseToolsProperties {

    private String id;
    private String name;
    private String status;
    private String description;

}
