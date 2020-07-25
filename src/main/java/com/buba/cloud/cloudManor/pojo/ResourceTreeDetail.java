package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Classname ResourceTreeDetail
 * @Description 树的产品描述信息
 * @Date 2020/7/23 15:11
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResourceTreeDetail {
    private Integer resourceId;//资源id
    private String breedName;//树木品种
    private Integer treeAge;//树龄
    private String yearlyOutput;//年产量
    private Integer diameter;//树木直径
    private Date leaseTime;//承包时间
    private String geographicPosition;//位置

}
