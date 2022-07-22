package cn.sq.platform.swagger.entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sunqiang
 * @version 1.0
 * @description 加载SpringBoot2.6.x配置
 * @date 2022/3/13 11:36 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class SwaggerProperties {
    /**
     * API文档生成基础路径
     */
    private String apiBasePackage;
    /**
     * 是否要启用登录认证
     */
    private boolean enableSecurity;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档描述
     */
    private String description;
    /**
     * 文档版本
     */
    private String version;
    /**
     * 文档联系人姓名
     */
    private String contactName;
    /**
     * 文档联系人网址
     */
    private String contactUrl;
    /**
     * 文档联系人邮箱
     */
    private String contactEmail;

    /**
     * 文档分组名称
     */
    private String groupName;

    /**
     * 许可证
     */
    private String license;


}

