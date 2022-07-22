package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.SmsHomeRecommendProductMapper;
import cn.sq.mall.pojo.entity.SmsHomeRecommendProduct;
import cn.sq.mall.service.HomeRecommendProductService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页人气推荐管理API
 * @date 2022/7/16 15:04
 */
@Service
public class HomeRecommendProductServiceImpl implements HomeRecommendProductService {
    @Autowired
    private SmsHomeRecommendProductMapper mapper;
    /**
     * 分页查询首页人气推荐
     *
     * @param productName
     *         人气推荐商品名称
     * @param recommendStatus
     *         推荐状态
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(String productName, Integer recommendStatus, Integer pageNum, Integer pageSize) {
        Page<SmsHomeRecommendProduct> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<SmsHomeRecommendProduct> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (StringUtils.isNotBlank(productName)) {
            wrapper.like("product_name",productName);
        }
        if (ObjectUtils.isNotEmpty(recommendStatus)) {
            wrapper.like("recommend_status",recommendStatus);
        }
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 批量添加首页人气推荐
     *
     * @param params
     *         品牌集合
     *
     * @return
     */
    @Override
    public int add(List<SmsHomeRecommendProduct> params) {
        params.stream().forEach(smsHomeBrand -> {
            smsHomeBrand.setSort(0);
            smsHomeBrand.setRecommendStatus(1);
        });
        return mapper.insertAll(params);
    }

    /**
     * 修改人气推荐排序
     *
     * @param id
     *         编号
     * @param sort
     *         排序
     *
     * @return
     */
    @Override
    public int update(Long id, Integer sort) {
        SmsHomeRecommendProduct product = new SmsHomeRecommendProduct();
        product.setId(id);
        product.setSort(sort);
        return mapper.updateById(product);
    }

    /**
     * 批量删除人气推荐
     *
     * @param ids
     *         编号集合
     *
     * @return
     */
    @Override
    public int delete(List<Long> ids) {
        return mapper.deleteBatchIds(ids);
    }

    /**
     * 批量修改人气推荐状态
     *
     * @param ids
     *         编号集合
     * @param status
     *         推荐状态
     *
     * @return
     */
    @Override
    public int status(List<Long> ids, Integer status) {
        SmsHomeRecommendProduct product = new SmsHomeRecommendProduct();
        product.setRecommendStatus(status);
        UpdateWrapper<SmsHomeRecommendProduct> wrapper = new UpdateWrapper<>();
        wrapper.in("id",ids);
        return mapper.update(product,wrapper);
    }
}
