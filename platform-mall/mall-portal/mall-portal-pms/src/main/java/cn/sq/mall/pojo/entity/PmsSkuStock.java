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
 * 商品sku表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_sku_stock")
@ApiModel(value = "PmsSkuStock对象", description = "商品sku表")
public class PmsSkuStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("sku编号;sku编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("产品编号;产品编号")
    private Long productId;

    @ApiModelProperty("sku编码;sku编码")
    private String skuCode;

    @ApiModelProperty("价格;价格")
    private BigDecimal price;

    @ApiModelProperty("库存;库存")
    private Integer stock;

    @ApiModelProperty("库存预警;库存预警")
    private Integer lowStock;

    @ApiModelProperty("规格属性1;规格属性1")
    private String sp1;

    @ApiModelProperty("规格属性2;规格属性2")
    private String sp2;

    @ApiModelProperty("规格属性3;规格属性3")
    private String sp3;

    @ApiModelProperty("图片展示;图片展示")
    private String pic;

    @ApiModelProperty("销量;销量")
    private Integer sale;

    @ApiModelProperty("单品促销价格;单品促销价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty("锁定库存;锁定库存")
    private Integer lockStock;

    @ApiModelProperty("商品销售属性;json格式")
    private String spData;


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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    public String getSpData() {
        return spData;
    }

    public void setSpData(String spData) {
        this.spData = spData;
    }

    @Override
    public String toString() {
        return "PmsSkuStock{" +
        "id=" + id +
        ", productId=" + productId +
        ", skuCode=" + skuCode +
        ", price=" + price +
        ", stock=" + stock +
        ", lowStock=" + lowStock +
        ", sp1=" + sp1 +
        ", sp2=" + sp2 +
        ", sp3=" + sp3 +
        ", pic=" + pic +
        ", sale=" + sale +
        ", promotionPrice=" + promotionPrice +
        ", lockStock=" + lockStock +
        ", spData=" + spData +
        "}";
    }
}
