package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 人气推荐商品表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_home_recommend_product")
@ApiModel(value = "SmsHomeRecommendProduct对象", description = "人气推荐商品表")
public class SmsHomeRecommendProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("人气推荐编号;人气推荐编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("商品名称;商品名称")
    private String productName;

    @ApiModelProperty("是否推荐;是否推荐")
    private Integer recommendStatus;

    @ApiModelProperty("排序;排序")
    private Integer sort;


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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SmsHomeRecommendProduct{" +
        "id=" + id +
        ", productId=" + productId +
        ", productName=" + productName +
        ", recommendStatus=" + recommendStatus +
        ", sort=" + sort +
        "}";
    }
}
