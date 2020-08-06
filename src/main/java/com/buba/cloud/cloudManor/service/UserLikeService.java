package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.UserLike;

import java.util.List;

public interface UserLikeService {
    //查询喜欢的作品
    List<UserLike> selectUserLike(Integer userId);
    //喜欢操作
    int  addUserLike(UserLike userLike);
    //取消喜欢
    int  deleUserLike(UserLike userLike);
    //返回喜欢量
    int selectuserlikemanor(Integer userId);
    //返回喜欢量
    int selectresourcelik(Integer rresourceId);

}
