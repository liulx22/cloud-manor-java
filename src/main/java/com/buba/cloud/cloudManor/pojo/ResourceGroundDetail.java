package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Classname ResourceGroundDetail
 * @Description 地块资源详情
 * @Date 2020/7/23 15:12
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResourceGroundDetail {
    private Integer resourceId;//资源id
    private String plantType;//去年种植
    private String yield;//产量
    private String proportion;//面积
    private String landType;//土地类型
    private Date leaseTime;//承包时间
    private String geographicPosition;//位置


}
