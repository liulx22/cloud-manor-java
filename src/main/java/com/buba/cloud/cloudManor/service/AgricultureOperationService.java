package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.AgricultureOperation;
import com.buba.cloud.cloudManor.pojo.Image;

public interface AgricultureOperationService {
    //添加养护记录
    boolean addAgricultureOperation(AgricultureOperation agricultureOperation);

    //
    boolean mainImgadd(Image image, Integer resourceid);
}
