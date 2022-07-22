package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.UmsMenu;
import cn.sq.mall.pojo.entity.UmsResource;
import cn.sq.mall.pojo.entity.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 用户角色多表查询
 * @date 2022/7/18 09:07
 */
@Mapper
public interface AdminRoleDao {
    /**
     * 获取用户所有角色
     * @param adminId 用户编号
     * @return
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 根据用户获取菜单集合
     * @param adminId 用户编号
     * @return
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
    /**
     * 根据角色ID获取菜单
     * @param roleId 角色编号
     * @return
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     * @param roleId 角色编号
     * @return
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
