package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 胡冉
 * @ClassName HrItemServerApplication
 * @Date 2019/5/6 10:45
 * @Version 2.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HrItemServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrItemServerApplication.class, args);
    }

}
