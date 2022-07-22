package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.UmsRoleMenuRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台角色菜单关系表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface UmsRoleMenuRelationMapper extends BaseMapper<UmsRoleMenuRelation> {

    /**
     * 插入集合
     * @param list 关系集合
     * @return
     */
    int insertAll(@Param("list") List<UmsRoleMenuRelation> list);
}
