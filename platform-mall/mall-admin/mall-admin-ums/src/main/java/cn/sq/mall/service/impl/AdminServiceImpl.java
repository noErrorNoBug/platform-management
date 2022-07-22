package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.AdminRoleDao;
import cn.sq.mall.mapper.UmsAdminMapper;
import cn.sq.mall.pojo.dto.AdminParam;
import cn.sq.mall.pojo.dto.AdminPasswordParam;
import cn.sq.mall.pojo.entity.UmsAdmin;
import cn.sq.mall.pojo.entity.UmsRole;
import cn.sq.mall.service.AdminService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台用户管理API
 * @date 2022/7/16 15:24
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private AdminRoleDao roleDao;
    /**
     * 用户注册
     *
     * @param param
     *         用户注册参数
     *
     * @return
     */
    @Override
    public UmsAdmin register(AdminParam param) {
        UmsAdmin admin = new UmsAdmin();
        BeanUtils.copyProperties(param,admin);
        admin.setCreateTime(LocalDateTime.now());
        admin.setStatus(1);
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",admin.getUsername());
        List<UmsAdmin> exists = adminMapper.selectList(wrapper);
        if (!CollectionUtils.isEmpty(exists)) {
            return null;
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminMapper.insert(admin);
        return admin;
    }

    /**
     * 登录以后返回token
     *
     * @param username
     *         用户名
     * @param password
     *         密码
     *
     * @return
     */
    @Override
    public String login(String username, String password) {
        return null;
    }

    /**
     * 刷新token
     *
     * @param token
     *
     * @return
     */
    @Override
    public String refreshToken(String token) {
        return null;
    }

    /**
     * 通过用户名获取后台管理员
     *
     * @param username
     *         用户名
     *
     * @return
     */
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

    /**
     * 根据管理员编号获取角色
     *
     * @param id
     *
     * @return
     */
    @Override
    public List<UmsRole> getRoleList(Long id) {
        return roleDao.getRoleList(id);
    }

    /**
     * 根据用户名或姓名分页获取用户列表
     *
     * @param keyword
     *         搜索关键字
     * @param pageSize
     *         页码
     * @param pageNum
     *         每页数量
     *
     * @return
     */
    @Override
    public PageResponse list(String keyword, Integer pageSize, Integer pageNum) {
        Page<UmsAdmin> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("nick_name",keyword);
        }
        page = adminMapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据id获取用户
     *
     * @param id
     *
     * @return
     */
    @Override
    public UmsAdmin getItem(Long id) {
        return adminMapper.selectById(id);
    }

    /**
     * 修改指定用户信息
     *
     * @param id
     *         用户编号
     * @param admin
     *         用户信息
     *
     * @return
     */
    @Override
    public int update(Long id, UmsAdmin admin) {
        return 0;
    }

    /**
     * 修改用户密码
     *
     * @param param
     *         密码修改参数
     *
     * @return
     */
    @Override
    public int updatePassword(AdminPasswordParam param) {
        return 0;
    }

    /**
     * 删除指定用户
     *
     * @param id
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return 0;
    }

    /**
     * 修改账号状态
     *
     * @param id
     *         编号
     * @param status
     *         状态
     *
     * @return
     */
    @Override
    public int update(Long id, Integer status) {
        return 0;
    }

    /**
     * 给用户分配角色
     *
     * @param adminId
     *         用户编号
     * @param roleIds
     *         角色集合
     *
     * @return
     */
    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }
}
