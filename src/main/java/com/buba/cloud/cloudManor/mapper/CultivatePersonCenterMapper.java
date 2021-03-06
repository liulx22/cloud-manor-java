package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.BusinessResourceUserVo;
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
    //查找所有的资源类型表的数据，返回list集合。
    List<BusinessResourceUserVo> selectResourceType();
    //拿到资源类型id，去查找该类型id对应的主营业务
    BusinessResourceUserVo selectBusinessResourceUser(@Param("userId")Integer userId,@Param("resourceTypeId")Integer resourceTypeId);
    //通过UserId,资源类型id，主要业务 三个字段添加主营业务表
    boolean submitBusinessResourceUser(@Param("userId")Integer userId, @Param("resourceTypeId")Integer resourceTypeId,@Param("details") String details);
    //查询userId和资源类型id是否已经存在，存在就修改，不存在就添加
    Integer selectBusinessResourceUserCount(@Param("userId")Integer userId, @Param("resourceTypeId")Integer resourceTypeId);
    //  已经存在就修改
    boolean updatetBusinessResourceUser(@Param("userId")Integer userId, @Param("resourceTypeId")Integer resourceTypeId, @Param("details")String details);
}
