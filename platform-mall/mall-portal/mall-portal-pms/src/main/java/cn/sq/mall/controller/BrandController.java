package cn.sq.mall.controller;

import cn.sq.mall.service.BrandService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 品牌管理API
 * @date 2022/7/16 15:37
 */
@RestController
@RequestMapping("/brand")
@Api(tags = "品牌管理API")
public class BrandController {
    @Autowired
    private BrandService service;

    @ResponseBody
    @ApiOperation(value = "分页获取推荐品牌")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "分页获取品牌相关商品")
    @GetMapping(value = "/products", produces = {"application/json;charset=UTF-8"})
    public PageResponse products(@RequestParam Long brandId,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.products(brandId, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "分页获取品牌相关商品")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }
}
