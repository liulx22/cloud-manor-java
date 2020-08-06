package com.buba.cloud.cloudManor.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @program: cloud-manor-java
 * @description: 首页信息
 * @author: 罗子鉴
 * @create: 2020-07-31 10:26
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IndexVO {
    private Integer id;
    private String title;
    private String reTypeCode;//视频类型
    private String videoPath;//视频地址
    private String address;//地址
}


