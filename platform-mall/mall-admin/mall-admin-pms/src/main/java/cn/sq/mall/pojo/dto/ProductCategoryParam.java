package cn.sq.mall.pojo.dto;

import cn.sq.platform.core.annotations.StatusValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品分类参数
 * @date 2022/7/14 23:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductCategoryParam {
    @ApiModelProperty("父分类的编号")
    private Long parentId;
    @NotBlank
    @ApiModelProperty(value = "商品分类名称",required = true)
    private String name;
    @ApiModelProperty("分类单位")
    private String productUnit;
    @StatusValidator(value = {"0","1"},message = "导航栏显示状态只能为0或1")
    @ApiModelProperty("是否在导航栏显示")
    private Integer navStatus;
    @StatusValidator(value = {"0","1"},message = "显示状态只能为0或1")
    @ApiModelProperty("是否进行显示")
    private Integer showStatus;
    @Min(value = 0)
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("关键字")
    private String keywords;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("产品相关筛选属性集合")
    private List<Long> productAttributeIdList;
}
