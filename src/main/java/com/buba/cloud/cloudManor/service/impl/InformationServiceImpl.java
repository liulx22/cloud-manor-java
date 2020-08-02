package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.InformationMapper;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: InformationServiceImpl
 * @Author: JiangZe
 * @Description: 编辑个人资料
 * @Version: 1.0
 * @Date: 2020/7/28 20:32
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    //回显用户信息
    @Override
    public User echoUserInfo(int userId) {
        User userInfo = informationMapper.echoUserInfo(userId);
        return userInfo;
    }
    //修改用户信息
    @Override
    public boolean editUserInfo(User user) {
        boolean b = informationMapper.editUserInfo(user);
        return b;
    }
}
