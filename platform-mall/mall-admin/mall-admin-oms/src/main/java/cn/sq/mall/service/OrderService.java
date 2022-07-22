package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.*;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单管理接口
 * @date 2022/7/16 14:35
 */
public interface OrderService {
    /**
     * 分页查询订单
     * @param param 查询条件
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(OrderQueryParam param, Integer pageNum, Integer pageSize);

    /**
     * 获取订单详情
     * @param id 订单编号
     * @return
     */
    List<OrderDetials> getItem(Long id);

    /**
     * 修改收货人信息
     * @param params 收货人参数
     * @return
     */
    @Transactional
    int receiver(ReceiverParam params);

    /**
     * 修改费用信息
     * @param params 费用参数
     * @return
     */
    @Transactional
    int fee(FeeParam params);

    /**
     * 备注订单
     * @param id 订单编号
     * @param note 备注
     * @param status 订单状态
     * @return
     */
    @Transactional
    int note(Long id, String note, Integer status);

    /**
     * 批量发货
     * @param params 发货参数集合
     * @return
     */
    @Transactional
    int delivery(List<OrderDeliveryParam> params);

    /**
     * 批量关闭订单
     * @param ids 订单编号集合
     * @param note 备注
     * @return
     */
    @Transactional
    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     * @param ids 订单参数集合
     * @return
     */
    int delete(List<Long> ids);
}
