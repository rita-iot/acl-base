package com.xiaoyi.base.config.security.security;

import com.xiaoyi.base.utils.ResponseUtil;
import com.xiaoyi.base.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出处理器
 */
public class TokenLogoutHandler implements LogoutHandler {
    private static final Logger logger = LoggerFactory.getLogger(TokenLogoutHandler.class);

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;

    /**
     * 构造方法
     * @param tokenManager
     * @param redisTemplate
     */
    public TokenLogoutHandler(TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 退出方法
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        //1 从header里面获取token
        //2 token不为空，移除token，从redis删除token
        String token = request.getHeader("token");
        if (token != null) {
            //移除
            logger.info("移除token");
            tokenManager.removeToken(token);
            //从token获取用户名
            String username = tokenManager.getUserInfoFromToken(token);
            //从redis删除token key的用户名，value是权限列表
            redisTemplate.delete(username);
        }
        ResponseUtil.out(response, Result.ok());
    }
}
