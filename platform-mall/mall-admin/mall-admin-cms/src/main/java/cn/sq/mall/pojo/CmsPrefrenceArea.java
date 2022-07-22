package cn.sq.mall.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 优选专区表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("cms_prefrence_area")
@ApiModel(value = "CmsPrefrenceArea对象", description = "优选专区表")
public class CmsPrefrenceArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("专区编号;专区编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("专区名称;专区名称")
    private String name;

    @ApiModelProperty("副标题;副标题")
    private String subTitle;

    @ApiModelProperty("展示图片;展示图片")
    private String pic;

    @ApiModelProperty("排序;排序")
    private Integer sort;

    @ApiModelProperty("显示状态;显示状态")
    private Integer showStatus;


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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    @Override
    public String toString() {
        return "CmsPrefrenceArea{" +
        "id=" + id +
        ", name=" + name +
        ", subTitle=" + subTitle +
        ", pic=" + pic +
        ", sort=" + sort +
        ", showStatus=" + showStatus +
        "}";
    }
}
