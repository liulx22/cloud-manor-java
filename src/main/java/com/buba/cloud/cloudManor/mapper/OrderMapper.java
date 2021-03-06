package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.Order;
import com.buba.cloud.cloudManor.pojo.OrderHistoricalVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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
    //孙智慧 历史订单
    List<OrderHistoricalVO> GETOrderHistoricalVO(@Param("userId") int userId,@Param("shijian") String shijian,@Param("leixing") String leixing);
}
