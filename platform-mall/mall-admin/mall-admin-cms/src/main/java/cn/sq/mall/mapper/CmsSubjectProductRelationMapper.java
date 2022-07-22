package cn.sq.mall.mapper;

import cn.sq.mall.pojo.CmsSubjectProductRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 专题商品关系表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-20
 */
@Mapper
public interface CmsSubjectProductRelationMapper extends BaseMapper<CmsSubjectProductRelation> {
    /**
     * 批量插入专题商品关系
     * @param list
     * @return
     */
    int insertAll(@Param("list")List<CmsSubjectProductRelation> list);
}
