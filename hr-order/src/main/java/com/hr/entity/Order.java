package com.hr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author 胡冉
 * @ClassName Order
 * @Date 2019/5/5 9:27
 * @Version 2.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Order {
    private String orderId;
    private Long userId;
    private Date createDate;
    private Date updateDate;
    private List<OrderDetail> orderDetailList;
    public Order(){}
}
