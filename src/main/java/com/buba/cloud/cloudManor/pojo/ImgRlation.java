package com.buba.cloud.cloudManor.pojo;

import lombok.Data;

/**
 * @Classname ImgRlation
 * @Description 图片和其它表的关联表
 * @Date 2020/7/17 9:32
 * @Created by liulx
 */
@Data
public class ImgRlation {
    private Integer id;
    private String typeCode;//关联image表的typeCode
    private Integer imageId;//关联Image表的id
    private Integer otherId;//其它表的id
    private Integer typeCode;
}
