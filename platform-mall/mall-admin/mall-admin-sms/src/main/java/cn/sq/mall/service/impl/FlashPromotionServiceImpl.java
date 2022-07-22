package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.SmsFlashPromotionMapper;
import cn.sq.mall.pojo.entity.SmsFlashPromotion;
import cn.sq.mall.service.FlashPromotionService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购活动管理API
 * @date 2022/7/16 15:04
 */
@Service
public class FlashPromotionServiceImpl implements FlashPromotionService {
    @Autowired
    private SmsFlashPromotionMapper mapper;
    /**
     * 分页查询限时购活动列表
     *
     * @param keyword
     *         关键字
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页数量
     *
     * @return
     */
    @Override
    public PageResponse list(String keyword, Integer pageNum, Integer pageSize) {
        Page<SmsFlashPromotion> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<SmsFlashPromotion> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("title",keyword);
        }
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 查询限时购详情
     *
     * @param id
     *         限时购编号
     *
     * @return
     */
    @Override
    public SmsFlashPromotion getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 添加限时购活动
     *
     * @param param
     *         参数
     *
     * @return
     */
    @Override
    public int add(SmsFlashPromotion param) {
        return mapper.insert(param);
    }

    /**
     * 修改限时购活动
     *
     * @param id
     *         限时购编号
     * @param param
     *         参数
     *
     * @return
     */
    @Override
    public int update(Long id, SmsFlashPromotion param) {
        param.setId(id);
        return mapper.updateById(param);
    }

    /**
     * 删除限时购活动
     *
     * @param id
     *         限时购编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return mapper.deleteById(id);
    }

    /**
     * 修改上下线状态
     *
     * @param id
     *         编号
     * @param status
     *         状态
     *
     * @return
     */
    @Override
    public int updateStatus(Long id, Integer status) {
        SmsFlashPromotion promotion = new SmsFlashPromotion();
        promotion.setId(id);
        promotion.setStatus(status);
        return mapper.updateById(promotion);
    }
}
