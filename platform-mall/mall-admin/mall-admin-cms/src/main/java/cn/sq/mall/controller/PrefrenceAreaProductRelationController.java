package cn.sq.mall.controller;

import cn.sq.mall.service.PrefrenceAreaProductRelationService;
import cn.sq.platform.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cn.sq.mall.pojo.CmsPrefrenceAreaProductRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优选专区和商品关系管理API
 * @date 2022/7/20 00:11
 */
@RestController
@RequestMapping("/prefrence/relation")
@Api(tags = "优选专区和商品关系管理API")
public class PrefrenceAreaProductRelationController {
    @Autowired
    private PrefrenceAreaProductRelationService service;

    @ResponseBody
    @ApiOperation(value = "批量插入优选专区和商品关系")
    @PostMapping(value = "/add/{productId}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@PathVariable(value = "productId") Long productId, @RequestBody List<CmsPrefrenceAreaProductRelation> params) {
        int result = service.add(productId,params);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
