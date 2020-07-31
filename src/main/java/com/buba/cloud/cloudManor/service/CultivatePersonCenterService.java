package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.User;

import java.util.List;

/**
 * @author admin
 * @title: CultivatePersonCenter
 * @projectName cloud-manor-java
 * @description: TODO
 * @date 2020/7/290:15
 */
public interface CultivatePersonCenterService {
    /*通过user id获取养护人信息*/
    User pullMaintenanceInformation(Integer userId);
    /*通过user id查询对应资源数量*/
    Integer pullTheNumberOfResources(Integer userId);
    /*通过user id查询对应的余额*/
    Double pullMaintenanceBalance(Integer userId);
    /*通过user id查询发布的资源 (状态：已售出)*/
    List<Resource> pullConservationResources(Integer userId);
    /*通过user id查询发布的资源 (状态：未售出)*/
    List<Resource> pullConservatioNunsoldResources(Integer userId);
    //添加农事表
    boolean batchCommitResources(Integer userId, String content, int i);
}
