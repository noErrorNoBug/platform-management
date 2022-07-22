package cn.sq.mall.service;


import cn.sq.platform.core.entity.PageResponse;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券领取记录管理API
 * @date 2022/7/16 15:01
 */
public interface CouponHistoryService {
    /**
     * 分页查询优惠券领取记录
     * @param couponId 优惠卷编号
     * @param useStatus 使用状态
     * @param orderSn 订单编码
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(Long couponId, Integer useStatus, String orderSn, Integer pageNum, Integer pageSize);
}
