package cn.sq.mall.config;

import cn.sq.platform.swagger.annotations.EnableSwagger3;
import cn.sq.platform.swagger.config.BaseSwaggerConfig;
import cn.sq.platform.swagger.entity.SwaggerProperties;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunqiang
 * @version 1.0
 * @description Swagger3 配置，地址在swagger3改成了port/swagger-ui/
 *              若是使用 knife4j ui，访问port/doc.html
 * @date 2022/3/12 12:07 AM
 */
@Configuration
@EnableSwagger3
public class Swagger3Config extends BaseSwaggerConfig {


    public Swagger3Config(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver);
    }

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("cn.sq.mall.controller")
                .groupName("mall-portal-oms")
                .title("商城前端(买家)订单服务API")
                .description("商城前端(买家)订单服务API接口文档")
                .contactName("孙强")
                .contactUrl("https://github.com/noErrorNoBug")
                .contactEmail("749922109@qq.com")
                .version("1.0.0")
                .license("Apache License 2.0 Copyright [2022] [sunqiang]")
                .enableSecurity(false)
                .build();
    }
}
