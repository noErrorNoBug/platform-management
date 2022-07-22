package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.SmsHomeRecommendSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 首页专题推荐商品表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface SmsHomeRecommendSubjectMapper extends BaseMapper<SmsHomeRecommendSubject> {
    int insertAll(List<SmsHomeRecommendSubject> params);
}
