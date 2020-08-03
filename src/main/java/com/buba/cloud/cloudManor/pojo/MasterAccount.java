package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname MasterAccount
 * @Description 养护人提现记录
 * @Date 2020/7/17 11:08
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MasterAccount {
    private Integer id;
    private Integer masterId;//养护人id
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date time;//提现时间
    private Double money;//提现金额
    private Double remaindMoney;//余额
    private String info;//备注信息
}
