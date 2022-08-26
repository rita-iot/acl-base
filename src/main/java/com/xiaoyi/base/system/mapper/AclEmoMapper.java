package com.xiaoyi.base.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoyi.base.system.entity.AclEmo;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/26 15:37
 * @version：1.0
 */
@Mapper
public interface AclEmoMapper extends BaseMapper<AclEmo> {
    /**
     * 查找所有
     * @return
     */
    List<AclEmo> findAll();
}
