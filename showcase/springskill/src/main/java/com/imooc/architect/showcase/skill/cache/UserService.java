package com.imooc.architect.showcase.skill.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jimmy
 */
@Slf4j
@Service
public class UserService {

    private transient Map<String, UserVo> store = new ConcurrentHashMap<>();

    public UserVo createUser(String name, int age) {
        log.info("createUser name = {},age = {}", name, age);
        UserVo userVo = new UserVo(name, age);
        store.put(userVo.getName(), userVo);
        return userVo;
    }

    @CacheEvict(cacheNames = "users", key = "#name")
    public UserVo removeUser(String name) {
        log.info("removeUser name = {}", name);
        return store.remove(name);
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    public void removeAllUser() {
        log.info("removeAllUser");
        store.clear();
    }

    @CachePut(cacheNames = "users", key = "#name")
    public UserVo updateUser(String name, int age) {
        log.info("createUser name = {},age = {}", name, age);
        UserVo userVo = store.get(name);
        Assert.notNull(userVo, "the user not exist!");
        userVo.setAge(age);
        return userVo;
    }

    @Cacheable(cacheNames = "users", key = "#name")
    public UserVo findUser(String name) {
        log.info("findUser name = {}", name);
        UserVo userVo = store.get(name);
        Assert.notNull(userVo, "the user not exist!");
        return userVo;
    }


}
