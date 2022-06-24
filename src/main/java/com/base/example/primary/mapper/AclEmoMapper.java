package com.base.example.primary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.base.example.primary.entity.AclEmo;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/25 9:46
 * @version：1.0
 */
@Mapper
public interface AclEmoMapper extends BaseMapper<AclEmo> {
    List<AclEmo> findAll();
}
