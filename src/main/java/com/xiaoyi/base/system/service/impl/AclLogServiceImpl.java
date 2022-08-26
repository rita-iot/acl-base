package com.xiaoyi.base.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoyi.base.system.entity.AclLog;
import com.xiaoyi.base.system.mapper.AclLogMapper;
import com.xiaoyi.base.system.service.AclLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/29 11:30
 * @version：1.0
 */
@Service
public class AclLogServiceImpl extends ServiceImpl<AclLogMapper, AclLog> implements AclLogService {
    @Autowired
    private AclLogMapper aclLogMapper;

    private static final Logger log = LoggerFactory.getLogger(AclLogServiceImpl.class);

    @Override
    public IPage<AclLog> findpage(AclLog aclLog) {
        IPage<AclLog> iPage = new Page<>(aclLog.getCurrentPage(), aclLog.getPageSize());
        return this.page(iPage, new QueryWrapper<AclLog>().orderByDesc("create_time").eq("type",2));
    }

    @Async
    @Override
    public void addLog(AclLog aclLog) {
        //String name = Thread.currentThread().getName();
        //log.error("当前线程名："+name);
        this.save(aclLog);
    }

    @Override
    public IPage<AclLog> findpageLogin(AclLog aclLog) {
        IPage<AclLog> iPage = new Page<>(aclLog.getCurrentPage(), aclLog.getPageSize());
        return this.page(iPage, new QueryWrapper<AclLog>().orderByDesc("create_time").eq("type",1));
    }
}
