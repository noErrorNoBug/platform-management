package cn.sq.mall.service;

import cn.sq.mall.pojo.CmsSubject;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 专题管理接口
 * @date 2022/7/16 01:07
 */
public interface SubjectService {
    /**
     * 获取所有专题
     * @return
     */
    List<CmsSubject> getAll();

    /**
     * 根据专题名称分页获取商品专题
     * @param keyword 专题名称关键字
     * @param pageNum   页码
     * @param pageSize  每页大小
     * @return
     */
    PageResponse list(String keyword, Integer pageNum, Integer pageSize);
}
