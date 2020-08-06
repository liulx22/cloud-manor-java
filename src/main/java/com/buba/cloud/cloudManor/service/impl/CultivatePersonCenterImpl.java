package com.buba.cloud.cloudManor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.buba.cloud.cloudManor.mapper.CultivatePersonCenterMapper;
import com.buba.cloud.cloudManor.pojo.CenterControllerResourceVo;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.CommentServive;
import com.buba.cloud.cloudManor.service.CultivatePersonCenterService;
import com.buba.cloud.cloudManor.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

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
    @Autowired
    UserLikeService userLikeService;
    @Autowired
    CommentServive commentServive;
/*    // 连接 Redis 数据库 , 获取连接对象
    Jedis jedis = new Jedis("127.0.0.1");*/

    /*通过user id获取养护人信息*/
    @Override
    public User pullMaintenanceInformation(Integer userId) {
        User user = cultivatePersonCenterMapper.pullMaintenanceInformation(userId);
        return user;
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
        int i=0;
        List<CenterControllerResourceVo> list = cultivatePersonCenterMapper.pullConservationResources( userId);
        for(CenterControllerResourceVo l:list){
            Integer ii= l.getId();
            System.out.println("资源id是------"+ii);
            i++;
            //查询点赞数
            Integer selectresourcelik = userLikeService.selectresourcelik(ii);
            if(selectresourcelik!=null){
                l.setDianzan(selectresourcelik);
                l.setShoucang(selectresourcelik);
            }else {
                l.setDianzan(0);
                l.setShoucang(0);
            }
            System.out.println(l);
            //查询评论数
            Integer i1 = commentServive.readisResource(ii);
            if(i1!=null){
                l.setPinglun(i1);
            }else {
                l.setPinglun(0);
            }
            /*if (i % 2 == 1){
                l.setDianzan(4);
                l.setShoucang(7);
                l.setPinglun(9);
            }else{
                l.setDianzan(2);
                l.setShoucang(3);
                l.setPinglun(5);
            }*/

            System.out.println(l);

        }


        return list;
    }
    /*通过user id查询发布的资源 (状态：未售出)*/
    @Override
    public List<CenterControllerResourceVo> pullConservatioNunsoldResources(Integer userId) {
        int i=0;
        List<CenterControllerResourceVo> list = cultivatePersonCenterMapper.pullConservatioNunsoldResources( userId);
        for(CenterControllerResourceVo l:list){
            Integer ii= l.getId();
            i++;
            //查询点赞数
            Integer selectresourcelik2 = userLikeService.selectresourcelik(ii);
            if(selectresourcelik2!=null){
                l.setDianzan(selectresourcelik2);
                l.setShoucang(selectresourcelik2);
            }else {
                l.setDianzan(0);
                l.setShoucang(0);
            }
            System.out.println(l);
            //查询评论数
            Integer i12 = commentServive.readisResource(ii);
            if(i12!=null){
                l.setPinglun(i12);
            }else {
                l.setPinglun(0);
            }
           /* if (i % 2 == 1){
                l.setDianzan(6);
                l.setShoucang(8);
                l.setPinglun(11);
            }else{
                l.setDianzan(2);
                l.setShoucang(8);
                l.setPinglun(1);
            }*/
            System.out.println(l);
        }


        return list;
    }
    //添加农事表
    @Override
    public boolean batchCommitResources(Integer userId, String content, int resourceId) {
        return cultivatePersonCenterMapper.batchCommitResources( userId,  content,  resourceId);
    }
    //通过资源id删除资源表数据
    @Override
    public boolean deleteResources(int i) {
        return cultivatePersonCenterMapper.deleteResources( i);
    }
}
