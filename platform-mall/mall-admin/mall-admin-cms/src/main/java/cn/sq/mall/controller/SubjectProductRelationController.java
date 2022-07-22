package cn.sq.mall.controller;

import cn.sq.platform.core.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cn.sq.mall.pojo.CmsSubjectProductRelation;
import cn.sq.mall.service.SubjectProductRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 专题商品关系管理API
 * @date 2022/7/20 00:11
 */
@RestController
@RequestMapping("/subject/relation")
@Api(tags = "专题商品关系管理API")
public class SubjectProductRelationController {
    @Autowired
    private SubjectProductRelationService service;

    @ResponseBody
    @ApiOperation(value = "批量插入专题商品关系管理")
    @PostMapping(value = "/add/{productId}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@PathVariable(value = "productId") Long productId, @RequestBody List<CmsSubjectProductRelation> params) {
        int result = service.add(productId,params);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
