package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.UmsResource;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台资源管理API
 * @date 2022/7/16 15:23
 */
public interface ResourceService {
    /**
     * 查询所有后台资源
     * @return
     */
    List<UmsResource> all();

    /**
     * 分页查询后台资源
     * @param categoryId 后台资源分类编号
     * @param nameKeyword 名称关键字
     * @param urlKeyword url 关键字
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageNum, Integer pageSize);

    /**
     * 根据资源编号查询后台资源
     * @param id 资源编号
     * @return
     */
    UmsResource getItem(Long id);

    /**
     * 添加后台资源
     * @param param 后台资源参数
     * @return
     */
    int add(UmsResource param);

    /**
     * 修改后台资源
     * @param id 后台资源编号
     * @param param 后台资源参数
     * @return
     */
    int update(Long id, UmsResource param);

    /**
     * 删除后台资源
     * @param id 后台资源编号
     * @return
     */
    int delete(Long id);
}
