package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.SmsHomeRecommendSubject;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页专题推荐管理API
 * @date 2022/7/16 15:03
 */
public interface HomeRecommendSubjectService {
    /**
     * 分页查询首页专题
     * @param subjectName 新品名称
     * @param recommendStatus 推荐状态
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(String subjectName, Integer recommendStatus, Integer pageNum, Integer pageSize);

    /**
     * 批量添加首页专题推荐
     * @param params 品牌集合
     * @return
     */
    @Transactional
    int add(List<SmsHomeRecommendSubject> params);

    /**
     * 修改专题推荐排序
     * @param id 编号
     * @param sort 排序
     * @return
     */
    int update(Long id, Integer sort);

    /**
     * 批量删除专题推荐
     * @param ids 编号集合
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 批量修改专题推荐状态
     * @param ids 编号集合
     * @param status 推荐状态
     * @return
     */
    int status(List<Long> ids, Integer status);
}
