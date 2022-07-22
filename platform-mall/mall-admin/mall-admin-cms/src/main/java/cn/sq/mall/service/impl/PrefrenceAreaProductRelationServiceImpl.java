package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.CmsPrefrenceAreaProductRelationMapper;
import cn.sq.mall.pojo.CmsPrefrenceAreaProductRelation;
import cn.sq.mall.service.PrefrenceAreaProductRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优选专区和商品关系管理
 * @date 2022/7/20 00:05
 */
@Service
public class PrefrenceAreaProductRelationServiceImpl implements PrefrenceAreaProductRelationService {
    @Autowired
    private CmsPrefrenceAreaProductRelationMapper mapper;
    /**
     * 批量添加优选专区和商品关系
     *
     * @param params
     *         关系参数
     *
     * @return
     */
    @Override
    public int add(Long productId,List<CmsPrefrenceAreaProductRelation> params) {
        QueryWrapper<CmsPrefrenceAreaProductRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",productId);
        mapper.delete(wrapper);
        return mapper.insertAll(params);
    }
}
