package com.buba.cloud.cloudManor.service.impl;


import com.buba.cloud.cloudManor.mapper.UserLikeMapper;
import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.UserLike;
import com.buba.cloud.cloudManor.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
@Service
public class UserLikeServiceImpl implements UserLikeService {
    @Autowired
    private UserLikeMapper userLikeMapper;
    @Override
    public List<UserLike> selectUserLike(Integer userId) {
        return userLikeMapper.selectUserLike(userId);
    }

    @Override
    public int addUserLike(UserLike userLike) {
        return userLikeMapper.addUserLike(userLike);
    }

    @Override
    public int deleUserLike(UserLike userLike) {
        return userLikeMapper.deleUserLike(userLike);
    }
}
