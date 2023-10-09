package com.imooc.architect.showcase.flux.web;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author jimmy
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/getByName")
    public Mono<User> getByName(@RequestParam("name") String name) {
        User model = new User();
        model.setName(name);
        model.setDesc("this is user for Demo");

        return Mono.just(model);
    }

    @Data
    static class User {
        private String name;
        private String desc;
    }
}
