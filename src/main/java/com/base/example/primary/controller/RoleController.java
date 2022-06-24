package com.base.example.primary.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.core.anno.LogAnnotation;
import com.base.example.primary.entity.Role;
import com.base.example.primary.service.RoleService;
import com.base.example.utils.Result;
import com.base.example.utils.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/26 19:00
 * @version：1.0
 */
@RestController
@RequestMapping("role")
@Api(tags = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @LogAnnotation("角色管理-分页")
    @PostMapping("page")
    @ApiOperation("分页")
    public ResultPage page(@RequestBody Role role) {
        IPage<Role> list = roleService.findpage(role);
        return ResultPage.ok(list);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public Result save(@RequestBody Role role) {
        roleService.save(role);
        return Result.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("updateById")
    public Result updateById(@RequestBody Role role) {
        if (role.getId() == null) return Result.fail("id不能为空");
        roleService.updateById(role);
        return Result.ok();
    }

    @ApiOperation(value = "根据id查询")
    @GetMapping("getById/{id}")
    public Result getById(@PathVariable("id") String id) {
        Role role = roleService.getById(id);
        return Result.ok(role);
    }

    @ApiOperation(value = "根据id删除")
    @DeleteMapping("delById/{id}")
    public Result delById(@PathVariable("id") String id) {
        roleService.removeById(id);
        return Result.ok();
    }
}

