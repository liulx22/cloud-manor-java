package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Classname User
 * @Description 用户实体类表
 * @Date 2020/7/17 9:11
 * @Created by liulx
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;
    private String accountName;//账户
    private String password;//密码登陆
    private String userName;//中文名
    private String phone;  //手机号码
    private String email;  //邮箱
    private Integer sex;  //性别
    private Date birthday;  //生日
    private Integer imageId;  //关联图片表Image的id
    private Integer addressId; //关联Address表中pid不为0的id

    //角色
    private Integer role;
    /**
     * 0:庄园主
     * 1:养护人
     * */
}
