package com.xiaoyi.base.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.base.system.entity.YmRegion;
import com.xiaoyi.base.system.service.YmRegionService;
import com.xiaoyi.base.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2021/12/3 10:44
 * @version：1.0
 */
@Api(tags = "地区接口")
@RestController
@RequestMapping("/region")
public class YmRegionController {
    @Autowired
    private YmRegionService regionService;

    @ApiOperation("地区列表")
    @PostMapping("/list")
    public Result list() {
        List<YmRegion> list = regionService.list(new QueryWrapper<>());
        return Result.ok(list);
    }

    @ApiOperation("新增地区")
    @PostMapping("/add")
    public Result add(@RequestBody YmRegion ymRegion) {
        return Result.ok();
    }
}
