package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.CenterControllerResourceVo;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 * @title: CultivatePersonCenterMapper
 * @projectName cloud-manor-java
 * @description: TODO
 * @date 2020/7/290:16
 */
public interface CultivatePersonCenterMapper {
    /*通过user id获取养护人信息*/
    User pullMaintenanceInformation(@Param("userId") Integer userId);
    /*通过user id查询对应资源数量*/
    Integer pullTheNumberOfResources(@Param("userId") Integer userId);
    /*通过user id查询对应的余额*/
    Double pullMaintenanceBalance(@Param("userId")Integer userId);
    /*通过user id查询发布的资源 (状态：已售出)*/
    List<CenterControllerResourceVo> pullConservationResources(@Param("userId")Integer userId);
    /*通过user id查询发布的资源 (状态：未售出)*/
    List<CenterControllerResourceVo> pullConservatioNunsoldResources(@Param("userId")Integer userId);
    /*添加农事表*/
    boolean batchCommitResources(@Param("userId")Integer userId,@Param("content") String content, @Param("resourceId")int resourceId);
    /*通过资源id删除资源*/
    boolean deleteResources(@Param("resourceId")int i);
}
