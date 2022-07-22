package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 首页品牌推荐表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_home_brand")
@ApiModel(value = "SmsHomeBrand对象", description = "首页品牌推荐表")
public class SmsHomeBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("首页推荐编号;首页推荐编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品品牌编号;商品品牌编号")
    private Long brandId;

    @ApiModelProperty("商品品牌名称;商品品牌名称")
    private String brandName;

    @ApiModelProperty("是否推荐;是否推荐")
    private Integer recommendStatus;

    @ApiModelProperty("排序")
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
        return "SmsHomeBrand{" +
        "id=" + id +
        ", brandId=" + brandId +
        ", brandName=" + brandName +
        ", recommendStatus=" + recommendStatus +
        ", sort=" + sort +
        "}";
    }
}
