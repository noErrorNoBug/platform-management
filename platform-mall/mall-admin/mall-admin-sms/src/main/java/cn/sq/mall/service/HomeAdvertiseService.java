package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.SmsHomeAdvertise;
import cn.sq.platform.core.entity.PageResponse;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页轮播广告管理API
 * @date 2022/7/16 15:02
 */
public interface HomeAdvertiseService {
    /**
     * 分页查询广告
     * @param name 广告名称
     * @param type 广告类型
     * @param endTime 广告结束时间
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(String name, Integer type, String endTime, Integer pageNum, Integer pageSize);

    /**
     * 根据编号获取广告
     * @param id 编号
     * @return
     */
    SmsHomeAdvertise getItem(Long id);

    /**
     * 添加广告
     * @param param 广告参数
     * @return
     */
    int add(SmsHomeAdvertise param);

    /**
     * 删除广告
     * @param id id
     * @param param 广告
     * @return
     */
    int update(Long id, SmsHomeAdvertise param);

    /**
     * 删除广告
     * @param id 广告编号
     * @return
     */
    int delete(Long id);

    /**
     * 修改广告上下线状态
     * @param id 编号
     * @param status 上下线状态
     * @return
     */
    int updateStatus(Long id, Integer status);
}
