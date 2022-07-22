package cn.sq.platform.mvc.exceptions;

import cn.sq.platform.core.service.IErrorCode;

/**
 * @author sunqiang
 * @version 1.0
 * @description 自定义接口异常
 * @date 2022/7/14 13:21
 */
public class ApiException extends RuntimeException{
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message,Throwable cause) {
        super(message,cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
