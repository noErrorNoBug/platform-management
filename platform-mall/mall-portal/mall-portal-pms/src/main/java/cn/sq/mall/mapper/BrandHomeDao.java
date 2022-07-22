package cn.sq.mall.mapper;

import cn.sq.mall.pojo.entity.PmsBrand;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sunqiang
 * @version 1.0.0
 * @description 首页品牌多表查询
 * @date 2022/7/18 11:27
 */
@Mapper
public interface BrandHomeDao {

    /**
     * 分页查询首页品牌
     * @param page
     * @param wrapper
     * @return
     */
    Page selectPage(IPage<PmsBrand> page, QueryWrapper<PmsBrand> wrapper);
}
