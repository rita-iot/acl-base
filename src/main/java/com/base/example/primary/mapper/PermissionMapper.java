package com.base.example.primary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.example.primary.entity.Permission;

import java.util.List;

/**
 * 权限 Mapper 接口
 * @author testjava
 * @since 2020-01-12
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<String> selectPermissionValueByUserId(String id);

    List<String> selectAllPermissionValue();

    List<Permission> selectPermissionByUserId(String userId);
}
