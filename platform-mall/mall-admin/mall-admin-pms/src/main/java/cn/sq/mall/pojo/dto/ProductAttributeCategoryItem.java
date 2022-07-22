package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.PmsProductAttribute;
import cn.sq.mall.pojo.entity.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品属性分类集合
 * @date 2022/7/15 16:20
 */
public class ProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}
