package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.CenterControllerResourceVo;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.CultivatePersonCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin
 * @title: CultivatePersonCenterController
 * @projectName cloud-manor-java
 * @description: TODO
 * @date 2020/7/290:12
 */
@RequestMapping("CultivatePersonCenterController")
@RestController
public class CultivatePersonCenterController {
    @Autowired
    CultivatePersonCenterService cultivatePersonCenterService;

    /**
     * 功能描述:通过用户id获取养护人信息
     *
     * @Param: [userId]
     * @Return: com.buba.cloud.cloudManor.pojo.User
     * @Author: zbw
     * @Date: 2020/7/28 0024 16:20
     */
    @RequestMapping("pullMaintenanceInformation")
    public User pullMaintenanceInformation(Integer userId) {
        //判断用户id是否为空
        if (userId != null) {
            //通过用户id去获取养护人信息
            return cultivatePersonCenterService.pullMaintenanceInformation(userId);
        }
        //如果为空 返回null
        return null;
    }
    /**
     * 功能描述:通过user id查询对应资源数量
     *
     * @Param: [userId]
     * @Return: Integer
     * @Author: zbw
     * @Date: 2020/7/28 0024 16:20
     */
    @RequestMapping("pullTheNumberOfResources")
    public Integer pullTheNumberOfResources(Integer userId) {
        //判断资源id是否为空
        if (userId != null) {
            //通过资源id去获取养护人信息
            return cultivatePersonCenterService.pullTheNumberOfResources(userId);
        }
        //如果为空 返回null
        return null;
    }
    /**
     * 功能描述:通过user id查询对应的余额
     *
     * @Param: [userId]
     * @Return: Integer
     * @Author: zbw
     * @Date: 2020/7/28 0024 16:20
     */
    @RequestMapping("pullMaintenanceBalance")
    public Double pullMaintenanceBalance(Integer userId) {
        //判断资源id是否为空
        if (userId != null) {
            //通过资源id去获取养护人信息
            return cultivatePersonCenterService.pullMaintenanceBalance(userId);
        }
        //如果为空 返回null
        return null;
    }
    /**
     * 功能描述:通过user id查询发布的资源 (状态：1、已售出2、未售出)
     *
     * @Param: [userId]
     * @Return: Integer
     * @Author: zbw
     * @Date: 2020/7/28 0024 16:20
     */
    @RequestMapping("pullConservationResources")
    public List<CenterControllerResourceVo> pullConservationResources(Integer userId, Integer type) {
        //判断资源id是否为空
        if (userId != null && type!=null) {
                //判断 类型为1 已出售 类型为2 未出售
            if(type==1){
                return cultivatePersonCenterService.pullConservationResources(userId);
            }else if(type==2){
                return cultivatePersonCenterService.pullConservatioNunsoldResources(userId);
            }

        }
        //如果为空 返回null
        return null;
    }
    /**
     * 功能描述:批量上传农事
     *
     * @Param: [userId]
     * @Return: Integer
     * @Author: zbw
     * @Date: 2020/7/28 0024 16:20
     */
    @RequestMapping("batchCommitResources")
    public boolean batchCommitResources(Integer userId,int[] resouceId,String content) {
        boolean b=false;
        //判断资源id是否为空
        if (userId != null && resouceId.length!=0) {
                for(int i=0;i<resouceId.length;i++){
                        //添加农事表
                    b = cultivatePersonCenterService.batchCommitResources(userId, content, resouceId[i]);

                }
                    return b;
        }
        //如果为空 返回null
        return false;
    }
    /**
     * 功能描述:通过资源id删除资源
     *
     * @Param: [userId]
     * @Return: Integer
     * @Author: zbw
     * @Date: 2020/7/28 0024 16:20
     */
    @RequestMapping("deleteResources")
    public boolean deleteResources(Integer userId,int[] resouceId) {
        boolean b=true;
        //判断资源id是否为空
        if (userId != null && resouceId.length!=0) {
            for(int i=0;i<resouceId.length;i++){
                //删除资源
                b = cultivatePersonCenterService.deleteResources(resouceId[i]);

            }
            return b;
        }
        //如果为空 返回null
        return false;
    }

}
