package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.MoneyMapper;
import com.buba.cloud.cloudManor.pojo.*;
import com.buba.cloud.cloudManor.service.MoneyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author FHJ
 * @title: MoneryServiceImpl
 * @projectName cloud-manor-java
 * @date 2020/7/2914:21
 */
@Service
public class MoneryServiceImpl implements MoneyService {
    @Resource
    private MoneyMapper moneyMapper;
    //查询养护人金钱
    @Override
    public UserInfo findUserInfo(Integer userId) {
        return moneyMapper.findUserInfo(userId);
    }
    //查询银行卡  根据BandCardAndUser关联表的cardId，查询BankCard对应的银行卡信息
    @Override
    public List<BankCard> findBankCard(Integer userId) {
        return moneyMapper.findBankCard(userId);
    }
    //添加银行卡信息 添加BankCard详细信息同时添加BandCardAndUser关联信息
    @Transactional
    @Override
    public boolean addBankCard(BankCard bankCard,Integer userId) {
       moneyMapper.addBankCard(bankCard);
       boolean b=moneyMapper.addBandCardAndUser(bankCard.getId(),userId);
       return b;
    }
    //余额提现
    @Transactional
    @Override
    public boolean addMasterAccount(Integer userId,String cardNum,Double money,Double remaindMoney) {
        boolean a=moneyMapper.addMasterAccount(userId,money,remaindMoney);
        boolean b=moneyMapper.updateUserInfo(userId,remaindMoney);
        return a&&b;
    }

    //本月未入账金额 userId=masterId
    @Override
    public String findMoney0(Integer userId) {
        return moneyMapper.findMoney0(userId);
    }
    //本月已入账金额 userId=masterId
    @Override
    public String findMoney1(Integer userId) {
        return moneyMapper.findMoney1(userId);
    }
    //本月提现金额userId=masterId
    @Override
    public String findMasterAccount(Integer userId) {
        return moneyMapper.findMasterAccount(userId);
    }

    @Override
    public List<ManorAccount> findRecordMoney(Integer userId, Integer n,Integer y) {
        return moneyMapper.findRecordMoney(userId,n,y);
    }

    @Override
    public List<ManorAccount> findNoneRecordMoney(Integer userId,Integer n,Integer y) {
        return moneyMapper.findNoneRecordMoney(userId,n,y);
    }

    @Override
    public List<MasterAccount> findRemaindMoney(Integer userId, Integer n,Integer y) {
        return moneyMapper.findRemaindMoney(userId,n,y);
    }
}
