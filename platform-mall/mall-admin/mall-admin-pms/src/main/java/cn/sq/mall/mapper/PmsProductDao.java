package cn.sq.mall.mapper;

import cn.sq.mall.pojo.dto.ProductResult;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品相关表查询
 * @date 2022/7/15 20:50
 */
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     */
    ProductResult getInfo(@Param("id") Long id);
}
