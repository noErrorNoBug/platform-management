package cn.sq.platform.loadbalancer.annotations;

import cn.sq.platform.loadbalancer.config.FeignDefaultConfig;
import cn.sq.platform.swagger.config.PathMatherConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sunqiang
 * @version 1.0
 * @description FeignClients默认配置
 * @date 2022/7/21 18:01
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
@Documented
@Import({FeignDefaultConfig.class})
@Inherited
public @interface EnableFeignClientsDefault {
}
