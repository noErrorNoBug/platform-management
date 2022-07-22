package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.OmsOrderOperateHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单操作记录表 Mapper 接口
 * </p>
 *
 * @author sunqiang
 * @since 2022-07-14
 */
@Mapper
public interface OmsOrderOperateHistoryMapper extends BaseMapper<OmsOrderOperateHistory> {

    /**
     * 插入集合
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<OmsOrderOperateHistory> list);
}
