package cn.sq.platform.mvc.annotations;

import cn.sq.platform.mvc.handler.GlobalControllerExceptionHandler;
import cn.sq.platform.swagger.annotations.EnableSwagger3Default;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description Web项目启动默认配置
 * @date 2022/7/21 18:01
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
@Documented
// @Import({GlobalControllerExceptionHandler.class})
@Inherited
@EnableSwagger3Default
public @interface EnableMvcDefault {
}
