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
 * 订单操作记录表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("oms_order_operate_history")
@ApiModel(value = "OmsOrderOperateHistory对象", description = "订单操作记录表")
public class OmsOrderOperateHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("操作记录编号;操作记录编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单id;订单id")
    private Long orderId;

    @ApiModelProperty("操作人;操作人/后台系统/管理员相关信息")
    private String operateMan;

    @ApiModelProperty("操作时间;操作时间")
    private LocalDateTime createTime;

    @ApiModelProperty("订单状态;订单状态")
    private Integer orderStatus;

    @ApiModelProperty("备注;备注")
    private String note;


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

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OmsOrderOperateHistory{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", operateMan=" + operateMan +
        ", createTime=" + createTime +
        ", orderStatus=" + orderStatus +
        ", note=" + note +
        "}";
    }
}
