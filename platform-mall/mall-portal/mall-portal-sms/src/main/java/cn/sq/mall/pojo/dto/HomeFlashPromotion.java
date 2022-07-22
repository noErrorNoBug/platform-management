package cn.sq.mall.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页秒杀场次信息封装
 * @date 2022/7/18 14:02
 */
@Getter
@Setter
public class HomeFlashPromotion {
    @ApiModelProperty("本场开始时间")
    private LocalTime startTime;
    @ApiModelProperty("本场结束时间")
    private LocalTime endTime;
    @ApiModelProperty("下场开始时间")
    private LocalTime nextStartTime;
    @ApiModelProperty("下场结束时间")
    private LocalTime nextEndTime;
    @ApiModelProperty("属于该秒杀活动的商品")
    private List<FlashPromotionProduct> productList;
}
