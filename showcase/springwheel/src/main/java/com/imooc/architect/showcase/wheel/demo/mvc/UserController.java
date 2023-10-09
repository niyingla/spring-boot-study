package com.imooc.architect.showcase.wheel.demo.mvc;

import com.google.common.collect.Lists;
import com.imooc.architect.showcase.wheel.mvc.RequestMapping;

import javax.annotation.ManagedBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ManagedBean
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(path = "/index")
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jimmy");
        map.put("age", 18);
        return map;

    }

    @RequestMapping(path = "/list")
    public List<Map<String, Object>> list() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jimmy");
        map.put("age", 18);
        return Lists.newArrayList(map, map, map);

    }
}
