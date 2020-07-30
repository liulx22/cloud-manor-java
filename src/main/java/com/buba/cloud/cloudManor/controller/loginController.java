package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.service.LoginService;
import com.buba.cloud.cloudManor.utils.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("login")
public class loginController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LoginService loginService;

    //发送验证码
    @RequestMapping("yzm")
    public boolean yzm(String phone){
        int code = (int) ((Math.random()*9+1)*1000);
       // boolean sendMSM = SendSms.sendMSM(phone,String.valueOf(code));
        redisTemplate.expire("code",  60, TimeUnit.SECONDS);
        System.out.println(code);
        if(true){
            return true;
        }else {
            return false;
        }
    }



    //登陆
    @RequestMapping("login")
    public boolean login(String phone,String code){
        Long yzm=redisTemplate.getExpire("code");
        System.out.println(yzm);
        if(code.equals(yzm)){
            String b=loginService.findphone(phone);
            if(b!=""){
                return true;
            }else {
                //手机号存入数据库
                int i = loginService.addphone(phone);
                if(i>0){
                    return true;
                }
            }
            return true;
        }else {
            return false;
        }
    }
}
