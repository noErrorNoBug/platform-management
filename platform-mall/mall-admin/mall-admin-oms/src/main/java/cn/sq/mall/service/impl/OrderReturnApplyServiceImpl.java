package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.OmsOrderReturnApplyMapper;
import cn.sq.mall.mapper.OrderReturnApplyDao;
import cn.sq.mall.pojo.dto.OrderReturnApplyResult;
import cn.sq.mall.pojo.dto.ReturnApplyQueryParam;
import cn.sq.mall.pojo.dto.ReturnUpdateStatusParam;
import cn.sq.mall.pojo.entity.OmsOrderReturnApply;
import cn.sq.mall.service.OrderReturnApplyService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 订单退单管理接口
 * @date 2022/7/16 14:37
 */
@Service
public class OrderReturnApplyServiceImpl implements OrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyMapper mapper;
    @Autowired
    private OrderReturnApplyDao dao;

    /**
     * 分页查询退货申请
     *
     * @param param
     *         查询参数
     * @param pageNum
     *         页数
     * @param pageSize
     *         每页数量
     *
     * @return
     */
    @Override
    public PageResponse list(ReturnApplyQueryParam param, Integer pageNum, Integer pageSize) {
        Page<OmsOrderReturnApply> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<OmsOrderReturnApply> wrapper = new QueryWrapper<>();
        if (ObjectUtils.isNotEmpty(param.getId())) {
            wrapper.eq("id", param.getId());
        }
        if (ObjectUtils.isNotEmpty(param.getStatus())) {
            wrapper.eq("status", param.getStatus());
        }
        if (ObjectUtils.isNotEmpty(param.getHandleMan())) {
            wrapper.eq("handle_man", param.getHandleMan());
        }
        if (ObjectUtils.isNotEmpty(param.getCreateTime())) {
            wrapper.likeRight("create_time", param.getCreateTime());
        }
        if (ObjectUtils.isNotEmpty(param.getHandleTime())) {
            wrapper.likeRight("handle_time", param.getHandleTime());
        }
        if (ObjectUtils.isNotEmpty(param.getReceiverKeyword())) {
            wrapper.and(wrapper1 -> wrapper1.like("return_name", param.getReceiverKeyword()).or().like("return_name", param.getReceiverKeyword()));
        }
        page = mapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据编号查询退货申请详情信息
     *
     * @param id
     *         退货编号
     *
     * @return
     */
    @Override
    public OrderReturnApplyResult getItem(Long id) {
        return dao.getItem(id);
    }

    /**
     * 修改退货申请状态
     *
     * @param id
     *         退货编号
     * @param param
     *         退货状态参数
     *
     * @return
     */
    @Override
    public int update(Long id, ReturnUpdateStatusParam param) {
        OmsOrderReturnApply apply = new OmsOrderReturnApply();
        apply.setId(id);
        switch (param.getStatus()) {
            case 1:
                apply.setId(id);
                apply.setReturnAmount(param.getReturnAmount());
                apply.setCompanyAddressId(param.getCompanyAddressId());
                apply.setHandleTime(LocalDateTime.now());
                apply.setHandleMan(param.getHandleMan());
                apply.setHandleNote(param.getHandleNote());
                break;
            case 2:
                apply.setStatus(2);
                apply.setReceiveTime(LocalDateTime.now());
                apply.setReceiveMan(param.getReceiveMan());
                apply.setReceiveNote(param.getReceiveNote());
                break;
            case 3:
                apply.setStatus(3);
                apply.setHandleTime(LocalDateTime.now());
                apply.setHandleMan(param.getHandleMan());
                apply.setHandleNote(param.getHandleNote());
                break;
            default:
                return 0;
        }
        return mapper.updateById(apply);
    }

    /**
     * 批量删除退货申请
     *
     * @param ids
     *         退货编号集合
     *
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        QueryWrapper<OmsOrderReturnApply> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 3)
                .in("id", ids);
        return mapper.delete(wrapper);
    }
}
