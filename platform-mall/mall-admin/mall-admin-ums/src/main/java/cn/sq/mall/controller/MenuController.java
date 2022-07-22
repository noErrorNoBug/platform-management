package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.UmsMenu;
import cn.sq.mall.service.MenuService;
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
 * @description 菜单管理API
 * @date 2022/7/16 15:16
 */
@RestController
@RequestMapping("/menu")
@Api(tags = "菜单管理API")
public class MenuController {
    @Autowired
    private MenuService service;

    @ResponseBody
    @ApiOperation(value = "分页查询菜案")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@PathVariable Long parentId,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(parentId, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询菜单")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加菜单")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody UmsMenu param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改菜单")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody UmsMenu param) {
        int result = service.update(id, param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除菜单")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改菜单显示状态")
    @PutMapping(value = "/hidden/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse hidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        int result = service.hidden(id, hidden);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "返回菜单树")
    @GetMapping(value = "/tree", produces = {"application/json;charset=UTF-8"})
    public BaseResponse tree() {
        return BaseResponse.success(service.tree());
    }
}
