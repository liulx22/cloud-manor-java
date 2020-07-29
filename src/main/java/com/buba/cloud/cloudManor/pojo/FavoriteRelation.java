package com.buba.cloud.cloudManor.pojo;

/**
 * @Classname FavoriteRelation
 * @Description 喜欢产品（资源）
 * @Date 2020/7/29 14:07
 * @Created by liulx
 */
public class FavoriteRelation {
    private Integer id;
    private Integer userId;//关联用户User的id
    private Integer resourceId;//Resource的id
}
