package com.base.example.config.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Description: 描述
 * @Author：XiaoBing
 * @Date：2020/12/2 9:36
 * @Version：1.0
 */
@Component
public class InitBean {

    /**
     * 初始化密码加密器
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
