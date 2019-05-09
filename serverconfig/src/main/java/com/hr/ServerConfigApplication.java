package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 胡冉
 * @ClassName ServerConfigApplication
 * @Date 2019/5/7 15:34
 * @Version 2.0
 */
/**
 * 开启配置服务
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ServerConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerConfigApplication.class);
    }
}
