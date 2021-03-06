package com.tx.base.primary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tx.base.primary.entity.Post;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/26 21:49
 * @version：1.0
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {
}