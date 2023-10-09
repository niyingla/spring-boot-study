package com.imooc.architect.module.org.repository;

import com.imooc.architect.module.org.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jimmy
 */
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
