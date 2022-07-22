package cn.sq.platform.mvc.handler;

import cn.sq.platform.core.entity.BaseResponse;
import cn.sq.platform.mvc.exceptions.ApiException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sunqiang
 * @version 1.0
 * @description 全局Controller异常拦截，讲自定义API异常、参数校验异常、阐述绑定异常处理为统一的失败返回
 * @date 2022/7/14 13:33
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public BaseResponse handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return BaseResponse.failed(e.getErrorCode());
        }
        return BaseResponse.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResponse handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return BaseResponse.invalidate(message);
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public BaseResponse handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return BaseResponse.invalidate(message);
    }
}
