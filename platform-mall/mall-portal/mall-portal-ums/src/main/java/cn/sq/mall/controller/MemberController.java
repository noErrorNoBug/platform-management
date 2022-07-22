package cn.sq.mall.controller;

import cn.hutool.core.collection.CollUtil;
import cn.sq.mall.service.MemberService;
import cn.sq.platform.core.entity.BaseResponse;
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
 * @description 会员登录注册管理API
 * @date 2022/7/16 15:46
 */
@RestController
@RequestMapping("/member")
@Api(tags = "会员登录注册管理API")
public class MemberController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private MemberService service;

    @ResponseBody
    @ApiOperation(value = "会员注册")
    @PostMapping(value = "/register", produces = {"application/json;charset=UTF-8"})
    public BaseResponse register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        service.register(username,password,telephone,authCode);
        return BaseResponse.success("注册成功",null);
    }

    @ResponseBody
    @ApiOperation(value = "会员登录")
    @PostMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public BaseResponse login(@RequestParam String username,
                              @RequestParam String password) {
        String token = service.login(username, password);
        if (StringUtils.isBlank(token)) {
            return BaseResponse.invalidate("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return BaseResponse.success(tokenMap);
    }


    @ResponseBody
    @ApiOperation(value = "获取会员信息")
    @GetMapping(value = "/info", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getAdminInfo(Principal principal) {
        if(principal==null){
            return BaseResponse.unauthorized(null);
        }
        return BaseResponse.success(service.getCurrentMember());
    }

    @ResponseBody
    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "/authCode", produces = {"application/json;charset=UTF-8"})
    public BaseResponse authCode(@RequestParam String telephone) {
        return BaseResponse.success(service.generateAuthCode(telephone));
    }

    @ResponseBody
    @ApiOperation(value = "修改密码")
    @GetMapping(value = "/password", produces = {"application/json;charset=UTF-8"})
    public BaseResponse authCode(@RequestParam String telephone,
                                 @RequestParam String password,
                                 @RequestParam String authCode) {
        service.password(telephone,password,authCode);
        return BaseResponse.success("密码修改成功",null);
    }

    @ResponseBody
    @ApiOperation(value = "刷新token")
    @GetMapping(value = "/refreshToken", produces = {"application/json;charset=UTF-8"})
    public BaseResponse refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = service.refreshToken(token);
        if (StringUtils.isBlank(refreshToken)) {
            return BaseResponse.unauthorized("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return BaseResponse.success(tokenMap);
    }

}
