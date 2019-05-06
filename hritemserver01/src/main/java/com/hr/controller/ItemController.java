package com.hr.controller;

import com.hr.entity.Item;
import com.hr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡冉
 * @ClassName ItemController
 * @Date 2019/5/5 9:19
 * @Version 2.0
 */
@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/queryItemById/{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        System.out.println("接口调用..............");
        return itemService.queryItemById(id);
    }
}
