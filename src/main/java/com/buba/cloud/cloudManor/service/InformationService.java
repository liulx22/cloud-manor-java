package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.User;

/**
 * @ClassName: InformationService
 * @Author: JiangZe
 * @Description: 编辑个人资料$
 * @Version: 1.0
 * @Date: 2020/7/28 20:31
 */
public interface InformationService {
    //回显用户信息
    User echoUserInfo(int userId);
    //修改用户信息
    boolean editUserInfo(User user);
}
