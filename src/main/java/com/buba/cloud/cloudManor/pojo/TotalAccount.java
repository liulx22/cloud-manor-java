package com.buba.cloud.cloudManor.pojo;

import java.util.Date;

/**
 * @Classname Account
 * @Description 总账单表
 * @Date 2020/7/17 10:14
 * @Created by liulx
 */
public class TotalAccount {
    private Integer id;
    private String accountCode;//账单编号（yyyymmddzidyid）
    private Double totalMoney; //庄主支付的钱数
    private Date time;  //生成账单的时间
    private Integer masterId;//庄主id
    private Integer manorId;//养护人id
    private Double cloudMoney;//平台抽成金额
    private Double recordMoney;//养护人入账金额
    private Double noneRecordMoney;//养护人未入账金额
    private String info;//备注信息

}
