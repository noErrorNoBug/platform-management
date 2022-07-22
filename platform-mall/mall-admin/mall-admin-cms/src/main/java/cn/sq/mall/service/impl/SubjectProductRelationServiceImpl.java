package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.CmsSubjectProductRelationMapper;
import cn.sq.mall.pojo.CmsSubjectProductRelation;
import cn.sq.mall.service.SubjectProductRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 专题商品关系管理
 * @date 2022/7/20 00:20
 */
@Service
public class SubjectProductRelationServiceImpl implements SubjectProductRelationService {
    @Autowired
    private CmsSubjectProductRelationMapper mapper;

    /**
     * 批量插入专题和商品关系
     *
     * @param params
     *         关系参数
     *
     * @return
     */
    @Override
    public int add(Long productId,List<CmsSubjectProductRelation> params) {
        QueryWrapper<CmsSubjectProductRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",productId);
        mapper.delete(wrapper);
        return mapper.insertAll(params);
    }
}
