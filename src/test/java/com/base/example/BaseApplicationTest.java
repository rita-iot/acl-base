package com.base.example;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base项目系统
 * 主启动类
 */
@SpringBootTest
@Slf4j
class BaseApplicationTest {
    @Autowired
    private WxMpService wxMpService;
}
