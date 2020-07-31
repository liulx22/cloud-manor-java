package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLikeMapper {
    //查询喜欢的作品
     List<UserLike> selectUserLike(Integer userId);
     //喜欢操作
    int  addUserLike(UserLike userLike);
    //取消喜欢
    int  deleUserLike(UserLike userLike);


}
