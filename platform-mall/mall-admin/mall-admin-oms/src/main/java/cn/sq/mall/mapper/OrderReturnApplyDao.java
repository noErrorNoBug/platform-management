package cn.sq.mall.mapper;

import cn.sq.mall.pojo.dto.OrderReturnApplyResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunqiang
 * @version 1.0
 * @description 退货多表查询
 * @date 2022/7/17 17:37
 */
@Mapper
public interface OrderReturnApplyDao {
    OrderReturnApplyResult getItem(@Param("id")Long id);
}
