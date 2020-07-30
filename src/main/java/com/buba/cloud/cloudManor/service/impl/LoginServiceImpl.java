package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.LoginMapper;
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
    public String findphone(String phone) {
        return loginMapper.findphone(phone);
    }
}
