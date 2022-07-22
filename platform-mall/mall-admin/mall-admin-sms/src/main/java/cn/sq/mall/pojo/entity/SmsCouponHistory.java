package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 优惠券历史记录表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_coupon_history")
@ApiModel(value = "SmsCouponHistory对象", description = "优惠券历史记录表")
public class SmsCouponHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("优惠券历史记录编号;优惠券历史记录编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("优惠券编号;优惠券编号")
    private Long couponId;

    @ApiModelProperty("会员编号;会员编号")
    private Long memberId;

    @ApiModelProperty("订单id;订单id")
    private Long orderId;

    @ApiModelProperty("优惠券码;优惠券码")
    private String couponCode;

    @ApiModelProperty("领取人昵称;领取人昵称")
    private String memberNickname;

    @ApiModelProperty("领取方式;领取方式")
    private Integer getType;

    @ApiModelProperty("创建时间;创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("使用状态;使用状态")
    private Integer useStatus;

    @ApiModelProperty("使用时间;使用时间")
    private LocalDateTime useTime;

    @ApiModelProperty("订单编号;订单编号")
    private String orderSn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public Integer getGetType() {
        return getType;
    }

    public void setGetType(Integer getType) {
        this.getType = getType;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public LocalDateTime getUseTime() {
        return useTime;
    }

    public void setUseTime(LocalDateTime useTime) {
        this.useTime = useTime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    @Override
    public String toString() {
        return "SmsCouponHistory{" +
        "id=" + id +
        ", couponId=" + couponId +
        ", memberId=" + memberId +
        ", orderId=" + orderId +
        ", couponCode=" + couponCode +
        ", memberNickname=" + memberNickname +
        ", getType=" + getType +
        ", createTime=" + createTime +
        ", useStatus=" + useStatus +
        ", useTime=" + useTime +
        ", orderSn=" + orderSn +
        "}";
    }
}
