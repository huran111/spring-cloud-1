package com.hr.controller;

import com.hr.entity.Order;
import com.hr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡冉
 * @ClassName OrderController
 * @Date 2019/5/5 9:56
 * @Version 2.0
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = "order/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") String orderId) {
        return this.orderService.queryOrderById(orderId);
    }
}
