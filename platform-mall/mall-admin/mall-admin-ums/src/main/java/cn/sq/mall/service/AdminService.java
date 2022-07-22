package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.AdminParam;
import cn.sq.mall.pojo.dto.AdminPasswordParam;
import cn.sq.mall.pojo.entity.UmsAdmin;
import cn.sq.mall.pojo.entity.UmsRole;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台用户管理API
 * @date 2022/7/16 15:22
 */
public interface AdminService {
    /**
     * 用户注册
     * @param param 用户注册参数
     * @return
     */
    UmsAdmin register(AdminParam param);

    /**
     * 登录以后返回token
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新token
     * @param token
     * @return
     */
    String refreshToken(String token);

    /**
     * 通过用户名获取后台管理员
     * @param username 用户名
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 根据管理员编号获取角色
     * @param id
     * @return
     */
    List<UmsRole> getRoleList(Long id);

    /**
     * 根据用户名或姓名分页获取用户列表
     * @param keyword 搜索关键字
     * @param pageSize 页码
     * @param pageNum 每页数量
     * @return
     */
    PageResponse list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    UmsAdmin getItem(Long id);

    /**
     * 修改指定用户信息
     * @param id 用户编号
     * @param admin 用户信息
     * @return
     */
    @Transactional
    int update(Long id, UmsAdmin admin);

    /**
     * 修改用户密码
     * @param param 密码修改参数
     * @return
     */
    int updatePassword(AdminPasswordParam param);

    /**
     * 删除指定用户
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改账号状态
     * @param id 编号
     * @param status 状态
     * @return
     */
    int update(Long id, Integer status);

    /**
     * 给用户分配角色
     * @param adminId 用户编号
     * @param roleIds 角色集合
     * @return
     */
    int updateRole(Long adminId, List<Long> roleIds);
}
