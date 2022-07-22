package cn.sq.mall.controller;

import cn.sq.mall.service.MemberLevelService;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 会员等级管理API
 * @date 2022/7/16 15:16
 */
@RestController
@RequestMapping("/level")
@Api(tags = "会员等级管理API")
public class MemberLevelController {
    @Autowired
    private MemberLevelService service;

    @ResponseBody
    @ApiOperation(value = "分页查询会员等级")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam("defaultStatus") Integer defaultStatus,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.list(defaultStatus, pageNum, pageSize);
    }
}
