package cn.sq.mall.service;


import cn.sq.platform.core.entity.PageResponse;

/**
 * @author sunqiang
 * @version 1.0
 * @description 会员等级管理API
 * @date 2022/7/16 15:23
 */
public interface MemberLevelService {
    /**
     * 分页查询会员等级
     * @param defaultStatus 是否为默认等级
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(Integer defaultStatus, Integer pageNum, Integer pageSize);
}
