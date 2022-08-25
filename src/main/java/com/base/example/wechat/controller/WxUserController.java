package com.base.example.wechat.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.utils.Result;
import com.base.example.utils.ResultPage;
import com.base.example.wechat.entity.WxUser;
import com.base.example.wechat.service.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/25 17:13
 * @version：1.0
 */
@RestController
@RequestMapping("wxUser")
@Api(tags = "微信用户管理")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;

    @PostMapping("page")
    @ApiOperation("分页")
    public ResultPage page(@RequestBody WxUser wxUser) {
        IPage<WxUser> list = wxUserService.findBypage(wxUser);
        return ResultPage.ok(list);
    }

    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result list() {
        List<WxUser> list = wxUserService.list();
        return Result.ok(list);
    }

    @GetMapping("getById/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Integer id) {
        WxUser wxUser = wxUserService.getById(id);
        return Result.ok(wxUser);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public Result add(@RequestBody WxUser wxUser) {
        wxUser.setCreateTime(DateUtil.date());
        wxUserService.save(wxUser);
        return Result.ok();
    }

    @PutMapping("updateById")
    @ApiOperation("修改")
    public Result updateById(@RequestBody WxUser wxUser) {
        if (wxUser.getOpenId() == null) return Result.fail("id不能为空");
        wxUserService.updateById(wxUser);
        return Result.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable Integer id) {
        wxUserService.removeById(id);
        return Result.ok();
    }

    @GetMapping("syncUserList")
    @ApiOperation("同步用户列表")
    public Result syncUserList() {
        wxUserService.syncUserList();
        return Result.ok();
    }
}
