package com.imooc.architect.spring.endpoint;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

/**
 * @author jimmy
 */
public class ShowcaseHealthIndicator  extends AbstractHealthIndicator implements InitializingBean {
    private static final long TIME = 5000;
    private long initTime;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        long duration = System.currentTimeMillis() - initTime;
        
        if(duration > TIME){
            builder.up().withDetail("cache","cache warm up complete");
        }else{
            builder.down().withDetail("cache","cache warm up starting")
                    .withDetail("duration",duration);
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.initTime = System.currentTimeMillis();
    }
}
