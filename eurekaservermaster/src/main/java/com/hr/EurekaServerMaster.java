package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 胡冉
 * @ClassName EurekaServer
 * @Date 2019/5/5 18:23
 * @Version 2.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerMaster {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMaster.class);
    }

}
