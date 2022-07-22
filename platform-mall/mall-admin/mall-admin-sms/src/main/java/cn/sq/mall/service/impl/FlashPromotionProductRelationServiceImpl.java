package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.FlashPromotionProductRelationDao;
import cn.sq.mall.mapper.SmsFlashPromotionProductRelationMapper;
import cn.sq.mall.pojo.dto.FlashPromotionProduct;
import cn.sq.mall.pojo.entity.SmsFlashPromotionProductRelation;
import cn.sq.mall.service.FlashPromotionProductRelationService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购和商品关系管理API
 * @date 2022/7/16 15:03
 */
@Service
public class FlashPromotionProductRelationServiceImpl implements FlashPromotionProductRelationService {
    @Autowired
    private SmsFlashPromotionProductRelationMapper mapper;
    @Autowired
    private FlashPromotionProductRelationDao dao;

    /**
     * 分页查询不同场次限时购和商品关系
     *
     * @param flashPromotionId
     *         限时购编号
     * @param flashPromotionSessionId
     *         限时购场次编号
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageNum, Integer pageSize) {
        Page<FlashPromotionProduct> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        page = dao.getList(page,flashPromotionId,flashPromotionSessionId);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据编号查询限时购和商品关系信息
     *
     * @param id
     *         关系编号
     *
     * @return
     */
    @Override
    public SmsFlashPromotionProductRelation getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 修改限时购和商品关系
     *
     * @param id
     *         编号
     * @param param
     *         参数
     *
     * @return
     */
    @Override
    public int update(Long id, SmsFlashPromotionProductRelation param) {
        param.setId(id);
        return mapper.updateById(param);
    }

    /**
     * 删除限时购和商品关系
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
     * 批量添加商品关联
     *
     * @param relationLists
     *         关联关系列表
     *
     * @return
     */
    @Override
    public int add(List<SmsFlashPromotionProductRelation> relationLists) {
        return mapper.insertAll(relationLists);
    }

    @Override
    public long getCount(Long flashPromotionId, Long flashPromotionSessionId) {
        QueryWrapper<SmsFlashPromotionProductRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("flash_promotion_id",flashPromotionId)
                .eq("flash_promotion_session_id",flashPromotionSessionId);
        return mapper.selectCount(wrapper);
    }
}
