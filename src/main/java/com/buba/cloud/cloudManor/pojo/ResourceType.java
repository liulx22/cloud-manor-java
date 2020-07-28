package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Classname ResourceType
 * @Description 资源类型
 * @Date 2020/7/23 15:01
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;
    private String code;//英文代码
    private String name;//中文名称
}
