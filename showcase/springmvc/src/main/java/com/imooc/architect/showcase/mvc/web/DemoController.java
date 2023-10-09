package com.imooc.architect.showcase.mvc.web;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author jimmy
 */
@Slf4j
@RestController
@RequestMapping("/demo")
@Validated
public class DemoController {

    @GetMapping(value = "/getByName")
    public User getByName(
            @RequestParam("name") String name) {
        User model = new User();
        model.setName(name);
        model.setDesc("this is user for Demo");

        return model;
    }


    @PostMapping(value = "/createUser2")
    public User createUser2(@Valid User user, BindingResult errors) {
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            for (ObjectError objectError : errorList) {
                log.info("error : {}", objectError);
            }
            return null;
        } else {
            user.setDesc("this is user for Demo");
            return user;
        }
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
    }

    @PostMapping(value = "/createUser")
    public User createUser(@Valid User user) {
        user.setDesc("this is user for Demo");
        return user;
    }

    @Data
    static class User {
        @Size(min = 3, max = 18, message = "name.length >=3 and <=18")
        private String name;
        private String desc;
    }


}
