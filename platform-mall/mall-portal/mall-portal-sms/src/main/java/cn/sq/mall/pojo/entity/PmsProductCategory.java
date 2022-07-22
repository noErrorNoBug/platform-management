package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商品分类表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product_category")
@ApiModel(value = "PmsProductCategory对象", description = "商品分类表")
public class PmsProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类编号;自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("上级分类编号;0表示一级分类")
    private Long parentId;

    @ApiModelProperty("名称;商品分类名称")
    private String name;

    @ApiModelProperty("分类级别;0->1级;1->2级")
    private Integer level;

    @ApiModelProperty("商品数量;商品数量")
    private Integer productCount;

    @ApiModelProperty("商品单位;商品单位")
    private String productUnit;

    @ApiModelProperty("是否显示导航栏;是否显示导航栏")
    private Integer navStatus;

    @ApiModelProperty("显示状态;是否显示状态")
    private Integer showStatus;

    @ApiModelProperty("排序;排序")
    private Integer sort;

    @ApiModelProperty("图标;图标位置")
    private String icon;

    @ApiModelProperty("关键字;关键字描述")
    private String keywords;

    @ApiModelProperty("分类描述;分类描述")
    private String description;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getNavStatus() {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PmsProductCategory{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", name=" + name +
        ", level=" + level +
        ", productCount=" + productCount +
        ", productUnit=" + productUnit +
        ", navStatus=" + navStatus +
        ", showStatus=" + showStatus +
        ", sort=" + sort +
        ", icon=" + icon +
        ", keywords=" + keywords +
        ", description=" + description +
        "}";
    }
}
