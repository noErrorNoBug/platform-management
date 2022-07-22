package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.UmsResourceCategory;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台资源分类管理API
 * @date 2022/7/16 15:23
 */
public interface ResourceCategoryService {

    /**
     * 查询所有后台资源分类
     * @return
     */
    List<UmsResourceCategory> all();

    /**
     * 添加后台资源分类
     * @param param 后台资源
     * @return
     */
    int add(UmsResourceCategory param);

    /**
     * 更新后台资源
     * @param id 资源id
     * @param param 后台资源
     * @return
     */
    int update(Long id, UmsResourceCategory param);

    /**
     * 删除后台资源
     * @param id 资源id
     * @return
     */
    int delete(Long id);
}
