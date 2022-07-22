package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsSkuStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品sku表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface PmsSkuStockMapper extends BaseMapper<PmsSkuStock> {

    /**
     * 更新sku
     * @param list sku集合
     * @return
     */
    int replace(@Param("list") List<PmsSkuStock> list);

    /**
     * 插入sku表
     * @param productId 产品编号
     * @param list sku集合
     */
    void insertAll(@Param("productId") long productId,@Param("list") List<PmsSkuStock> list);
}
