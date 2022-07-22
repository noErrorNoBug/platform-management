package cn.sq.mall.controller;

import cn.hutool.core.collection.CollUtil;
import cn.sq.mall.pojo.dto.AdminLoginParam;
import cn.sq.mall.pojo.dto.AdminParam;
import cn.sq.mall.pojo.dto.AdminPasswordParam;
import cn.sq.mall.pojo.entity.UmsAdmin;
import cn.sq.mall.pojo.entity.UmsRole;
import cn.sq.mall.service.AdminService;
import cn.sq.mall.service.RoleService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台用户管理API
 * @date 2022/7/16 15:16
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "后台用户管理API")
public class AdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register", produces = {"application/json;charset=UTF-8"})
    public BaseResponse register(@Validated @RequestBody AdminParam param) {
        UmsAdmin umsAdmin = adminService.register(param);
        if (umsAdmin == null) {
            return BaseResponse.invalidate("用户名已存在");
        }
        return BaseResponse.success(umsAdmin);
    }

    @ResponseBody
    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public BaseResponse login(@Validated @RequestBody AdminLoginParam param) {
        String token = adminService.login(param.getUsername(), param.getPassword());
        if (StringUtils.isBlank(token)) {
            return BaseResponse.invalidate("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return BaseResponse.success(tokenMap);
    }

    @ResponseBody
    @ApiOperation(value = "刷新token")
    @GetMapping(value = "/refreshToken", produces = {"application/json;charset=UTF-8"})
    public BaseResponse refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (StringUtils.isBlank(refreshToken)) {
            return BaseResponse.unauthorized("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return BaseResponse.success(tokenMap);
    }

    @ResponseBody
    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getAdminInfo(Principal principal) {
        if(principal==null){
            return BaseResponse.unauthorized(null);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles",roles);
        }
        return BaseResponse.success(data);
    }

    @ResponseBody
    @ApiOperation(value = "登出功能")
    @PostMapping(value = "/logout", produces = {"application/json;charset=UTF-8"})
    public BaseResponse logout() {
        return BaseResponse.success(null);
    }


    @ResponseBody
    @ApiOperation(value = "根据用户名或姓名分页获取用户列表")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return adminService.list(keyword, pageSize, pageNum);
    }


    @ResponseBody
    @ApiOperation(value = "获取用户详情")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(adminService.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "修改指定用户信息")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        int count = adminService.update(id, admin);
        if (count > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }


    @ResponseBody
    @ApiOperation(value = "修改用户密码")
    @PutMapping(value = "/password", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updatePassword(@Validated @RequestBody AdminPasswordParam param) {
        int status = adminService.updatePassword(param);
        if (status > 0) {
            return BaseResponse.success(status);
        } else if (status == -1) {
            return BaseResponse.invalidate("提交参数不合法");
        } else if (status == -2) {
            return BaseResponse.invalidate("找不到该用户");
        } else if (status == -3) {
            return BaseResponse.invalidate("旧密码错误");
        } else {
            return BaseResponse.failed();
        }
    }

    @ResponseBody
    @ApiOperation(value = "删除指定用户信息")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int count = adminService.delete(id);
        if (count > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改帐号状态")
    @PutMapping(value = "/status/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateStatus(@PathVariable Long id,@RequestParam(value = "status") Integer status) {
        int count = adminService.update(id,status);
        if (count > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "给用户分配角色")
    @PostMapping(value = "/role/update", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return BaseResponse.success(count);
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "获取指定用户的角色")
    @GetMapping(value = "/role/{adminId}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getRoleList(@PathVariable Long adminId) {
        return BaseResponse.success(adminService.getRoleList(adminId));
    }
}
