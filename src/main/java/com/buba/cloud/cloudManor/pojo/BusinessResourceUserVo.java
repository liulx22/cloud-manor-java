package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Classname Image
 * @Description 主营业务管理VO
 * @Date 2020/7/17 9:28
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BusinessResourceUserVo {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;
    private String resourceTypeName;//资源类型表的Name字段
    private Integer resourceTypeId;//资源类型表的id字段
    private Integer resourceTypeCode;//资源类型表的Code字段

    private Integer userBusinessId;//主营业务User表的id字段
    private Integer UserId;//主营业务User表的id字段
    private String details;//资源类型表的Name字段
}
