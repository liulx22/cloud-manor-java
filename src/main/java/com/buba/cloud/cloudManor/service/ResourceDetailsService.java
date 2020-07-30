package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.Agriculture;
import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 孙智慧
 * 资源详情
 * */

public interface ResourceDetailsService {
    /*获取农事*/
    Agriculture GETAgriculture(int rid,int mid);
    /*提交农事*/
    boolean INSAgriculture(Agriculture agriculture);
    /*获取养护记录*/
    List<AgricultureOperation> GETAgricultureOperation(int rid,int mid);
}
