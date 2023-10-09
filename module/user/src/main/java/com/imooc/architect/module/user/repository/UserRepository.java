package com.imooc.architect.module.user.repository;

import com.imooc.architect.module.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jimmy
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
