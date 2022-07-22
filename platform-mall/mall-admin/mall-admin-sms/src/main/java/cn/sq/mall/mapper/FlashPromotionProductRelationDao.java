package cn.sq.mall.mapper;

import cn.sq.mall.pojo.dto.FlashPromotionProduct;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunqiang
 * @version 1.0
 * @description 限时购关联表多表查询
 * @date 2022/7/17 20:36
 */
@Mapper
public interface FlashPromotionProductRelationDao {

    Page<FlashPromotionProduct> getList(Page<FlashPromotionProduct> page, @Param("flashPromotionId") Long flashPromotionId, @Param("flashPromotionSessionId") Long flashPromotionSessionId);
}
