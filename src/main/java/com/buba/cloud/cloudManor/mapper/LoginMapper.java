package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.User;

public interface LoginMapper {
    int addphone(String phone);

    String findphone(String phone);

    User find(String phone);
}
