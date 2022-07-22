package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品会员价格表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_member_price")
@ApiModel(value = "PmsMemberPrice对象", description = "商品会员价格表")
public class PmsMemberPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("会员价格编号;会员价格编号")
    private Long id;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("会员等级编号;会员等级编号")
    private Long memberLevelId;

    @ApiModelProperty("会员价格;会员价格")
    private BigDecimal memberPrice;

    @ApiModelProperty("会员等级名称;会员等级名称")
    private String memberLevelName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public String getMemberLevelName() {
        return memberLevelName;
    }

    public void setMemberLevelName(String memberLevelName) {
        this.memberLevelName = memberLevelName;
    }

    @Override
    public String toString() {
        return "PmsMemberPrice{" +
        "id=" + id +
        ", productId=" + productId +
        ", memberLevelId=" + memberLevelId +
        ", memberPrice=" + memberPrice +
        ", memberLevelName=" + memberLevelName +
        "}";
    }
}
