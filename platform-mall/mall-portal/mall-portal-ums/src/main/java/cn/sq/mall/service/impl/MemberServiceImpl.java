package cn.sq.mall.service.impl;

import cn.sq.mall.pojo.entity.UmsMember;
import cn.sq.mall.service.MemberService;
import org.springframework.stereotype.Service;

/**
 * @author sunqiang
 * @version 1.0
 * @description 会员登录注册管理
 * @date 2022/7/16 15:59
 */
@Service
public class MemberServiceImpl implements MemberService {
    /**
     * 会员注册
     *
     * @param username
     *         用户名
     * @param password
     *         密码
     * @param telephone
     *         手机号
     * @param authCode
     *         验证码
     */
    @Override
    public void register(String username, String password, String telephone, String authCode) {

    }

    /**
     * 会员登录
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
     * 获取当前用户
     *
     * @return
     */
    @Override
    public UmsMember getCurrentMember() {
        return null;
    }

    /**
     * 生成验证码
     *
     * @param telephone
     *         手机号
     *
     * @return
     */
    @Override
    public String generateAuthCode(String telephone) {
        return null;
    }

    /**
     * 修改密码
     *
     * @param telephone
     *         手机号
     * @param password
     *         密码
     * @param authCode
     *         验证码
     */
    @Override
    public void password(String telephone, String password, String authCode) {

    }

    /**
     * 刷新token
     *
     * @param token
     *         原有token
     *
     * @return
     */
    @Override
    public String refreshToken(String token) {
        return null;
    }
}
