package cn.sq.mall.mapper;

import cn.sq.mall.pojo.dto.OrderDeliveryParam;
import cn.sq.mall.pojo.dto.OrderDetials;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单组合查询
 * @date 2022/7/17 14:56
 */
@Mapper
public interface OrderDao {
    /**
     * 关联查询订单详情
     * @param id 订单编号
     * @return
     */
    List<OrderDetials> getItem(@Param("id") Long id);


    int delivery(@Param("list") List<OrderDeliveryParam> params);
}
