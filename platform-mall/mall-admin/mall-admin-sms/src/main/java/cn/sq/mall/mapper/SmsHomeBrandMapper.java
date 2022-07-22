package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.SmsHomeBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 首页品牌推荐表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface SmsHomeBrandMapper extends BaseMapper<SmsHomeBrand> {

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<SmsHomeBrand> list);
}
