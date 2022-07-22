package cn.sq.platform.core.utils;



import cn.sq.platform.core.annotations.StatusValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sunqiang
 * @version 1.0
 * @description 状态值校验工具类
 * @date 2022/7/14 16:04
 */
public class StatusValidatorUtil implements ConstraintValidator<StatusValidator,Integer> {

    private String[] values;
    @Override
    public void initialize(StatusValidator validator) {
        this.values = validator.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if(value==null){
            //当状态为空时使用默认值
            return true;
        }
        for(int i=0;i<values.length;i++){
            if(values[i].equals(String.valueOf(value))){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
