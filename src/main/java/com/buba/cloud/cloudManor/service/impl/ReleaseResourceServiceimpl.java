package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.ReleaseResourceMapper;
import com.buba.cloud.cloudManor.pojo.Image;
import com.buba.cloud.cloudManor.pojo.ResourceVO;
import com.buba.cloud.cloudManor.service.ReleaseResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2020-08-01 15:03
 * @desc 发布资源serviceimpl
 **/
@Service
public class ReleaseResourceServiceimpl implements ReleaseResourceService {

    @Resource
    private ReleaseResourceMapper releaseResourceMapper;
    /*
     * @author fgh
     * @description //添加资源信息
     * @date 2020/8/1 15:55
     * @param
     * @return
     */
    @Transactional
    @Override
    public boolean resourceadd(ResourceVO resourceVO) {
        boolean b=false;
        //添加resource
        int i=releaseResourceMapper.resourceadd(resourceVO);
        if (i>0){
            //添加资源类型表
            if (resourceVO.getReTypeCode().equals("fruiter")){
                //添加林业表
                b=releaseResourceMapper.resourceTreeadd(resourceVO);
            }else if (resourceVO.getReTypeCode().equals("livestock")){
                //添加畜牧业表
                b=releaseResourceMapper.resourceAnimaladd(resourceVO);
            }else if (resourceVO.getReTypeCode().equals("plot")){
                //添加地块表
                b=releaseResourceMapper.resourceGroundadd(resourceVO);
            }else {
                b=false;
            }
        }
        return b;
    }
    /*
     * @author fgh
     * @description 图片视频详情上传
     * @date 2020/8/2 13:32
     * @param Image image, Integer resourceid
     * @return boolean
     */
    @Override
    public boolean resourceImgadd(Image image, Integer resourceid) {
        boolean b=false;
        //上传图片表
        int i=releaseResourceMapper.resourceImgadd(image);
        if (i>0){
            //上传图片中间表
            int typeCode=0;
            if (image.getCodeType().equals("resource_vedio")){
                typeCode=3;
            }else if (image.getCodeType().equals("resource_detail")){
                typeCode=2;
            }else if (image.getCodeType().equals("resource_main")){
                typeCode=1;
            }
            if (typeCode!=0){
                b=releaseResourceMapper.resourceImgRlationadd(typeCode,image.getId(),resourceid);
            }
        }
        return b;
    }
}
