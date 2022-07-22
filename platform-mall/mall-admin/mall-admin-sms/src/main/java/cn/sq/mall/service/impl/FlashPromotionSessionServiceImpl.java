package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.SmsFlashPromotionSessionMapper;
import cn.sq.mall.pojo.dto.FlashPromotionSessionDetail;
import cn.sq.mall.pojo.entity.SmsFlashPromotionSession;
import cn.sq.mall.service.FlashPromotionProductRelationService;
import cn.sq.mall.service.FlashPromotionSessionService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购场次管理API
 * @date 2022/7/16 15:04
 */
@Service
public class FlashPromotionSessionServiceImpl implements FlashPromotionSessionService {
    @Autowired
    private SmsFlashPromotionSessionMapper mapper;
    @Autowired
    private FlashPromotionProductRelationService service;
    /**
     * 分页查询全部场次
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
        Page<SmsFlashPromotionSession> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<SmsFlashPromotionSession> wrapper = new QueryWrapper<>();
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 查询所有可用场次和数量
     *
     * @param flashPromotionId
     *         限时购id
     *
     * @return
     */
    @Override
    public List<FlashPromotionSessionDetail> available(Long flashPromotionId) {
        List<FlashPromotionSessionDetail> result = new ArrayList<>();
        QueryWrapper<SmsFlashPromotionSession> wrapper = new QueryWrapper<>();
        wrapper.eq("status",1);
        List<SmsFlashPromotionSession> sessions = mapper.selectList(wrapper);
        sessions.stream().forEach(session -> {
            FlashPromotionSessionDetail detail = new FlashPromotionSessionDetail();
            BeanUtils.copyProperties(session,detail);
            long count = service.getCount(flashPromotionId, session.getId());
            detail.setProductCount(count);
            result.add(detail);
        });
        return result;
    }

    /**
     * 根据编号查询场次信息
     *
     * @param id
     *         编号
     *
     * @return
     */
    @Override
    public SmsFlashPromotionSession getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 添加限时购场次
     *
     * @param param
     *         场次
     *
     * @return
     */
    @Override
    public int add(SmsFlashPromotionSession param) {
        param.setCreateTime(LocalDateTime.now());
        return mapper.insert(param);
    }

    /**
     * 修改限时购场次
     *
     * @param id
     *         编号
     * @param param
     *         场次
     *
     * @return
     */
    @Override
    public int update(Long id, SmsFlashPromotionSession param) {
        param.setId(id);
        return mapper.updateById(param);
    }

    /**
     * 删除场次
     *
     * @param id
     *         编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return mapper.deleteById(id);
    }

    /**
     * 修改可用状态
     *
     * @param id
     *         编号
     * @param status
     *         可用状态
     *
     * @return
     */
    @Override
    public int updateStatus(Long id, Integer status) {
        SmsFlashPromotionSession session = new SmsFlashPromotionSession();
        session.setId(id);
        session.setStatus(status);
        return mapper.updateById(session);
    }
}
