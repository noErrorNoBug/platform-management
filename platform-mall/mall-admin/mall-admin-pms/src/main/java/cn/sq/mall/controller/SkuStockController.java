package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.PmsSkuStock;
import cn.sq.mall.service.SkuStockService;
import cn.sq.platform.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 库存管理API
 * @date 2022/7/15 16:30
 */
@RestController
@RequestMapping("/sku")
@Api(tags = "sku库存管理API")
public class SkuStockController {
    @Autowired
    private SkuStockService service;

    @ResponseBody
    @ApiOperation(value = "根据商品ID及sku编码模糊搜索sku库存")
    @GetMapping(value = "/{pid}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        return BaseResponse.success(service.getList(pid,keyword));
    }

    @ResponseBody
    @ApiOperation(value = "批量更新sku库存信息")
    @PutMapping(value = "/batch", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@RequestBody List<PmsSkuStock> list) {
        int result = service.update(list);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
