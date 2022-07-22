package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品满减表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product_full_reduction")
@ApiModel(value = "PmsProductFullReduction对象", description = "商品满减表")
public class PmsProductFullReduction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("满减编号;满减编号")
    private Long id;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("商品满足金额;商品满足金额")
    private BigDecimal fullPrice;

    @ApiModelProperty("商品减少金额;商品减少金额")
    private BigDecimal reducePrice;


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

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }

    public BigDecimal getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(BigDecimal reducePrice) {
        this.reducePrice = reducePrice;
    }

    @Override
    public String toString() {
        return "PmsProductFullReduction{" +
        "id=" + id +
        ", productId=" + productId +
        ", fullPrice=" + fullPrice +
        ", reducePrice=" + reducePrice +
        "}";
    }
}
