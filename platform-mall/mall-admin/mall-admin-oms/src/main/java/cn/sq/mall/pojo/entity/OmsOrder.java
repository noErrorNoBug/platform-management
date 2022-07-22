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
 * 订单表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("oms_order")
@ApiModel(value = "OmsOrder对象", description = "订单表")
public class OmsOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id;订单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("会员编号;会员编号")
    private Long memberId;

    @ApiModelProperty("优惠券编号;优惠券编号")
    private Long couponId;

    @ApiModelProperty("订单编号;订单编号")
    private String orderSn;

    @ApiModelProperty("订单提交时间;订单提交时间")
    private LocalDateTime createTime;

    @ApiModelProperty("用户账号;用户账号")
    private String memberUsername;

    @ApiModelProperty("订单总金额;订单总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty("应付金额;应付金额")
    private BigDecimal payAmount;

    @ApiModelProperty("运费金额;运费金额")
    private BigDecimal freightAmount;

    @ApiModelProperty("促销优化金额;促销价、满减、阶梯价")
    private BigDecimal promotionAmount;

    @ApiModelProperty("积分抵扣金额;积分抵扣金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty("优惠券抵扣金额;优惠券抵扣金额")
    private BigDecimal couponAmount;

    @ApiModelProperty("管理员后台调整订单使用的折扣金额;管理员后台调整订单使用的折扣金额")
    private BigDecimal discountAmount;

    @ApiModelProperty("支付方式;支付方式")
    private Integer payType;

    @ApiModelProperty("订单来源;订单来源")
    private Integer sourceType;

    @ApiModelProperty("订单状态;订单状态")
    private Integer status;

    @ApiModelProperty("订单类型;订单类型")
    private Integer orderType;

    @ApiModelProperty("物流公司;物流公司")
    private String deliveryCompany;

    @ApiModelProperty("物流单号;物流单号")
    private String deliverySn;

    @ApiModelProperty("自动确认时间(天);自动确认时间(天)")
    private Integer autoConfirmDay;

    @ApiModelProperty("可获得积分;可获得积分")
    private Integer integration;

    @ApiModelProperty("可获得活动成长值;可获得活动成长值")
    private Integer growth;

    @ApiModelProperty("活动信息")
    private String promotionInfo;

    @ApiModelProperty("发票类型;发票类型")
    private Integer billType;

    @ApiModelProperty("发票抬头;发票抬头")
    private String billHeader;

    @ApiModelProperty("发票内容;发票内容")
    private String billContent;

    @ApiModelProperty("收票人电话;收票人电话")
    private String billReceiverPhone;

    @ApiModelProperty("收票人邮箱;收票人邮箱")
    private String billReceiverEmail;

    @ApiModelProperty("收货人姓名;收货人姓名")
    private String receiverName;

    @ApiModelProperty("收货人电话;收货人电话")
    private String receiverPhone;

    @ApiModelProperty("收货人邮编;收货人邮编")
    private String receiverPostCode;

    @ApiModelProperty("省份/直辖市;省份/直辖市")
    private String receiverProvince;

    @ApiModelProperty("城市;城市")
    private String receiverCity;

    @ApiModelProperty("区/县;区/县")
    private String receiverRegion;

    @ApiModelProperty("详细地址;详细地址")
    private String receiverDetailAddress;

    @ApiModelProperty("订单备注;订单备注")
    private String note;

    @ApiModelProperty("确认收货状态;确认收货状态")
    private Integer confirmStatus;

    @ApiModelProperty("订单删除状态;订单删除状态")
    private Integer deleteStatus;

    @ApiModelProperty("下单时使用的积分;下单时使用过的积分")
    private Integer useIntegration;

    @ApiModelProperty("支付时间;支付时间")
    private LocalDateTime paymentTime;

    @ApiModelProperty("发货时间;发货时间")
    private LocalDateTime deliveryTime;

    @ApiModelProperty("确认收货时间;确认收货时间")
    private LocalDateTime receiveTime;

    @ApiModelProperty("评价时间;评价时间")
    private LocalDateTime commentTime;

    @ApiModelProperty("修改时间;修改时间")
    private LocalDateTime modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getBillHeader() {
        return billHeader;
    }

    public void setBillHeader(String billHeader) {
        this.billHeader = billHeader;
    }

    public String getBillContent() {
        return billContent;
    }

    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }

    public String getBillReceiverPhone() {
        return billReceiverPhone;
    }

    public void setBillReceiverPhone(String billReceiverPhone) {
        this.billReceiverPhone = billReceiverPhone;
    }

    public String getBillReceiverEmail() {
        return billReceiverEmail;
    }

    public void setBillReceiverEmail(String billReceiverEmail) {
        this.billReceiverEmail = billReceiverEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "OmsOrder{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", couponId=" + couponId +
        ", orderSn=" + orderSn +
        ", createTime=" + createTime +
        ", memberUsername=" + memberUsername +
        ", totalAmount=" + totalAmount +
        ", payAmount=" + payAmount +
        ", freightAmount=" + freightAmount +
        ", promotionAmount=" + promotionAmount +
        ", integrationAmount=" + integrationAmount +
        ", couponAmount=" + couponAmount +
        ", discountAmount=" + discountAmount +
        ", payType=" + payType +
        ", sourceType=" + sourceType +
        ", status=" + status +
        ", orderType=" + orderType +
        ", deliveryCompany=" + deliveryCompany +
        ", deliverySn=" + deliverySn +
        ", autoConfirmDay=" + autoConfirmDay +
        ", integration=" + integration +
        ", growth=" + growth +
        ", promotionInfo=" + promotionInfo +
        ", billType=" + billType +
        ", billHeader=" + billHeader +
        ", billContent=" + billContent +
        ", billReceiverPhone=" + billReceiverPhone +
        ", billReceiverEmail=" + billReceiverEmail +
        ", receiverName=" + receiverName +
        ", receiverPhone=" + receiverPhone +
        ", receiverPostCode=" + receiverPostCode +
        ", receiverProvince=" + receiverProvince +
        ", receiverCity=" + receiverCity +
        ", receiverRegion=" + receiverRegion +
        ", receiverDetailAddress=" + receiverDetailAddress +
        ", note=" + note +
        ", confirmStatus=" + confirmStatus +
        ", deleteStatus=" + deleteStatus +
        ", useIntegration=" + useIntegration +
        ", paymentTime=" + paymentTime +
        ", deliveryTime=" + deliveryTime +
        ", receiveTime=" + receiveTime +
        ", commentTime=" + commentTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
