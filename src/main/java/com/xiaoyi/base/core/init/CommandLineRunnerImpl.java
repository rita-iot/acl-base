package com.xiaoyi.base.core.init;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.base.system.entity.AclTask;
import com.xiaoyi.base.system.service.AclTaskService;
import com.xiaoyi.base.system.taskscheduler.CoreScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: --项目启动成功后执行
 * @author：Bing
 * @date：2022/1/17 17:28
 * @version：1.0
 */
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CommandLineRunnerImpl.class);
    @Autowired
    private AclTaskService aclTaskService;
    @Autowired
    private CoreScheduler coreScheduler;

    @Override
    public void run(String... args) throws Exception {
        log.info("extends CommandLineRunner interface,spring boot run ...");
        initTask();
    }

    /**
     * 初始化执行定时任务
     */
    private void initTask() {
        QueryWrapper<AclTask> qw = new QueryWrapper<>();
        qw.eq("task_status", 1);
        List<AclTask> list = aclTaskService.list(qw);
        for (AclTask aclTask : list) {
            coreScheduler.start(aclTask);
        }
    }
}
