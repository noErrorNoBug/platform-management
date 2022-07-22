package cn.sq.mall.pojo.dto;

import cn.sq.mall.pojo.entity.CmsSubject;
import cn.sq.mall.pojo.entity.PmsBrand;
import cn.sq.mall.pojo.entity.PmsProduct;
import cn.sq.mall.pojo.entity.SmsHomeAdvertise;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页内容
 * @date 2022/7/18 14:00
 */
@Getter
@Setter
public class HomeContentResult {
    @ApiModelProperty("轮播广告")
    private List<SmsHomeAdvertise> advertiseList;
    @ApiModelProperty("推荐品牌")
    private List<PmsBrand> brandList;
    @ApiModelProperty("当前秒杀场次")
    private HomeFlashPromotion homeFlashPromotion;
    @ApiModelProperty("新品推荐")
    private List<PmsProduct> newProductList;
    @ApiModelProperty("人气推荐")
    private List<PmsProduct> hotProductList;
    @ApiModelProperty("推荐专题")
    private List<CmsSubject> subjectList;
}
