package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.ReleaseResourceMapper;
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
}
