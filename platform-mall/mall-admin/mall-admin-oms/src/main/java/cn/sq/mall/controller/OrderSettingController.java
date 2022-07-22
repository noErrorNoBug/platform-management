package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.OmsOrderSetting;
import cn.sq.mall.service.OrderSettingService;
import cn.sq.platform.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单设置管理API
 * @date 2022/7/16 14:20
 */
@RestController
@RequestMapping("/order/setting")
@Api(tags = "订单设置管理API")
public class OrderSettingController {
    @Autowired
    private OrderSettingService service;

    @ResponseBody
    @ApiOperation(value = "根据编号查找订单设置")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "修改订单设置")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody OmsOrderSetting param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
