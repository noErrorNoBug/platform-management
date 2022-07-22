package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 限时购与商品关系表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_flash_promotion_product_relation")
@ApiModel(value = "SmsFlashPromotionProductRelation对象", description = "限时购与商品关系表")
public class SmsFlashPromotionProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("关系表编号;关系表编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("限时购编号;限时购编号")
    private Long flashPromotionId;

    @ApiModelProperty("限时购场次编号;限时购场次编号")
    private Long flashPromotionSessionId;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("限时购价格;限时购价格")
    private BigDecimal flashPromotionPrice;

    @ApiModelProperty("限时购数量;限时购数量")
    private Integer flashPromotionCount;

    @ApiModelProperty("每人限购数量;每人限购数量")
    private Integer flashPromotionLimit;

    @ApiModelProperty("排序;排序")
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlashPromotionId() {
        return flashPromotionId;
    }

    public void setFlashPromotionId(Long flashPromotionId) {
        this.flashPromotionId = flashPromotionId;
    }

    public Long getFlashPromotionSessionId() {
        return flashPromotionSessionId;
    }

    public void setFlashPromotionSessionId(Long flashPromotionSessionId) {
        this.flashPromotionSessionId = flashPromotionSessionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getFlashPromotionPrice() {
        return flashPromotionPrice;
    }

    public void setFlashPromotionPrice(BigDecimal flashPromotionPrice) {
        this.flashPromotionPrice = flashPromotionPrice;
    }

    public Integer getFlashPromotionCount() {
        return flashPromotionCount;
    }

    public void setFlashPromotionCount(Integer flashPromotionCount) {
        this.flashPromotionCount = flashPromotionCount;
    }

    public Integer getFlashPromotionLimit() {
        return flashPromotionLimit;
    }

    public void setFlashPromotionLimit(Integer flashPromotionLimit) {
        this.flashPromotionLimit = flashPromotionLimit;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SmsFlashPromotionProductRelation{" +
        "id=" + id +
        ", flashPromotionId=" + flashPromotionId +
        ", flashPromotionSessionId=" + flashPromotionSessionId +
        ", productId=" + productId +
        ", flashPromotionPrice=" + flashPromotionPrice +
        ", flashPromotionCount=" + flashPromotionCount +
        ", flashPromotionLimit=" + flashPromotionLimit +
        ", sort=" + sort +
        "}";
    }
}
