package com.base.example.config.security.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码处理配置类
 */
@Component
public class DefaultPasswordEncoder implements PasswordEncoder {

    /**
     * 无参构造方法
     */
    public DefaultPasswordEncoder() {
        this(-1);
    }

    /**
     * 1个参数构造方法
     * @param strength
     */
    public DefaultPasswordEncoder(int strength) {
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return PasswordEncoder.super.upgradeEncoding(encodedPassword);
    }

    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
