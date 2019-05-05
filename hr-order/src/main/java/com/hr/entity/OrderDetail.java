package com.hr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 胡冉
 * @ClassName OrderDetail
 * @Date 2019/5/5 9:28
 * @Version 2.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class OrderDetail {
    private String orderId;
    private Item item = new Item();

    public OrderDetail() {
    }

}
