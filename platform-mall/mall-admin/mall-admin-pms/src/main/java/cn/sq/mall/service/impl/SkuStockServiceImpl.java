package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.PmsSkuStockMapper;
import cn.sq.mall.pojo.entity.PmsSkuStock;
import cn.sq.mall.service.SkuStockService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description sku库存管理
 * @date 2022/7/15 17:33
 */
@Service
public class SkuStockServiceImpl implements SkuStockService {

    @Autowired
    private PmsSkuStockMapper mapper;

    /**
     * 根据商品ID及sku编码模糊搜索sku库存
     *
     * @param pid
     *         商品id
     * @param keyword
     *         sku编码
     *
     * @return
     */
    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        QueryWrapper<PmsSkuStock> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",pid)
                .like("sku_code",keyword);
        return mapper.selectList(wrapper);
    }

    /**
     * 批量更新sku库存信息
     *
     * @param list
     *         sku列表
     *
     * @return
     */
    @Override
    public int update(List<PmsSkuStock> list) {
        return mapper.replace(list);
    }
}
