package com.hr.feign;

import com.hr.entity.Item;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 胡冉
 * @ClassName ItemFeignClient
 * @Date 2019/5/6 14:15
 * @Version 2.0
 */
@FeignClient(value = "hr-item")
public interface ItemFeignClient {
    /**
     * 根據
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/item/queryItemById/{id}", method = RequestMethod.GET)
    Item queryItemById(@PathVariable("id") Long id);
}
