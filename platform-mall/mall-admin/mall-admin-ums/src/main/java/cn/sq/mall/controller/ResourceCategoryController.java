package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.UmsResourceCategory;
import cn.sq.mall.service.ResourceCategoryService;
import cn.sq.platform.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台资源分类管理API
 * @date 2022/7/16 15:16
 */
@RestController
@RequestMapping("/cataegory")
@Api(tags = "后台资源分类管理API")
public class ResourceCategoryController {
    @Autowired
    private ResourceCategoryService service;

    @ResponseBody
    @ApiOperation(value = "查询所有后台资源分类")
    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public BaseResponse all() {
        return BaseResponse.success(service.all());
    }

    @ResponseBody
    @ApiOperation(value = "添加后台资源分类")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody UmsResourceCategory param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改后台资源分类")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody UmsResourceCategory param) {
        int result = service.update(id, param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除后台资源分类")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

}
