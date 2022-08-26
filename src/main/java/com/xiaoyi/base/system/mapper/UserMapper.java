package com.xiaoyi.base.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoyi.base.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper 接口
 * @author testjava
 * @since 2020-01-12
 */
@Mapper

public interface UserMapper extends BaseMapper<User> {

}
