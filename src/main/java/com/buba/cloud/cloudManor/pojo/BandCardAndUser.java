package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Classname BandCardAndUser
 * @Description 银行卡和养护人的关联表
 * @Date 2020/7/17 9:45
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BandCardAndUser {
    private Integer id;
    private Integer userId;//养护人id
    private Integer cardId;//银行卡id
}
