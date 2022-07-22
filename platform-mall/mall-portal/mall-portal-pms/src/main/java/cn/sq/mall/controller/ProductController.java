package cn.sq.mall.controller;

import cn.sq.mall.service.ProductService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品管理API
 * @date 2022/7/16 15:37
 */
@RestController
@RequestMapping("/product")
@Api(tags = "商品管理API")
public class ProductController {
    @Autowired
    private ProductService service;

    @ResponseBody
    @ApiOperation(value = "综合搜索、筛选、排序")
    @GetMapping(value = "/search", produces = {"application/json;charset=UTF-8"})
    @ApiImplicitParam(name = "sort", value = "排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低",
            defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    public PageResponse search(@RequestParam(required = false) String keyword,
                               @RequestParam(required = false) Long brandId,
                               @RequestParam(required = false) Long productCategoryId,
                               @RequestParam(required = false, defaultValue = "0") Integer sort,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.search(keyword,brandId,productCategoryId,sort,pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "以树形结构获取所有商品分类")
    @GetMapping(value = "/tree", produces = {"application/json;charset=UTF-8"})
    public BaseResponse tree() {
        return BaseResponse.success(service.tree());
    }

    @ResponseBody
    @ApiOperation(value = "获取前台商品详情")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }


}
