package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsProductCategoryAttributeRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 商品分类和属性关系表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface PmsProductCategoryAttributeRelationMapper extends BaseMapper<PmsProductCategoryAttributeRelation> {

    int insertAll(List<PmsProductCategoryAttributeRelation> relations);
}
