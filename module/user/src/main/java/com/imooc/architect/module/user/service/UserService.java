package com.imooc.architect.module.user.service;

import com.imooc.architect.module.user.model.User;

/**
 * @author jimmy
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User findById(Long id);
}
