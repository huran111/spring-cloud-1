package com.hr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 胡冉
 * @ClassName Item
 * @Date 2019/5/5 9:12
 * @Version 2.0
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Item {
    private Long id;
    private String title;
    private String pic;
    private String desc;
    private Long price;


}
