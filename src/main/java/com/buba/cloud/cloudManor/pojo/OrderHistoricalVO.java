package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * \* User: 智慧
 * \* Date: 2020/8/14
 * \* Time: 13:08
 * \* 模块:
 * \
 */
@Data
public class OrderHistoricalVO {
    private int id;
    private Long orderNo;//订单编号   yyyymmddxxx
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderTime;//下单时间
    private Double money;//金额
    private String title;//标题
    private String geographicPosition;//位置
    private String imgDir;//存放路径
    private String digitalCode;//订单状态  （待支付，已支付，已完成，已取消，未退款，）
    private Integer shijian;//筛选-时间
    private String leixing;//筛选-类型

}
