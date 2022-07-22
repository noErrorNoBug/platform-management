package cn.sq.mall.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @author sunqiang
 * @version 1.0
 * @description 登录参数
 * @date 2022/7/17 22:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdminLoginParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
