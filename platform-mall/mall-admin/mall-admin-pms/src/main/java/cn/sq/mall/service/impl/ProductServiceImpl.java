package cn.sq.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.sq.mall.feign.CmsPrefrenceAreaProductRelationFeign;
import cn.sq.mall.feign.CmsSubjectProductRelationFeign;
import cn.sq.mall.mapper.*;
import cn.sq.mall.pojo.dto.ProductParam;
import cn.sq.mall.pojo.dto.ProductQueryParam;
import cn.sq.mall.pojo.dto.ProductResult;
import cn.sq.mall.pojo.entity.*;
import cn.sq.mall.service.ProductService;
import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.core.entity.PageResponse;
import cn.sq.platform.mvc.exceptions.Asserts;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品管理
 * @date 2022/7/15 17:56
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductDao productDao;
    @Autowired
    private PmsMemberPriceMapper memberPriceMapper;
    @Autowired
    private PmsProductLadderMapper ladderMapper;
    @Autowired
    private PmsProductFullReductionMapper reductionMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductAttributeValueMapper attributeValueMapper;
    @Autowired
    private PmsProductVertifyRecordMapper recordMapper;
    @Autowired
    private CmsSubjectProductRelationFeign subjectFeign;
    @Autowired
    private CmsPrefrenceAreaProductRelationFeign prefrenceFeign;



    /**
     * 分页查询商品
     *
     * @param param
     *         分页查询参数
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(ProductQueryParam param, Integer pageNum, Integer pageSize) {
        Page<PmsProduct> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_status",0);
        if (param.getPublishStatus() != null) {
            wrapper.eq("publish_status",param.getPublishStatus());
        }
        if (param.getVerifyStatus() != null) {
            wrapper.eq("verify_status",param.getVerifyStatus());
        }
        if (StringUtils.isNotBlank(param.getKeyword())) {
            wrapper.like("name",param.getKeyword());
        }
        if (StringUtils.isNotBlank(param.getProductSn())) {
            wrapper.eq("product_sn",param.getProductSn());
        }
        if (param.getBrandId() != null) {
            wrapper.eq("brand_id",param.getBrandId());
        }
        if (param.getProductCategoryId() != null) {
            wrapper.eq("product_category_id",param.getProductCategoryId());
        }
        page = productMapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据商品名称或货号模糊查询
     *
     * @param keyword
     *         关键字
     *
     * @return
     */
    @Override
    public List<PmsProduct> list(String keyword) {
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        wrapper.eq("delete_status",0)
                .like("name",keyword);
        return productMapper.selectList(wrapper);
    }

    /**
     * 根据id查询商品编辑信息
     *
     * @param id
     *         商品编号
     *
     * @return
     */
    @Override
    public ProductResult getItem(Long id) {
        return productDao.getInfo(id);
    }

    /**
     * 添加商品
     *
     * @param param
     *         商品相关信息
     *
     * @return
     */
    @Override
    public int add(ProductParam param) {
        // 商品主表
        PmsProduct product = param;
        long productId = productMapper.insert(product);
        // 会员价
        memberPriceMapper.insertAll(product.getId(),param.getMemberPriceList());
        // 阶梯价
        ladderMapper.insertAll(product.getId(),param.getProductLadderList());
        // 满减价
        reductionMapper.insertAll(product.getId(),param.getProductFullReductionList());
        // sku编码
        handleSkuStockCode(param.getSkuStockList(),product.getId());
        // sku库存
        skuStockMapper.insertAll(product.getId(),param.getSkuStockList());
        // 商品参数、规格
        attributeValueMapper.insertAll(product.getId(),param.getProductAttributeValueList());
        // 调用内容服务专题接口
        if (!CollectionUtils.isEmpty(param.getSubjectProductRelationList())) {
            BaseResponse response = subjectFeign.add(product.getId(),param.getSubjectProductRelationList());
            if (HttpStatus.SC_OK != response.getCode()) {
                Asserts.fail("网络异常，调用内容服务(cms)专题接口异常！");
            }
        }
        // 调用内容服务优选接口
        if (!CollectionUtils.isEmpty(param.getPrefrenceAreaProductRelationList())) {
            BaseResponse response = prefrenceFeign.add(product.getId(),param.getPrefrenceAreaProductRelationList());
            if (HttpStatus.SC_OK != response.getCode()) {
                Asserts.fail("网络异常，调用内容服务(cms)优选接口异常！");
            }
        }
        return 1;
    }

    /**
     * 生成sku
     * @param list sku集合
     * @param productId 产品编号
     */
    private void handleSkuStockCode(List<PmsSkuStock> list, Long productId) {
        if(CollectionUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            StringBuilder builder = new StringBuilder();
            //日期
            builder.append(format.format(new Date()));
            builder.append(String.format("%04d", productId));
            builder.append(String.format("%03d", i));
            list.get(i).setSkuCode(builder.toString());
        }
    }

    /**
     * 修改商品
     *
     * @param id
     *         商品编号
     * @param param
     *         商品相关信息
     *
     * @return
     */
    @Override
    public int update(Long id, ProductParam param) {
        // 商品信息
        productMapper.updateById(param);
        // 会员价格
        QueryWrapper<PmsMemberPrice> memberPriceQueryWrapper = new QueryWrapper<>();
        memberPriceQueryWrapper.eq("product_id",id);
        memberPriceMapper.delete(memberPriceQueryWrapper);
        memberPriceMapper.insertAll(id,param.getMemberPriceList());
        // 阶梯价格
        QueryWrapper<PmsProductLadder> ladderQueryWrapper = new QueryWrapper<>();
        ladderQueryWrapper.eq("product_id",id);
        ladderMapper.delete(ladderQueryWrapper);
        ladderMapper.insertAll(id,param.getProductLadderList());
        // 满减价格
        QueryWrapper<PmsProductFullReduction> reductionQueryWrapper = new QueryWrapper<>();
        reductionQueryWrapper.eq("product_id",id);
        reductionMapper.delete(reductionQueryWrapper);
        reductionMapper.insertAll(id,param.getProductFullReductionList());
        // 更新sku
        handleUpdateSkuStockList(id,param);
        // 参数和规格
        QueryWrapper<PmsProductAttributeValue> attributeValueQueryWrapper = new QueryWrapper<>();
        attributeValueQueryWrapper.eq("product_id",id);
        attributeValueMapper.delete(attributeValueQueryWrapper);
        attributeValueMapper.insertAll(id,param.getProductAttributeValueList());
        // 调用内容服务专题接口
        if (!CollectionUtils.isEmpty(param.getSubjectProductRelationList())) {
            BaseResponse response = subjectFeign.add(id,param.getSubjectProductRelationList());
            if (HttpStatus.SC_OK != response.getCode()) {
                Asserts.fail("网络异常，调用内容服务(cms)专题接口异常！");
            }
        }
        // 调用内容服务优选接口
        if (!CollectionUtils.isEmpty(param.getPrefrenceAreaProductRelationList())) {
            BaseResponse response = prefrenceFeign.add(id,param.getPrefrenceAreaProductRelationList());
            if (HttpStatus.SC_OK != response.getCode()) {
                Asserts.fail("网络异常，调用内容服务(cms)优选接口异常！");
            }
        }
        return 1;
    }

    private void handleUpdateSkuStockList(Long id, ProductParam param) {
        //当前的sku信息
        List<PmsSkuStock> currSkus = param.getSkuStockList();
        QueryWrapper<PmsSkuStock> skuWrapper = new QueryWrapper<>();
        //当前没有sku直接删除
        if(CollUtil.isEmpty(currSkus)){
            skuWrapper.eq("product_id",id);
            skuStockMapper.delete(skuWrapper);
            return;
        }
        // 原有sku
        List<PmsSkuStock> oldSkus = skuStockMapper.selectList(skuWrapper);
        // 此次新增的sku
        List<PmsSkuStock> insertSkus = currSkus.stream().filter(item -> ObjectUtils.isEmpty(item.getId())).collect(Collectors.toList());
        // 对原有sku的修改
        List<PmsSkuStock> updateSkus = currSkus.stream().filter(item -> ObjectUtils.isNotEmpty(item.getId())).collect(Collectors.toList());
        // 需要删除的sku
        List<Long> updateIds = updateSkus.stream().map(PmsSkuStock::getId).collect(Collectors.toList());
        List<Long> deleteIds = oldSkus.stream().filter(item -> !updateIds.contains(item.getId())).map(PmsSkuStock::getId).collect(Collectors.toList());

        //处理新增和修改的sku code
        handleSkuStockCode(insertSkus,id);
        handleSkuStockCode(updateSkus,id);

        if (!CollectionUtils.isEmpty(insertSkus)) {
            skuStockMapper.insertAll(id,insertSkus);
        }
        if (!CollectionUtils.isEmpty(updateIds)) {
            skuStockMapper.replace(updateSkus);
        }
        if (!CollectionUtils.isEmpty(deleteIds)) {
            skuStockMapper.deleteBatchIds(deleteIds);
        }
    }

    /**
     * 批量审核 toDo 获取前端审核员
     *
     * @param ids
     *         商品编号集合
     * @param verifyStatus
     *         审核标志
     * @param detail
     *         审核意见
     *
     * @return
     */
    @Override
    public int verify(List<Long> ids, Integer verifyStatus, String detail) {
        // 修改审核状态
        UpdateWrapper<PmsProduct> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        PmsProduct product = new PmsProduct();
        product.setVerifyStatus(verifyStatus);
        productMapper.update(product,wrapper);
        // 插入审核记录
        List<PmsProductVertifyRecord> records = Lists.newArrayList();
        ids.stream().forEach(productId -> {
            PmsProductVertifyRecord record = new PmsProductVertifyRecord();
            record.setProductId(productId);
            record.setCreateTime(LocalDateTime.now());
            record.setStatus(verifyStatus);
            record.setDetail(detail);
            record.setVertifyMan("mall-admin-pms/ProductServiceImpl");
            records.add(record);
        });
        return recordMapper.insertAll(records);
    }

    /**
     * 批量上下架
     *
     * @param ids
     *         商品编号集合
     * @param publishStatus
     *         上下架标志
     *
     * @return
     */
    @Override
    public int publish(List<Long> ids, Integer publishStatus) {
        UpdateWrapper<PmsProduct> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        PmsProduct product = new PmsProduct();
        product.setPublishStatus(publishStatus);
        return productMapper.update(product,wrapper);
    }

    /**
     * 批量推荐
     *
     * @param ids
     *         商品编号集合
     * @param recommendStatus
     *         推荐集合
     *
     * @return
     */
    @Override
    public int recommend(List<Long> ids, Integer recommendStatus) {
        UpdateWrapper<PmsProduct> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        PmsProduct product = new PmsProduct();
        product.setRecommandStatus(recommendStatus);
        return productMapper.update(product,wrapper);
    }

    /**
     * 批量设置新品
     *
     * @param ids
     *         商品编号集合
     * @param newStatus
     *         新品标志
     *
     * @return
     */
    @Override
    public int newest(List<Long> ids, Integer newStatus) {
        UpdateWrapper<PmsProduct> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        PmsProduct product = new PmsProduct();
        product.setNewStatus(newStatus);
        return productMapper.update(product,wrapper);
    }

    /**
     * 批量逻辑删除
     *
     * @param ids
     *         商品编号集合
     * @param deleteStatus
     *         删除标志
     *
     * @return
     */
    @Override
    public int delete(List<Long> ids, Integer deleteStatus) {
        UpdateWrapper<PmsProduct> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        PmsProduct product = new PmsProduct();
        product.setDeleteStatus(deleteStatus);
        return productMapper.update(product,wrapper);
    }
}
