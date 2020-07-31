package com.buba.cloud.cloudManor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname AgricultureOperation
 * @Description 养护记录表
 * @Date 2020/7/23 15:37
 * @Created by liulx
 */
@Data
public class AgricultureOperation {
    private Integer id;
    private Integer aid;//农事id
    private Integer resourceId;//产品（资源）Id
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date  operTime;//操作时间
    private String title;//标题
    //视频，图片关联图片表

    private String imgName;//图片名称
    private String imgDir;//存放路径
}
