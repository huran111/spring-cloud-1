package com.hr.service;

import com.hr.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    /**
     * 调用商品的微服务提供的接口进行查询数据
     *
     * @param id
     */
    public Item queryItemById(Long id) {
        System.out.println("请求参数ID:"+id);
        String url = "http://localhost:8080/item/queryItemById/" + id;
        System.out.println(this.restTemplate.getForObject(url, Item.class));
        return this.restTemplate.getForObject(url, Item.class);
    }
}
