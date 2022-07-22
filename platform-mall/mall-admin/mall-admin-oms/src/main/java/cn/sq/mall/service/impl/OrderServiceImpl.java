package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.OmsOrderMapper;
import cn.sq.mall.mapper.OmsOrderOperateHistoryMapper;
import cn.sq.mall.mapper.OrderDao;
import cn.sq.mall.pojo.dto.*;
import cn.sq.mall.pojo.entity.OmsOrder;
import cn.sq.mall.pojo.entity.OmsOrderOperateHistory;
import cn.sq.mall.service.OrderService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单管理接口
 * @date 2022/7/16 14:37
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OmsOrderOperateHistoryMapper historyMapper;


    /**
     * 分页查询订单
     *
     * @param param
     *         查询条件
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(OrderQueryParam param, Integer pageNum, Integer pageSize) {
        Page<OmsOrder> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<OmsOrder> wrapper = new QueryWrapper<>();
        if (ObjectUtils.isNotEmpty(page)) {
            if (ObjectUtils.isNotEmpty(param.getOrderSn())) {
                wrapper.eq("order_sn",param.getOrderSn());
            }
            if (ObjectUtils.isNotEmpty(param.getStatus())) {
                wrapper.eq("status",param.getStatus());
            }
            if (ObjectUtils.isNotEmpty(param.getOrderType())) {
                wrapper.eq("order_type",param.getOrderType());
            }
            if (ObjectUtils.isNotEmpty(param.getSourceType())) {
                wrapper.eq("source_type",param.getSourceType());
            }
            if (StringUtils.isNotBlank(param.getCreateTime())) {
                wrapper.ge("create_time",LocalDateTime.parse(param.getCreateTime()+" 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                wrapper.le("create_time",LocalDateTime.parse(param.getCreateTime()+" 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
            if (StringUtils.isNotBlank(param.getReceiverKeyword())) {
                wrapper.and(omsOrderQueryWrapper -> omsOrderQueryWrapper.like("receiver_name",param.getReceiverKeyword()).or().like("receiver_phone",param.getReceiverKeyword()));
            }
        }
        page = orderMapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 获取订单详情
     *
     * @param id
     *         订单编号
     *
     * @return
     */
    @Override
    public List<OrderDetials> getItem(Long id) {
        return orderDao.getItem(id);
    }

    /**
     * 修改收货人信息
     *
     * @param params
     *         收货人参数
     *
     * @return
     */
    @Override
    public int receiver(ReceiverParam params) {
        OmsOrder order = new OmsOrder();
        order.setId(params.getOrderId());
        order.setReceiverName(params.getReceiverName());
        order.setReceiverPhone(params.getReceiverPhone());
        order.setReceiverPostCode(params.getReceiverPostCode());
        order.setReceiverDetailAddress(params.getReceiverDetailAddress());
        order.setReceiverProvince(params.getReceiverProvince());
        order.setReceiverCity(params.getReceiverCity());
        order.setReceiverRegion(params.getReceiverRegion());
        order.setModifyTime(LocalDateTime.now());
        orderMapper.updateById(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(params.getOrderId());
        history.setCreateTime(LocalDateTime.now());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(params.getStatus());
        history.setNote("修改收货人信息");
        return historyMapper.insert(history);
    }

    /**
     * 修改费用信息
     *
     * @param params
     *         费用参数
     *
     * @return
     */
    @Override
    public int fee(FeeParam params) {
        OmsOrder order = new OmsOrder();
        order.setId(params.getOrderId());
        order.setFreightAmount(params.getFreightAmount());
        order.setDiscountAmount(params.getDiscountAmount());
        order.setModifyTime(LocalDateTime.now());
        orderMapper.updateById(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(params.getOrderId());
        history.setCreateTime(LocalDateTime.now());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(params.getStatus());
        history.setNote("修改费用信息");
        return historyMapper.insert(history);
    }

    /**
     * 备注订单
     *
     * @param id
     *         订单编号
     * @param note
     *         备注
     * @param status
     *         订单状态
     *
     * @return
     */
    @Override
    public int note(Long id, String note, Integer status) {
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setStatus(status);
        orderMapper.updateById(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(LocalDateTime.now());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息："+note);
        return historyMapper.insert(history);
    }

    /**
     * 批量发货
     *
     * @param params
     *         发货参数集合
     *
     * @return
     */
    @Override
    public int delivery(List<OrderDeliveryParam> params) {
        orderDao.delivery(params);
        List<OmsOrderOperateHistory> histories = params.stream().map(param -> {
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(param.getOrderId());
            history.setCreateTime(LocalDateTime.now());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(2);
            history.setNote("完成发货");
            return history;
        }).collect(Collectors.toList());
        return historyMapper.insertAll(histories);
    }

    /**
     * 批量关闭订单
     *
     * @param ids
     *         订单编号集合
     * @param note
     *         备注
     *
     * @return
     */
    @Override
    public int close(List<Long> ids, String note) {
        OmsOrder order = new OmsOrder();
        order.setStatus(4);
        UpdateWrapper<OmsOrder> wrapper = new UpdateWrapper<>();
        wrapper.eq("delete_status","0")
                .in("id",ids);
        orderMapper.update(order,wrapper);
        List<OmsOrderOperateHistory> histories = ids.stream().map(id -> {
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(id);
            history.setCreateTime(LocalDateTime.now());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:" + note);
            return history;
        }).collect(Collectors.toList());
        return historyMapper.insertAll(histories);
    }

    /**
     * 批量删除订单
     *
     * @param ids
     *         订单参数集合
     *
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        OmsOrder order = new OmsOrder();
        order.setDeleteStatus(1);
        UpdateWrapper<OmsOrder> wrapper = new UpdateWrapper<>();
        wrapper.eq("delete_status","0")
                .in("id",ids);
        return orderMapper.update(order,wrapper);
    }
}
