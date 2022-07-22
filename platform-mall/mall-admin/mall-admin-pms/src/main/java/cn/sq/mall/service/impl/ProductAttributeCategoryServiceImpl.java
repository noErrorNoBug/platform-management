package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.PmsProductAttributeCategoryDao;
import cn.sq.mall.mapper.PmsProductAttributeCategoryMapper;
import cn.sq.mall.pojo.dto.ProductAttributeCategoryItem;
import cn.sq.mall.pojo.entity.PmsProductAttributeCategory;
import cn.sq.mall.service.ProductAttributeCategoryService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品属性分类管理
 * @date 2022/7/15 11:06
 */
@Service
public class ProductAttributeCategoryServiceImpl implements ProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper mapper;
    @Autowired
    private PmsProductAttributeCategoryDao dao;


    /**
     * 分页获取属性分类
     *
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(Integer pageNum, Integer pageSize) {
        Page<PmsProductAttributeCategory> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsProductAttributeCategory> wrapper = new QueryWrapper<>();
        page = mapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 获取对应属性集合
     *
     * @return
     */
    @Override
    public List<ProductAttributeCategoryItem> attrList() {
        return dao.getListWithAttr();
    }

    /**
     * 根据编号获取属性分类
     *
     * @param id
     *         属性分类编号
     *
     * @return
     */
    @Override
    public PmsProductAttributeCategory getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 添加属性分类
     *
     * @param name
     *         属性分类名称
     *
     * @return
     */
    @Override
    public int add(String name) {
        PmsProductAttributeCategory attributeCategory = new PmsProductAttributeCategory();
        attributeCategory.setName(name);
        return mapper.insert(attributeCategory);
    }

    /**
     * 更新属性分类
     *
     * @param id
     *         属性分类编号
     * @param name
     *         属性分类名称
     *
     * @return
     */
    @Override
    public int update(Long id, String name) {
        PmsProductAttributeCategory attributeCategory = new PmsProductAttributeCategory();
        attributeCategory.setName(name);
        attributeCategory.setId(id);
        return mapper.updateById(attributeCategory);
    }

    /**
     * 删除属性分类
     *
     * @param id
     *         属性分类编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return mapper.deleteById(id);
    }
}
