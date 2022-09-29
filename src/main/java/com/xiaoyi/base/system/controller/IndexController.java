package com.xiaoyi.base.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyi.base.config.JwtTokenManager;
import com.xiaoyi.base.system.service.IndexService;
import com.xiaoyi.base.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:31
 * @version：1.0
 */
@RestController
@RequestMapping("index")
@Api(tags = "首页接口")
public class IndexController {

    @Autowired
    private IndexService indexService;
    private JwtTokenManager jwtTokenManager;

    /**
     * 获取登录用户信息
     */
    @GetMapping("info")
    @ApiOperation("获取登录用户信息")
    public Result info() {
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return Result.ok(userInfo);
    }

    /**
     * 获取菜单
     * @return
     */
    @GetMapping("menu")
    @ApiOperation("获取菜单")
    public Result getMenu() {
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList = indexService.getMenu(username);
        return Result.ok(permissionList);
    }

    @ApiOperation("注销登录")
    @PostMapping("logout")
    public Result logout() {
        System.out.println("logout执行了。。。");
        return Result.ok();
    }

    @ApiOperation("无需认证接口")
    @GetMapping("unAuth")
    public Result unAuth() {
        System.out.println("unAuth。。。");
        return Result.ok("当前接口没有认证，不需要token");
    }

    @ApiOperation("异常测试")
    @GetMapping("/exception")
    public Result exception() {
        //throw new GuliException(111111111, "自定义异常");
        return Result.ok();
    }
}
