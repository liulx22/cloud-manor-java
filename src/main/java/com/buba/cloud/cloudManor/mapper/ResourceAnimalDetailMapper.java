package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.ResourceAnimalDetail;
import com.buba.cloud.cloudManor.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.mapper
 * @ClassName: ResourceAnimalDetailMapper
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/26 0026 12:56
 * @Version: 1.0
 */
@Repository
public interface ResourceAnimalDetailMapper  {
    //通过资源id查询畜牧具体信息
    @Select("select * from resourceanimaldetail where resource_id = #{resourceId}")
    ResourceAnimalDetail resourceLivestockMessage(Integer resourceId);
}
