package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.SmsCoupon;
import cn.sq.mall.pojo.entity.SmsCouponProductCategoryRelation;
import cn.sq.mall.pojo.entity.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券参数
 * @date 2022/7/17 19:29
 */
public class CouponParam extends SmsCoupon {
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
