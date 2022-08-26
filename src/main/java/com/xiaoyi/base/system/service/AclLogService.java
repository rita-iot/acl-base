package com.xiaoyi.base.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoyi.base.system.entity.AclLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/29 11:30
 * @version：1.0
 */
public interface AclLogService extends IService<AclLog> {

    /**
     * 分页查询
     * @param aclLog
     * @return
     */
    IPage<AclLog> findpage(AclLog aclLog);

    /**
     * 异步保存方法
     * @param aclLog
     */
    void addLog(AclLog aclLog);

    /**
     * 登录分页方法
     * @param aclLog
     * @return
     */
    IPage<AclLog> findpageLogin(AclLog aclLog);
}
