package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.SmsHomeAdvertise;
import cn.sq.mall.service.HomeAdvertiseService;
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
 * @description 首页轮播广告管理API
 * @date 2022/7/16 15:00
 */
@RestController
@RequestMapping("/home/advertise")
@Api(tags = "首页轮播广告管理API")
public class HomeAdvertiseController {
    @Autowired
    private HomeAdvertiseService service;

    @ResponseBody
    @ApiOperation(value = "分页查询广告")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "type", required = false) Integer type,
                             @RequestParam(value = "endTime", required = false) String endTime,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(name,type,endTime,pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询广告")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加广告")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody SmsHomeAdvertise param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改广告")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody SmsHomeAdvertise param) {
        int result = service.update(id, param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除广告")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改上下线状态")
    @PutMapping(value = "/status/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateStatus(@PathVariable Long id,
                                     @RequestParam Integer status) {
        int result = service.updateStatus(id, status);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
