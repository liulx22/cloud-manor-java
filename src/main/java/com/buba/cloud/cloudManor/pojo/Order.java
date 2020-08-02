package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname Order
 * @Description 订单表
 * @Date 2020/7/23 15:14
 * @Created by liulx
 */
@Data
public class Order {
    private Integer id;
    private String orderNo;//订单编号   yyyymmddxxx
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderTime;//下单时间
    private Integer userId;//下单人
    private Integer resourceId;//资源id
    private String desc;//备注留言信息
    private Double money;//金额
    private String digitalCode;//订单状态  （待支付，已支付，已完成，已取消，未退款，）

}
