package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.BusinessResourceUserVo;
import com.buba.cloud.cloudManor.pojo.CenterControllerResourceVo;
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
    List<CenterControllerResourceVo> pullConservationResources(Integer userId);
    /*通过user id查询发布的资源 (状态：未售出)*/
    List<CenterControllerResourceVo> pullConservatioNunsoldResources(Integer userId);
    //添加农事表
    boolean batchCommitResources(Integer userId, String content, int i);


    //通过资源id删除资源表数据
    boolean deleteResources(int i);
    /*通过UserId查找该用户对应的主营业务*/
    List<BusinessResourceUserVo> selectBusinessResourceUser(Integer userId);
    //通过UserId,资源类型id，主要业务 三个字段添加主营业务表
    boolean submitBusinessResourceUser(Integer userId, Integer resourceTypeId, String details);
    //查询userId和资源类型id是否已经存在，存在就修改，不存在就添加
    Integer selectBusinessResourceUserCount(Integer userId, Integer resourceTypeId);
    //  已经存在就修改
    boolean updatetBusinessResourceUser(Integer userId, Integer resourceTypeId, String details);
}
