package com.base.example.wechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.example.wechat.entity.WxUser;
import com.base.example.wechat.mapper.WxUserMapper;
import com.base.example.wechat.service.WxUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/25 16:58
 * @version：1.0
 */
@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUser> implements WxUserService {
    @Resource
    private WxUserMapper wxUserMapper;
}


