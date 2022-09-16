package com.xiaoyi.base.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyi.base.config.JwtTokenManager;
import com.xiaoyi.base.config.LoginUser;
import com.xiaoyi.base.core.redis.RedisService;
import com.xiaoyi.base.system.entity.User;
import com.xiaoyi.base.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description: --
 * @author：Bing
 * @date：2022/9/16 11:23
 * @version：1.0
 */
@RestController
@Api(tags = "登录注销")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenManager jwtTokenManager;
    @Autowired
    private RedisService redisService;

    @ApiOperation("用户登录")
    @PostMapping("/user/login")
    public Result login(@RequestBody User user) {
        //3使用ProviderManager auth方法进行验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //校验失败了
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误!");
        }
        //4自己生成jwt给前端
        LoginUser loginUser = (LoginUser) (authenticate.getPrincipal());
        User currentUser = loginUser.getCurrentUser();
        currentUser.setPassword(null);
        String username = loginUser.getUsername();
        //String jwt = JwtUtil.createJWT(userId);
        String token = jwtTokenManager.createToken(username);
        Map<String, Object> map = new HashMap();
        map.put("token", token);
        map.put("user", currentUser);
        //5系统用户相关所有信息放入redis
        //  有效期4小时
        String jsonString = JSONObject.toJSONString(loginUser);
        redisService.set("login:" + username, jsonString, 14400);
        return Result.ok(map);
    }

    @ApiOperation("退出登录")
    @GetMapping("/user/logout")
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String username = loginUser.getUsername();
        redisService.del("login:" + username);
        return Result.ok();
    }
}
