package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product")
@ApiModel(value = "PmsProduct对象", description = "商品表")
public class PmsProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品编号;商品编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("品牌编号;品牌编号")
    private Long brandId;

    @ApiModelProperty("品牌分类编号;品牌分类编号")
    private Long productCategoryId;

    @ApiModelProperty("运费模板编号;运费模板编号")
    private Long feightTemplateId;

    @ApiModelProperty("品牌属性分类编号;品牌属性分类编号")
    private Long productAttributeCategoryId;

    @ApiModelProperty("商品名称;商品名称")
    private String name;

    @ApiModelProperty("商品图片;商品图片")
    private String pic;

    @ApiModelProperty("货号;货号")
    private String productSn;

    @ApiModelProperty("逻辑删除状态;逻辑删除状态")
    private Integer deleteStatus;

    @ApiModelProperty("上架状态;是否上架")
    private Integer publishStatus;

    @ApiModelProperty("新品状态;是否新品")
    private Integer newStatus;

    @ApiModelProperty("推荐状态;是否推荐")
    private Integer recommandStatus;

    @ApiModelProperty("审核状态;审核状态")
    private Integer verifyStatus;

    @ApiModelProperty("排序;排序")
    private Integer sort;

    @ApiModelProperty("销量;销量")
    private Integer sale;

    @ApiModelProperty("商品价格;价格")
    private BigDecimal price;

    @ApiModelProperty("促销价格;促销价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty("赠送的成长值;赠送的成长值")
    private Integer giftGrowth;

    @ApiModelProperty("赠送的积分;赠送的积分")
    private Integer giftPoint;

    @ApiModelProperty("限制使用的积分数;限制使用的积分数")
    private Integer usePointLimit;

    @ApiModelProperty("副标题;副标题")
    private String subTitle;

    @ApiModelProperty("商品描述;商品描述")
    private String description;

    @ApiModelProperty("市场价;市场价")
    private BigDecimal originalPrice;

    @ApiModelProperty("库存;库存")
    private Integer stock;

    @ApiModelProperty("库存预警值;库存预警值")
    private Integer lowStock;

    @ApiModelProperty("单位;单位")
    private String unit;

    @ApiModelProperty("商品重量;商品重量，默认克")
    private BigDecimal weight;

    @ApiModelProperty("是否为预告商品;是否为预告商品")
    private Integer previewStatus;

    @ApiModelProperty("产品服务id;以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String serviceIds;

    @ApiModelProperty("关键字;关键字")
    private String keywords;

    @ApiModelProperty("备注;备注")
    private String note;

    @ApiModelProperty("画册图片;连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @ApiModelProperty("详情标题;详情标题")
    private String detailTitle;

    @ApiModelProperty("详情描述;详情描述")
    private String detailDesc;

    @ApiModelProperty("产品详情网页内容;产品详情网页内容")
    private String detailHtml;

    @ApiModelProperty("移动端网页详情;移动端网页详情")
    private String detailMobileHtml;

    @ApiModelProperty("促销开始时间;促销开始时间")
    private LocalDateTime promotionStartTime;

    @ApiModelProperty("促销结束时间;促销结束时间")
    private LocalDateTime promotionEndTime;

    @ApiModelProperty("活动限购数量;活动限购数量")
    private Integer promotionPerLimit;

    @ApiModelProperty("促销类型;促销类型")
    private Integer promotionType;

    @ApiModelProperty("产品分类名称;产品分类名称")
    private String productCategoryName;

    @ApiModelProperty("品牌名称;品牌名称")
    private String brandName;


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

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getFeightTemplateId() {
        return feightTemplateId;
    }

    public void setFeightTemplateId(Long feightTemplateId) {
        this.feightTemplateId = feightTemplateId;
    }

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    public Integer getUsePointLimit() {
        return usePointLimit;
    }

    public void setUsePointLimit(Integer usePointLimit) {
        this.usePointLimit = usePointLimit;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getPreviewStatus() {
        return previewStatus;
    }

    public void setPreviewStatus(Integer previewStatus) {
        this.previewStatus = previewStatus;
    }

    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml;
    }

    public LocalDateTime getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(LocalDateTime promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public LocalDateTime getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(LocalDateTime promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "PmsProduct{" +
        "id=" + id +
        ", brandId=" + brandId +
        ", productCategoryId=" + productCategoryId +
        ", feightTemplateId=" + feightTemplateId +
        ", productAttributeCategoryId=" + productAttributeCategoryId +
        ", name=" + name +
        ", pic=" + pic +
        ", productSn=" + productSn +
        ", deleteStatus=" + deleteStatus +
        ", publishStatus=" + publishStatus +
        ", newStatus=" + newStatus +
        ", recommandStatus=" + recommandStatus +
        ", verifyStatus=" + verifyStatus +
        ", sort=" + sort +
        ", sale=" + sale +
        ", price=" + price +
        ", promotionPrice=" + promotionPrice +
        ", giftGrowth=" + giftGrowth +
        ", giftPoint=" + giftPoint +
        ", usePointLimit=" + usePointLimit +
        ", subTitle=" + subTitle +
        ", description=" + description +
        ", originalPrice=" + originalPrice +
        ", stock=" + stock +
        ", lowStock=" + lowStock +
        ", unit=" + unit +
        ", weight=" + weight +
        ", previewStatus=" + previewStatus +
        ", serviceIds=" + serviceIds +
        ", keywords=" + keywords +
        ", note=" + note +
        ", albumPics=" + albumPics +
        ", detailTitle=" + detailTitle +
        ", detailDesc=" + detailDesc +
        ", detailHtml=" + detailHtml +
        ", detailMobileHtml=" + detailMobileHtml +
        ", promotionStartTime=" + promotionStartTime +
        ", promotionEndTime=" + promotionEndTime +
        ", promotionPerLimit=" + promotionPerLimit +
        ", promotionType=" + promotionType +
        ", productCategoryName=" + productCategoryName +
        ", brandName=" + brandName +
        "}";
    }
}
