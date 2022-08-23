package com.base.example.primary.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.primary.entity.AclEmo;
import com.base.example.primary.service.AclEmoService;
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
 * @date：2022/3/24 15:19
 * @version：1.0
 */
@RestController
@RequestMapping("emo")
@Api(tags = "emo接口")
public class AclEmoController {

    @Autowired
    private AclEmoService aclEmoService;


    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result list() {
        List<AclEmo> list = aclEmoService.findAll();
        return Result.ok(list);
    }

    @PostMapping("page")
    @ApiOperation("分页")
    public ResultPage page(@RequestBody AclEmo aclEmo) {
        IPage<AclEmo> list = aclEmoService.page(aclEmo);
        return ResultPage.ok(list);
    }

    @GetMapping("getById/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Integer id) {
        AclEmo aclEmo = aclEmoService.getById(id);
        return Result.ok(aclEmo);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public Result add(@RequestBody AclEmo aclEmo) {
        if (aclEmo.getText() == null) return Result.fail("emo语句不能为空");
        aclEmo.setCreateTime(new Date());
        aclEmoService.save(aclEmo);
        return Result.ok();
    }

    @PostMapping("updateById")
    @ApiOperation("修改")
    public Result updateById(@RequestBody AclEmo aclEmo) {
        if (aclEmo.getId() == null) return Result.fail("emo语句不能为空");
        aclEmoService.updateById(aclEmo);
        return Result.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable Integer id) {
        aclEmoService.removeById(id);
        return Result.ok();
    }
}
