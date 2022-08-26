package com.xiaoyi.base.system.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoyi.base.system.entity.User;
import com.xiaoyi.base.system.service.RoleService;
import com.xiaoyi.base.system.service.UserService;
import com.xiaoyi.base.utils.R;
import com.xiaoyi.base.utils.Result;
import com.xiaoyi.base.utils.ResultPage;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 用户接口
 * @author testjava
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/admin/user")
@Api(tags = "用户管理")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "获取管理用户分页列表")
    @PostMapping("page")
    public ResultPage page(@RequestBody User user) {
        IPage<User> page = userService.findPage(user);
        return ResultPage.ok(page);
    }

    @ApiOperation(value = "新增管理用户")
    @PostMapping("save")
    public Result save(@RequestBody User user) {
        Boolean b = userService.findByUserName(user);
        if (b) return Result.fail("当前登录名已存在，请使用其他登录名");
        BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
        user.setPassword(bp.encode(user.getPassword()));
        // 这里要判断用户名是否重复
        userService.save(user);
        return Result.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable String id) {
        if (id.equals("1")) return Result.fail("超级管理员不能删除");
        userService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("/toAssign/{userId}")
    public R toAssign(@PathVariable String userId) {
        Map<String, Object> roleMap = roleService.findRoleByUserId(userId);
        return R.ok().data(roleMap);
    }

    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/doAssign")
    public R doAssign(@RequestParam String userId, @RequestParam String[] roleId) {
        roleService.saveUserRoleRealtionShip(userId, roleId);
        return R.ok();
    }
    @ApiOperation(value = "根据id查询")
    @GetMapping("getById/{id}")
    public Result getById(@PathVariable("id") String id) {
        User user = userService.getById(id);
        return Result.ok(user);
    }

    @ApiOperation(value = "修改")
    @PutMapping("updateById")
    public Result updateById(@RequestBody User user) {
        if (user.getId() == null) return Result.fail("id不能为空");
        if (user.getId().equals("1")) return Result.fail("超级管理员不能更新");
        userService.updateById(user);
        return Result.ok();
    }

    /**
     * 获取验证码接口
     * @param response
     */
    @ApiOperation("获取验证码")
    @GetMapping("/getVerificationCode")
    public void getVerificationCode(ServletResponse response) {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(220, 80, 5, 6);
        //ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        //captcha.write("d:/shear.png");
        //验证图形验证码的有效性，返回boolean值
        log.info("当前验证码为：" + captcha.getCode());
        //  验证码放到redis中 key:value
        redisTemplate.opsForValue().set("123", captcha.getCode());
        captcha.verify("1234");
        try {
            //  写入验证码到流中
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("获取easyCaptcha")
    @GetMapping("/getEasyCaptcha")
    public void easyCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        //SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        //// 设置字体
        //specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        //// 设置类型，纯数字、纯字母、字母数字混合
        //specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        // 算术验证码
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        //captcha.setLen(3);  // 几位数运算，默认是两位
        captcha.getArithmeticString();  // 获取运算的公式：3+2=?
        captcha.text();  // 获取运算的结果：5
        System.out.println(captcha.text());


        // 验证码存入session
        //request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());

        // 输出图片流
        try {
            captcha.out(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

