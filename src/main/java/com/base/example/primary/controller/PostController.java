package com.base.example.primary.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.primary.entity.Post;
import com.base.example.primary.service.PostService;
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
 * @date：2022/3/26 21:50
 * @version：1.0
 */
@RestController
@RequestMapping("post")
@Api(tags = "岗位管理")
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping("list")
    @ApiOperation("查询所有")
    public Result list() {
        List<Post> list = postService.list();
        return Result.ok(list);
    }

    @PostMapping("page")
    @ApiOperation("分页")
    public ResultPage page(@RequestBody Post post) {
        IPage<Post> list = postService.findBypage(post);
        return ResultPage.ok(list);
    }

    @GetMapping("getById/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Integer id) {
        Post post = postService.getById(id);
        return Result.ok(post);
    }

    @PostMapping("add")
    @ApiOperation("新增")
    public Result add(@RequestBody Post post) {
        post.setCreateTime(new Date());
        postService.save(post);
        return Result.ok();
    }

    @PutMapping("updateById")
    @ApiOperation("修改")
    public Result updateById(@RequestBody Post post) {
        if (post.getPostId() == null) return Result.fail("id不能为空");
        postService.updateById(post);
        return Result.ok();
    }

    @ApiOperation("删除")
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable Integer id) {
        postService.removeById(id);
        return Result.ok();
    }
}

