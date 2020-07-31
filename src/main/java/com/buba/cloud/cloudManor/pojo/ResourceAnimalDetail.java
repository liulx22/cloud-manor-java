package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.util.Date;

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

    private Integer id;
    private String title;//标题
    private String reTypeCode;//资源类型的英文名称
    private Integer uid;//发布资源用户id
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;//发布时间
    private Integer imageId;
    private String imgDir;


}
