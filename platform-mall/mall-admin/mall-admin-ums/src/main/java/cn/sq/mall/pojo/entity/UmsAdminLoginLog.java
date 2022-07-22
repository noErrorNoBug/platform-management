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
 * 后台用户登录日志表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("ums_admin_login_log")
@ApiModel(value = "UmsAdminLoginLog对象", description = "后台用户登录日志表")
public class UmsAdminLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志编号;日志编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("后台用户编号;后台用户编号")
    private Long adminId;

    @ApiModelProperty("登录时间;登录时间")
    private LocalDateTime createTime;

    @ApiModelProperty("登录ip;登录ip")
    private String ip;

    @ApiModelProperty("登录地址;登录地址")
    private String address;

    @ApiModelProperty("浏览器登录类型;浏览器登录类型")
    private String userAgent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "UmsAdminLoginLog{" +
        "id=" + id +
        ", adminId=" + adminId +
        ", createTime=" + createTime +
        ", ip=" + ip +
        ", address=" + address +
        ", userAgent=" + userAgent +
        "}";
    }
}
