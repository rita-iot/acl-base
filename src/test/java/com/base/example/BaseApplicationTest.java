package com.base.example;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.junit.jupiter.api.Test;
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

    @Test
    public  void getOpenId() throws WxErrorException {
        WxMpUserList wxMpUserList = wxMpService.getUserService().userList(null);
        System.out.println();
    }
}
