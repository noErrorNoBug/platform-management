package cn.sq.platform.core.entity;

import cn.sq.platform.core.constants.ResultCode;
import cn.sq.platform.core.service.IErrorCode;
import lombok.Data;

/**
 * 返回值封装
 *
 * @author sunqiang
 * @date 2020-10-24 20:18:35
 */
@Data
public class BaseResponse<T> {

    /**
     * 状态码，默认200成功
     */
    private Integer code;
    /**
     * 返回值携带信息
     */
    private String message;
    /**
     * 返回体
     */
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> BaseResponse<T> success(String message, T data) {
        return new BaseResponse<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> BaseResponse<T> failed(IErrorCode errorCode) {
        return new BaseResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> BaseResponse<T> failed(String message, IErrorCode errorCode) {
        return new BaseResponse<>(errorCode.getCode(), message, null);
    }

    public static <T> BaseResponse<T> failed(String message) {
        return new BaseResponse<>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> BaseResponse<T> failed() {
        return failed(ResultCode.FAILED);
    }

    public static <T> BaseResponse<T> invalidate() {
        return failed(ResultCode.INVALIDATE);
    }

    public static <T> BaseResponse<T> invalidate(String message) {
        return new BaseResponse<>(ResultCode.INVALIDATE.getCode(), message, null);
    }

    public static <T> BaseResponse<T> unauthorized(T data) {
        return new BaseResponse<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    public static <T> BaseResponse<T> forbidden(T data) {
        return new BaseResponse<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
