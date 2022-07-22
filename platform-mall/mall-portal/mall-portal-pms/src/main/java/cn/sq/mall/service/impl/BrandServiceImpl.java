package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.BrandHomeDao;
import cn.sq.mall.mapper.PmsBrandMapper;
import cn.sq.mall.mapper.PmsProductMapper;
import cn.sq.mall.pojo.entity.PmsBrand;
import cn.sq.mall.pojo.entity.PmsProduct;
import cn.sq.mall.service.BrandService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunqiang
 * @version 1.0
 * @description 品牌管理
 * @date 2022/7/16 15:38
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private BrandHomeDao dao;

    /**
     * 分页获取品牌推荐
     *
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页条数
     *
     * @return
     */
    @Override
    public PageResponse list(Integer pageNum, Integer pageSize) {
        Page<PmsBrand> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsBrand> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("hb.sort");
        page = dao.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 分页获取品牌下商品清单
     *
     * @param brandId
     *         品牌编号
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页条数
     *
     * @return
     */
    @Override
    public PageResponse products(Long brandId, Integer pageNum, Integer pageSize) {
        Page<PmsProduct> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        wrapper.eq("brand_id", brandId)
                .eq("delete_status", 0);
        page = productMapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 获取品牌详情
     *
     * @param id
     *         品牌编号
     *
     * @return
     */
    @Override
    public PmsBrand getItem(Long id) {
        return brandMapper.selectById(id);
    }
}
