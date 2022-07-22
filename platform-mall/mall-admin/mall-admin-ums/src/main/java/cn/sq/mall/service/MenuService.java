package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.MenuNode;
import cn.sq.mall.pojo.entity.UmsMenu;
import cn.sq.platform.core.entity.PageResponse;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券管理API
 * @date 2022/7/16 15:23
 */
public interface MenuService {
    /**
     * 分页查询菜单
     * @param parentId 父目录编号
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(Long parentId, Integer pageNum, Integer pageSize);

    /**
     * 根据编号查询菜单
     * @param id 菜单编号
     * @return
     */
    UmsMenu getItem(Long id);

    /**
     * 添加菜单
     * @param param 菜单参数
     * @return
     */
    int add(UmsMenu param);

    /**
     * 更新菜单
     * @param id 菜单编号
     * @param param 菜单参数
     * @return
     */
    int update(Long id, UmsMenu param);

    /**
     * 根据编号删除菜单
     * @param id 菜单编号
     * @return
     */
    int delete(Long id);

    /**
     * 更改菜单显示状态
     * @param id 菜单编号
     * @param hidden 是否显示
     * @return
     */
    int hidden(Long id, Integer hidden);

    /**
     * 获取菜单树
     * @return
     */
    List<MenuNode> tree();
}
