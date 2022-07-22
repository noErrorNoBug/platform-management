package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.SmsCouponProductRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 优惠券和商品关系表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface SmsCouponProductRelationMapper extends BaseMapper<SmsCouponProductRelation> {

    void insertAll(List<SmsCouponProductRelation> relations);
}
