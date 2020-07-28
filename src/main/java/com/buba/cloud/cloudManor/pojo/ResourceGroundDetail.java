package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
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
@Table(name = "resourcegrounddetail")
public class ResourceGroundDetail {
    private Integer resourceId;//资源id
    private String plantType;//去年种植
    private String yield;//产量
    private String proportion;//面积
    private String landType;//土地类型
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date leaseTime;//承包时间
    private String geographicPosition;//位置


}
