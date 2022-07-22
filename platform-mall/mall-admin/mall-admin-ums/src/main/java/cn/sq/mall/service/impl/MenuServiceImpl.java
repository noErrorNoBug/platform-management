package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.UmsMenuMapper;
import cn.sq.mall.pojo.dto.MenuNode;
import cn.sq.mall.pojo.entity.UmsMenu;
import cn.sq.mall.service.MenuService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优惠券管理API
 * @date 2022/7/16 15:25
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private UmsMenuMapper mapper;
    /**
     * 分页查询菜单
     *
     * @param parentId
     *         父目录编号
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(Long parentId, Integer pageNum, Integer pageSize) {
        Page<UmsMenu> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<UmsMenu> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (ObjectUtils.isNotEmpty(parentId)) {
            wrapper.eq("parent_id",parentId);
        }
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据编号查询菜单
     *
     * @param id
     *         菜单编号
     *
     * @return
     */
    @Override
    public UmsMenu getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 添加菜单
     *
     * @param param
     *         菜单参数
     *
     * @return
     */
    @Override
    public int add(UmsMenu param) {
        return mapper.insert(param);
    }

    /**
     * 更新菜单
     *
     * @param id
     *         菜单编号
     * @param param
     *         菜单参数
     *
     * @return
     */
    @Override
    public int update(Long id, UmsMenu param) {
        param.setId(id);
        return mapper.updateById(param);
    }

    /**
     * 根据编号删除菜单
     *
     * @param id
     *         菜单编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return mapper.deleteById(id);
    }

    /**
     * 更改菜单显示状态
     *
     * @param id
     *         菜单编号
     * @param hidden
     *         是否显示
     *
     * @return
     */
    @Override
    public int hidden(Long id, Integer hidden) {
        UmsMenu menu = new UmsMenu();
        menu.setId(id);
        menu.setHidden(hidden);
        return mapper.updateById(menu);
    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @Override
    public List<MenuNode> tree() {
        QueryWrapper<UmsMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("1","1");
        List<UmsMenu> menus = mapper.selectList(wrapper);
        List<MenuNode> tree = menus.stream().filter(umsMenu -> umsMenu.getParentId().equals(0L))
                .map(umsMenu -> covertMenuNode(umsMenu, menus))
                .collect(Collectors.toList());
        return tree;
    }

    /**
     * 转换为树
     * @param menu
     * @param menuList
     * @return
     */
    private MenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        MenuNode node = new MenuNode();
        BeanUtils.copyProperties(menu, node);
        List<MenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
