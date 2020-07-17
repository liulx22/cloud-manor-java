package com.buba.cloud.cloudManor.pojo;

/**
 * @Classname ImgRlation
 * @Description 图片和其它表的关联表
 * @Date 2020/7/17 9:32
 * @Created by liulx
 */
public class ImgRlation {
    private Integer id;
    private Integer imageId;//关联Image表的id
    private Integer otherId;//其它表的id
}
