package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商品属性值表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product_attribute_value")
@ApiModel(value = "PmsProductAttributeValue对象", description = "商品属性值表")
public class PmsProductAttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("属性值编号;商品属性值编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("商品属性编号;商品属性编号")
    private Long productAttributeId;

    @ApiModelProperty("商品属性值;手动添加的规格或参数值，多个用逗号分开")
    private String value;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductAttributeId() {
        return productAttributeId;
    }

    public void setProductAttributeId(Long productAttributeId) {
        this.productAttributeId = productAttributeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PmsProductAttributeValue{" +
        "id=" + id +
        ", productId=" + productId +
        ", productAttributeId=" + productAttributeId +
        ", value=" + value +
        "}";
    }
}
