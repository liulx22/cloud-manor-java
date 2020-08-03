package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.pojo.ResourceVO;

public interface ReleaseResourceService {

    //添加资源信息
    boolean resourceadd(ResourceVO resourceVO);
    //图片上传
    boolean resourceImgadd(Image image, Integer resourceid);
}
