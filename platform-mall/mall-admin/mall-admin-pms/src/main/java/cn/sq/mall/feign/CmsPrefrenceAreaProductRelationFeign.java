package cn.sq.mall.feign;

import cn.sq.mall.pojo.entity.CmsPrefrenceAreaProductRelation;
import cn.sq.platform.core.entity.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 调用CMS(内容)服务 优选专区和商品关系管理API
 * @date 2022/7/20 01:06
 */
@FeignClient(contextId = "cms-prefrence-relation",value = "mall-admin-cms",path = "/prefrence/relation")
public interface CmsPrefrenceAreaProductRelationFeign {
    @PostMapping(value = "/add/{productId}", produces = {"application/json;charset=UTF-8"})
    BaseResponse add(@PathVariable(value = "productId") Long productId, @RequestBody List<CmsPrefrenceAreaProductRelation> params);
}
