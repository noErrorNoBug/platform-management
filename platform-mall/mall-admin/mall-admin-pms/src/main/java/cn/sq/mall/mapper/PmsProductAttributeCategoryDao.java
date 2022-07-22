package cn.sq.mall.mapper;

import cn.sq.mall.pojo.dto.ProductAttributeCategoryItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunqiang
 * @version 商品属性分类DAO
 * @description 商品属性分类DAO
 * @date 2022/7/15 16:18
 */
@Mapper
public interface PmsProductAttributeCategoryDao {
    /**
     * 获取属性分类集合
     * @return
     */
    List<ProductAttributeCategoryItem> getListWithAttr();
}
