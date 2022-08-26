package com.xiaoyi.base.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoyi.base.system.entity.AclDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    /**
     * 树结构
     * @param aclDept
     * @return
     */
    List<Tree<String>> tree(AclDept aclDept);
}
