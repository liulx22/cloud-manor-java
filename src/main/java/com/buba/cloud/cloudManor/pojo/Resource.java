package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Classname TransationHistory
 * @Description 资源（作品）
 * @Date 2020/7/23 14:49
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Resource {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;
    private String title;//标题
    private String reTypeCode;//资源类型的英文名称
    private Integer uid;//发布资源用户id
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date publicDate;//发布时间
    private Integer imageId;
    private String imgDir;
    //图片信息，视频信息关联图片表
    //浏览量，关注量，收藏量都用缓存实现
    private ResourceAnimalDetail resourceAnimalDetail;
    private ResourceGroundDetail resourceGroundDetail;
    private ResourceTreeDetail resourceTreeDetail;
    private Double money;//金额


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReTypeCode() {
        return reTypeCode;
    }

    public void setReTypeCode(String reTypeCode) {
        this.reTypeCode = reTypeCode;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImgDir() {
        return imgDir;
    }

    public void setImgDir(String imgDir) {
        this.imgDir = imgDir;
    }

    public ResourceAnimalDetail getResourceAnimalDetail() {
        return resourceAnimalDetail;
    }

    public void setResourceAnimalDetail(ResourceAnimalDetail resourceAnimalDetail) {
        this.resourceAnimalDetail = resourceAnimalDetail;
    }

    public ResourceGroundDetail getResourceGroundDetail() {
        return resourceGroundDetail;
    }

    public void setResourceGroundDetail(ResourceGroundDetail resourceGroundDetail) {
        this.resourceGroundDetail = resourceGroundDetail;
    }

    public ResourceTreeDetail getResourceTreeDetail() {
        return resourceTreeDetail;
    }

    public void setResourceTreeDetail(ResourceTreeDetail resourceTreeDetail) {
        this.resourceTreeDetail = resourceTreeDetail;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
