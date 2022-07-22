package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsProductFullReduction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品满减表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface PmsProductFullReductionMapper extends BaseMapper<PmsProductFullReduction> {

    /**
     * 批量插入商品满减
     * @param productId 产品id
     * @param list 满减表集合
     * @return
     */
    int insertAll(@Param("productId") long productId,@Param("list") List<PmsProductFullReduction> list);
}
