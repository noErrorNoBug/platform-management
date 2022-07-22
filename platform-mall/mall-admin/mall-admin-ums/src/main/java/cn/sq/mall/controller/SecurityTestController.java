package cn.sq.mall.controller;

import cn.sq.platform.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunqiang
 * @version 1.0
 * @description 测试
 * @date 2022/7/20 10:52
 */
@RestController
@RequestMapping("/security")
@Api(tags = "测试用Controller")
public class SecurityTestController {
    @ResponseBody
    @ApiOperation(value = "测试SpringSecurity")
    @GetMapping(value = "/hello", produces = {"application/json;charset=UTF-8"})
    public BaseResponse register() {
        return BaseResponse.success();
    }
}
