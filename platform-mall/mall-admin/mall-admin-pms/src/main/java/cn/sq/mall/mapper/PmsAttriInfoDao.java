package cn.sq.mall.mapper;

import cn.sq.mall.pojo.dto.ProductAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 查询商品属性及属性分类
 * @date 2022/7/15 01:58
 */
public interface PmsAttriInfoDao {
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long cid);
}
