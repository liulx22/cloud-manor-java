package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.UserLike;

import java.util.List;

public interface UserLikeService {
    //查询喜欢的作品
    List<Resource> selectUserLike(Integer userId);
    //喜欢操作
    boolean  addUserLike(UserLike userLike);
    //取消喜欢
    boolean  deleUserLike(UserLike userLike);
}
