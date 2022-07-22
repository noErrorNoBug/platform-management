package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsProductAttributeValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品属性值表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface PmsProductAttributeValueMapper extends BaseMapper<PmsProductAttributeValue> {

    /**
     * 批量插入商品属性值
     * @param productId 产品编号
     * @param list 商品属性值集合
     * @return
     */
    int insertAll(@Param("productId") long productId, @Param("list") List<PmsProductAttributeValue> list);
}
