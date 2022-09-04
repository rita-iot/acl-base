package com.xiaoyi.base.project.wechat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoyi.base.project.wechat.entity.WxUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/25 21:02
 * @version：1.0
 */
@Mapper
public interface WxUserMapper extends BaseMapper<WxUser> {
    /**
     * 删除全部用户
     */
    void removeAllUser();
}
