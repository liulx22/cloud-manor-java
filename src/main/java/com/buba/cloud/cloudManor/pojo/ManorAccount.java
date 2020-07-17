package com.buba.cloud.cloudManor.pojo;

import java.util.Date;

/**
 * @Classname ManorAccount
 * @Description 养护人账单
 * @Date 2020/7/17 11:03
 * @Created by liulx
 */
public class ManorAccount {
    private Integer id;
    private Date time;  //生成账单的时间
    private Date recordTime;//入账时间
    private Integer masterId;//养护人id
    private Double money;//金额
    private String paccountCode;//关联的账单编号
    private byte tag;//tag(0:未入账，1：已入账)
    private String info;//备注信息

}
