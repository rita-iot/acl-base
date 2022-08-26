package com.xiaoyi.base.system.controller;

import com.xiaoyi.base.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: --
 * @author：Bing
 * @date：2022/6/10 11:30
 * @version：1.0
 */
@Slf4j
@RestController
@RequestMapping("test")
@Api(tags = "test接口")
public class TestController {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping("test")
    @ApiOperation("test")
    public Result test() {
        threadPoolTaskExecutor.submit(() -> {
            String name = Thread.currentThread().getName();
            log.info("123"+name);
        });
        return Result.ok();
    }
}
