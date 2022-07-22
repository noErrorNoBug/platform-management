package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.SmsFlashPromotionProductRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 限时购与商品关系表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface SmsFlashPromotionProductRelationMapper extends BaseMapper<SmsFlashPromotionProductRelation> {
    int insertAll(@Param("list") List<SmsFlashPromotionProductRelation> list);
}
