package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.SmsCouponHistoryMapper;
import cn.sq.mall.pojo.entity.SmsCouponHistory;
import cn.sq.mall.service.CouponHistoryService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券领取记录管理API
 * @date 2022/7/16 15:03
 */
@Service
public class CouponHistoryServiceImpl implements CouponHistoryService {
    @Autowired
    private SmsCouponHistoryMapper mapper;

    /**
     * 分页查询优惠券领取记录
     *
     * @param couponId
     *         优惠卷编号
     * @param useStatus
     *         使用状态
     * @param orderSn
     *         订单编码
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(Long couponId, Integer useStatus, String orderSn, Integer pageNum, Integer pageSize) {
        Page<SmsCouponHistory> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<SmsCouponHistory> wrapper = new QueryWrapper<>();
        if (ObjectUtils.isNotEmpty(couponId)) {
            wrapper.eq("coupon_id",couponId);
        }
        if (ObjectUtils.isNotEmpty(useStatus)) {
            wrapper.eq("use_status",useStatus);
        }
        if (StringUtils.isNotBlank(orderSn)) {
            wrapper.eq("order_sn",orderSn);
        }
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }
}
