package com.xiaoyi.base.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyi.base.system.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/26 19:00
 * @version：1.0
 */
public interface RoleService extends IService<Role> {

    //根据用户获取角色数据
    Map<String, Object> findRoleByUserId(String userId);

    //根据用户分配角色
    void saveUserRoleRealtionShip(String userId, String[] roleId);

    List<Role> selectRoleByUserId(String id);

    /**
     * 分页查询
     * @param role
     * @return
     */
    IPage<Role> findpage(Role role);
}



