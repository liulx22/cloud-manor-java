package com.buba.cloud.cloudManor.pojo;

import lombok.Data;

/**
 * @Classname Digital
 * @Description 字典表（存储常量信息）
 * @Date 2020/7/23 15:19
 * @Created by liulx
 */
@Data
public class Digital {
    private Integer id;
    private String type;//类型   订单-order   图片类型-image
    private String code;//英文code
    private String name;//中文名称
}
