package com.hr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrOrderApplicationTests {
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Test
	public void contextLoads() {
	}
	@Test
	public  void test(){
        String serviceId="hr-item";
        for(int i=0;i<100;i++){
            ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
            System.out.println("第"+(i+1)+"次: "+serviceInstance.getHost() + ":" + serviceInstance.getPort());
        }
	}
}
