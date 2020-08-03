package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Classname Bank
 * @Description 银行卡表
 * @Date 2020/7/17 9:42
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BankCard {
    private Integer id;
    private String BankName;//开户行名称
    private String cardNum;  //银行卡号码
    private String userName;//开户行人的姓名
    private String phone;//开户行手机号码
    private String BankType;//银行类别
}
