package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.SmsHomeNewProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 新品推荐商品表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface SmsHomeNewProductMapper extends BaseMapper<SmsHomeNewProduct> {

    int insertAll(List<SmsHomeNewProduct> params);
}
