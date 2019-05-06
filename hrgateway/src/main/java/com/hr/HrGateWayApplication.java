package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 胡冉
 * @ClassName HrGateWayApplication
 * @Date 2019/5/6 16:07
 * @Version 2.0
 */
@EnableZuulProxy
@SpringBootApplication
public class HrGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrGateWayApplication.class);
    }
}
