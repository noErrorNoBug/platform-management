package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.ProductAttributeCategoryItem;
import cn.sq.mall.pojo.entity.PmsProductAttributeCategory;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品属性分类接口
 * @date 2022/7/15 11:05
 */
public interface ProductAttributeCategoryService {
    /**
     * 分页获取属性分类
     * @param pageNum 页码
     * @param pageSize  每页大小
     * @return
     */
    PageResponse list(Integer pageNum, Integer pageSize);

    /**
     * 获取对应属性集合
     *
     * @return
     */
    List<ProductAttributeCategoryItem> attrList();

    /**
     * 根据编号获取属性分类
     * @param id    属性分类编号
     * @return
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     * 添加属性分类
     * @param name 属性分类名称
     * @return
     */
    int add(String name);

    /**
     * 更新属性分类
     * @param id    属性分类编号
     * @param name  属性分类名称
     * @return
     */
    int update(Long id, String name);

    /**
     * 删除属性分类
     * @param id    属性分类编号
     * @return
     */
    int delete(Long id);
}
