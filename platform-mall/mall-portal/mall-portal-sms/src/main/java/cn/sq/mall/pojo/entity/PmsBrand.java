package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商品品牌表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_brand")
@ApiModel(value = "PmsBrand对象", description = "商品品牌表")
public class PmsBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号;品牌编号，自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("品牌名称;品牌名称")
    private String name;

    @ApiModelProperty("首字母;首字母")
    private String firstLetter;

    @ApiModelProperty("排序;排序")
    private Integer sort;

    @ApiModelProperty("是否是品牌制造商;是否是品牌制造商")
    private Integer factoryStatus;

    @ApiModelProperty("是否显示;是否显示")
    private Integer showStatus;

    @ApiModelProperty("产品数量;产品数量")
    private Integer productCount;

    @ApiModelProperty("产品评论数量;产品评论数量")
    private Integer productCommentCount;

    @ApiModelProperty("品牌logo;品牌logo位置")
    private String logo;

    @ApiModelProperty("专区大图;专区大图位置")
    private String bigPic;

    @ApiModelProperty("品牌故事;品牌故事")
    private String brandStory;


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

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getProductCommentCount() {
        return productCommentCount;
    }

    public void setProductCommentCount(Integer productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    @Override
    public String toString() {
        return "PmsBrand{" +
        "id=" + id +
        ", name=" + name +
        ", firstLetter=" + firstLetter +
        ", sort=" + sort +
        ", factoryStatus=" + factoryStatus +
        ", showStatus=" + showStatus +
        ", productCount=" + productCount +
        ", productCommentCount=" + productCommentCount +
        ", logo=" + logo +
        ", bigPic=" + bigPic +
        ", brandStory=" + brandStory +
        "}";
    }
}
