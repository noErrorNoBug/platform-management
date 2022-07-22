package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.OmsOrderReturnReason;
import cn.sq.mall.service.OrderReturnReasonService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单退单原因管理API
 * @date 2022/7/16 14:20
 */
@RestController
@RequestMapping("/return/reason")
@Api(tags = "订单退单原因管理API")
public class OrderReturnReasonController {
    @Autowired
    private OrderReturnReasonService service;

    @ResponseBody
    @ApiOperation(value = "分页查询退货原因")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据id查询商品退货原因")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加退货原因")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody OmsOrderReturnReason param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改退货原因")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody OmsOrderReturnReason param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量删除退货原因")
    @DeleteMapping(value = "/batch/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@RequestParam("ids") List<Long> ids) {
        int result = service.delete(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改退货原因启用状态")
    @PutMapping(value = "/batch/status", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("status") Integer status) {
        int result = service.updateStatus(ids,status);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

}
