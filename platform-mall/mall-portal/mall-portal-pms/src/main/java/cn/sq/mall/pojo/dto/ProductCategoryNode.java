package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 包含子分类的商品分类
 * @date 2022/7/18 13:13
 */
@Getter
@Setter
public class ProductCategoryNode extends PmsProductCategory {
    @ApiModelProperty("子分类集合")
    private List<ProductCategoryNode> children;
}
