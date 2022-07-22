package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.OmsOrderReturnReasonMapper;
import cn.sq.mall.pojo.entity.OmsOrderReturnReason;
import cn.sq.mall.service.OrderReturnReasonService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单退单原因管理接口
 * @date 2022/7/16 14:37
 */
@Service
public class OrderReturnReasonServiceImpl implements OrderReturnReasonService {
    @Autowired
    private OmsOrderReturnReasonMapper mapper;
    /**
     * 分页查询退货原因
     *
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(Integer pageNum, Integer pageSize) {
        Page<OmsOrderReturnReason> page = new Page<>();
        page.setPages(pageNum);
        page.setPages(pageSize);
        QueryWrapper<OmsOrderReturnReason> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        page= mapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据id查询商品退货原因
     *
     * @param id
     *         退货原因编号
     *
     * @return
     */
    @Override
    public OmsOrderReturnReason getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 添加退货原因
     *
     * @param param
     *         退货原因
     *
     * @return
     */
    @Override
    public int add(OmsOrderReturnReason param) {
        param.setCreateTime(LocalDateTime.now());
        return mapper.insert(param);
    }

    /**
     * 修改退货原因
     *
     * @param id
     *         退货原因编号
     * @param param
     *         退货原因参数
     *
     * @return
     */
    @Override
    public int update(Long id, OmsOrderReturnReason param) {
        param.setId(id);
        return mapper.updateById(param);
    }

    /**
     * 批量删除退货原因
     *
     * @param ids
     *         退货原因编号集合
     *
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        return mapper.deleteBatchIds(ids);
    }

    /**
     * 修改退货原因启用状态
     *
     * @param ids
     *         退货原因编号集合
     * @param status
     *         启用状态
     *
     * @return
     */
    @Override
    public int updateStatus(List<Long> ids, Integer status) {
        UpdateWrapper<OmsOrderReturnReason> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        OmsOrderReturnReason reason = new OmsOrderReturnReason();
        reason.setStatus(status);
        return mapper.update(reason,wrapper);
    }
}
