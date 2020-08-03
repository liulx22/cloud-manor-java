package com.buba.cloud.cloudManor.controller;

import com.buba.cloud.cloudManor.pojo.*;
import com.buba.cloud.cloudManor.service.MoneyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.List;

/**
 * @author FHJ
 * @title: MoneyController
 * @projectName cloud-manor-java
 * @date 2020/7/2814:11
 */
@RequestMapping("money")
@Controller
public class MoneyController {
    @Resource
    private MoneyService moneyService;
    //查询养护人金钱
    @ResponseBody
    @RequestMapping("findUserInfo")
    public UserInfo findUserInfo(Integer userId){
        UserInfo u=moneyService.findUserInfo(userId);
        return u;
    }
    @ResponseBody
    @RequestMapping("findBankCard")
    //查询银行卡  根据BandCardAndUser关联表的cardId，查询BankCard对应的银行卡信息
    public List<BankCard> findBankCard(Integer userId){
        List<BankCard> bc=moneyService.findBankCard(userId);
        return bc;
    }
    @ResponseBody
    @RequestMapping("addBankCard")
    //添加银行卡信息 添加BankCard详细信息同时添加BandCardAndUser关联信息
    public boolean addBankCard(BankCard bankCard,Integer userId){
        System.out.println(userId);
       boolean b= moneyService.addBankCard(bankCard,userId);
       return b;
    }
    //提现
    @ResponseBody
    @RequestMapping("addMasterAccount")
    public boolean addMasterAccount(Integer userId,String cardNum,Double money,Double rm){
        double remaindMoney=rm-money;
        boolean b=moneyService.addMasterAccount(userId,cardNum,money,remaindMoney);
        return b;
    }
    //账单信息
    //本月未入账金额 userId=masterId
    @ResponseBody
    @RequestMapping("findMoney0")
    public String findMoney0(Integer userId){
        String t=moneyService.findMoney0(userId);
        return t;
    }
    //本月已入账金额 userId=masterId
    @ResponseBody
    @RequestMapping("findMoney1")
    public String findMoney1(Integer userId){
        String t=moneyService.findMoney1(userId);
        return t;
    }
    //本月提现金额userId=masterId
    @ResponseBody
    @RequestMapping("findMasterAccount")
    public String findMasterAccount(Integer userId){
        String m=moneyService.findMasterAccount(userId);
        return m;
    }

    //本月账单
    @ResponseBody
    @RequestMapping("findRecordMoney")
    public List findRecordMoney(Integer userId,String ri,Integer s){
        Integer  n=0;
        Integer  y=0;
        if(ri==null){
        }else {
            //截取字符串里的
            n= Integer.valueOf(ri.substring(0, 4));
            y= Integer.valueOf(ri.substring(5, 6));
        }
        if(s==1){
            System.out.println(n);
            List<ManorAccount> rm=moneyService.findRecordMoney(userId,n,y);

            return rm;
        }else if (s==2){
            List<ManorAccount> rm=moneyService.findNoneRecordMoney(userId,n,y);
            return rm;
        }else {
            List<MasterAccount> rm=moneyService.findRemaindMoney(userId,n,y);
            return rm;
        }
    }
}
