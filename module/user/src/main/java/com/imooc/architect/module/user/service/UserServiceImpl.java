package com.imooc.architect.module.user.service;

import com.imooc.architect.module.user.model.User;
import com.imooc.architect.module.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jimmy
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }
}
