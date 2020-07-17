package com.buba.cloud.cloudManor.pojo;

import java.util.Date;

/**
 * @Classname User
 * @Description 用户实体类表
 * @Date 2020/7/17 9:11
 * @Created by liulx
 */
public class User {
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
