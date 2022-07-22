package cn.sq.platform.core.service;

/**
 * @author sunqiang
 * @date 2022-6-24 20:18:35
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    Integer getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
