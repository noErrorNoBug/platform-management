package cn.sq.mall.controller;

import cn.sq.mall.service.MemberAttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 会员关注品牌管理API todo 使用到了MongoDB
 * @date 2022/7/16 15:46
 */
@RestController
@RequestMapping("/member/attention")
@Api(tags = "会员关注品牌管理API")
public class MemberAttentionController {

    // @Autowired
    // private MemberAttentionService service;
    //
    // @ResponseBody
    // @ApiOperation(value = "显示当前用户品牌关注列表")
    // @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    // public PageResponse list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
    //                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
    //     return service.list(pageNum, pageSize);
    // }
    //
    // @ResponseBody
    // @ApiOperation(value = "显示品牌关注详情")
    // @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    // public BaseResponse getItem(@PathVariable Long id) {
    //     return BaseResponse.success(service.getItem(id));
    // }
    //
    // @ResponseBody
    // @ApiOperation(value = "添加品牌关注")
    // @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    // public BaseResponse add(@Validated @RequestBody UmsMenu param) {
    //     int result = service.add(param);
    //     if (result > 0) {
    //         return BaseResponse.success();
    //     }
    //     return BaseResponse.failed();
    // }
    //
    //
    // @ResponseBody
    // @ApiOperation(value = "取消品牌关注")
    // @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    // public BaseResponse delete(@PathVariable Long id) {
    //     int result = service.delete(id);
    //     if (result > 0) {
    //         return BaseResponse.success();
    //     }
    //     return BaseResponse.failed();
    // }
    //
    // @ResponseBody
    // @ApiOperation(value = "清空当前用户品牌关注列表")
    // @DeleteMapping(value = "/clear", produces = {"application/json;charset=UTF-8"})
    // public BaseResponse clear() {
    //     int result = service.clear();
    //     if (result > 0) {
    //         return BaseResponse.success();
    //     }
    //     return BaseResponse.failed();
    // }
}
