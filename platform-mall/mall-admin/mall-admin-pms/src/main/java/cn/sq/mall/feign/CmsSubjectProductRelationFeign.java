package cn.sq.mall.feign;

import cn.sq.mall.pojo.entity.CmsSubjectProductRelation;
import cn.sq.platform.core.entity.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 调用CMS(内容)服务 专题和商品关系管理API
 * @date 2022/7/20 01:06
 */
@FeignClient(contextId = "cms-subject-relation",value = "mall-admin-cms",path = "/subject/relation")
public interface CmsSubjectProductRelationFeign {
    @PostMapping(value = "/add/{productId}", produces = {"application/json;charset=UTF-8"})
    BaseResponse add(@PathVariable(value = "productId") Long productId, @RequestBody List<CmsSubjectProductRelation> params);
}
