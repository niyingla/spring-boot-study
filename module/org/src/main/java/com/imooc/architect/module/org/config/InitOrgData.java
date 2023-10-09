package com.imooc.architect.module.org.config;

import com.imooc.architect.module.org.model.Organization;
import com.imooc.architect.module.org.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableConfigurationProperties(ModuleOrgProperties.class)
public class InitOrgData implements InitializingBean {

    @Autowired
    private ModuleOrgProperties properties;

    @Autowired
    private OrganizationRepository repository;

    @Override
    public void afterPropertiesSet() throws Exception {
        initUserData();
    }

    private void initUserData() {
        long count = repository.count();
        if (count == 0) {
            int initDataCount = properties.getInitDataCount();
            log.info("init Data for dev start");
            for (int i = 0; i < initDataCount; i++) {
                Organization organization = new Organization();
                organization.setName("org_name_" + i);
                organization.setDescription("desc_" + i);
                organization.setStatus(i % 5);
                repository.save(organization);
            }
            log.info("init Data for dev end");
        }
    }
}
