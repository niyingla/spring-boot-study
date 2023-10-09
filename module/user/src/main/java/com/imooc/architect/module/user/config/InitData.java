package com.imooc.architect.module.user.config;

import com.imooc.architect.module.user.model.User;
import com.imooc.architect.module.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author jimmy
 */
@Slf4j
@Component
@Profile("dev")
public class InitData implements InitializingBean {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        initUserData();
    }

    private void initUserData() {
        long count = userRepository.count();
        if(count == 0){
            log.info("init Data for dev start");
            for (int i = 0; i < 50; i++) {
                User user = new User();
                user.setName("name_"+i);
                user.setLoginName("loginName_"+i);
                user.setDescription("desc_"+i);
                user.setStatus(i%5);
                userRepository.save(user);
            }
            log.info("init Data for dev end");
        }
    }
}
