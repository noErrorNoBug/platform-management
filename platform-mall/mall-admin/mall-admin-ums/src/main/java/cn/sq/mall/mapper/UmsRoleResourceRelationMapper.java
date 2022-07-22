package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.UmsRoleResourceRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台角色资源关系表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface UmsRoleResourceRelationMapper extends BaseMapper<UmsRoleResourceRelation> {

    int insertAll(@Param("list") List<UmsRoleResourceRelation> list);
}
