package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商品分类和属性关系表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product_category_attribute_relation")
@ApiModel(value = "PmsProductCategoryAttributeRelation对象", description = "商品分类和属性关系表")
public class PmsProductCategoryAttributeRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("对应关系编号;对应关系编号")
    private Long id;

    @ApiModelProperty("商品分类编号;商品分类编号")
    private Long productCategoryId;

    @ApiModelProperty("商品属性编号;商品属性编号")
    private Long productAttributeId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    @Override
    public String toString() {
        return "PmsProductCategoryAttributeRelation{" +
        "id=" + id +
        ", productCategoryId=" + productCategoryId +
        ", productAttributeId=" + productAttributeId +
        "}";
    }
}
