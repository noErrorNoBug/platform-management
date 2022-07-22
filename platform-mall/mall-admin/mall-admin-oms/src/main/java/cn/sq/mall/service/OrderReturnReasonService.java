package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.OmsOrderReturnReason;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单退单原因管理接口
 * @date 2022/7/16 14:36
 */
public interface OrderReturnReasonService {

    /**
     * 分页查询退货原因
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(Integer pageNum, Integer pageSize);

    /**
     * 根据id查询商品退货原因
     * @param id 退货原因编号
     * @return
     */
    OmsOrderReturnReason getItem(Long id);

    /**
     * 添加退货原因
     * @param param 退货原因
     * @return
     */
    int add(OmsOrderReturnReason param);

    /**
     * 修改退货原因
     * @param id 退货原因编号
     * @param param 退货原因参数
     * @return
     */
    int update(Long id, OmsOrderReturnReason param);

    /**
     * 批量删除退货原因
     * @param ids 退货原因编号集合
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 修改退货原因启用状态
     * @param ids 退货原因编号集合
     * @param status 启用状态
     * @return
     */
    int updateStatus(List<Long> ids, Integer status);
}
