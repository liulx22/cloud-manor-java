package com.buba.cloud.cloudManor.pojo;

/**
 * @ClassName Like
 * @Description 喜欢表，是一张关联表
 * @Created by Administrator on 2020/7/28 15:55
 * @Version 1.0
 **/
public class UserLike {
    private Integer id;
    private Integer fromUserId;//喜欢人的id
    private Integer resourceId;//喜欢的资源id

}
