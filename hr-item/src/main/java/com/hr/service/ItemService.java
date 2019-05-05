package com.hr.service;

import com.hr.entity.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 胡冉
 * @ClassName ItemService
 * @Date 2019/5/5 9:14
 * @Version 2.0
 */
@Service
public class ItemService {
    private static final Map<Long, Item> MAP = new HashMap<>();

    static {
        MAP.put(1L, new Item(1L, "商品1", "http://图片1", "商品描述", 1000L));
        MAP.put(2L, new Item(2L, "商品2", "http://图片2", "商品描述", 2000L));
        MAP.put(3L, new Item(3L, "商品3", "http://图片3", "商品描述", 3000L));
        MAP.put(4L, new Item(4L, "商品4", "http://图片4", "商品描述", 4000L));
        MAP.put(5L, new Item(5L, "商品5", "http://图片5", "商品描述", 5000L));
        MAP.put(6L, new Item(6L, "商品6", "http://图片6", "商品描述", 6000L));
        MAP.put(7L, new Item(7L, "商品7", "http://图片7", "商品描述", 7000L));
        MAP.put(8L, new Item(8L, "商品8", "http://图片8", "商品描述", 8000L));
    }

    public Item queryItemById(Long id) {
        return MAP.get(id);
    }
}
