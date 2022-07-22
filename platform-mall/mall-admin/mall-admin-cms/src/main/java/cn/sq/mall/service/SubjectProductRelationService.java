package cn.sq.mall.service;

import cn.sq.mall.pojo.CmsSubjectProductRelation;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 专题商品关系管理
 * @date 2022/7/20 00:16
 */
public interface SubjectProductRelationService {
    /**
     * 批量插入专题和商品关系
     * @param params 关系参数
     * @return
     */
    int add(Long productId,List<CmsSubjectProductRelation> params);
}
