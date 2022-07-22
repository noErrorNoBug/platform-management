package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.SmsFlashPromotionSession;
import cn.sq.mall.service.FlashPromotionSessionService;
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
 * @description 限时购场次管理API
 * @date 2022/7/16 14:59
 */
@RestController
@RequestMapping("/flash/session")
@Api(tags = "限时购场次管理API")
public class FlashPromotionSessionController {
    @Autowired
    private FlashPromotionSessionService service;

    @ResponseBody
    @ApiOperation(value = "分页查询全部场次")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "查询所有可用场次和数量")
    @GetMapping(value = "/available/{flashPromotionId}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse available(@PathVariable(value = "flashPromotionId") Long flashPromotionId) {
        return BaseResponse.success(service.available(flashPromotionId));
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询场次信息")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加限时购场次")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody SmsFlashPromotionSession param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改限时购场次")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody SmsFlashPromotionSession param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除限时购场次")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改启用状态")
    @PutMapping(value = "/status/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateStatus(@PathVariable Long id,
                                     @RequestParam Integer status) {
        int result = service.updateStatus(id,status);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
