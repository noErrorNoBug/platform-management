package cn.sq.mall.controller;

import cn.sq.mall.pojo.entity.SmsHomeBrand;
import cn.sq.mall.service.HomeBrandService;
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
 * @description 首页品牌管理API
 * @date 2022/7/16 15:00
 */
@RestController
@RequestMapping("/home/brand")
@Api(tags = "首页品牌管理API")
public class HomeBrandController {
    @Autowired
    private HomeBrandService service;

    @ResponseBody
    @ApiOperation(value = "分页查询品牌推荐")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(@RequestParam(value = "brandName", required = false) String brandName,
                             @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(brandName,recommendStatus,pageNum, pageSize);
    }


    @ResponseBody
    @ApiOperation(value = "批量添加首页品牌推荐")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@RequestBody List<SmsHomeBrand> params) {
        int result = service.add(params);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改品牌推荐排序")
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
    @ApiOperation(value = "批量删除品牌推荐")
    @DeleteMapping(value = "/batch/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@RequestParam List<Long> ids) {
        int result = service.delete(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量修改品牌推荐状态")
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
