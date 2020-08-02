package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.User;

/**
 * @ClassName: InformationMapper
 * @Author: JiangZe
 * @Description: 编辑个人资料$
 * @Version: 1.0
 * @Date: 2020/7/28 15:59
 */
public interface InformationMapper {
    //回显用户信息
    User echoUserInfo(int userId);
    //修改用户信息
    boolean editUserInfo(User user);
}
