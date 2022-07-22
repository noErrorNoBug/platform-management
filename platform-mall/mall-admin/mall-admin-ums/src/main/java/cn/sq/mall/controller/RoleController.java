package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.UmsRole;
import cn.sq.mall.service.RoleService;
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
 * @description 后台用户角色管理API
 * @date 2022/7/16 15:17
 */
@RestController
@RequestMapping("/role")
@Api(tags = "后台用户角色管理API")
public class RoleController {
    @Autowired
    private RoleService service;

    @ResponseBody
    @ApiOperation(value = "获取所有角色")
    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public BaseResponse all() {
        return BaseResponse.success(service.all());
    }

    @ResponseBody
    @ApiOperation(value = "根据角色名称分页获取角色列表")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(keyword, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "获取角色相关菜单")
    @GetMapping(value = "/menu/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse menu(@PathVariable Long roleId) {
        return BaseResponse.success(service.menu(roleId));
    }

    @ResponseBody
    @ApiOperation(value = "获取角色相关资源")
    @GetMapping(value = "/resource/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse resource(@PathVariable Long roleId) {
        return BaseResponse.success(service.resource(roleId));
    }

    @ResponseBody
    @ApiOperation(value = "添加角色")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody UmsRole param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "给角色分配菜单")
    @PostMapping(value = "/menu", produces = {"application/json;charset=UTF-8"})
    public BaseResponse addMenus(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int result = service.addMenus(roleId,menuIds);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "给角色分配资源")
    @PostMapping(value = "/resource", produces = {"application/json;charset=UTF-8"})
    public BaseResponse addResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int result = service.addResource(roleId,resourceIds);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改角色")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody UmsRole param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量删除角色")
    @DeleteMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@RequestParam("ids") List<Long> ids) {
        int result = service.delete(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改角色状态")
    @PutMapping(value = "/status/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse status(@PathVariable("id") Long id,
                               @RequestParam("status") Integer status) {
        int result = service.status(id,status);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }


}
