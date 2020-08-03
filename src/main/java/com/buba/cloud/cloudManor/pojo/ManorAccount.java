package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname ManorAccount
 * @Description 养护人账单
 * @Date 2020/7/17 11:03
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ManorAccount {
    private Integer id;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date time;  //生成账单的时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date recordTime;//入账时间
    private Integer masterId;//养护人id
    private Double money;//金额
    private String paccountCode;//关联的账单编号
    private byte tag;//tag(0:未入账，1：已入账)
    private String info;//备注信息

}
