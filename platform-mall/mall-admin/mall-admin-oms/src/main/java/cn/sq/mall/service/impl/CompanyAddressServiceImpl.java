package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.OmsCompanyAddressMapper;
import cn.sq.mall.pojo.entity.OmsCompanyAddress;
import cn.sq.mall.service.CompanyAddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 收货地址管理接口
 * @date 2022/7/16 14:37
 */
@Service
public class CompanyAddressServiceImpl implements CompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper mapper;

    /**
     * 获取所有收货地址
     *
     * @return
     */
    @Override
    public List<OmsCompanyAddress> getAll() {
        QueryWrapper<OmsCompanyAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("1","1");
        return mapper.selectList(wrapper);
    }
}
