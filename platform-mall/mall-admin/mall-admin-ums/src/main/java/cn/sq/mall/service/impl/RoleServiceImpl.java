package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.AdminRoleDao;
import cn.sq.mall.mapper.UmsRoleMapper;
import cn.sq.mall.mapper.UmsRoleMenuRelationMapper;
import cn.sq.mall.mapper.UmsRoleResourceRelationMapper;
import cn.sq.mall.pojo.entity.*;
import cn.sq.mall.service.RoleService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台用户角色管理API
 * @date 2022/7/16 15:25
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private AdminRoleDao roleDao;
    @Autowired
    private UmsRoleMenuRelationMapper menuRelationMapper;
    @Autowired
    private UmsRoleResourceRelationMapper resourceRelationMapper;

    /**
     * 通过管理员id获取菜单信息
     *
     * @param id
     *         用户编号
     *
     * @return
     */
    @Override
    public List<UmsMenu> getMenuList(Long id) {
        return roleDao.getMenuList(id);
    }

    /**
     * 获取所有角色
     *
     * @return
     */
    @Override
    public List<UmsRole> all() {
        QueryWrapper<UmsRole> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        wrapper.eq("1", "1");
        return roleMapper.selectList(wrapper);
    }

    /**
     * 根据角色名称分页获取角色列表
     *
     * @param keyword
     *         关键字
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(String keyword, Integer pageNum, Integer pageSize) {
        Page<UmsRole> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<UmsRole> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("name",keyword);
        }
        page = roleMapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据用户角色获取菜单
     *
     * @param roleId
     *         用户角色
     *
     * @return
     */
    @Override
    public List<UmsMenu> menu(Long roleId) {
        return roleDao.getMenuListByRoleId(roleId);
    }

    /**
     * 根据用户角色获取资源
     *
     * @param roleId
     *         用户角色
     *
     * @return
     */
    @Override
    public List<UmsResource> resource(Long roleId) {
        return roleDao.getResourceListByRoleId(roleId);
    }

    /**
     * 添加角色
     *
     * @param param
     *         角色参数
     *
     * @return
     */
    @Override
    public int add(UmsRole param) {
        param.setCreateTime(LocalDateTime.now());
        param.setAdminCount(0);
        param.setSort(0);
        return roleMapper.insert(param);
    }

    /**
     * 给角色分配菜单
     *
     * @param roleId
     *         用户角色
     * @param menuIds
     *         用户菜单
     *
     * @return
     */
    @Override
    public int addMenus(Long roleId, List<Long> menuIds) {
        QueryWrapper<UmsRoleMenuRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        menuRelationMapper.delete(wrapper);
        List<UmsRoleMenuRelation> list = Lists.newArrayList();
        menuIds.stream().forEach(menuId -> {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setMenuId(menuId);
            relation.setRoleId(roleId);
            list.add(relation);
        });
        return menuRelationMapper.insertAll(list);
    }

    /**
     * 给角色分配资源
     *
     * @param roleId
     *         用户角色
     * @param resourceIds
     *         用户资源
     *
     * @return
     */
    @Override
    public int addResource(Long roleId, List<Long> resourceIds) {
        QueryWrapper<UmsRoleResourceRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        resourceRelationMapper.delete(wrapper);
        List<UmsRoleResourceRelation> list = Lists.newArrayList();
        resourceIds.stream().forEach(resourceId -> {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setResourceId(resourceId);
            relation.setRoleId(roleId);
            list.add(relation);
        });
        return resourceRelationMapper.insertAll(list);
    }

    /**
     * 更新角色
     *
     * @param id
     *         角色编号
     * @param param
     *         角色参数
     *
     * @return
     */
    @Override
    public int update(Long id, UmsRole param) {
        param.setId(id);
        return roleMapper.updateById(param);
    }

    /**
     * 批量删除角色
     *
     * @param ids
     *         角色编号集合
     *
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    /**
     * 修改角色状态
     *
     * @param id
     *         角色编号
     * @param status
     *         角色状态
     *
     * @return
     */
    @Override
    public int status(Long id, Integer status) {
        UmsRole role = new UmsRole();
        role.setId(id);
        role.setStatus(status);
        return roleMapper.updateById(role);
    }
}
