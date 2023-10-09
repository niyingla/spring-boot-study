package com.imooc.architect.module.user.web;

import com.imooc.architect.module.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/user")
    public User user(String name){
        User user = new User();
        user.setName(name);
        user.setDescription(name+"_desc2");
        return user;
    }

}
