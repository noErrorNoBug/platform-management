package cn.sq.mall.controller;

import cn.sq.mall.pojo.dto.ProductAttributeParam;
import cn.sq.mall.service.ProductAttributeService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品属性管理
 * @date 2022/7/15 00:39
 */
@RestController
@Api(tags = "商品属性管理API")
@RequestMapping("/attribute")
public class ProductAttributeController {
    @Autowired
    private ProductAttributeService service;

    @ResponseBody
    @ApiOperation(value = "根据查询分类进行分页查询")
    @GetMapping(value = "/list/{cid}", produces = {"application/json;charset=UTF-8"})
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "0-属性，1-参数", required = true, paramType = "query", dataType = "integer")})
    public PageResponse list(@PathVariable Long cid,
                             @RequestParam(value = "type") Integer type,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(cid,type,pageNum,pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据id查询商品属性")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "根据商品分类编号查询商品属性及属性分类")
    @GetMapping(value = "/attrInfo/{cid}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse attrInfo(@PathVariable Long cid) {
        return BaseResponse.success(service.attrInfo(cid));
    }

    @ResponseBody
    @ApiOperation(value = "添加商品属性")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody ProductAttributeParam param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改商品属性")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody ProductAttributeParam param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量删除商品属性")
    @DeleteMapping(value = "/batch", produces = {"application/json;charset=UTF-8"})
    public BaseResponse deleteBatch(@RequestParam("ids") List<Long> ids) {
        int result = service.deleteBatch(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }


}
