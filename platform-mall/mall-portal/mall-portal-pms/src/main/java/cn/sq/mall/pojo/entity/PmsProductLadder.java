package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品阶梯价格表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product_ladder")
@ApiModel(value = "PmsProductLadder对象", description = "商品阶梯价格表")
public class PmsProductLadder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("阶梯价格编号;阶梯价格编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("满足阶梯价格的商品数量;满足阶梯价格的商品数量")
    private Integer count;

    @ApiModelProperty("折扣;折扣")
    private BigDecimal discount;

    @ApiModelProperty("折后价;折后价")
    private BigDecimal price;


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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PmsProductLadder{" +
        "id=" + id +
        ", productId=" + productId +
        ", count=" + count +
        ", discount=" + discount +
        ", price=" + price +
        "}";
    }
}
