package com.buba.cloud.cloudManor.pojo;

import java.util.Date;

/**
 * @Classname Agriculture
 * @Description 农事表
 * @Date 2020/7/23 15:29
 * @Created by liulx
 */
public class Agriculture {
    private Integer id;
    private Integer userId;//谁发布的
    private Date putTime;//什么时间发布的
    private Date operationTime;//计划操作时间
    private Integer resourceId;//针对哪个产品发布的
    private String content;//发布的内容
    /*type=agriculture   未完成，已完成，进行中，取消*/
    private String code;//状态，关联Digital表

}
