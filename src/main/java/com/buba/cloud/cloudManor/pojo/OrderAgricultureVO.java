package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName OrderAgricultureVO
 * @Description
 * @Created by Administrator on 2020/7/28 16:32
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderAgricultureVO {
    private Integer aId;//农事id
    private Integer orderId;//订单id
    private Integer resourceId;//产品（资源）Id
    private String content;//农事内容
    private List<OrderAgricultureImgVO> orderAgricultureImgVO;
}
