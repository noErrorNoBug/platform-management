package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.UmsMenu;
import cn.sq.mall.pojo.entity.UmsResource;
import cn.sq.mall.pojo.entity.UmsRole;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台用户角色管理API
 * @date 2022/7/16 15:23
 */
public interface RoleService {
    /**
     * 通过管理员id获取菜单信息
     * @param id 用户编号
     * @return
     */
    List<UmsMenu> getMenuList(Long id);

    /**
     * 获取所有角色
     * @return
     */
    List<UmsRole> all();

    /**
     * 根据角色名称分页获取角色列表
     * @param keyword 关键字
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据用户角色获取菜单
     * @param roleId 用户角色
     * @return
     */
    List<UmsMenu> menu(Long roleId);

    /**
     * 根据用户角色获取资源
     * @param roleId 用户角色
     * @return
     */
    List<UmsResource> resource(Long roleId);

    /**
     * 添加角色
     * @param param 角色参数
     * @return
     */
    int add(UmsRole param);

    /**
     * 给角色分配菜单
     * @param roleId 用户角色
     * @param menuIds 用户菜单
     * @return
     */
    @Transactional
    int addMenus(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     * @param roleId 用户角色
     * @param resourceIds 用户资源
     * @return
     */
    @Transactional
    int addResource(Long roleId, List<Long> resourceIds);

    /**
     * 更新角色
     * @param id 角色编号
     * @param param 角色参数
     * @return
     */
    int update(Long id, UmsRole param);

    /**
     * 批量删除角色
     * @param ids 角色编号集合
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 修改角色状态
     * @param id 角色编号
     * @param status 角色状态
     * @return
     */
    int status(Long id, Integer status);
}
