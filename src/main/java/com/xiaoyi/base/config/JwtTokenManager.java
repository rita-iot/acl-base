package com.xiaoyi.base.config;

import cn.hutool.jwt.signers.JWTSigner;
import com.alibaba.fastjson.JSONObject;
import com.xiaoyi.base.system.entity.User;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

/**
 * Jwt工具类
 * token操作工具类
 */
@Component
public class JwtTokenManager {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenManager.class);
    /**
     * token有效时长 单位 毫秒
     * token 过期时间, 单位: 秒. 这个值表示 7 天
     */
    private long tokenEcpiration = 4 * 60 * 60 * 1000;
    /**
     * 编码秘钥 太简单 后期要更改
     */
    private String tokenSignKey = "acl-admin";

    /**
     * 1 使用jwt根据用户名生成token
     * @param username
     * @return
     */
    public String createToken(String username) {
        String token = Jwts.builder().setSubject(username)//主体
                .setExpiration(new Date(System.currentTimeMillis() + tokenEcpiration))//有效时长
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)//秘钥加密
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    /**
     * 2 根据token字符串得到用户信息
     * @param token
     * @return
     */
    public String getUserInfoFromToken(String token) {
        String userinfo = Jwts.parser().setSigningKey(tokenSignKey)
                .parseClaimsJws(token).getBody().getSubject();
        return userinfo;
    }

    /**
     * 删除token
     * @param token
     */
    public void removeToken(String token) {
    }

    /**
     * 获取过期时间
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * 从token中获取
     * @param token
     * @param claimsResolver
     * @param <T>
     * @return
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenSignKey)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 验证token是否有效
     * @param token
     * @return
     */
    public Boolean validateToken(String token) {
        String userInfo;
        try {
            userInfo = getUserInfoFromToken(token);
        } catch (ExpiredJwtException jwtException) {
            logger.error("token过期:{}", jwtException.getMessage());
            return false;
        }
        if (StringUtils.isBlank(userInfo)) {
            return false;
        }
        User user = JSONObject.parseObject(userInfo, User.class);
        if (user != null && StringUtils.isBlank(user.getUsername())) {
            return false;
        }
        return true;
    }
}
