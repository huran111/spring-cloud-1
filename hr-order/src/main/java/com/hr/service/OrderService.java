package com.hr.service;

import com.hr.entity.Item;
import com.hr.entity.Order;
import com.hr.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 胡冉
 * @ClassName OrderService
 * @Date 2019/5/5 9:32
 * @Version 2.0
 */
@Service
public class OrderService {
    private static final Map<String, Order> MAP = new HashMap<>();
    @Autowired
    private ItemService itemService;

    static {
        Order order = new Order();
        order.setOrderId("111111")
                .setCreateDate(new Date())
                .setUpdateDate(new Date());
        order.setUserId(1L);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Item item = new Item();
        item.setId(1L);
        orderDetailList.add(new OrderDetail(order.getOrderId(), item));
        item = new Item();
        item.setId(2L);
        orderDetailList.add(new OrderDetail(order.getOrderId(), item));
        order.setOrderDetailList(orderDetailList);
        MAP.put(order.getOrderId(), order);
    }

    public Order queryOrderById(String orderId) {
        Order order = MAP.get(orderId);
        if (null == order) {
            return null;
        }
        List<OrderDetail> orderDetailList = order.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetailList) {
            Item item = this.itemService.queryItemById(orderDetail.getItem().getId());
            orderDetail.setItem(item);
        }
        return order;

    }
}
