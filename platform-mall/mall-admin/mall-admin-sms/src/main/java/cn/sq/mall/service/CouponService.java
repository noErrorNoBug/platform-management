package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.CouponParam;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券管理API
 * @date 2022/7/16 15:01
 */
public interface CouponService {
    /**
     * 分页查询优惠券
     * @param name  优惠券名称
     * @param type  优惠券类型
     * @param pageNum   页码
     * @param pageSize  每页大小
     * @return
     */
    PageResponse list(String name, Integer type, Integer pageNum, Integer pageSize);

    /**
     * 查询优惠券信息
     * @param id 优惠券编号
     * @return
     */
    CouponParam getItem(Long id);

    /**
     * 添加新优惠券
     * @param param 优惠券参数
     * @return
     */
    @Transactional
    int add(CouponParam param);

    /**
     * 更新优惠券
     * @param id 优惠券编号
     * @param param 优惠券参数
     * @return
     */
    @Transactional
    int update(Long id, CouponParam param);

    /**
     * 删除指定优惠券
     * @param id 优惠券编号
     * @return
     */
    @Transactional
    int delete(Long id);
}
