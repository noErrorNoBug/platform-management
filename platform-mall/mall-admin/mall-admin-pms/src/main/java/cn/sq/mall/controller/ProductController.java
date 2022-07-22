package cn.sq.mall.controller;

import cn.sq.mall.pojo.dto.ProductParam;
import cn.sq.mall.pojo.dto.ProductQueryParam;
import cn.sq.mall.service.ProductService;
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
 * @description 商品管理API
 * @date 2022/7/15 17:51
 */
@RestController
@Api(tags = "商品管理API")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @ResponseBody
    @ApiOperation(value = "分页查询商品")
    @GetMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public PageResponse list(ProductQueryParam param,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return service.list(param, pageNum, pageSize);
    }

    @ResponseBody
    @ApiOperation(value = "根据商品名称或货号模糊查询")
    @GetMapping(value = "/keyword", produces = {"application/json;charset=UTF-8"})
    public BaseResponse list(String keyword) {
        return BaseResponse.success(service.list(keyword));
    }

    @ResponseBody
    @ApiOperation(value = "根据id查询商品编辑信息")
    @GetMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse getItem(@PathVariable Long id) {
        return BaseResponse.success(service.getItem(id));
    }

    @ResponseBody
    @ApiOperation(value = "添加商品")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public BaseResponse add(@Validated @RequestBody ProductParam param) {
        int result = service.add(param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "修改商品")
    @PutMapping(value = "/{id}", produces = {"application/json;charset=UTF-8"})
    public BaseResponse update(@PathVariable Long id,
                               @Validated @RequestBody ProductParam param) {
        int result = service.update(id,param);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量审核")
    @PutMapping(value = "/verify", produces = {"application/json;charset=UTF-8"})
    public BaseResponse verify(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("verifyStatus") Integer verifyStatus,
                                        @RequestParam("detail") String detail) {
        int result = service.verify(ids,verifyStatus,detail);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量上下架")
    @PutMapping(value = "/publish", produces = {"application/json;charset=UTF-8"})
    public BaseResponse publish(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("publishStatus") Integer publishStatus) {
        int result = service.publish(ids,publishStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量推荐")
    @PutMapping(value = "/recommend", produces = {"application/json;charset=UTF-8"})
    public BaseResponse recommend(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("recommendStatus") Integer recommendStatus) {
        int result = service.recommend(ids,recommendStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量设置新品")
    @PutMapping(value = "/newest", produces = {"application/json;charset=UTF-8"})
    public BaseResponse newest(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("newStatus") Integer newStatus) {
        int result = service.newest(ids,newStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }

    @ResponseBody
    @ApiOperation(value = "批量逻辑删除")
    @PutMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    public BaseResponse delete(@RequestParam("ids") List<Long> ids,
                                         @RequestParam("deleteStatus") Integer deleteStatus) {
        int result = service.delete(ids,deleteStatus);
        if (result > 0) {
            return BaseResponse.success();
        }
        return BaseResponse.failed();
    }


}
