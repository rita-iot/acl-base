package com.xiaoyi.base.config.security.filter;

import com.xiaoyi.base.config.security.security.JwtTokenManager;
import com.xiaoyi.base.core.redis.RedisService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @description: --
 * @author：Bing
 * @date：2022/9/16 12:33
 * @version：1.0
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisService redisService;
    @Autowired
    private JwtTokenManager jwtTokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws IOException, ServletException {
        //1获取token  header的token
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            //放行，让后面的过滤器执行
            filterChain.doFilter(request, response);
            return;
        }
        String username = jwtTokenManager.getUserInfoFromToken(token);
        String currentName = (String) redisService.get("login:" + username);
        if (Objects.isNull(currentName)) {
            throw new RuntimeException("当前用户未登录！");
        }
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(username, null, null);
        //5存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行，让后面的过滤器执行
        filterChain.doFilter(request, response);
    }
}
