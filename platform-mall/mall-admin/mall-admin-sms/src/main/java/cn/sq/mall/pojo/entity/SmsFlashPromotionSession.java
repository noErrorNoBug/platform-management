package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 限时购场次表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_flash_promotion_session")
@ApiModel(value = "SmsFlashPromotionSession对象", description = "限时购场次表")
public class SmsFlashPromotionSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("限时购场次编号;限时购场次编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("场次名称;场次名称")
    private String name;

    @ApiModelProperty("每日开始时间;每日开始时间")
    private LocalTime startTime;

    @ApiModelProperty("每日结束时间;每日结束时间")
    private LocalTime endTime;

    @ApiModelProperty("启用状态;启用状态")
    private Integer status;

    @ApiModelProperty("创建时间;创建时间")
    private LocalDateTime createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SmsFlashPromotionSession{" +
        "id=" + id +
        ", name=" + name +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status=" + status +
        ", createTime=" + createTime +
        "}";
    }
}
