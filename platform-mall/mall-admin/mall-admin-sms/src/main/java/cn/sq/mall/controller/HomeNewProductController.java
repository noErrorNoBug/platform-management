package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.SmsHomeNewProduct;
import cn.sq.mall.service.HomeNewProductService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页新品管理API
 * @date 2022/7/16 15:00
 */
@RestController
@RequestMapping("/home/newist")
@Api(tags = "首页新品管理API")
public class HomeNewProductController {
    @Autowired
    private HomeNewProductService service;

    @ResponseBody
    @ApiOperation(value = "分页查询新品推荐")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "productName", required = false) String productName,
                             @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(productName,recommendStatus,pageNum, pageSize);
    }


    @ResponseBody
    @ApiOperation(value = "批量添加首页新品推荐")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@RequestBody List<SmsHomeNewProduct> params) {
        int result = service.add(params);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改新品推荐排序")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @RequestParam Integer sort) {
        int result = service.update(id, sort);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量删除新品推荐")
    @DeleteMapping(value = "/batch/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@RequestParam List<Long> ids) {
        int result = service.delete(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量修改新品推荐状态")
    @PutMapping(value = "/batch/status", produces = {"application/json;charset=UTF-8"})
    public BaseResponse status(@RequestParam List<Long> ids,
                               @RequestParam Integer status) {
        int result = service.status(ids,status);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
