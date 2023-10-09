package com.imooc.architect.module.org.autoconfigure.actuator;

import com.imooc.architect.module.org.model.Organization;
import com.imooc.architect.module.org.repository.OrganizationRepository;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author jimmy
 */
public class ModuleOrgHealthIndicator extends AbstractHealthIndicator {
    private OrganizationRepository repository;

    public ModuleOrgHealthIndicator(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        Page<Organization> page = repository.findAll(PageRequest.of(0, 10));
        if(page.getTotalElements() > 0){
            builder.up().withDetail("module.org","initOrg Data success");
        }else {
            builder.down().withDetail("module.org","initOrg Data starting");
        }
    }
}
