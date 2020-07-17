package com.buba.cloud.cloudManor.pojo;

/**
 * @Classname Attention
 * @Description 关注表，其实是一张关联表
 * @Date 2020/7/17 10:08
 * @Created by liulx
 */
public class Attention {
    private Integer id;
    private Integer fromUserId;//关注人的id
    private Integer destUserId;//被关注人的id
}
