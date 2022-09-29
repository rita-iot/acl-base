package com.xiaoyi.base.config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:31
 * @version：1.0
 */
@SuppressWarnings("ALL")
@Component
public class JwtTokenManager {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenManager.class);
    /**
     * 编码秘钥 太简单 后期要更改
     */
    private final String tokenSignKey = "acl-admin";

    /**
     * 使用jwt根据用户名生成token
     * @param username
     * @return
     */
    public String createToken(String username) {
        /**
         * token有效时长 单位 毫秒
         * token 过期时间, 单位: 秒. 这个值表示 4 小时
         */
        long tokenEcpiration = 4 * 60 * 60 * 1000;
        Map<String, Object> map = new HashMap<>(2);
        map.put("username", username);
        map.put("expire_time", System.currentTimeMillis() + tokenEcpiration);
        JWTSigner signer = JWTSignerUtil.hs512(tokenSignKey.getBytes());
        return JWTUtil.createToken(map, signer);
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    public String getUserInfoFromToken(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        //Object header = jwt.getHeader(JWTHeader.TYPE);
        return (String) jwt.getPayload("username");
    }

    /**
     * 获取过期时间
     * @param token
     * @return
     */
    public Date getExpireTime(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        Long expireTime = (Long) jwt.getPayload("expire_time");
        return DateUtil.date(expireTime);
    }

    /**
     * 验证token有效
     * @param token
     * @return
     */
    public Boolean isEffective(String token) {
        return JWTUtil.verify(token, tokenSignKey.getBytes());
    }
}
