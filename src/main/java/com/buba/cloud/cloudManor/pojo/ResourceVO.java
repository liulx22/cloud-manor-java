package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Administrator
 * @create 2020-07-31 8:39
 * @desc 资源vo
 **/
@Data
public class ResourceVO {
    private Integer id;
    /*resource表字段*/
    private String title;//标题
    private Integer uid;//用户id
    private String reTypeCode;//资源类型的英文名称
    private Double money;//金额
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;//发布时间
    /*animal字段*/
    private String breedName;//牲畜品种
    private Double weight;//重量
    private String colour;//颜色
    private Integer age;//年龄
    private String vaccine;//是否打过疫苗
    private String geographicPosition;//位置
    /*ground表字段*/
    private String plantType;//去年种植
    private String yield;//产量
    private String proportion;//面积
    private String landType;//土地类型
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date leaseTime;//承包时间
    /*tree表字段*/
    private Integer treeAge;//树龄
    private String yearlyOutput;//年产量
    private Integer diameter;//树木直径
}
