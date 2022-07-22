package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.PmsProduct;
import cn.sq.mall.pojo.entity.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购关联商品
 * @date 2022/7/17 20:34
 */
public class FlashPromotionProduct extends SmsFlashPromotionProductRelation {
    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private PmsProduct product;
}
