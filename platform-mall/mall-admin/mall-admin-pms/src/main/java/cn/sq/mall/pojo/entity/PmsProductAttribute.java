package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商品属性表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product_attribute")
@ApiModel(value = "PmsProductAttribute对象", description = "商品属性表")
public class PmsProductAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("属性id;属性id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品属性分类id;商品属性分类id")
    private Long productAttributeCategoryId;

    @ApiModelProperty("属性名称;属性名称")
    private String name;

    @ApiModelProperty("属性选择类型;属性选择类型")
    private Integer selectType;

    @ApiModelProperty("属性录入方式;属性录入方式")
    private Integer inputType;

    @ApiModelProperty("可选值列表;以逗号分割")
    private String inputList;

    @ApiModelProperty("排序;排序，最高的可上传图片")
    private Integer sort;

    @ApiModelProperty("分类筛选方式;分类筛选方式")
    private Integer filterType;

    @ApiModelProperty("检索类型;检索类型")
    private Integer searchType;

    @ApiModelProperty("相同属性产品是否关联;相同属性产品是否关联")
    private Integer relatedStatus;

    @ApiModelProperty("是否支持手动新增;是否支持手动新增")
    private Integer handAddStatus;

    @ApiModelProperty("商品属性的类型;商品属性的类型")
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PmsProductAttribute{" +
        "id=" + id +
        ", productAttributeCategoryId=" + productAttributeCategoryId +
        ", name=" + name +
        ", selectType=" + selectType +
        ", inputType=" + inputType +
        ", inputList=" + inputList +
        ", sort=" + sort +
        ", filterType=" + filterType +
        ", searchType=" + searchType +
        ", relatedStatus=" + relatedStatus +
        ", handAddStatus=" + handAddStatus +
        ", type=" + type +
        "}";
    }
}
