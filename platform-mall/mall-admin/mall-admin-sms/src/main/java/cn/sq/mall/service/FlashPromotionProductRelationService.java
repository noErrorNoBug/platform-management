package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.SmsFlashPromotionProductRelation;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购和商品关系管理API
 * @date 2022/7/16 15:01
 */
public interface FlashPromotionProductRelationService {
    /**
     * 分页查询不同场次限时购和商品关系
     * @param flashPromotionId 限时购编号
     * @param flashPromotionSessionId 限时购场次编号
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageNum, Integer pageSize);

    /**
     * 根据编号查询限时购和商品关系信息
     * @param id 关系编号
     * @return
     */
    SmsFlashPromotionProductRelation getItem(Long id);

    /**
     * 修改限时购和商品关系
     * @param id 编号
     * @param param 参数
     * @return
     */
    int update(Long id, SmsFlashPromotionProductRelation param);

    /**
     * 删除限时购和商品关系
     * @param id 编号
     * @return
     */
    int delete(Long id);

    /**
     * 批量添加商品关联
     * @param relationLists 关联关系列表
     * @return
     */
    int add(List<SmsFlashPromotionProductRelation> relationLists);

    /**
     * 查询符合条件的数量
     * @param flashPromotionId 限时购编号
     * @param flashPromotionSessionId 限时购场次编号
     * @return
     */
    long getCount(Long flashPromotionId, Long flashPromotionSessionId);
}
