package cn.sq.mall.controller;

import cn.sq.mall.pojo.dto.FeeParam;
import cn.sq.mall.pojo.dto.OrderDeliveryParam;
import cn.sq.mall.pojo.dto.OrderQueryParam;
import cn.sq.mall.pojo.dto.ReceiverParam;
import cn.sq.mall.service.OrderService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单管理API
 * @date 2022/7/16 14:19
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单管理API")
public class OrderController {
    @Autowired
    private OrderService service;


    @ResponseBody
    @ApiOperation(value = "分页查询订单")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(OrderQueryParam param,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.list(param, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询订单详情信息")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }


    @ResponseBody
    @ApiOperation(value = "修改收货人信息")
    @PutMapping(value = "/receiver", produces = {"application/json;charset=UTF-8"})
    public BaseResponse receiver(@RequestBody ReceiverParam params) {
        int result = service.receiver(params);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改订单费用信息")
    @PutMapping(value = "/fee", produces = {"application/json;charset=UTF-8"})
    public BaseResponse fee(@RequestBody FeeParam params) {
        int result = service.fee(params);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "备注订单")
    @PutMapping(value = "/note/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse note(@PathVariable("id") Long id,
                             @RequestParam("note") String note,
                             @RequestParam("status") Integer status) {
        int result = service.note(id,note,status);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量发货")
    @PutMapping(value = "/batch/delivery", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delivery(@RequestBody List<OrderDeliveryParam> params) {
        int result = service.delivery(params);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量关闭订单")
    @PutMapping(value = "/batch/close", produces = {"application/json;charset=UTF-8"})
    public BaseResponse close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int result = service.close(ids,note);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量删除订单")
    @DeleteMapping(value = "/batch/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@RequestParam("ids") List<Long> ids) {
        int result = service.delete(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }


}
