package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.UmsResource;
import cn.sq.mall.service.ResourceService;
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
 * @description 后台资源管理API
 * @date 2022/7/16 15:17
 */
@RestController
@RequestMapping("/resource")
@Api(tags = "后台资源管理API")
public class ResourceController {
    @Autowired
    private ResourceService service;

    @ResponseBody
    @ApiOperation(value = "查询所有后台资源")
    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public BaseResponse all() {
        return BaseResponse.success(service.all());
    }

    @ResponseBody
    @ApiOperation(value = "分页查询后台资源")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(required = false) Long categoryId,
                             @RequestParam(required = false) String nameKeyword,
                             @RequestParam(required = false) String urlKeyword,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(categoryId,nameKeyword,urlKeyword, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询后台资源")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加后台资源")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody UmsResource param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改后台资源")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody UmsResource param) {
        int result = service.update(id, param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除后台资源")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

}
