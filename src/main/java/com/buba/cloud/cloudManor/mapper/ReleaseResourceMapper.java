package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.pojo.ResourceVO;
import org.apache.ibatis.annotations.Param;

public interface ReleaseResourceMapper {
    //添加resource
    int resourceadd(ResourceVO resourceVO);
    //添加林业表
    boolean resourceTreeadd(ResourceVO resourceVO);
    //添加畜牧业表
    boolean resourceAnimaladd(ResourceVO resourceVO);
    //添加地块表
    boolean resourceGroundadd(ResourceVO resourceVO);
    //上传图片表
    int resourceImgadd(Image image);
    //上传图片中间表
    boolean resourceImgRlationadd(@Param("typecode") Integer typecode,@Param("id") Integer id, @Param("resourceid") Integer resourceid);
}
