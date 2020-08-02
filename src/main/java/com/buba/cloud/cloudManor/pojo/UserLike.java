package com.buba.cloud.cloudManor.pojo;

import lombok.Data;

/**
 * @Classname User
 * @Description 用户实体类表
 * @Date 2020/7/17 9:11
 * @Created by liulx
 */
@Data
public class UserLike {

    private Integer id;
    private  Integer RresourceId;//喜欢的作品id
    private  Integer userId;//用户id
    //---------查询展示所需字段---------
    private  String title;//标题
    private  String userName;//用户名
    private  String addressName;//地址名
    private  String imgName;//图片名称
    private  String imgDir;//图片地址


}
