package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 专题商品关系表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("cms_subject_product_relation")
@ApiModel(value = "CmsSubjectProductRelation对象", description = "专题商品关系表")
public class CmsSubjectProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("关系表编号;关系表编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("专题编号;专题编号")
    private Long subjectId;

    @ApiModelProperty("商品编号;商品编号")
    private Long productId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CmsSubjectProductRelation{" +
        "id=" + id +
        ", subjectId=" + subjectId +
        ", productId=" + productId +
        "}";
    }
}
