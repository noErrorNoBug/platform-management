package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.PortalProductDetail;
import cn.sq.mall.pojo.dto.ProductCategoryNode;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品管理
 * @date 2022/7/16 15:37
 */
public interface ProductService {
    /**
     * 综合搜索、筛选、排序
     * @param keyword 关键字
     * @param brandId   品牌编号
     * @param productCategoryId 商品分类编号
     * @param sort 排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse search(String keyword, Long brandId, Long productCategoryId, Integer sort, Integer pageNum, Integer pageSize);

    /**
     * 以树形结构获取所有商品分类
     * @return
     */
    List<ProductCategoryNode> tree();

    /**
     * 获取前台商品详情
     * @param id 商品编号
     * @return
     */
    PortalProductDetail getItem(Long id);
}
