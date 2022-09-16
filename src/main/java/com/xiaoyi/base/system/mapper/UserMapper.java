package com.xiaoyi.base.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoyi.base.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: --
 * @author：Bing
 * @date：2022/9/16 13:32
 * @version：1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}