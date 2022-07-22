package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.SmsFlashPromotionProductRelation;
import cn.sq.mall.service.FlashPromotionProductRelationService;
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
 * @description 限时购和商品关系管理API
 * @date 2022/7/16 14:59
 */
@RestController
@RequestMapping("/flash/relation")
@Api(tags = "限时购和商品关系管理API")
public class FlashPromotionProductRelationController {
    @Autowired
    private FlashPromotionProductRelationService service;

    @ResponseBody
    @ApiOperation(value = "分页查询不同场次限时购和商品关系")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "flashPromotionId") Long flashPromotionId,
                             @RequestParam(value = "flashPromotionSessionId") Long flashPromotionSessionId,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.list(flashPromotionId,flashPromotionSessionId, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询限时购和商品关系信息")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }


    @ResponseBody
    @ApiOperation(value = "修改限时购和商品关系")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody SmsFlashPromotionProductRelation param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除限时购和商品关系")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量添加商品关联")
    @PostMapping(value = "/batch", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody List<SmsFlashPromotionProductRelation> relationLists) {
        int result = service.add(relationLists);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
