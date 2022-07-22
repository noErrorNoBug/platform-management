package cn.sq.mall.controller;

import cn.sq.mall.pojo.dto.ReturnApplyQueryParam;
import cn.sq.mall.pojo.dto.ReturnUpdateStatusParam;
import cn.sq.mall.service.OrderReturnApplyService;
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
 * @description 订单退单管理API
 * @date 2022/7/16 14:20
 */
@RestController
@RequestMapping("/return/apply")
@Api(tags = "订单退单管理API")
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService service;

    @ResponseBody
    @ApiOperation(value = "分页查询退货申请")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(ReturnApplyQueryParam param,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.list(param, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询退货申请详情信息")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }


    @ResponseBody
    @ApiOperation(value = "修改退货申请状态")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable("id") Long id,
                             @RequestBody ReturnUpdateStatusParam param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量删除退货申请")
    @DeleteMapping(value = "/batch/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@RequestParam("ids") List<Long> ids) {
        int result = service.delete(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
