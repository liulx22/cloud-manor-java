package com.buba.cloud.cloudManor.service.impl;


import com.buba.cloud.cloudManor.mapper.UserLikeMapper;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.UserLike;
import com.buba.cloud.cloudManor.service.UserLikeService;
import com.buba.cloud.cloudManor.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.ws.ServiceMode;
import java.util.List;
@Service
public class UserLikeServiceImpl implements UserLikeService {
    @Autowired
    private UserLikeMapper userLikeMapper;
    //调用redis
    @Autowired
    private  RedisUtils redisUtils;
    @Override
    public List<UserLike> selectUserLike(Integer userId) {
        return userLikeMapper.selectUserLike(userId);
    }
//添加喜欢的作品
    @Override
    public int addUserLike(UserLike userLike) {
        Integer rresourceId = userLike.getRresourceId();//获取作品id
        String s = rresourceId.toString();//将int转为 String类型
         redisUtils.hset("resourceId_number","resourceid_"+s,0);//先设置初始值
        int i = userLikeMapper.addUserLike(userLike);//添加mysql操作
        if (i!=0){//如果成功添加至mysql
            Integer resourceId_number = (Integer)redisUtils.hget("resourceId_number", "resourceid_" + s);//获取redis中的点赞量
            redisUtils.hset("resourceId_number","resourceid_"+s,resourceId_number+1);//让redis中的点赞量加一
        }
        return   (Integer)redisUtils.hget("resourceId_number", "resourceid_" + s);//返回redis的点赞量
    }



//取消喜欢某个作品
 @Override
    public int deleUserLike(UserLike userLike) {
     Integer rresourceId = userLike.getRresourceId();//获取作品id
     String s = rresourceId.toString();//将int转为 String类型

     int i = userLikeMapper.deleUserLike(userLike);//删除mysql操作
     if (i!=0){//如果成功在mysql删除
         Integer resourceId_number = (Integer)redisUtils.hget("resourceId_number", "resourceid_" + s);//获取redis中的点赞量
         System.out.println("获取的点赞量"+resourceId_number);
         redisUtils.hset("resourceId_number","resourceid_"+s,resourceId_number-1);//让redis中的点赞量加一
     }
     return   (Integer)redisUtils.hget("resourceId_number", "resourceid_" + s);//返回redis的点赞量
    }
}
