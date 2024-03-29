package com.xiaoyi.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:31
 * @version：1.0
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
//@MapperScan(basePackages = {"com.xiaoyi.base.system.mapper","com.xiaoyi.base.wechat.mapper"})
//@ComponentScan(basePackages = {"com.base.example"})
public class BaseApplication {
    private static final Logger log = LoggerFactory.getLogger(BaseApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = SpringApplication.run(BaseApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        String port = environment.getProperty("server.port");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        //启动完成后在控制台提示项目启动成功，并且输出当前服务对应的swagger接口文档访问地址
        log.info("应用{}启动成功!swagger文档地址：http://{}:{}/doc.html", appName, hostAddress, port);
    }

}
