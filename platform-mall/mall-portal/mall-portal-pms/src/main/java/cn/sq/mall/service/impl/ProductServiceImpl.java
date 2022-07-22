package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.*;
import cn.sq.mall.pojo.dto.PortalProductDetail;
import cn.sq.mall.pojo.dto.ProductCategoryNode;
import cn.sq.mall.pojo.entity.*;
import cn.sq.mall.service.ProductService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品管理
 * @date 2022/7/16 15:38
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductLadderMapper productLadderMapper;
    @Autowired
    private PmsProductFullReductionMapper productFullReductionMapper;


    /**
     * 综合搜索、筛选、排序
     *
     * @param keyword
     *         关键字
     * @param brandId
     *         品牌编号
     * @param productCategoryId
     *         商品分类编号
     * @param sort
     *         排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse search(String keyword, Long brandId, Long productCategoryId, Integer sort, Integer pageNum, Integer pageSize) {
        Page<PmsProduct> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("name",keyword);
        }
        if (ObjectUtils.isNotEmpty(brandId)) {
            wrapper.eq("brand_id", brandId);
        }
        if (ObjectUtils.isNotEmpty(productCategoryId)) {
            wrapper.eq("product_category_id", productCategoryId);
        }
        switch (sort){
            case 1:
                wrapper.orderByDesc("id");
                break;
            case 2:
                wrapper.orderByDesc("sale");
                break;
            case 3:
                wrapper.orderByAsc("price");
                break;
            case 4:
                wrapper.orderByDesc("price");
                break;
            default:
                wrapper.orderByDesc("sort");
        }
        page = productMapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 以树形结构获取所有商品分类
     *
     * @return
     */
    @Override
    public List<ProductCategoryNode> tree() {
        QueryWrapper<PmsProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("1","1");
        List<PmsProductCategory> allList = productCategoryMapper.selectList(wrapper);
        List<ProductCategoryNode> result = allList.stream().filter(item -> item.getParentId().equals(0L))
                .map(item -> covert(item, allList))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 初始对象转化为节点对象
     */
    private ProductCategoryNode covert(PmsProductCategory item, List<PmsProductCategory> allList) {
        ProductCategoryNode node = new ProductCategoryNode();
        BeanUtils.copyProperties(item, node);
        List<ProductCategoryNode> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    /**
     * 获取前台商品详情
     *
     * @param id
     *         商品编号
     *
     * @return
     */
    @Override
    public PortalProductDetail getItem(Long id) {
        PortalProductDetail result = new PortalProductDetail();
        // 商品
        PmsProduct product = productMapper.selectById(id);
        result.setProduct(product);
        // 品牌
        PmsBrand brand = brandMapper.selectById(product.getBrandId());
        result.setBrand(brand);
        // 属性列表
        QueryWrapper<PmsProductAttribute> attributeWrapper = new QueryWrapper<>();
        attributeWrapper.eq("product_attribute_category_id",product.getProductAttributeCategoryId());
        List<PmsProductAttribute> attributes = productAttributeMapper.selectList(attributeWrapper);
        result.setProductAttributeList(attributes);
        // 属性值列表
        if (!CollectionUtils.isEmpty(attributes)) {
            List<Long> attributeIds = attributes.stream().map(PmsProductAttribute::getId).collect(Collectors.toList());
            QueryWrapper<PmsProductAttributeValue> valueWrapper = new QueryWrapper<>();
            valueWrapper.eq("product_id",id)
                    .in("product_attribute_id",attributeIds);
            List<PmsProductAttributeValue> values = productAttributeValueMapper.selectList(valueWrapper);
            result.setProductAttributeValueList(values);
        }
        // sku库存
        QueryWrapper<PmsSkuStock> skuWrapper = new QueryWrapper<>();
        skuWrapper.eq("product_id",id);
        List<PmsSkuStock> skus = skuStockMapper.selectList(skuWrapper);
        result.setSkuStockList(skus);
        // 阶梯价格
        if (product.getPromotionType() == 3) {
            QueryWrapper<PmsProductLadder> ladderWrapper = new QueryWrapper<>();
            ladderWrapper.eq("product_id",id);
            List<PmsProductLadder> ladders = productLadderMapper.selectList(ladderWrapper);
            result.setProductLadderList(ladders);
        }
        // 满减价格
        if (product.getPromotionType() == 4) {
            QueryWrapper<PmsProductFullReduction> fullWrapper = new QueryWrapper<>();
            fullWrapper.eq("product_id",id);
            List<PmsProductFullReduction> fullReductions = productFullReductionMapper.selectList(fullWrapper);
            result.setProductFullReductionList(fullReductions);
        }
        // 可用优惠券 TODO 调用远程优惠券服务
        // List<SmsCoupon> couponList =
        // result.setCouponList(couponList);
        return result;
    }
}
