package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsProductVertifyRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 商品审核记录表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface PmsProductVertifyRecordMapper extends BaseMapper<PmsProductVertifyRecord> {

    /**
     * 批量插入审核记录
     * @param list 审核记录列表
     * @return
     */
    int insertAll(List<PmsProductVertifyRecord> list);
}
