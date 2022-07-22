package cn.sq.mall.controller;

import cn.sq.mall.pojo.dto.BrandParam;
import cn.sq.mall.service.BrandService;
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
 * @description 商品品牌管理
 * @date 2022/7/14 15:27
 */
@RestController
@RequestMapping("/brand")
@Api(tags = "商品品牌管理API")
public class BrandController {
    @Autowired
    private BrandService service;

    @ResponseBody
    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse getRecords(@RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.getRecords(keyword,pageNum,pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据编号查询品牌信息")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable("id") Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加品牌")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@RequestBody BrandParam brandParam) {
        int result = service.add(brandParam);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "更新品牌")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable("id") Long id,
                               @RequestBody BrandParam brandParam) {
        int result = service.update(id,brandParam);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "删除品牌")
    @DeleteMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@PathVariable("id") Long id) {
        int result = service.delete(id);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量删除品牌")
    @DeleteMapping(value = "/batch", produces = {"application/json;charset=UTF-8"})
    public BaseResponse deleteBatch(@RequestParam("ids") List<Long> ids) {
        int result = service.deleteBatch(ids);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量更新显示状态")
    @PutMapping(value = "/showStatus", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateShowStatus(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("showStatus") Integer showStatus) {
        int result = service.updateShowStatus(ids,showStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量更新厂家制造商状态")
    @PutMapping(value = "/factoryStatus", produces = {"application/json;charset=UTF-8"})
    public BaseResponse updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                                            @RequestParam("factoryStatus") Integer factoryStatus) {
        int result = service.updateFactoryStatus(ids,factoryStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }
}
