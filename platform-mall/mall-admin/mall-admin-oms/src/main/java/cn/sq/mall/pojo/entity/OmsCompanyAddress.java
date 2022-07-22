package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 公司收货地址表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("oms_company_address")
@ApiModel(value = "OmsCompanyAddress对象", description = "公司收货地址表")
public class OmsCompanyAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收货地址编号;收货地址编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("地址名称;地址名称")
    private String addressName;

    @ApiModelProperty("是否默认发货地址;是否默认发货地址")
    private Integer sendStatus;

    @ApiModelProperty("是否默认收货地址;是否默认收货地址")
    private Integer receiveStatus;

    @ApiModelProperty("收发货人名称;收发货人名称")
    private String name;

    @ApiModelProperty("收货人电话;收货人电话")
    private String phone;

    @ApiModelProperty("省;省")
    private String province;

    @ApiModelProperty("市;市")
    private String city;

    @ApiModelProperty("区/县;区/县")
    private String region;

    @ApiModelProperty("详细地址;详细地址")
    private String detailAddress;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public String toString() {
        return "OmsCompanyAddress{" +
        "id=" + id +
        ", addressName=" + addressName +
        ", sendStatus=" + sendStatus +
        ", receiveStatus=" + receiveStatus +
        ", name=" + name +
        ", phone=" + phone +
        ", province=" + province +
        ", city=" + city +
        ", region=" + region +
        ", detailAddress=" + detailAddress +
        "}";
    }
}
