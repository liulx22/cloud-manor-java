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
    private RedisUtils redisUtils;

    //查询喜欢的作品
    @Override
    public List<UserLike> selectUserLike(Integer userId) {
        return userLikeMapper.selectUserLike(userId);
    }

    //添加喜欢的作品返回的是点赞量
    @Override
    public int addUserLike(UserLike userLike) {
        Integer rresourceId = userLike.getRresourceId();//获取作品id
        Integer userId = userLike.getUserId();
        int i = userLikeMapper.addUserLike(userLike);//添加mysql操作
        if (i != 0) {//如果成功添加至mysql
            boolean manor_like_number = redisUtils.hHasKey("manor_like_number", "manor_" + userId);//判断该key与itm是否存在
            if (manor_like_number==false){//如果不存在
                redisUtils.hset("manor_like_number", "manor_" + userId, 1);//设置初始值并为1
            }else {//如果该key与itm存在
                Integer manor_like_number1 = (Integer) redisUtils.hget("manor_like_number", "manor_" + userId);//获取redis中的喜欢量
                redisUtils.hset("manor_like_number", "manor_" + userId, manor_like_number1+1);//让redis中的喜欢量加一
            }
            boolean resource_like_number = redisUtils.hHasKey("resource_like_number", "resourceId_" + rresourceId);//判断该key与itm是否存在
            if (resource_like_number == false) {//如果不存在
                redisUtils.hset("resource_like_number", "resourceId_" + rresourceId, 1);//设置初始值并为1
            } else {//如果该key与itm存在
                Integer resourceId_number1 = (Integer) redisUtils.hget("resource_like_number", "resourceId_" + rresourceId);//获取redis中的点赞量
                redisUtils.hset("resource_like_number", "resourceId_" + rresourceId, resourceId_number1 + 1);//让redis中的点赞量加一
            }
        }
        return (Integer) redisUtils.hget("resource_like_number", "resourceId_" + rresourceId);//返回redis的点赞量
    }


    //取消喜欢某个作品
    @Override
    public int deleUserLike(UserLike userLike) {
        Integer rresourceId = userLike.getRresourceId();//获取作品id
        Integer userId = userLike.getUserId();

        int i = userLikeMapper.deleUserLike(userLike);//删除mysql操作
        if (i != 0) {//如果成功在mysql删除
            boolean manor_like_number = redisUtils.hHasKey("manor_like_number", "manor_" + userId);//判断该key与itm是否存在
            if (manor_like_number == false) {//如果不存在
                redisUtils.hset("manor_like_number", "manor_" + userId, 1);//设置初始值并为1
            } else {//如果该key与itm存在
                Integer manor_like_number1 = (Integer) redisUtils.hget("manor_like_number", "manor_" + userId);//获取redis中的点赞量
                redisUtils.hset("manor_like_number", "manor_" + userId, manor_like_number1 - 1);//让redis中的点赞量加一
            }

            boolean resource_like_number = redisUtils.hHasKey("resource_like_number", "resourceId_" + rresourceId);//判断该key与itm是否存在
            if (resource_like_number == false) {//如果不存在
                redisUtils.hset("resource_like_number", "resourceId_" + rresourceId, 1);//设置初始值并为1
            } else {//如果该key与itm存在
                Integer resource_like_number1 = (Integer) redisUtils.hget("resource_like_number", "resourceid_" + rresourceId);//获取redis中的点赞量
                redisUtils.hset("resource_like_number", "resourceId_" + rresourceId, resource_like_number1 - 1);//让redis中的点赞量加一
            }
        }
        return (Integer) redisUtils.hget("resource_like_number", "resourceId_" + rresourceId);//返回redis的点赞量
    }
//获取喜欢的作品数量
    @Override
    public int selectuserlikemanor(Integer userId) {
        return (Integer) redisUtils.hget("manor_like_number", "manor_" + userId);
    }
//获取作品的点赞量
    @Override
    public int selectresourcelik(Integer rresourceId) {
        return  (int)redisUtils.hget("resource_like_number", "resourceId_" + rresourceId);
    }
}
