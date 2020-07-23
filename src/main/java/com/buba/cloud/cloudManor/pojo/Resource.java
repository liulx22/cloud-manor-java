package com.buba.cloud.cloudManor.pojo;

import java.util.Date;

/**
 * @Classname TransationHistory
 * @Description 资源（作品）
 * @Date 2020/7/23 14:49
 * @Created by liulx
 */
public class Resource {
    private Integer id;
    private String title;//标题
    private String reTypeCode;//资源类型的英文名称
    private Integer uid;//发布资源用户id
    private Date publicDate;//发布时间

    //图片信息，视频信息关联图片表
    //浏览量，关注量，收藏量都用缓存实现

}
