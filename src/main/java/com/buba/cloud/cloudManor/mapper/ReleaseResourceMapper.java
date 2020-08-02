package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.ResourceVO;

public interface ReleaseResourceMapper {
    //添加resource
    int resourceadd(ResourceVO resourceVO);
    //添加林业表
    boolean resourceTreeadd(ResourceVO resourceVO);
    //添加畜牧业表
    boolean resourceAnimaladd(ResourceVO resourceVO);
    //添加地块表
    boolean resourceGroundadd(ResourceVO resourceVO);
}
