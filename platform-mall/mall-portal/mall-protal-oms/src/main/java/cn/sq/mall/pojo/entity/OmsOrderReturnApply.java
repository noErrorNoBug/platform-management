package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单退货申请表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("oms_order_return_apply")
@ApiModel(value = "OmsOrderReturnApply对象", description = "订单退货申请表")
public class OmsOrderReturnApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单退货申请编号;订单退货申请编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单id;订单id")
    private Long orderId;

    @ApiModelProperty("公司收货地址表编号;公司收货地址表编号")
    private Long companyAddressId;

    @ApiModelProperty("退货商品编号;退货商品编号")
    private Long productId;

    @ApiModelProperty("订单编号;订单编号")
    private String orderSn;

    @ApiModelProperty("退货申请时间;退货申请时间")
    private LocalDateTime createTime;

    @ApiModelProperty("会员用户名;会员用户名")
    private String memberUsername;

    @ApiModelProperty("退款金额;退款金额")
    private BigDecimal returnAmount;

    @ApiModelProperty("退货人姓名;退货人姓名")
    private String returnName;

    @ApiModelProperty("退货人电话;退货人电话")
    private String returnPhone;

    @ApiModelProperty("退货申请状态;退货申请状态")
    private Integer status;

    @ApiModelProperty("处理时间;处理时间")
    private LocalDateTime handleTime;

    @ApiModelProperty("商品图片;商品图片")
    private String productPic;

    @ApiModelProperty("商品名称;商品名称")
    private String productName;

    @ApiModelProperty("商品品牌;商品品牌")
    private String productBrand;

    @ApiModelProperty("商品销售属性;颜色：红色；尺码：xl;")
    private String productAttr;

    @ApiModelProperty("退订数量;退订数量")
    private Integer productCount;

    @ApiModelProperty("商品单价;商品单价")
    private BigDecimal productPrice;

    @ApiModelProperty("商品实际支付价;商品实际支付价")
    private BigDecimal productRealPrice;

    @ApiModelProperty("退订原因;退订原因")
    private String reason;

    @ApiModelProperty("退订原因描述;退订原因描述")
    private String description;

    @ApiModelProperty("图片凭证;图片凭证，逗号隔开")
    private String proofPics;

    @ApiModelProperty("处理备注;处理备注")
    private String handleNote;

    @ApiModelProperty("处理人员;处理人员")
    private String handleMan;

    @ApiModelProperty("收货人;收货人")
    private String receiveMan;

    @ApiModelProperty("收货时间;收货时间")
    private LocalDateTime receiveTime;

    @ApiModelProperty("收货备注;收货备注")
    private String receiveNote;


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

    public Long getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(Long companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnPhone() {
        return returnPhone;
    }

    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(LocalDateTime handleTime) {
        this.handleTime = handleTime;
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

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductRealPrice() {
        return productRealPrice;
    }

    public void setProductRealPrice(BigDecimal productRealPrice) {
        this.productRealPrice = productRealPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProofPics() {
        return proofPics;
    }

    public void setProofPics(String proofPics) {
        this.proofPics = proofPics;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReceiveNote() {
        return receiveNote;
    }

    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote;
    }

    @Override
    public String toString() {
        return "OmsOrderReturnApply{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", companyAddressId=" + companyAddressId +
        ", productId=" + productId +
        ", orderSn=" + orderSn +
        ", createTime=" + createTime +
        ", memberUsername=" + memberUsername +
        ", returnAmount=" + returnAmount +
        ", returnName=" + returnName +
        ", returnPhone=" + returnPhone +
        ", status=" + status +
        ", handleTime=" + handleTime +
        ", productPic=" + productPic +
        ", productName=" + productName +
        ", productBrand=" + productBrand +
        ", productAttr=" + productAttr +
        ", productCount=" + productCount +
        ", productPrice=" + productPrice +
        ", productRealPrice=" + productRealPrice +
        ", reason=" + reason +
        ", description=" + description +
        ", proofPics=" + proofPics +
        ", handleNote=" + handleNote +
        ", handleMan=" + handleMan +
        ", receiveMan=" + receiveMan +
        ", receiveTime=" + receiveTime +
        ", receiveNote=" + receiveNote +
        "}";
    }
}
