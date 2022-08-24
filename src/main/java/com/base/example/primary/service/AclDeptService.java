package com.base.example.primary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.primary.entity.AclDept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/24 9:53
 * @version：1.0
 */
public interface AclDeptService extends IService<AclDept> {

    /**
     * 分页查询
     * @param aclDept
     * @return
     */
    IPage<AclDept> findBypage(AclDept aclDept);
}
