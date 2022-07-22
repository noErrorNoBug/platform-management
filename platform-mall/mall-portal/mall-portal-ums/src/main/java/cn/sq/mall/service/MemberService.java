package cn.sq.mall.service;

import cn.sq.mall.pojo.entity.UmsMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunqiang
 * @version 1.0
 * @description 会员注册登录管理
 * @date 2022/7/16 15:56
 */
public interface MemberService {
    /**
     * 会员注册
     * @param username 用户名
     * @param password 密码
     * @param telephone 手机号
     * @param authCode 验证码
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * 会员登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username, String password);

    /**
     * 获取当前用户
     * @return
     */
    UmsMember getCurrentMember();

    /**
     * 生成验证码
     * @param telephone 手机号
     * @return
     */
    String generateAuthCode(String telephone);

    /**
     * 修改密码
     * @param telephone 手机号
     * @param password 密码
     * @param authCode 验证码
     */
    @Transactional
    void password(String telephone, String password, String authCode);

    /**
     * 刷新token
     * @param token 原有token
     * @return
     */
    String refreshToken(String token);
}
