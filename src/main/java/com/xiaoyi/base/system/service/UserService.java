package com.xiaoyi.base.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyi.base.system.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
public interface UserService extends IService<User> {

    // 从数据库中取出用户信息
    User selectByUsername(String username);

    /**
     * 分页查询
     * @param user
     * @return
     */
    IPage<User> findPage(User user);

    /**
     * 查询是否有当前用户
     * @param user
     * @return
     */
    Boolean findByUserName(User user);
}
