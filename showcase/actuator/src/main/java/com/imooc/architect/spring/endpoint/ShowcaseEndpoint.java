package com.imooc.architect.spring.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jimmy
 */
@Endpoint(id = "showcase")
public class ShowcaseEndpoint {
    @ReadOperation
    public Map<String, String> showcase() {
        Map<String, String> map = new HashMap<>();
        map.put("org", "imooc");
        map.put("author", "jimmy");
        return map;
    }
}
