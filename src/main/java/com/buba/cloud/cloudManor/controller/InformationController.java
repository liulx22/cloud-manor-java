package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: InformationController
 * @Author: JiangZe
 * @Description: 编辑个人资料
 * @Version: 1.0
 * @Date: 2020/7/28 20:34
 */
@RestController
@RequestMapping("/Info")
public class InformationController {
    @Autowired
    private InformationService informationService;

    //回显用户信息
    @RequestMapping("/echoUserInfo")
    public User echoUserInfo(int userId) {
        User userInfo = informationService.echoUserInfo(userId);
        return userInfo;
    }
    //修改用户信息
    @RequestMapping("/editUserInfo")
    public boolean editUserInfo(User user) {
        boolean b = informationService.editUserInfo(user);
        return b;
    }
}
