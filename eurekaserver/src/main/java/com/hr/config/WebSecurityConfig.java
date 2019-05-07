package com.hr.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 胡冉
 * @ClassName WebSecurityConfig
 * @Date 2019/5/5 17:52
 * @Version 2.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //加这句是为了访问eureka控制台和/actuator时能做安全控制
        super.configure(http);
        http.csrf().disable();
    }

}
