package cn.sq.mall.controller;

import cn.sq.mall.service.ProductAttributeCategoryService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品属性分类管理
 * @date 2022/7/14 23:15
 */
@RestController
@Api(tags = "商品属性分类管理API")
@RequestMapping("/attrCate")
public class ProductAttributeCategoryController {

    @Autowired
    private ProductAttributeCategoryService service;

    @ResponseBody
    @ApiOperation(value = "分页查询商品属性分类")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据商品分类编号查询商品属性及属性分类")
    @GetMapping(value = "/attrList", produces = {"application/json;charset=UTF-8"})
    public BaseResponse attrList() {
        return BaseResponse.success(service.attrList());
    }

    @ResponseBody
    @ApiOperation(value = "根据id查询商品属性分类")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加商品属性分类")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@RequestParam String name) {
        int result = service.add(name);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改商品属性分类")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @RequestParam String name) {
        int result = service.update(id,name);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除商品属性分类")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
