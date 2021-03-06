package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.LoginMapper;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public int addphone(String phone) {
        return loginMapper.addphone(phone);
    }

    @Override
    public User findphone(String phone) {
        User u=loginMapper.findphone(phone);
        return u;
    }

    @Override
    public User find(String phone) {
        return loginMapper.find(phone);
    }
}
