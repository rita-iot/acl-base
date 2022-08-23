package com.base.example.primary.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.primary.entity.AclTask;
import com.base.example.primary.service.AclTaskService;
import com.base.example.primary.taskScheduler.TestScheduler;
import com.base.example.utils.Result;
import com.base.example.utils.ResultPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:28
 * @version：1.0
 */
@RestController
@RequestMapping("task")
@Api(tags = "定时任务")
public class AclTaskController {
    @Autowired
    private AclTaskService aclTaskService;
    @Resource
    private TestScheduler testScheduler;

    @PostMapping("page")
    @ApiOperation("分页")
    public ResultPage page(@RequestBody AclTask aclTask) {
        IPage<AclTask> list = aclTaskService.findBypage(aclTask);
        return ResultPage.ok(list);
    }

    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result list() {
        List<AclTask> list = aclTaskService.list();
        return Result.ok(list);
    }

    @GetMapping("getById/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Integer id) {
        AclTask aclTask = aclTaskService.getById(id);
        return Result.ok(aclTask);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public Result add(@RequestBody AclTask aclTask) {
        if (aclTask.getTaskId() == null) return Result.fail("id不能为空");
        aclTask.setCreateTime(new Date());
        aclTaskService.save(aclTask);
        return Result.ok();
    }

    @PostMapping("updateById")
    @ApiOperation("修改")
    public Result updateById(@RequestBody AclTask aclTask) {
        if (aclTask.getTaskId() == null) return Result.fail("emo语句不能为空");
        aclTaskService.updateById(aclTask);
        return Result.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable Integer id) {
        aclTaskService.removeById(id);
        return Result.ok();
    }

    @ApiOperation("启动")
    @GetMapping("start/{taskId}")
    public Result start(@PathVariable("taskId") String taskId) {
        testScheduler.start(taskId);
        return Result.ok();

    }

    @ApiOperation("停止")
    @GetMapping("stop/{taskId}")
    public Result stop(@PathVariable("taskId") String taskId) {
        testScheduler.stop(taskId);
        return Result.ok();
    }

    @ApiOperation("更新定时任务")
    @PostMapping("updateTask")
    public Result save(@RequestBody AclTask task) throws IllegalAccessException {
        //先更新表数据
        //AclTask tbTask = aclTaskService.getById(task.getTaskId());
        aclTaskService.updateById(task);
        //null值忽略
        List<String> ignoreProperties = new ArrayList<>(7);

        //反射获取Class的属性（Field表示类中的成员变量）
        for (Field field : task.getClass().getDeclaredFields()) {
            //获取授权
            field.setAccessible(true);
            //属性名称
            String fieldName = field.getName();
            //属性的值
            Object fieldValue = field.get(task);
            //找出值为空的属性，我们复制的时候不进行赋值
            if (null == fieldValue) {
                ignoreProperties.add(fieldName);
            }
        }

        //org.springframework.beans BeanUtils.copyProperties(A,B)：A中的值付给B
        //BeanUtils.copyProperties(task, AclTask, ignoreProperties.toArray(new String[0]));
        //tbTaskRepository.save(tbTask);
        TestScheduler.tasks.clear();

        //停止旧任务
        testScheduler.stop(task.getTaskId() + "");

        //重新启动
        testScheduler.start(task.getTaskId() + "");
        return Result.ok();
    }
}
