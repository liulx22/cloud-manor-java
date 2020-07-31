package com.buba.cloud.cloudManor.mapper;

import com.buba.cloud.cloudManor.pojo.ResourceTreeDetail;
import com.buba.cloud.cloudManor.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ProjectName: cloud-manor-java
 * @Package: com.buba.cloud.cloudManor.mapper
 * @ClassName: ResourceTreeDetailMapper
 * @Author: ggx
 * @Description:
 * @Date: 2020/7/26 0026 12:56
 * @Version: 1.0
 */
@Repository
public interface ResourceTreeDetailMapper {

    //通过资源id查询树木具体信息
    @Select("select * from resourcetreedetail where resource_id = #{resourceId}")
    ResourceTreeDetail resourceFruiterMessage(Integer resourceId);
}
