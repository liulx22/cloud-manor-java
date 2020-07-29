package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.UserLike;
import com.buba.cloud.cloudManor.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("userLiker")
@Controller
public class UserLikeController {
@Autowired
private UserLikeService userLikeService;
    //查询点了喜欢的作品
    @RequestMapping("/selectUserLike")
    public List<Resource> selectUserLike(Integer userId){
        List<Resource> userLikes = userLikeService.selectUserLike(userId);
        if (userLikes!=null){
            return userLikes;
        }
        return null;
    }
   /* //点击喜欢,添加喜欢的作品
    @RequestMapping("/addUserLike")
    public boolean addUserLike(UserLike userLike){
        boolean userLikes = userLikeService.addUserLike(userLike);
        if (userLikes!=null){
            return userLikes;
        }
        return null;
    }*/

}

