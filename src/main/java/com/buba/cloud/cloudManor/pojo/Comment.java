package com.buba.cloud.cloudManor.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Classname Comment
 * @Description 评论表
 * @Date 2020/7/17 10:02
 * @Created by liulx
 */
@Data
public class Comment {
    private Integer id;
    private Date time;//评论的时间
    private Integer userId;//关联User表的id,谁评论的
    private String content;//评论内容
    private Integer resourceId;//关联资源Id
    private Integer pid;//父评论id

    //展示查询时需要，不需要建表创建字段
    private String userName;
    private String imagetu;
    private String imgName;
    private String imgDir;
    private String commentId;
}
