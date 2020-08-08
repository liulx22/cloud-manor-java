package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.LoginService;
import com.buba.cloud.cloudManor.utils.RedisUtils;
import com.buba.cloud.cloudManor.utils.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private LoginService loginService;

    //发送验证码
    @RequestMapping("yzm")
    public boolean yzm(String phone){
        int code = (int) ((Math.random()*9+1)*1000);
        //收费的测试几次就可以了
       boolean sendMSM = SendSms.sendMSM(phone,String.valueOf(code));
        redisUtils.set("code",code,60);
        System.out.println(code);
        if(true){
            return true;
        }else {
            return false;
        }
    }



    //登陆
    @RequestMapping("login")
    public User login(String phone,String yzm){
        String code=String.valueOf(redisUtils.get("code"));
        User user;
        if(yzm.equals(code)){
           User u= loginService.findphone(phone);
            System.out.println("123132132132"+u);
            if(u==null){
                //手机号存入数据库
                int i = loginService.addphone(phone);
                user=loginService.find(phone);
                if(i>0){
                    return user;
                }
            }else {
                user=loginService.find(phone);
                return user;
            }
            return user;
        }else {
            return null;
        }
    }
}
