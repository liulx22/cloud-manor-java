package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.pojo.ImgRlation;
import com.buba.cloud.cloudManor.pojo.User;
import tk.mybatis.mapper.common.Mapper;

public interface AgricultureOperationMapper extends Mapper<AgricultureOperation> {
    //添加养护记录
    boolean addAgricultureOperation(AgricultureOperation agricultureOperation);
    //添加图片视屏
    boolean addImage(Image image);
    //添加中间表
    boolean addImgRlation(ImgRlation imr);
}
