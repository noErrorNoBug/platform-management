package cn.sq.mall.controller;

import cn.sq.mall.pojo.dto.CouponParam;
import cn.sq.mall.service.CouponService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券管理API
 * @date 2022/7/16 14:59
 */
@RestController
@RequestMapping("/coupon")
@Api(tags = "优惠券管理API")
public class CouponController {
    @Autowired
    private CouponService service;

    @ResponseBody
    @ApiOperation(value = "分页查询优惠券")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "name",required = false) String name,
                             @RequestParam(value = "type",required = false) Integer type,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.list(name,type, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询优惠券详情信息")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加优惠券")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody CouponParam param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改优惠券")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody CouponParam param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除优惠券")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
