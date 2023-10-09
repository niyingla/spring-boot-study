package com.imooc.architect.module.org.autoconfigure.actuator;

import com.imooc.architect.module.org.model.Organization;
import com.imooc.architect.module.org.repository.OrganizationRepository;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jimmy
 */
@Endpoint(id = "moduleorg")
public class ModuleOrgEndpoint {

    private OrganizationRepository repository;

    public ModuleOrgEndpoint(OrganizationRepository repository) {
        this.repository = repository;
    }

    @ReadOperation
    public List<Organization> orgList() {
        List<Organization> collect = repository.findAll(PageRequest.of(0, 10)).get().collect(Collectors.toList());
        return collect;
    }
}
