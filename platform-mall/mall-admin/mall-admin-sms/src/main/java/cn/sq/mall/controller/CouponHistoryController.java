package cn.sq.mall.controller;

import cn.sq.mall.service.CouponHistoryService;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券领取记录管理API
 * @date 2022/7/16 14:59
 */
@RestController
@RequestMapping("/coupon/history")
@Api(tags = "优惠券领取记录管理API")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService service;

    @ResponseBody
    @ApiOperation(value = "分页查询优惠券领取记录")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "couponId", required = false) Long couponId,
                             @RequestParam(value = "useStatus", required = false) Integer useStatus,
                             @RequestParam(value = "orderSn", required = false) String orderSn,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(couponId,useStatus,orderSn,pageNum, pageSize);
    }
}
