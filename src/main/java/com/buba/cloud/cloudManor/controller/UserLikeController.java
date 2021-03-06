package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.UserLike;
import com.buba.cloud.cloudManor.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("userLiker")
@RestController
public class UserLikeController {
    @Autowired
    private UserLikeService userLikeService;
    int s = 0;//自定义一个喜欢的个数

    //查询点了喜欢的作品 参数：用户id
    @RequestMapping("/selectUserLike")
    public List<UserLike> selectUserLike(Integer userId) {
        System.out.println(userId);
        List<UserLike> userLikes = userLikeService.selectUserLike(userId);
        if (userLikes != null) {
            s = userLikes.size();
            return userLikes;
        }
        return null;
    }

    //点击喜欢,添加喜欢的作品 参数：Integer user_id,Integer resource_id （登录人id与作品id）
    @RequestMapping("/addUserLike")
    public int addUserLike(Integer user_id, Integer resource_id) {
        UserLike like = new UserLike();
        like.setUserId(user_id);
        like.setRresourceId(resource_id);
        int userLikes = userLikeService.addUserLike(like);
        if (userLikes != 0) {
            return userLikes;
        }
        return 0;
    }

    //点击喜欢,取消喜欢的作品
    @RequestMapping("/deleUserLike")
    public int deleUserLike(Integer user_id, Integer resource_id) {
        UserLike userLike = new UserLike();
        userLike.setUserId(user_id);
        userLike.setRresourceId(resource_id);
        int userLikes = userLikeService.deleUserLike(userLike);
        if (userLikes != 0) {
            return userLikes;
        }
        return 0;
    }

}


