package cn.sq.platform.db.annotations;

import cn.sq.platform.db.config.MyBatisPlusDefaultConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description MybatisPlus默认配置
 * @date 2022/7/21 18:01
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
@Documented
@Import({MyBatisPlusDefaultConfig.class})
@Inherited
public @interface EnableMybatisDefault {
}
