package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.OmsOrderSettingMapper;
import cn.sq.mall.pojo.entity.OmsOrderSetting;
import cn.sq.mall.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单设置管理接口
 * @date 2022/7/16 14:37
 */
@Service
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    private OmsOrderSettingMapper mapper;

    /**
     * 根据编号查找订单设置
     *
     * @param id
     *         订单设置编号
     *
     * @return
     */
    @Override
    public OmsOrderSetting getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 修改订单设置
     *
     * @param id
     *         订单设置编号
     * @param param
     *         订单设置
     *
     * @return
     */
    @Override
    public int update(Long id, OmsOrderSetting param) {
        param.setId(id);
        return mapper.updateById(param);
    }
}
