package com.buba.cloud.cloudManor.pojo;

/**
 * @Classname UserInfo
 * @Description 用户冷数据信息
 * @Date 2020/7/17 9:20
 * @Created by liulx
 */
public class UserInfo {
    private Integer userId;//关联User表的id字段,该表的主键
    //身份证信息
    private Integer idCardId;//关联身份证IdCard表的id
    //余额
    private Double recodeMoney;//已入账余额，可以直接体现
    private Double noneRecodeMoney;//未入账，平台扣留部分

}
