package com.buba.cloud.cloudManor.pojo;

import java.util.Date;

/**
 * @Classname MasterAccount
 * @Description 养护人提现记录
 * @Date 2020/7/17 11:08
 * @Created by liulx
 */
public class MasterAccount {
    private Integer id;
    private Integer masterId;//养护人id
    private Date time;//提现时间
    private Double money;//提现金额
    private Double remaindMoney;//余额
    private String info;//备注信息
}
