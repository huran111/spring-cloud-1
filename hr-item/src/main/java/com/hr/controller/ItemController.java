package com.hr.controller;

import com.hr.config.JdbcConfig;
import com.hr.entity.Item;
import com.hr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private JdbcConfig jdbcConfig;

    @GetMapping(value = "/queryItemById/{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        System.out.println("接口调用..............");
        return itemService.queryItemById(id);
    }

    @GetMapping(value = "/test")
    public String test() {
        System.out.println("接口调用..............");
        return this.jdbcConfig.toString();
    }
}
