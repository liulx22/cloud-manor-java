package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.*;

import java.util.List;

/**
 * @author FHJ
 * @title: MoneyService
 * @projectName cloud-manor-java
 * @date 2020/7/2814:10
 */
public interface MoneyService {
    //查询养护人金钱
    UserInfo findUserInfo(Integer userId);
    //查询银行卡  根据BandCardAndUser关联表的cardId，查询BankCard对应的银行卡信息
    List<BankCard> findBankCard(Integer userId);
    //添加银行卡信息 添加BankCard详细信息同时添加BandCardAndUser关联信息
    boolean addBankCard(BankCard bankCard,Integer userId);
    //余额提现
    boolean addMasterAccount(Integer userId,String cardNum,Double money,Double remaindMoney);
    //本月未入账总金额 userId=masterId
    String findMoney0(Integer userId);
    //本月已入账总金额 userId=masterId
    String findMoney1(Integer userId);
    //本月提现总金额userId=masterId
    String findMasterAccount(Integer userId);
    //本月账单
    //已入账
    List<ManorAccount> findRecordMoney(Integer userId, Integer n,Integer y);
    //未入账
    List<ManorAccount> findNoneRecordMoney(Integer userId,Integer n,Integer y);
    //提现
    List<MasterAccount> findRemaindMoney(Integer userId,Integer n,Integer y);

}
