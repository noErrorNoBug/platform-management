package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.OmsCompanyAddress;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 收货地址管理接口
 * @date 2022/7/16 14:35
 */
public interface CompanyAddressService {
    /**
     * 获取所有收货地址
     * @return
     */
    List<OmsCompanyAddress> getAll();
}
