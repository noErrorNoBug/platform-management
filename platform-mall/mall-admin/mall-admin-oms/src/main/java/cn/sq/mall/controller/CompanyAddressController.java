package cn.sq.mall.controller;

import cn.sq.mall.service.CompanyAddressService;
import cn.sq.platform.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunqiang
 * @version 1.0
 * @description 收货地址管理API
 * @date 2022/7/16 14:19
 */
@RestController
@RequestMapping("/address")
@Api(tags = "收货地址管理API")
public class CompanyAddressController {
    @Autowired
    private CompanyAddressService service;

    @ResponseBody
    @ApiOperation(value = "获取所有收货地址")
    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getAll() {
        return BaseResponse.success(service.getAll());
    }
}
