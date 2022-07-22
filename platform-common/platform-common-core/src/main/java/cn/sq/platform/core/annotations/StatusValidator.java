package cn.sq.platform.core.annotations;


import cn.sq.platform.core.utils.StatusValidatorUtil;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author sunqiang
 * @version 1.0.0
 * @description 状态机校验器，校验状态值是否在允许范围(数据字典)中
 * @date 2022/7/14 16:01
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = StatusValidatorUtil.class)
public @interface StatusValidator {
    String[] value() default {};

    String message() default "状态标志位为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
