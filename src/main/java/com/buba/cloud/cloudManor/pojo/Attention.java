package com.buba.cloud.cloudManor.pojo;

import lombok.Data;

/**
 * @Classname Attention
 * @Description 关注表，其实是一张关联表
 * @Date 2020/7/17 10:08
 * @Created by liulx
 */
@Data
public class Attention {
    private Integer id;
    private Integer fromUserId;//关注人的id
    private Integer destUserId;//被关注人的id
    private Integer codeType;

}
