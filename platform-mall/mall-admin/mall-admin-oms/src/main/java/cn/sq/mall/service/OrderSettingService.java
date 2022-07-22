package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.OmsOrderSetting;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单设置管理接口
 * @date 2022/7/16 14:36
 */
public interface OrderSettingService {
    /**
     * 根据编号查找订单设置
     * @param id 订单设置编号
     * @return
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改订单设置
     * @param id 订单设置编号
     * @param param 订单设置
     * @return
     */
    int update(Long id, OmsOrderSetting param);
}
