package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.OrderReturnApplyResult;
import cn.sq.mall.pojo.dto.ReturnApplyQueryParam;
import cn.sq.mall.pojo.dto.ReturnUpdateStatusParam;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单退单管理接口
 * @date 2022/7/16 14:35
 */
public interface OrderReturnApplyService {
    /**
     * 分页查询退货申请
     * @param param 查询参数
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @return
     */
    PageResponse list(ReturnApplyQueryParam param, Integer pageNum, Integer pageSize);

    /**
     * 根据编号查询退货申请详情信息
     * @param id 退货编号
     * @return
     */
    OrderReturnApplyResult getItem(Long id);

    /**
     * 修改退货申请状态
     * @param id 退货编号
     * @param param 退货状态参数
     * @return
     */
    int update(Long id, ReturnUpdateStatusParam param);

    /**
     * 批量删除退货申请
     * @param ids 退货编号集合
     * @return
     */
    int delete(List<Long> ids);
}
