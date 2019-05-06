package com.hr.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 胡冉
 * @ClassName OrderProperties
 * @Description: TODO
 * @Date 2019/5/5 13:04
 * @Version 2.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "hr")
public class OrderProperties {
    private ItemProperties item = new ItemProperties();

}
