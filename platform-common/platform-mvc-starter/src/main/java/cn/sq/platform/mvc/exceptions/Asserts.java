package cn.sq.platform.mvc.exceptions;


import cn.sq.platform.core.service.IErrorCode;

/**
 * @author sunqiang
 * @version 1.0
 * @description 断言处理，抛出异常
 * @date 2022/7/14 13:27
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
