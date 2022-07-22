package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.PmsBrand;
import cn.sq.platform.core.entity.PageResponse;

/**
 * @author sunqiang
 * @version 1.0
 * @description 品牌管理
 * @date 2022/7/16 15:37
 */
public interface BrandService {
    /**
     * 分页获取品牌推荐
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    PageResponse list(Integer pageNum, Integer pageSize);

    /**
     * 分页获取品牌下商品清单
     * @param brandId 品牌编号
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    PageResponse products(Long brandId, Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     * @param id 品牌编号
     * @return
     */
    PmsBrand getItem(Long id);
}
