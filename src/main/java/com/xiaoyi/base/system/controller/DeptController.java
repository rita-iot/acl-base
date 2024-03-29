package com.xiaoyi.base.system.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoyi.base.system.entity.AclDept;
import com.xiaoyi.base.system.service.AclDeptService;
import com.xiaoyi.base.utils.Result;
import com.xiaoyi.base.utils.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/24 9:55
 * @version：1.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("dept")
@Api(tags = "部门管理")
public class DeptController {

    @Autowired
    private AclDeptService aclDeptService;

    @PostMapping("page")
    @ApiOperation("分页")
    public ResultPage page(@RequestBody AclDept aclDept) {
        IPage<AclDept> list = aclDeptService.findBypage(aclDept);
        return ResultPage.ok(list);
    }

    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result list() {
        List<AclDept> list = aclDeptService.list();
        return Result.ok(list);
    }

    @GetMapping("getById/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Integer id) {
        AclDept aclDept = aclDeptService.getById(id);
        return Result.ok(aclDept);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public Result add(@RequestBody AclDept aclDept) {
        aclDept.setCreateTime(DateUtil.date());
        aclDeptService.save(aclDept);
        return Result.ok();
    }

    @PutMapping("updateById")
    @ApiOperation("修改")
    public Result updateById(@RequestBody AclDept aclDept) {
        if (aclDept.getDeptId() == null) {
            return Result.fail("id不能为空");
        }
        aclDeptService.updateById(aclDept);
        return Result.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable Integer id) {
        aclDeptService.removeById(id);
        return Result.ok();
    }

    @PostMapping("tree")
    @ApiOperation("树行结构")
    public Result menuTree(@RequestBody AclDept aclDept) {
        //if(sysMenu.getType() == null) return Result.fail("type不能为空");
        List<Tree<String>> tree = aclDeptService.tree(aclDept);
        return Result.ok(tree);
    }
}
