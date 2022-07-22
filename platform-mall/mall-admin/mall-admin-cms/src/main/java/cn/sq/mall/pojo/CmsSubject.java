package cn.sq.mall.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 专题表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("cms_subject")
@ApiModel(value = "CmsSubject对象", description = "专题表")
public class CmsSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("专题编号;专题编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("专题分类编号;专题分类编号")
    private Long categoryId;

    @ApiModelProperty("专题分类名称;专题分类名称")
    private String categoryName;

    @ApiModelProperty("专题标题;专题标题")
    private String title;

    @ApiModelProperty("专题主图;专题主图")
    private String pic;

    @ApiModelProperty("关联产品数量;关联产品数量")
    private Integer productCount;

    @ApiModelProperty("推荐状态;是否推荐")
    private Integer recommendStatus;

    @ApiModelProperty("创建时间;创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("收藏数量;收藏数量")
    private Integer collectCount;

    @ApiModelProperty("阅读量;阅读量")
    private Integer readCount;

    @ApiModelProperty("评论量;评论量")
    private Integer commentCount;

    @ApiModelProperty("转发数量;转发数量")
    private Integer forwardCount;

    @ApiModelProperty("画册图片;画册图片")
    private String albumPics;

    @ApiModelProperty("专题描述;专题描述")
    private String description;

    @ApiModelProperty("显示状态;是否显示")
    private Integer showStatus;

    @ApiModelProperty("专题内容;专题内容")
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }

    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CmsSubject{" +
        "id=" + id +
        ", categoryId=" + categoryId +
        ", categoryName=" + categoryName +
        ", title=" + title +
        ", pic=" + pic +
        ", productCount=" + productCount +
        ", recommendStatus=" + recommendStatus +
        ", createTime=" + createTime +
        ", collectCount=" + collectCount +
        ", readCount=" + readCount +
        ", commentCount=" + commentCount +
        ", forwardCount=" + forwardCount +
        ", albumPics=" + albumPics +
        ", description=" + description +
        ", showStatus=" + showStatus +
        ", content=" + content +
        "}";
    }
}
