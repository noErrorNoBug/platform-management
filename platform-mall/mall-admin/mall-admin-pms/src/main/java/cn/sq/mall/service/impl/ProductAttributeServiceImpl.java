package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.PmsAttriInfoDao;
import cn.sq.mall.mapper.PmsProductAttributeCategoryMapper;
import cn.sq.mall.mapper.PmsProductAttributeMapper;
import cn.sq.mall.pojo.dto.ProductAttrInfo;
import cn.sq.mall.pojo.dto.ProductAttributeParam;
import cn.sq.mall.pojo.entity.PmsProductAttribute;
import cn.sq.mall.pojo.entity.PmsProductAttributeCategory;
import cn.sq.mall.service.ProductAttributeService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品属性管理业务
 * @date 2022/7/15 00:46
 */
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    @Autowired
    private PmsProductAttributeMapper attributeMapper;
    @Autowired
    private PmsProductAttributeCategoryMapper attributeCategoryMapper;
    @Autowired
    private PmsAttriInfoDao infoDao;


    /**
     * 根据查询分类进行分页查询
     *
     * @param cid
     *         商品分类编号
     * @param type
     *         查询分类(0-属性，1-参数)
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页条数
     *
     * @return
     */
    @Override
    public PageResponse list(Long cid, Integer type, Integer pageNum, Integer pageSize) {
        Page<PmsProductAttribute> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsProductAttribute> wrapper = new QueryWrapper<>();
        wrapper.eq("product_attribute_category_id", cid)
                .eq("type", type)
                .orderByDesc("sort");
        page = attributeMapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据id查询商品属性
     *
     * @param id
     *         商品属性id
     *
     * @return
     */
    @Override
    public PmsProductAttribute getItem(Long id) {
        return attributeMapper.selectById(id);
    }

    /**
     * 根据商品分类编号查询商品属性及属性分类
     *
     * @param cid
     *         商品分类编号
     *
     * @return
     */
    @Override
    public List<ProductAttrInfo> attrInfo(Long cid) {
        return infoDao.getProductAttrInfo(cid);
    }

    /**
     * 添加商品属性
     *
     * @param param
     *         商品属性参数
     *
     * @return
     */
    @Override
    public int add(ProductAttributeParam param) {
        PmsProductAttribute attribute = new PmsProductAttribute();
        BeanUtils.copyProperties(param, attribute);
        // 需要更新商品属性分类的数量
        PmsProductAttributeCategory attributeCategory = attributeCategoryMapper.selectById(param.getProductAttributeCategoryId());
        if (attribute.getType() == 0) {
            attributeCategory.setAttributeCount(attributeCategory.getAttributeCount() + 1);
        } else {
            attributeCategory.setParamCount(attributeCategory.getParamCount() + 1);
        }
        attributeCategoryMapper.updateById(attributeCategory);
        return attributeMapper.insert(attribute);
    }

    /**
     * 修改商品属性
     *
     * @param id
     *         商品属性编号
     * @param param
     *         商品属性参数
     *
     * @return
     */
    @Override
    public int update(Long id, ProductAttributeParam param) {
        PmsProductAttribute attribute = new PmsProductAttribute();
        attribute.setId(id);
        BeanUtils.copyProperties(param, attribute);
        return attributeMapper.updateById(attribute);
    }

    /**
     * 批量删除商品属性
     *
     * @param ids
     *         商品属性编号合集
     *
     * @return
     */
    @Override
    public int deleteBatch(List<Long> ids) {
        // 所有可删除的ids下acid是相同的
        PmsProductAttribute attribute = attributeMapper.selectById(ids.get(0));
        PmsProductAttributeCategory attributeCategory = attributeCategoryMapper.selectById(attribute.getProductAttributeCategoryId());
        int count = attributeMapper.deleteBatchIds(ids);
        // 需要减去相关商品属性分类的数量
        if (attribute.getType() == 0) {
            if (attributeCategory.getAttributeCount() >= count) {
                attributeCategory.setAttributeCount(attributeCategory.getAttributeCount() - count);
            } else {
                attributeCategory.setAttributeCount(0);
            }
        } else {
            if (attributeCategory.getParamCount() >= count) {
                attributeCategory.setParamCount(attributeCategory.getParamCount() - count);
            } else {
                attributeCategory.setParamCount(0);
            }
        }
        return attributeCategoryMapper.updateById(attributeCategory);
    }
}
