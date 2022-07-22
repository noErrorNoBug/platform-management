package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.OmsOrder;
import cn.sq.mall.pojo.entity.OmsOrderItem;
import cn.sq.mall.pojo.entity.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单详情信息
 * @date 2022/7/17 14:23
 */
public class OrderDetials extends OmsOrder {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
