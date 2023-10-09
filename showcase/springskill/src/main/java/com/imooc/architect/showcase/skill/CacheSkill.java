package com.imooc.architect.showcase.skill;

import com.github.benmanes.caffeine.cache.CaffeineSpec;
import com.imooc.architect.showcase.skill.cache.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

/**
 * @author jimmy
 */
@Slf4j
@EnableCaching
@Configuration
@Import(UserService.class)
public class CacheSkill {

    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        CaffeineSpec caffeineSpec = CaffeineSpec.parse(
                        "initialCapacity=500," +
                        "maximumSize=5000," +
                        "expireAfterWrite=5000s");
//        cacheManager.setCaffeineSpec(caffeineSpec);
        return cacheManager;
    }

    @Bean
    public CacheManager concurrentMapCacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
