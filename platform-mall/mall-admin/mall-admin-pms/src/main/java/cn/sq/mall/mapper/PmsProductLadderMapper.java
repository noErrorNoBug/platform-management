package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsProductLadder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品阶梯价格表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface PmsProductLadderMapper extends BaseMapper<PmsProductLadder> {

    /**
     * 批量插入阶梯价格表
     * @param productId 商品编号
     * @param list 阶梯价格集合
     * @return
     */
    int insertAll(@Param("productId") long productId, @Param("list") List<PmsProductLadder> list);
}
