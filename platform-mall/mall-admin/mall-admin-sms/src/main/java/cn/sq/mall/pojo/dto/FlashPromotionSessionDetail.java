package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.SmsFlashPromotionSession;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sunqiang
 * @version 1.0
 * @description 场次信息
 * @date 2022/7/17 20:55
 */
public class FlashPromotionSessionDetail extends SmsFlashPromotionSession {
    @Setter
    @Getter
    @ApiModelProperty("商品数量")
    private Long productCount;
}
