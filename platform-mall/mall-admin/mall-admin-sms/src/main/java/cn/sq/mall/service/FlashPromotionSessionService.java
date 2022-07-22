package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.FlashPromotionSessionDetail;
import cn.sq.mall.pojo.entity.SmsFlashPromotionSession;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购场次管理API
 * @date 2022/7/16 15:02
 */
public interface FlashPromotionSessionService {
    /**
     * 分页查询全部场次
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(Integer pageNum, Integer pageSize);

    /**
     * 查询所有可用场次和数量
     * @param flashPromotionId 限时购id
     * @return
     */
    List<FlashPromotionSessionDetail> available(Long flashPromotionId);

    /**
     * 根据编号查询场次信息
     * @param id 编号
     * @return
     */
    SmsFlashPromotionSession getItem(Long id);

    /**
     * 添加限时购场次
     * @param param 场次
     * @return
     */
    int add(SmsFlashPromotionSession param);

    /**
     * 修改限时购场次
     * @param id 编号
     * @param param 场次
     * @return
     */
    int update(Long id, SmsFlashPromotionSession param);

    /**
     * 删除场次
     * @param id 编号
     * @return
     */
    int delete(Long id);

    /**
     * 修改可用状态
     * @param id 编号
     * @param status 可用状态
     * @return
     */
    int updateStatus(Long id, Integer status);
}
