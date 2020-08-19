package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
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
@Table(name = "resourcetreedetail")
public class ResourceTreeDetail {
    private Integer resourceId;//资源id
    private String breedName;//树木品种
    private Integer treeAge;//树龄
    private String yearlyOutput;//年产量
    private Integer diameter;//树木直径
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date leaseTime;//承包时间
    private String geographicPosition;//位置
    private Integer id;
    private String title;//标题
    private String reTypeCode;//资源类型的英文名称
    private Integer uid;//发布资源用户id
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date publicDate;//发布时间
    private Integer imageId;
    private String imgDir;


}
