package com.hr.service;

import com.hr.entity.Item;
import com.hr.properties.OrderProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 胡冉
 * @ClassName ItemService
 * @Date 2019/5/5 9:40
 * @Version 2.0
 */
@Service
public class ItemService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderProperties orderProperties;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 调用商品的微服务提供的接口进行查询数据
     *
     * @param id
     */
    @HystrixCommand(fallbackMethod = "queryItemByIdFallBack", commandProperties = {
            //隔离策略，有THREAD和SEMAPHORE
            // THREAD - 它在单独的线程上执行，并发请求受线程池中的线程数量的限制
            // SEMAPHORE - 它在调用线程上执行，并发请求受到信号量计数的限制
            //默认使用THREAD模式，以下几种场景可以使用SEMAPHORE模式：
            //只想控制并发度
            //外部的方法已经做了线程隔离
            //调用的是本地方法或者可靠度非常高、耗时特别小的方法（如medis）
            @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
            //超时时间 默认值：1000  在THREAD模式下，达到超时时间，可以中断
            //在SEMAPHORE模式下，会等待执行完成后，再去判断是否超时
            //设置标准：有retry，99meantime+avg meantime //没有retry，99.5meantime
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000"),
            //熔断触发的最小个数/10s 默认值：20
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //失败率达到多少百分比后熔断 默认值：50 主要根据依赖重要性进行调整
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "40")
    }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "10"),
            @HystrixProperty(name = "maxQueueSize", value = "10"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
            //
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
    })
    public Item queryItemById(Long id) {
      /*  List<ServiceInstance> list = this.discoveryClient.getInstances("HR-ITEM");
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ServiceInstance serviceInstance = list.get(0);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();*/
        //Ribbon如下
        return this.restTemplate.getForObject("http://" + "HR-ITEM" + "/item/queryItemById/" + id, Item.class);
    }

    public Item queryItemByIdFallBack(Long id) {
        return new Item(id, "商品查询出租", null, null, null);
    }
}
