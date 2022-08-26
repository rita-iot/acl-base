package com.xiaoyi.base.system.taskScheduler;

import cn.hutool.core.date.DateUtil;
import com.xiaoyi.base.system.entity.AclTask;
import com.xiaoyi.base.system.service.AclTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:39
 * @version：1.0
 */
@Slf4j
@Component
public class CoreScheduler {
    @Autowired
    private AclTaskService aclTaskService;
    //数据库的任务
    //public static ConcurrentHashMap<String, AclTask> tasks = new ConcurrentHashMap<>(10);

    //正在运行的任务
    public static ConcurrentHashMap<String, ScheduledFuture> runTasks = new ConcurrentHashMap<>(10);

    //线程池任务调度
    private ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

    /**
     * 初始化线程池任务调度
     */
    @Autowired
    public CoreScheduler() {
        this.threadPoolTaskScheduler.setPoolSize(10);
        this.threadPoolTaskScheduler.setThreadNamePrefix("task-thread-");
        this.threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        this.threadPoolTaskScheduler.initialize();
    }


    /**
     * 根据定时任务id，启动定时任务
     */
    public void start(AclTask aclTask) {
        Integer taskId = aclTask.getTaskId();
        try {
            //AclTask tbTask = aclTaskService.getById(taskId);
            //获取并实例化Runnable任务类
            Class<?> clazz = Class.forName(aclTask.getTaskClass());
            Runnable runnable = (Runnable) clazz.newInstance();

            //Cron表达式
            CronTrigger cron = new CronTrigger(aclTask.getTaskExp());

            //执行，并put到runTasks
            CoreScheduler.runTasks.put(taskId + "", Objects.requireNonNull(this.threadPoolTaskScheduler.schedule(runnable, cron)));

            this.updateTaskStatus(taskId + "", 1);

            log.info("{}，任务启动！", taskId);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            log.error("{}，任务启动失败...", taskId);
            e.printStackTrace();
        }

    }

    /**
     * 根据定时任务id，停止定时任务
     */
    public void stop(AclTask aclTask) {
        String taskId = String.valueOf(aclTask.getTaskId());
        boolean b = CoreScheduler.runTasks.containsKey(taskId);
        if (b) {
            CoreScheduler.runTasks.get(taskId).cancel(true);
            ScheduledFuture scheduledFuture = CoreScheduler.runTasks.get(taskId);
            CoreScheduler.runTasks.remove(taskId);
        }
        this.updateTaskStatus(taskId, 2);
        log.info("{}，任务停止...", taskId);
    }

    /**
     * 更新数据库动态定时任务状态
     */
    private void updateTaskStatus(String taskId, int status) {
        AclTask task = aclTaskService.getById(taskId);
        task.setTaskStatus(status);
        task.setUpdateTime(DateUtil.date());
        aclTaskService.updateById(task);
    }
}
