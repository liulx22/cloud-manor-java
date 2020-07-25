package com.buba.cloud.cloudManor.service.impl;

import com.buba.cloud.cloudManor.mapper.BuyMapper;
import com.buba.cloud.cloudManor.pojo.User;
import com.buba.cloud.cloudManor.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.service
 * @ClassName: BuyService
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/24 0024 16:09
 * @Version: 1.0
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyMapper buyMapper;


    /**
     * 功能描述:通过资源id获取养护人信息
     * @Param: [resourceId]
     * @Return: com.buba.cloud.cloudManor.pojo.User
     * @Author: ggx
     * @Date: 2020/7/24 0024 16:13
     */
    @Override
    public User obtainMaintenancePeopleMessage(Integer resourceId) {
        return  buyMapper.selectOne(new User().setId(resourceId));
    }
}
