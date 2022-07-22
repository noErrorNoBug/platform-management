package cn.sq.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.sq.mall.pojo.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 优选专区和产品关系表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-20
 */
@Mapper
public interface CmsPrefrenceAreaProductRelationMapper extends BaseMapper<CmsPrefrenceAreaProductRelation> {
    int insertAll(@Param("list") List<CmsPrefrenceAreaProductRelation> list);
}
