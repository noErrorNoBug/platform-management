package cn.sq.mall.controller;

import cn.sq.mall.service.SubjectService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品专题管理API
 * @date 2022/7/16 01:02
 */
@RestController
@RequestMapping("/subject")
@Api(tags = "商品专题管理API")
public class SubjectController {
    @Autowired
    private SubjectService service;

    @ResponseBody
    @ApiOperation(value = "获取全部商品专题")
    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getAll() {
        return BaseResponse.success(service.getAll());
    }


    @ResponseBody
    @ApiOperation(value = "根据专题名称分页获取商品专题")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.list(keyword,pageNum,pageSize);
    }
}
