package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.CouponDao;
import cn.sq.mall.mapper.SmsCouponMapper;
import cn.sq.mall.mapper.SmsCouponProductCategoryRelationMapper;
import cn.sq.mall.mapper.SmsCouponProductRelationMapper;
import cn.sq.mall.pojo.dto.CouponParam;
import cn.sq.mall.pojo.entity.SmsCoupon;
import cn.sq.mall.pojo.entity.SmsCouponProductCategoryRelation;
import cn.sq.mall.pojo.entity.SmsCouponProductRelation;
import cn.sq.mall.service.CouponService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券管理API
 * @date 2022/7/16 15:03
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private CouponDao couponDao;
    @Autowired
    private SmsCouponProductRelationMapper productRelationMapper;
    @Autowired
    private SmsCouponProductCategoryRelationMapper  categoryRelationMapper;

    /**
     * 分页查询优惠券
     *
     * @param name
     *         优惠券名称
     * @param type
     *         优惠券类型
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(String name, Integer type, Integer pageNum, Integer pageSize) {
        Page<SmsCoupon> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<SmsCoupon> wrapper = new QueryWrapper<>();
        if (ObjectUtils.isNotEmpty(type)) {
            wrapper.eq("type",type);
        }
        if (StringUtils.isNotBlank(name)) {
            wrapper.like("name",name);
        }
        page = couponMapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 查询优惠券信息
     *
     * @param id
     *         优惠券编号
     *
     * @return
     */
    @Override
    public CouponParam getItem(Long id) {
        return couponDao.getItem(id);
    }

    /**
     * 添加新优惠券
     *
     * @param param
     *         优惠券参数
     *
     * @return
     */
    @Override
    public int add(CouponParam param) {
        param.setCount(param.getPublishCount());
        param.setUseCount(0);
        param.setReceiveCount(0);
        int insert = couponMapper.insert(param);
        if (param.getUseType().equals(1)){
            List<SmsCouponProductCategoryRelation> relations = param.getProductCategoryRelationList();
            for (SmsCouponProductCategoryRelation relation : relations) {
                relation.setCouponId(param.getId());
            }
            categoryRelationMapper.insertAll(relations);
        }
        if (param.getUseType().equals(2)){
            List<SmsCouponProductRelation> relations = param.getProductRelationList();
            for (SmsCouponProductRelation relation: relations) {
                relation.setCouponId(param.getId());
            }
            productRelationMapper.insertAll(relations);
        }
        return insert;
    }

    /**
     * 更新优惠券
     *
     * @param id
     *         优惠券编号
     * @param param
     *         优惠券参数
     *
     * @return
     */
    @Override
    public int update(Long id, CouponParam param) {
        param.setId(id);
        if (param.getUseType().equals(1)){
            QueryWrapper<SmsCouponProductCategoryRelation>  wrapper= new QueryWrapper<>();
            wrapper.eq("coupon_id",id);
            categoryRelationMapper.delete(wrapper);
            List<SmsCouponProductCategoryRelation> relations = param.getProductCategoryRelationList();
            for (SmsCouponProductCategoryRelation relation : relations) {
                relation.setCouponId(id);
            }
            categoryRelationMapper.insertAll(relations);
        }
        if (param.getUseType().equals(2)){
            QueryWrapper<SmsCouponProductRelation>  wrapper= new QueryWrapper<>();
            wrapper.eq("coupon_id",id);
            productRelationMapper.delete(wrapper);
            List<SmsCouponProductRelation> relations = param.getProductRelationList();
            for (SmsCouponProductRelation relation: relations) {
                relation.setCouponId(id);
            }
            productRelationMapper.insertAll(relations);
        }
        return couponMapper.updateById(param);
    }

    /**
     * 删除指定优惠券
     *
     * @param id
     *         优惠券编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        couponMapper.deleteById(id);
        QueryWrapper<SmsCouponProductRelation> productRelationWrapper = new QueryWrapper<>();
        productRelationWrapper.eq("coupon_id",id);
        productRelationMapper.delete(productRelationWrapper);
        QueryWrapper<SmsCouponProductCategoryRelation> categoryRelationWrapper = new QueryWrapper<>();
        categoryRelationWrapper.eq("coupon_id",id);
        categoryRelationMapper.delete(categoryRelationWrapper);
        return 1;
    }
}
