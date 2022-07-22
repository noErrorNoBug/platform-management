package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsMemberPrice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品会员价格表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface PmsMemberPriceMapper extends BaseMapper<PmsMemberPrice> {

    /**
     * 批量插入商品会员价格表
     * @param productId 商品编号
     * @param list 商品会员价格列表
     * @return
     */
    int insertAll(@Param("productId") long productId, @Param("list") List<PmsMemberPrice> list);
}
