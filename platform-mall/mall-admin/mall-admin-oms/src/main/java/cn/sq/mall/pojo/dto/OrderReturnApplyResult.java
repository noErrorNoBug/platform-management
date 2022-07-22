package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.OmsCompanyAddress;
import cn.sq.mall.pojo.entity.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sunqiang
 * @version 1.0
 * @description 退货详情
 * @date 2022/7/17 16:51
 */
public class OrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}
