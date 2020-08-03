package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.CultivatePersonCenterMapper;
import com.buba.cloud.cloudManor.pojo.CenterControllerResourceVo;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.CultivatePersonCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @title: CultivatePersonCenterImpl
 * @projectName cloud-manor-java
 * @description: TODO
 * @date 2020/7/290:15
 */
@Service
public class CultivatePersonCenterImpl implements CultivatePersonCenterService {
    @Autowired
    CultivatePersonCenterMapper cultivatePersonCenterMapper;
    /*通过user id获取养护人信息*/
    @Override
    public User pullMaintenanceInformation(Integer userId) {
        return cultivatePersonCenterMapper.pullMaintenanceInformation(userId);
    }
    /*通过user id查询对应资源数量*/
    @Override
    public Integer pullTheNumberOfResources(Integer userId) {
        return cultivatePersonCenterMapper.pullTheNumberOfResources(userId);
    }
    /*通过user id查询对应的余额*/
    @Override
    public Double pullMaintenanceBalance(Integer userId) {
        return cultivatePersonCenterMapper.pullMaintenanceBalance( userId);
    }
    /*通过user id查询发布的资源 (状态：已售出)*/
    @Override
    public List<CenterControllerResourceVo> pullConservationResources(Integer userId) {
        return cultivatePersonCenterMapper.pullConservationResources(userId);
    }
    /*通过user id查询发布的资源 (状态：未售出)*/
    @Override
    public List<CenterControllerResourceVo> pullConservatioNunsoldResources(Integer userId) {
        return cultivatePersonCenterMapper.pullConservatioNunsoldResources(userId);
    }
    //添加农事表
    @Override
    public boolean batchCommitResources(Integer userId, String content, int resourceId) {
        return cultivatePersonCenterMapper.batchCommitResources( userId,  content,  resourceId);
    }
}
