package com.base.example.primary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.example.primary.entity.AclEmo;
import com.base.example.primary.mapper.AclEmoMapper;
import com.base.example.primary.service.AclEmoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/24 15:19
 * @version：1.0
 */
@Service
public class AclEmoServiceImpl extends ServiceImpl<AclEmoMapper, AclEmo> implements AclEmoService {

    @Resource
    private AclEmoMapper aclEmoMapper;

    @Override
    public List<AclEmo> findAll() {
        return aclEmoMapper.findAll();
    }

    /**
     * 简单分页
     * @param aclEmo
     * @return
     */
    @Override
    public IPage<AclEmo> page(AclEmo aclEmo) {
        IPage<AclEmo> iPage = new Page<>(aclEmo.getCurrentPage(), aclEmo.getPageSize());
        return this.page(iPage, new QueryWrapper<AclEmo>().orderByDesc("create_time"));
    }
}


