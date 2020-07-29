package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Resource;
import com.buba.cloud.cloudManor.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.mapper
 * @ClassName: BuyMapper
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/24 0024 16:17
 * @Version: 1.0
 */
@Repository
public interface BuyMapper extends Mapper<User>{
    //通过资源id获取养护人信息
    User obtainMaintenancePeopleMessage(Integer resourceId);
    //通过资源id查询资源信息
    Resource resourceMessage(Integer resourceId);
}
