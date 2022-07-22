package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.HomeDao;
import cn.sq.mall.mapper.SmsFlashPromotionMapper;
import cn.sq.mall.mapper.SmsFlashPromotionSessionMapper;
import cn.sq.mall.mapper.SmsHomeAdvertiseMapper;
import cn.sq.mall.pojo.dto.FlashPromotionProduct;
import cn.sq.mall.pojo.dto.HomeContentResult;
import cn.sq.mall.pojo.dto.HomeFlashPromotion;
import cn.sq.mall.pojo.entity.*;
import cn.sq.mall.service.HomeService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalTime;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页管理
 * @date 2022/7/16 15:44
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private SmsFlashPromotionMapper promotionMapper;
    @Autowired
    private SmsFlashPromotionSessionMapper sessionMapper;

    /**
     * 首页内容展示
     *
     * @return
     */
    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐品牌
        result.setBrandList(homeDao.getRecommendBrandList(0, 6));
        //获取秒杀信息
        result.setHomeFlashPromotion(getHomeFlashPromotion());
        //获取新品推荐
        result.setNewProductList(homeDao.getNewProductList(0, 4));
        //获取人气推荐
        result.setHotProductList(homeDao.getHotProductList(0, 4));
        //获取推荐专题
        result.setSubjectList(homeDao.getRecommendSubjectList(0, 4));
        return result;
    }

    /**
     * 获取首页广告列表
     * @return
     */
    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        QueryWrapper<SmsHomeAdvertise> wrapper = new QueryWrapper<>();
        wrapper.eq("type", 1)
                .eq("status", 1)
                .orderByAsc("sort");
        return advertiseMapper.selectList(wrapper);
    }

    /**
     * 主页秒杀场次展示
     *
     * @return
     */
    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        LocalTime now = LocalTime.now();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if (nextSession != null) {
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

    /**
     * 根据时间获取秒杀活动
     *
     * @param date
     *
     * @return
     */
    private SmsFlashPromotion getFlashPromotion(LocalTime date) {
        QueryWrapper<SmsFlashPromotion> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 1)
                .ge("start_date", date)
                .lt("end_date", date);
        List<SmsFlashPromotion> promotions = promotionMapper.selectList(wrapper);
        if (!CollectionUtils.isEmpty(promotions)) {
            return promotions.get(0);
        }
        return null;
    }

    /**
     * 根据时间获取秒杀场次
     *
     * @param date
     *
     * @return
     */
    private SmsFlashPromotionSession getFlashPromotionSession(LocalTime date) {
        QueryWrapper<SmsFlashPromotionSession> wrapper = new QueryWrapper<>();
        wrapper.ge("start_time", date)
                .lt("end_time", date);
        List<SmsFlashPromotionSession> sessions = sessionMapper.selectList(wrapper);
        if (!CollectionUtils.isEmpty(sessions)) {
            return sessions.get(0);
        }
        return null;
    }

    //获取下一个场次信息
    private SmsFlashPromotionSession getNextFlashPromotionSession(LocalTime time) {
        QueryWrapper<SmsFlashPromotionSession> wrapper = new QueryWrapper<>();
        wrapper.ge("start_time", time)
                .orderByAsc("start_time");
        List<SmsFlashPromotionSession> sessions = sessionMapper.selectList(wrapper);
        if (!CollectionUtils.isEmpty(sessions)) {
            return sessions.get(0);
        }
        return null;
    }

    /**
     * 分页获取推荐商品
     *
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse recommend(Integer pageNum, Integer pageSize) {
        // todo 调用商品服务或者放到商品服务里
        return null;
    }

    /**
     * 根据分类获取专题
     *
     * @param cateId
     *         分类编号
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse subject(Long cateId, Integer pageNum, Integer pageSize) {
        // todo 调用内容服务或者放到内容服务里
        return null;
    }

    /**
     * 分页获取人气推荐商品
     *
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse hot(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        List<PmsProduct> list = homeDao.getHotProductList(offset, pageSize);
        return PageResponse.success((long)pageNum,(long)pageSize,0L,(long)list.size(),list);
    }

    /**
     * 分页获取新品推荐商品
     *
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse newist(Integer pageNum, Integer pageSize) {
        int offset = pageSize * (pageNum - 1);
        List<PmsProduct> newProductList = homeDao.getNewProductList(offset, pageSize);
        return PageResponse.success((long)pageNum,(long)pageSize,0L,(long)newProductList.size(),newProductList);
    }

    /**
     * 获取首页商品分类
     *
     * @param parentId
     *         上级分类编号
     *
     * @return
     */
    @Override
    public List<PmsProductCategory> getItem(Long parentId) {
        // todo 调用商品服务或者放到商品服务里
        return null;
    }
}
