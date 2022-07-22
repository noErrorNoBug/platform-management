package cn.sq.mall.service;

import cn.sq.mall.pojo.CmsPrefrenceAreaProductRelation;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优选专区和商品关系管理
 * @date 2022/7/20 00:03
 */
public interface PrefrenceAreaProductRelationService {
    /**
     * 批量添加优选专区和商品关系
     * @param params 关系参数
     * @return
     */
    int add(Long productId,List<CmsPrefrenceAreaProductRelation> params);
}
