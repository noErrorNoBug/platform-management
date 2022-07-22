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
 * 首页轮播广告表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_home_advertise")
@ApiModel(value = "SmsHomeAdvertise对象", description = "首页轮播广告表")
public class SmsHomeAdvertise implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("轮播广告编号;轮播广告编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("名称;名称")
    private String name;

    @ApiModelProperty("轮播位置;轮播位置")
    private Integer type;

    @ApiModelProperty("图片地址;图片地址")
    private String pic;

    @ApiModelProperty("开始时间;开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("结束时间;结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("是否上线;是否上线")
    private Integer status;

    @ApiModelProperty("点击数;点击数")
    private Integer clickCount;

    @ApiModelProperty("下单数;下单数")
    private Integer orderCount;

    @ApiModelProperty("链接地址;链接地址")
    private String url;

    @ApiModelProperty("备注;备注")
    private String note;

    @ApiModelProperty("排序;排序")
    private Integer sort;


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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SmsHomeAdvertise{" +
        "id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", pic=" + pic +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status=" + status +
        ", clickCount=" + clickCount +
        ", orderCount=" + orderCount +
        ", url=" + url +
        ", note=" + note +
        ", sort=" + sort +
        "}";
    }
}
