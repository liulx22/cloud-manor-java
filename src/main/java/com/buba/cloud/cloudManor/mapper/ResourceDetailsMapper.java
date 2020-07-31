package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Agriculture;
import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 孙智慧
 * 资源详情
 * */
public interface ResourceDetailsMapper {
    /*获取农事*/
    Agriculture GETAgriculture(@Param("rid") int rid,@Param("mid") int mid);
    /*提交农事*/
    boolean INSAgriculture(@Param("agriculture")Agriculture agriculture);
    /*获取养护记录*/
    List<AgricultureOperation> GETAgricultureOperation(@Param("rid") int rid,@Param("mid") int mid);
}
