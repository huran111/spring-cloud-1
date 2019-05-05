package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huran
 */
@EnableDiscoveryClient
@SpringBootApplication
public class  HrItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrItemApplication.class, args);
	}

}
