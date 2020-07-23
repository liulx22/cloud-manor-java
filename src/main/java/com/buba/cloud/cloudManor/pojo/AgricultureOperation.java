package com.buba.cloud.cloudManor.pojo;

import java.util.Date;

/**
 * @Classname AgricultureOperation
 * @Description 养护记录表
 * @Date 2020/7/23 15:37
 * @Created by liulx
 */
public class AgricultureOperation {
    private Integer id;
    private Integer aid;//农事id
    private Integer resourceId;//产品（资源）Id
    private Date  operTime;//操作时间
    private String title;//标题
    //视频，图片关联图片表
}
