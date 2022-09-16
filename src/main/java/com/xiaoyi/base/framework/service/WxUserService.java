package com.xiaoyi.base.framework.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyi.base.framework.entity.WxUser;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/25 16:58
 * @version：1.0
 */
public interface WxUserService extends IService<WxUser> {

    /**
     * 分页查询
     * @param wxUser
     * @return
     */
    IPage<WxUser> findBypage(WxUser wxUser);

    /**
     * 同步用户列表
     */
    void syncUserList();
}


