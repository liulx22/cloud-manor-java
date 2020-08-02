package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class UserAttentionVo {
    private Integer userId;
    private String accountName;//账户
    private String password;//密码登陆
    private String userName;//中文名
    private String phone;  //手机号码
    private String email;  //邮箱
    private Integer sex;  //性别
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthday;  //生日
    private Integer imageId;  //关联图片表Image的id
    private Integer addressId; //关联Address表中pid不为0的id
    private String imgName;//图片名称
    private String imgDir;//存放路径
    private Integer attentionId;

}
