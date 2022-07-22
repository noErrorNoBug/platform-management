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
 * 订单商品信息表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("oms_order_item")
@ApiModel(value = "OmsOrderItem对象", description = "订单商品信息表")
public class OmsOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单商品编号;订单商品编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单id;订单id")
    private Long orderId;

    @ApiModelProperty("订单编号;订单编号")
    private String orderSn;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("商品图片地址;商品图片地址")
    private String productPic;

    @ApiModelProperty("商品名称;商品名称")
    private String productName;

    @ApiModelProperty("商品品牌;商品品牌")
    private String productBrand;

    @ApiModelProperty("商品条码;商品条码")
    private String productSn;

    @ApiModelProperty("销售价格;销售价格")
    private BigDecimal productPrice;

    @ApiModelProperty("购买数量;购买数量")
    private Integer productQuantity;

    @ApiModelProperty("sku编号;sku编号")
    private Long productSkuId;

    @ApiModelProperty("sku编码;sku编码")
    private String productSkuCode;

    @ApiModelProperty("商品分类id;商品分类id")
    private Long productCategoryId;

    @ApiModelProperty("商品的销售属性1;商品的销售属性1")
    private String sp1;

    @ApiModelProperty("商品的销售属性2;商品的销售属性2")
    private String sp2;

    @ApiModelProperty("商品的销售属性3;商品的销售属性3")
    private String sp3;

    @ApiModelProperty("商品促销活动名称;商品促销活动名称")
    private String promotionName;

    @ApiModelProperty("商品促销分解金额;商品促销分解金额")
    private BigDecimal promotionAmount;

    @ApiModelProperty("优惠券优惠分解金额;优惠券优惠分解金额")
    private BigDecimal couponAmount;

    @ApiModelProperty("积分优惠分解金额;积分优惠分解金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty("该商品经过优惠后的分解金额;该商品经过优惠后的分解金额")
    private BigDecimal realAmount;

    @ApiModelProperty("商品赠送积分;商品赠送积分")
    private Integer giftIntegration;

    @ApiModelProperty("商品赠送成长值;商品赠送成长值")
    private Integer giftGrowth;

    @ApiModelProperty("商品销售属性:;商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]")
    private String productAttr;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
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

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getGiftIntegration() {
        return giftIntegration;
    }

    public void setGiftIntegration(Integer giftIntegration) {
        this.giftIntegration = giftIntegration;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    @Override
    public String toString() {
        return "OmsOrderItem{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", orderSn=" + orderSn +
        ", productId=" + productId +
        ", productPic=" + productPic +
        ", productName=" + productName +
        ", productBrand=" + productBrand +
        ", productSn=" + productSn +
        ", productPrice=" + productPrice +
        ", productQuantity=" + productQuantity +
        ", productSkuId=" + productSkuId +
        ", productSkuCode=" + productSkuCode +
        ", productCategoryId=" + productCategoryId +
        ", sp1=" + sp1 +
        ", sp2=" + sp2 +
        ", sp3=" + sp3 +
        ", promotionName=" + promotionName +
        ", promotionAmount=" + promotionAmount +
        ", couponAmount=" + couponAmount +
        ", integrationAmount=" + integrationAmount +
        ", realAmount=" + realAmount +
        ", giftIntegration=" + giftIntegration +
        ", giftGrowth=" + giftGrowth +
        ", productAttr=" + productAttr +
        "}";
    }
}
