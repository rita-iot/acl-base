package com.base.example.primary.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.example.primary.entity.AclDept;
import com.base.example.primary.mapper.AclDeptMapper;
import com.base.example.primary.service.AclDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/24 9:53
 * @version：1.0
 */
@Service
public class AclDeptServiceImpl extends ServiceImpl<AclDeptMapper, AclDept> implements AclDeptService{
    @Resource
    private AclDeptMapper aclDeptMapper;

    @Override
    public IPage<AclDept> findBypage(AclDept aclDept) {
        return null;
    }
}
