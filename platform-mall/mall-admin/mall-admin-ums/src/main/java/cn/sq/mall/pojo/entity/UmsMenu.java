package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 后台菜单表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("ums_menu")
@ApiModel(value = "UmsMenu对象", description = "后台菜单表")
public class UmsMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("后台菜单列表;后台菜单列表")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("父级ID;父级ID")
    private Long parentId;

    @ApiModelProperty("创建时间;创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("菜单名称;菜单名称")
    private String title;

    @ApiModelProperty("菜单级数;菜单级数")
    private Integer level;

    @ApiModelProperty("菜单排序;菜单排序")
    private Integer sort;

    @ApiModelProperty("前端名称;前端名称")
    private String name;

    @ApiModelProperty("前端图标;前端图标")
    private String icon;

    @ApiModelProperty("前端隐藏;是否隐藏")
    private Integer hidden;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "UmsMenu{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", createTime=" + createTime +
        ", title=" + title +
        ", level=" + level +
        ", sort=" + sort +
        ", name=" + name +
        ", icon=" + icon +
        ", hidden=" + hidden +
        "}";
    }
}
