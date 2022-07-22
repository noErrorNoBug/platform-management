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
 * 后台资源表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("ums_resource")
@ApiModel(value = "UmsResource对象", description = "后台资源表")
public class UmsResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("资源编号;资源编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("创建时间;创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("资源名称;资源名称")
    private String name;

    @ApiModelProperty("资源URL;资源URL")
    private String url;

    @ApiModelProperty("描述;描述")
    private String description;

    @ApiModelProperty("资源分类ID;资源分类ID")
    private Long categoryId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "UmsResource{" +
        "id=" + id +
        ", createTime=" + createTime +
        ", name=" + name +
        ", url=" + url +
        ", description=" + description +
        ", categoryId=" + categoryId +
        "}";
    }
}
