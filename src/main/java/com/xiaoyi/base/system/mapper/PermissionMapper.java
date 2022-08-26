package com.xiaoyi.base.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoyi.base.system.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限 Mapper 接口
 * @author testjava
 * @since 2020-01-12
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    List<String> selectPermissionValueByUserId(String id);

    List<String> selectAllPermissionValue();

    List<Permission> selectPermissionByUserId(String userId);
}
