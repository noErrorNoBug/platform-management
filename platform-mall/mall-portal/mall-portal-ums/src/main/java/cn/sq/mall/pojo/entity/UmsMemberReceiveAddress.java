package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 会员收货地址表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("ums_member_receive_address")
@ApiModel(value = "UmsMemberReceiveAddress对象", description = "会员收货地址表")
public class UmsMemberReceiveAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("收货地址编号;收货地址编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("会员编号;会员编号")
    private Long memberId;

    @ApiModelProperty("收货人名称;收货人名称")
    private String name;

    @ApiModelProperty("收货人电话;收货人电话")
    private String phoneNumber;

    @ApiModelProperty("是否默认地址;是否默认地址")
    private Integer defaultStatus;

    @ApiModelProperty("邮编;邮编")
    private String postCode;

    @ApiModelProperty("省份;省份")
    private String province;

    @ApiModelProperty("城市;城市")
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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
        return "UmsMemberReceiveAddress{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", name=" + name +
        ", phoneNumber=" + phoneNumber +
        ", defaultStatus=" + defaultStatus +
        ", postCode=" + postCode +
        ", province=" + province +
        ", city=" + city +
        ", region=" + region +
        ", detailAddress=" + detailAddress +
        "}";
    }
}
