package com.base.example.primary.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.primary.entity.AclLog;
import com.base.example.primary.service.AclLogService;
import com.base.example.utils.Result;
import com.base.example.utils.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/29 11:39
 * @version：1.0
 */
@RestController
@RequestMapping("log")
@Api(tags = "日志接口")
public class AclLogController {

    @Autowired
    private AclLogService aclLogService;


    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result list() {
        List<AclLog> list = aclLogService.list();
        return Result.ok(list);
    }
    @PostMapping("page")
    @ApiOperation("分页")
    public ResultPage page(@RequestBody AclLog aclLog) {
        IPage<AclLog> list = aclLogService.findpage(aclLog);
        return ResultPage.ok(list);
    }

    @PostMapping("page/login")
    @ApiOperation("分页")
    public ResultPage pageLogin(@RequestBody AclLog aclLog) {
        IPage<AclLog> list = aclLogService.findpageLogin(aclLog);
        return ResultPage.ok(list);
    }
    @GetMapping("getById/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Integer id) {
        AclLog aclLog = aclLogService.getById(id);
        return Result.ok(aclLog);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public Result add(@RequestBody AclLog aclLog) {
        if (aclLog.getId() == null) return Result.fail("id不能为空");
        aclLog.setCreateTime(new Date());
        aclLogService.save(aclLog);
        return Result.ok();
    }
    @PostMapping("updateById")
    @ApiOperation("修改")
    public Result updateById(@RequestBody AclLog aclLog) {
        if (aclLog.getId() == null) return Result.fail("emo语句不能为空");
        aclLogService.updateById(aclLog);
        return Result.ok();
    }
    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable Integer id) {
        aclLogService.removeById(id);
        return Result.ok();
    }
}
