package cn.sq.mall.controller;

import cn.sq.mall.service.HomeService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 主页管理API
 * @date 2022/7/16 15:42
 */
@RestController
@RequestMapping("/home")
@Api(tags = "主页管理API")
public class HomeController {
    @Autowired
    private HomeService service;

    @ResponseBody
    @ApiOperation(value = "首页内容展示")
    @GetMapping(value = "/content", produces = {"application/json;charset=UTF-8"})
    public BaseResponse content() {
        return BaseResponse.success(service.content());
    }

    @ResponseBody
    @ApiOperation(value = "分页获取推荐商品")
    @GetMapping(value = "/recommend", produces = {"application/json;charset=UTF-8"})
    public PageResponse recommend(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.recommend(pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据分类获取专题")
    @GetMapping(value = "/subject", produces = {"application/json;charset=UTF-8"})
    public PageResponse subject(@RequestParam(required = false) Long cateId,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.subject(cateId, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "分页获取人气推荐商品")
    @GetMapping(value = "/hot", produces = {"application/json;charset=UTF-8"})
    public PageResponse hot(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.hot(pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "分页获取新品推荐商品")
    @GetMapping(value = "/newist", produces = {"application/json;charset=UTF-8"})
    public PageResponse newist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.newist(pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "获取前台商品详情")
    @GetMapping(value = "/category/{parentId}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse category(@PathVariable Long parentId) {
        return BaseResponse.success(service.getItem(parentId));
    }
}
