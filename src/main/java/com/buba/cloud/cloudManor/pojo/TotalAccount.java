package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname Account
 * @Description 总账单表
 * @Date 2020/7/17 10:14
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TotalAccount {
    private Integer id;
    private String accountCode;//账单编号（yyyymmddzidyid）庄园主id养护人id
    private Double totalMoney; //庄主支付的钱数
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date time;  //生成账单的时间
    private Integer masterId;//庄主id
    private Integer manorId;//养护人id
    private Double cloudMoney;//平台抽成金额
    private Double recordMoney;//养护人入账金额
    private Double noneRecordMoney;//养护人未入账金额
    private String info;//备注信息

}
