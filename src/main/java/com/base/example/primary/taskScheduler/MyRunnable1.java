package com.base.example.primary.taskScheduler;

/**
 * @description: --Runnable任务类1
 * @author：Bing
 * @date：2022/8/23 8:51
 * @version：1.0
 */

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        log.info("MyRunnable1  {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
