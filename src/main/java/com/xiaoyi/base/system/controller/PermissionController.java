package com.xiaoyi.base.system.controller;

import com.xiaoyi.base.system.entity.Permission;
import com.xiaoyi.base.system.service.PermissionService;
import com.xiaoyi.base.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限 菜单管理
 * @author testjava
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/admin/permission")
@Api(tags = "权限接口")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("getById/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Integer id) {
        Permission permission = permissionService.getById(id);
        return Result.ok(permission);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public Result add(@RequestBody Permission permission) {
        permissionService.save(permission);
        return Result.ok();
    }

    @PutMapping("updateById")
    @ApiOperation("修改")
    public Result updateById(@RequestBody Permission permission) {
        if (permission.getId() == null) return Result.fail("id不能为空");
        permissionService.updateById(permission);
        return Result.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable String  id) {
        permissionService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping
    public Result indexAllPermission() {
        List<Permission> list = permissionService.queryAllMenu();
        return Result.ok(list);
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public Result doAssign(String roleId, String[] permissionId) {
        permissionService.saveRolePermissionRealtionShipGuli(roleId, permissionId);
        return Result.ok();
    }

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("toAssign/{roleId}")
    public Result toAssign(@PathVariable String roleId) {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return Result.ok(list);
    }
}

