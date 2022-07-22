package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.SmsHomeRecommendProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 人气推荐商品表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface SmsHomeRecommendProductMapper extends BaseMapper<SmsHomeRecommendProduct> {
    int insertAll(List<SmsHomeRecommendProduct> params);
}
