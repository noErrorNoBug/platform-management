package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.SmsFlashPromotion;
import cn.sq.platform.core.entity.PageResponse;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购活动管理API
 * @date 2022/7/16 15:02
 */
public interface FlashPromotionService {
    /**
     * 分页查询限时购活动列表
     * @param keyword 关键字
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return
     */
    PageResponse list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 查询限时购详情
     * @param id 限时购编号
     * @return
     */
    SmsFlashPromotion getItem(Long id);

    /**
     * 添加限时购活动
     * @param param 参数
     * @return
     */
    int add(SmsFlashPromotion param);

    /**
     * 修改限时购活动
     * @param id 限时购编号
     * @param param 参数
     * @return
     */
    int update(Long id, SmsFlashPromotion param);

    /**
     * 删除限时购活动
     * @param id 限时购编号
     * @return
     */
    int delete(Long id);

    /**
     * 修改上下线状态
     * @param id 编号
     * @param status 状态
     * @return
     */
    int updateStatus(Long id, Integer status);
}
