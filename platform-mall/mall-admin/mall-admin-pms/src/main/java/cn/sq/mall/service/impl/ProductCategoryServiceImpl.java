package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.PmsProductCategoryAttributeRelationMapper;
import cn.sq.mall.mapper.PmsProductCategoryMapper;
import cn.sq.mall.mapper.PmsProductMapper;
import cn.sq.mall.pojo.dto.ProductCategoryParam;
import cn.sq.mall.pojo.entity.PmsProduct;
import cn.sq.mall.pojo.entity.PmsProductCategory;
import cn.sq.mall.pojo.entity.PmsProductCategoryAttributeRelation;
import cn.sq.mall.service.ProductCategoryService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品分类服务
 * @date 2022/7/14 23:31
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private PmsProductCategoryMapper categoryMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryAttributeRelationMapper relationMapper;


    /**
     * 分页查询商品分类
     *
     * @param parentId
     *         父级分类编号
     * @param pageNum
     *         页数
     * @param pageSize
     *         每页数量
     *
     * @return
     */
    @Override
    public PageResponse list(Long parentId, Integer pageNum, Integer pageSize) {
        Page<PmsProductCategory> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (ObjectUtils.isNotEmpty(parentId)) {
            wrapper.eq("parent_id", parentId);
        }
        page = categoryMapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据id查询商品分类
     *
     * @param id
     *         商品分类编号
     *
     * @return
     */
    @Override
    public PmsProductCategory getItem(Long id) {
        return categoryMapper.selectById(id);
    }

    /**
     * 添加商品分类
     *
     * @param param
     *         商品分类参数
     *
     * @return
     */
    @Override
    public int add(ProductCategoryParam param) {
        PmsProductCategory category = new PmsProductCategory();
        BeanUtils.copyProperties(param, category);
        category.setProductCount(0);
        // 需要根据parentId设置level
        setLevel(category);
        List<Long> attributeIds = param.getProductAttributeIdList();
        int categoryId = categoryMapper.insert(category);
        // 需要新建分类与规格关系
        if (!CollectionUtils.isEmpty(attributeIds)) {
            addRelations(category.getId(), attributeIds);
        }
        return categoryId;
    }


    /**
     * 修改商品分类
     *
     * @param id
     *         商品分类编号
     * @param param
     *         商品分类参数
     *
     * @return
     */
    @Override
    public int update(Long id, ProductCategoryParam param) {
        PmsProductCategory category = new PmsProductCategory();
        category.setId(id);
        BeanUtils.copyProperties(param,category);
        // 需要根据改动重新计算level
        setLevel(category);
        // 需要更新商品中的分类信息
        PmsProduct product = new PmsProduct();
        product.setProductCategoryName(category.getName());
        UpdateWrapper<PmsProduct> wrapper = new UpdateWrapper<>();
        wrapper.eq("product_category_id",id);
        productMapper.update(product,wrapper);
        // 需要筛选更新分类与规格关系(删或增)
        List<Long> attributeIds = param.getProductAttributeIdList();
        relationMapper.deleteBatchIds(attributeIds);
        if (!CollectionUtils.isEmpty(attributeIds)) {
            addRelations(id, attributeIds);
        }
        return categoryMapper.updateById(category);
    }

    /**
     * 删除商品分类
     *
     * @param id
     *         商品分类编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return categoryMapper.deleteById(id);
    }

    /**
     * 批量修改导航栏显示状态
     *
     * @param ids
     *         商品分类编号集合
     * @param navStatus
     *         导航栏显示状态
     *
     * @return
     */
    @Override
    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        PmsProductCategory category = new PmsProductCategory();
        category.setNavStatus(navStatus);
        UpdateWrapper<PmsProductCategory> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        return categoryMapper.update(category,wrapper);
    }

    /**
     * 批量修改显示状态
     *
     * @param ids
     *         商品分类编号
     * @param showStatus
     *         导航栏显示状态
     *
     * @return
     */
    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsProductCategory category = new PmsProductCategory();
        category.setShowStatus(showStatus);
        UpdateWrapper<PmsProductCategory> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        return categoryMapper.update(category,wrapper);
    }

    /**
     * 根据parentId设置level，如果没有ParentId则设置为1级
     *
     * @param category
     *         商品分类
     */
    private void setLevel(PmsProductCategory category) {
        if (category.getParentId() == 0) {
            category.setLevel(0);
        } else {
            PmsProductCategory parent = categoryMapper.selectById(category.getParentId());
            if (ObjectUtils.isEmpty(parent)) {
                category.setLevel(0);
            } else {
                category.setLevel(parent.getLevel() + 1);
            }
        }
    }

    /**
     * 添加商品分类和规格关系表
     * @param categoryId  商品分类编号
     * @param attributeIds  商品规格编号列表
     */
    private void addRelations(Long categoryId, List<Long> attributeIds) {
        List<PmsProductCategoryAttributeRelation> relations = Lists.newArrayList();
        attributeIds.stream().forEach(id -> {
            PmsProductCategoryAttributeRelation relation = new PmsProductCategoryAttributeRelation();
            relation.setProductCategoryId(categoryId);
            relation.setProductAttributeId(id);
            relations.add(relation);
        });
        relationMapper.insertAll(relations);
    }
}
