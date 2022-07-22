package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.HomeContentResult;
import cn.sq.mall.pojo.entity.PmsProductCategory;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 主页管理
 * @date 2022/7/16 15:44
 */
public interface HomeService {
    /**
     * 首页内容展示
     * @return
     */
    HomeContentResult content();

    /**
     * 分页获取推荐商品
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse recommend(Integer pageNum, Integer pageSize);

    /**
     * 根据分类获取专题
     * @param cateId 分类编号
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse subject(Long cateId, Integer pageNum, Integer pageSize);

    /**
     * 分页获取人气推荐商品
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse hot(Integer pageNum, Integer pageSize);

    /**
     * 分页获取新品推荐商品
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse newist(Integer pageNum, Integer pageSize);

    /**
     * 获取首页商品分类
     * @param parentId 上级分类编号
     * @return
     */
    List<PmsProductCategory> getItem(Long parentId);
}
