package com.hr.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 胡冉
 * @ClassName MyRandomRule
 * @Date 2019/5/6 11:08
 * @Version 2.0
 */
//@Configuration
public class MyRandomRule {


    @Bean
    public IRule myRule(){
        return  new RandomRule();
    }


}
