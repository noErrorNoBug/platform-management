package cn.sq.mall.mapper;

import cn.sq.mall.pojo.dto.CouponParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券多表查询
 * @date 2022/7/17 19:34
 */
@Mapper
public interface CouponDao {
    /**
     * 查询优惠券信息
     * @param id 优惠券编号
     * @return
     */
    CouponParam getItem(@Param("id") Long id);
}
