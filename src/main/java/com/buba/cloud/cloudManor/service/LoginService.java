package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.User;

public interface LoginService {
    int addphone(String phone);

    User findphone(String phone);

    User find(String phone);
}
