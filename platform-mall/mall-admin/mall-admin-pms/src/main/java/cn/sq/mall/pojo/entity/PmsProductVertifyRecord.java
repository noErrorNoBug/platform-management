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
 * 商品审核记录表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("pms_product_vertify_record")
@ApiModel(value = "PmsProductVertifyRecord对象", description = "商品审核记录表")
public class PmsProductVertifyRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("审核记录编号;审核记录编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;

    @ApiModelProperty("创建时间;创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("审核员;审核员")
    private String vertifyMan;

    @ApiModelProperty("审核状态;审核状态")
    private Integer status;

    @ApiModelProperty("审核反馈;审核反馈")
    private String detail;


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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getVertifyMan() {
        return vertifyMan;
    }

    public void setVertifyMan(String vertifyMan) {
        this.vertifyMan = vertifyMan;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "PmsProductVertifyRecord{" +
        "id=" + id +
        ", productId=" + productId +
        ", createTime=" + createTime +
        ", vertifyMan=" + vertifyMan +
        ", status=" + status +
        ", detail=" + detail +
        "}";
    }
}
