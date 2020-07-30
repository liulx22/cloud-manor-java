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
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date leaseTime;//承包时间
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

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public Integer getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(Integer treeAge) {
        this.treeAge = treeAge;
    }

    public String getYearlyOutput() {
        return yearlyOutput;
    }

    public void setYearlyOutput(String yearlyOutput) {
        this.yearlyOutput = yearlyOutput;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Date getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(Date leaseTime) {
        this.leaseTime = leaseTime;
    }

    public String getGeographicPosition() {
        return geographicPosition;
    }

    public void setGeographicPosition(String geographicPosition) {
        this.geographicPosition = geographicPosition;
    }

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
}
