package com.buba.cloud.cloudManor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.buba.cloud.cloudManor.mapper.CultivatePersonCenterMapper;
import com.buba.cloud.cloudManor.pojo.CenterControllerResourceVo;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.CultivatePersonCenterService;
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
    // 连接 Redis 数据库 , 获取连接对象
    Jedis jedis = new Jedis("127.0.0.1");

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
        int i=0;
        List<CenterControllerResourceVo> list = cultivatePersonCenterMapper.pullConservationResources( userId);
        for(CenterControllerResourceVo l:list){
            i++;
/*            //查询点赞数
            // int id=1;//前端资源id
            String key="likeCount"+l.getId();
            String dian= jedis.get(key);
            if(dian!=null&&dian!=""){
                String s = JSONObject.toJSONString(dian);
                int i = Integer.parseInt(s);
                l.setDianzan(i);
            }else{
                l.setDianzan(6);
            }

            //查询收藏数
            // int id=1;//前端资源id
            String key2="shoucangCount"+l.getId();
            String dian2= jedis.get(key2);
            if(dian2!=null&&dian2!=""){
                String s2 = JSONObject.toJSONString(dian2);
                int i2 = Integer.parseInt(s2);
                l.setShoucang(i2);
            }else{
                l.setShoucang(8);
            }

            //查询评论数
            // int id=1;//前端资源id
            String key3="pinglunCount"+l.getId();
            String dian3= jedis.get(key3);
            if(dian3!=null&&dian3!=""){
                String s3 = JSONObject.toJSONString(dian3);
                int i3 = Integer.parseInt(s3);
                l.setPinglun(i3);
            }else{
                l.setPinglun(13);
            }*/
            if (i % 2 == 1){
                l.setDianzan(4);
                l.setShoucang(7);
                l.setPinglun(9);
            }else{
                l.setDianzan(2);
                l.setShoucang(3);
                l.setPinglun(5);
            }

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
            i++;
    /*        //查询点赞数
            // int id=1;//前端资源id
            String key="likeCount"+l.getId();
            String dian= jedis.get(key);
            if(dian!=null&&dian!=""){
                String s = JSONObject.toJSONString(dian);
                int i = Integer.parseInt(s);
                l.setDianzan(i);
            }else{
                l.setDianzan(6);
            }

            //查询收藏数
            // int id=1;//前端资源id
            String key2="shoucangCount"+l.getId();
            String dian2= jedis.get(key2);
            if(dian2!=null&&dian2!=""){
                String s2 = JSONObject.toJSONString(dian2);
                int i2 = Integer.parseInt(s2);
                l.setShoucang(i2);
            }else{
                l.setShoucang(8);
            }

            //查询评论数
            // int id=1;//前端资源id
            String key3="pinglunCount"+l.getId();
            String dian3= jedis.get(key3);
            if(dian3!=null&&dian3!=""){
                String s3 = JSONObject.toJSONString(dian3);
                int i3 = Integer.parseInt(s3);
                l.setPinglun(i3);
            }else{
                l.setPinglun(13);
            }
*/
            if (i % 2 == 1){
                l.setDianzan(6);
                l.setShoucang(8);
                l.setPinglun(11);
            }else{
                l.setDianzan(2);
                l.setShoucang(8);
                l.setPinglun(1);
            }
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
   /* @Override
    public boolean deleteResources(int i) {
        return cultivatePersonCenterMapper.deleteResources( i);
    }*/
}
