package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.PmsSkuStock;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0.0
 * @description sku库存管理接口
 * @date 2022/7/15 17:33
 */
public interface SkuStockService {
    /**
     * 根据商品ID及sku编码模糊搜索sku库存
     * @param pid 商品id
     * @param keyword   sku编码
     * @return
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新sku库存信息
     *
     * @param list
     *         sku列表
     *
     * @return
     */
    int update(List<PmsSkuStock> list);
}
