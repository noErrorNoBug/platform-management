package cn.sq.mall.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sunqiang
 * @version 1.0
 * @description 查询单个商品修改结果
 * @date 2022/7/15 18:19
 */
public class ProductResult extends ProductParam{
    @Getter
    @Setter
    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}
