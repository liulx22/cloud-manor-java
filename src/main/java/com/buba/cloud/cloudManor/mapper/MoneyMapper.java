package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.BankCard;
import com.buba.cloud.cloudManor.pojo.ManorAccount;
import com.buba.cloud.cloudManor.pojo.MasterAccount;
import com.buba.cloud.cloudManor.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author FHJ
 * @title: MoneyMapper
 * @projectName cloud-manor-java
 * @date 2020/7/3014:01
 */
public interface MoneyMapper {
    // 查询养护人金钱
    UserInfo findUserInfo(Integer userId);
    //查询银行卡  根据BandCardAndUser关联表的cardId，查询BankCard对应的银行卡信息
    List<BankCard> findBankCard(Integer userId);
    //添加银行卡信息 添加BankCard详细信息同时添加BandCardAndUser关联信息
    Integer addBankCard(BankCard bankCard);

    boolean addBandCardAndUser(@Param("id") Integer id,@Param("userId") Integer userId);

    //本月未入账金额 userId=masterId
    String findMoney0(Integer userId);
    //本月已入账金额 userId=masterId
    String findMoney1(Integer userId);
    //本月提现金额userId=masterId
    String findMasterAccount(Integer userId);

    List<ManorAccount> findRecordMoney(@Param("userId") Integer userId,@Param("n")  Integer n,@Param("y")  Integer y);

    List<ManorAccount> findNoneRecordMoney(@Param("userId") Integer userId,@Param("n")  Integer n,@Param("y")  Integer y);

    List<MasterAccount> findRemaindMoney(@Param("userId") Integer userId,@Param("n")  Integer n,@Param("y")  Integer y);
    //添加提现账单MasterAccount
    boolean addMasterAccount(@Param("userId")Integer userId, @Param("money")Double money, @Param("remaindMoney")Double remaindMoney);
    //修改UserInfo个人余额信息
    boolean updateUserInfo(@Param("userId")Integer userId, @Param("remaindMoney")Double remaindMoney);
}
