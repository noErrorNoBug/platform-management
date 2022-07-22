package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 首页专题推荐商品表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("sms_home_recommend_subject")
@ApiModel(value = "SmsHomeRecommendSubject对象", description = "首页专题推荐商品表")
public class SmsHomeRecommendSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("首页专题推荐编号;首页专题推荐编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("专题编号;专题编号")
    private Long subjectId;

    @ApiModelProperty("专题名称;专题名称")
    private String subjectName;

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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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
        return "SmsHomeRecommendSubject{" +
        "id=" + id +
        ", subjectId=" + subjectId +
        ", subjectName=" + subjectName +
        ", recommendStatus=" + recommendStatus +
        ", sort=" + sort +
        "}";
    }
}
