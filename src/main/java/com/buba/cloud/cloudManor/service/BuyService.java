package com.buba.cloud.cloudManor.service;

import com.buba.cloud.cloudManor.pojo.User;

/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.service
 * @ClassName: BuyService
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/24 0024 16:09
 * @Version: 1.0
 */
public interface BuyService{
    //通过资源id获取养护人信息
    User obtainMaintenancePeopleMessage(Integer resourceId);

}
