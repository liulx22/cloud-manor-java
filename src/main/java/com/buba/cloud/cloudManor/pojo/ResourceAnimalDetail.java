package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * @Classname ResourceAnimalDetail
 * @Description 畜牧业的资源详情
 * @Date 2020/7/23 15:12
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "resourceanimaldetail")
public class ResourceAnimalDetail {
    private Integer resourceId;//资源id
    private String breedName;//牲畜品种
    private Double weight;//重量
    private String colour;//颜色
    private Integer age;//年龄
    private String vaccine;//是否打过疫苗
    private String geographicPosition;//位置
}
