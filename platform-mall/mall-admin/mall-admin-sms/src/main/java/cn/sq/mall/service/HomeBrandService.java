package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.SmsHomeBrand;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页品牌管理API
 * @date 2022/7/16 15:02
 */
public interface HomeBrandService {
    /**
     * 分页查询首页品牌
     * @param brandName 品牌名称
     * @param recommendStatus 推荐状态
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(String brandName, Integer recommendStatus, Integer pageNum, Integer pageSize);

    /**
     * 批量添加首页品牌推荐
     * @param params 品牌集合
     * @return
     */
    int add(List<SmsHomeBrand> params);

    /**
     * 修改品牌推荐排序
     * @param id 编号
     * @param sort 排序
     * @return
     */
    int update(Long id, Integer sort);

    /**
     * 批量删除品牌推荐
     * @param ids 编号集合
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 批量修改品牌推荐状态
     * @param ids 编号集合
     * @param status 推荐状态
     * @return
     */
    int status(List<Long> ids, Integer status);
}
