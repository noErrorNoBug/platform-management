package cn.sq.platform.swagger.annotations;

import cn.sq.platform.swagger.config.DefaultSwagger3Config;
import cn.sq.platform.swagger.config.PathMatherConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description 加载SpringBoot2.6.x配置
 * @date 2022/3/13 11:36 PM
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
@Documented
@Import({PathMatherConfig.class, DefaultSwagger3Config.class})
@Inherited
public @interface EnableSwagger3Default {
}
