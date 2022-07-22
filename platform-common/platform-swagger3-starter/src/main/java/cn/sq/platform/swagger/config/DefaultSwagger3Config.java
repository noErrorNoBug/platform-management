package cn.sq.platform.swagger.config;

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
public class DefaultSwagger3Config extends BaseSwaggerConfig {


    public DefaultSwagger3Config(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver);
    }

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("cn.sq.platform.*.controller")
                .groupName("DEFAULT_GROUP")
                .title("Swagger3 接口文档")
                .description("Swagger3 接口文档")
                .contactName("孙强")
                .contactUrl("https://noerrornobug.github.io/docs/")
                .contactEmail("no mail")
                .version("1.0.0")
                .license("Apache License 2.0 Copyright [2022] [sunqiang]")
                .enableSecurity(false)
                .build();
    }
}
