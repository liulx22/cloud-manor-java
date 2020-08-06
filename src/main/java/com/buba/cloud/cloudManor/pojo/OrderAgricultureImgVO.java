package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName OrderAgricultureVO
 * @Description
 * @Created by Administrator on 2020/7/28 16:32
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderAgricultureImgVO {
    private Integer imgId;//图片/视频id
    private String imgName;//图片名称
    private String imgDir;//存放路径
    private String typeCode;//图片类型

}
