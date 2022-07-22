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
 * 优惠券表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_coupon")
@ApiModel(value = "SmsCoupon对象", description = "优惠券表")
public class SmsCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("优惠券编号;优惠券编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("优惠券类型;优惠券类型")
    private Integer type;

    @ApiModelProperty("优惠券名称;优惠券名称")
    private String name;

    @ApiModelProperty("使用平台;使用平台")
    private Integer platform;

    @ApiModelProperty("数量;数量")
    private Integer count;

    @ApiModelProperty("金额;金额")
    private BigDecimal amount;

    @ApiModelProperty("每人限领数量;每人限领数量")
    private Integer perLimit;

    @ApiModelProperty("使用门槛;使用门槛，0元表示无门槛")
    private BigDecimal minPoint;

    @ApiModelProperty("开始使用时间;开始使用时间")
    private LocalDateTime startTime;

    @ApiModelProperty("结束使用时间;结束使用时间")
    private LocalDateTime endTime;

    @ApiModelProperty("使用类型;使用类型")
    private Integer useType;

    @ApiModelProperty("备注;备注")
    private String note;

    @ApiModelProperty("发行数量;发行数量")
    private Integer publishCount;

    @ApiModelProperty("已使用数量;已使用数量")
    private Integer useCount;

    @ApiModelProperty("领取数量;领取数量")
    private Integer receiveCount;

    @ApiModelProperty("可以领取的日期;可以领取的日期")
    private LocalDateTime enableTime;

    @ApiModelProperty("优惠码;优惠码")
    private String code;

    @ApiModelProperty("可领取的会员类型;0->无限制")
    private Integer memberLevel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getPerLimit() {
        return perLimit;
    }

    public void setPerLimit(Integer perLimit) {
        this.perLimit = perLimit;
    }

    public BigDecimal getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(BigDecimal minPoint) {
        this.minPoint = minPoint;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    public LocalDateTime getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(LocalDateTime enableTime) {
        this.enableTime = enableTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    @Override
    public String toString() {
        return "SmsCoupon{" +
        "id=" + id +
        ", type=" + type +
        ", name=" + name +
        ", platform=" + platform +
        ", count=" + count +
        ", amount=" + amount +
        ", perLimit=" + perLimit +
        ", minPoint=" + minPoint +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", useType=" + useType +
        ", note=" + note +
        ", publishCount=" + publishCount +
        ", useCount=" + useCount +
        ", receiveCount=" + receiveCount +
        ", enableTime=" + enableTime +
        ", code=" + code +
        ", memberLevel=" + memberLevel +
        "}";
    }
}
