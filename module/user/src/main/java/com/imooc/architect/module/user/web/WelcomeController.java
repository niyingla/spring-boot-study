package com.imooc.architect.module.user.web;

import com.imooc.architect.module.user.model.User;
import com.imooc.architect.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/byId")
    public User findById(Long id) {
        return userService.findById(id);
    }

    @RequestMapping("/hello")
    public User hello(String name) {
        User user = new User();
        user.setName(name);
        user.setDescription(name + "_desc2");
        return user;
    }

}
