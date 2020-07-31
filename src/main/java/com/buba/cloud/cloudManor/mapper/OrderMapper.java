package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Order;
import tk.mybatis.mapper.common.Mapper;
/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.mapper
 * @ClassName: OrderMapper
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/31 0031 16:23
 * @Version: 1.0
 */
public interface OrderMapper{
    Integer orderRunningNum();
}
