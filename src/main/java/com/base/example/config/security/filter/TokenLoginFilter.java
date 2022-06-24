package com.base.example.config.security.filter;

import cn.hutool.core.date.DateUtil;
import com.base.example.config.security.security.TokenManager;
import com.base.example.primary.service.AclLogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.base.example.primary.entity.AclLog;
import com.base.example.primary.entity.SecurityUser;
import com.base.example.primary.entity.User;
import com.base.example.primary.service.impl.AclLogServiceImpl;
import com.base.example.utils.R;
import com.base.example.utils.ResponseUtil;
import com.base.example.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 认证自定义过滤器
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger logger = LoggerFactory.getLogger(TokenLoginFilter.class);

    private AclLogService aclLogService = new AclLogServiceImpl();
    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    private AuthenticationManager authenticationManager;

    /**
     * 构造方法
     * @param authenticationManager
     * @param tokenManager
     * @param redisTemplate
     */
    public TokenLoginFilter(AuthenticationManager authenticationManager, TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        this.setPostOnly(false); //提交方式
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/admin/login", "POST"));//登录路径
    }

    /**
     * 获取表单提交用户名和密码
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        //获取表单提交数据
        try {
            //根据流获取表单数据
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            //String captcha = user.getCaptcha();
            //String redisCaptcha = (String) redisTemplate.opsForValue().get("123");
            //logger.info("传进来的验证码：" + captcha);
            //logger.info("redis中存的验证码：" + redisCaptcha);
            //if (!captcha.equals(redisCaptcha)) {
            //    //验证码不正确
            //    throw new AuthenticationServiceException("用户验证码错误!");
            //}
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 2 认证成功调用的方法
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response
            , FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        logger.info("---进入认证成功方法---");
        //认证成功，得到认证成功之后用户信息
        AclLog aclLog = new AclLog();
        aclLog.setType("1");
        SecurityUser user = (SecurityUser) authResult.getPrincipal();
        aclLog.setTitle(user.getUsername());
        aclLog.setCreateTime(DateUtil.date());
        //根据用户名生成token
        String token = tokenManager.createToken(user.getCurrentUserInfo().getUsername());
        //把用户名称和用户权限列表放到redis
        //key:用户名 value：权限列表
        redisTemplate.opsForValue().set(user.getCurrentUserInfo().getUsername(), user.getPermissionValueList());
        //返回token
        //aclLogService.addLog(aclLog);
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        //map.put("username", user.getUsername());
        map.put("user",user.getCurrentUserInfo());
        ResponseUtil.out(response, Result.ok(map));
    }

    /**
     * 3 认证失败调用的方法
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        logger.info("账户-密码-验证码错误");
        String message = exception.getMessage();
        //if (exception instanceof LockedException) {
        //    respBean.setMsg("账户被锁定，请联系管理员!");
        //} else if (exception instanceof CredentialsExpiredException) {
        //    respBean.setMsg("密码过期，请联系管理员!");
        //} else if (exception instanceof AccountExpiredException) {
        //    respBean.setMsg("账户过期，请联系管理员!");
        //} else if (exception instanceof DisabledException) {
        //    respBean.setMsg("账户被禁用，请联系管理员!");
        //} else if (exception instanceof BadCredentialsException) {
        //    respBean.setMsg("用户名或者密码输入错误，请重新输入!");
        //}
        if (exception instanceof AuthenticationServiceException) {
            ResponseUtil.out(response, R.usernameOrPasswordError("用户验证码错误!"));
        } else {
            ResponseUtil.out(response, R.usernameOrPasswordError("用户名或密码错误"));
        }
    }
}
