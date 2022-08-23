package com.base.example.primary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.base.example.primary.entity.AclTask;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:31
 * @version：1.0
 */
public interface AclTaskService extends IService<AclTask>{

        /**
         * 分页查询
         * @param aclTask
         * @return
         */
        IPage<AclTask> findBypage(AclTask aclTask);
    }
