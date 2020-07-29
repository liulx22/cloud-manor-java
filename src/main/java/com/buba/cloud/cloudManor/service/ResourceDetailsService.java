package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.Agriculture;
import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceDetailsService {
    /*获取农事*/
    Agriculture GETAgriculture(int id);
    /*获取养护记录*/
    List<AgricultureOperation> GETAgricultureOperation(int id);
}
