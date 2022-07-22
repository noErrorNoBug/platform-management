package cn.sq.mall.controller;

import cn.sq.mall.pojo.dto.ProductCategoryParam;
import cn.sq.mall.service.ProductCategoryService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品分类管理
 * @date 2022/7/14 23:15
 */
@RestController
@Api(tags = "商品分类管理API")
@RequestMapping("/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;

    @ResponseBody
    @ApiOperation(value = "分页查询商品分类")
    @GetMapping(value = "/list/{parentId}", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@PathVariable Long parentId,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(parentId, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据id查询商品分类")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加商品分类")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody ProductCategoryParam param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改商品分类")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody ProductCategoryParam param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除商品分类")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量修改导航栏显示状态")
    @PutMapping(value = "/batch/navStatus", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateNavStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("navStatus") Integer navStatus) {
        int result = service.updateNavStatus(ids,navStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量修改显示状态")
    @PutMapping(value = "/batch/showStatus", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateShowStatus(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("showStatus") Integer showStatus) {
        int result = service.updateShowStatus(ids,showStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

}
