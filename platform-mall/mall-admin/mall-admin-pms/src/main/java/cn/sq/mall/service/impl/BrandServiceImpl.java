package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.PmsBrandMapper;
import cn.sq.mall.mapper.PmsProductMapper;
import cn.sq.mall.pojo.dto.BrandParam;
import cn.sq.mall.pojo.entity.PmsBrand;
import cn.sq.mall.pojo.entity.PmsProduct;
import cn.sq.mall.service.BrandService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 品牌管理服务
 * @date 2022/7/14 16:15
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    /**
     * 根据品牌名称分页获取品牌列表
     *
     * @param keyword 搜索关键字
     * @param pageNum 页码
     * @param pageSize 每页数量
     */
    @Override
    public PageResponse<PmsBrand> getRecords(String keyword, int pageNum, int pageSize) {
        Page<PmsBrand> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsBrand> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("name",keyword);
        }
        page = brandMapper.selectPage(page, wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据编号查询品牌信息
     *
     * @param id 品牌编号
     */
    @Override
    public PmsBrand getItem(Long id) {
        return brandMapper.selectById(id);
    }

    /**
     * 创建品牌
     *
     * @param brandParam 品牌参数
     */
    @Override
    public int add(BrandParam brandParam) {
        PmsBrand brand = new PmsBrand();
        BeanUtils.copyProperties(brandParam,brand);
        if (StringUtils.isBlank(brandParam.getFirstLetter())){
            setFistLetter(brand);
        }
        return brandMapper.insert(brand);
    }

    /**
     * 修改品牌
     *
     * @param id    品牌编号
     * @param brandParam    品牌参数
     */
    @Override
    public int update(Long id, BrandParam brandParam) {
        PmsBrand brand = new PmsBrand();
        BeanUtils.copyProperties(brandParam,brand);
        brand.setId(id);
        if (StringUtils.isNotBlank(brandParam.getFirstLetter())){
            setFistLetter(brand);
        }
        // 同时更新商品中的品牌名
        PmsProduct product = new PmsProduct();
        product.setBrandName(brand.getName());
        UpdateWrapper<PmsProduct> wrapper = new UpdateWrapper<>();
        wrapper.eq("brand_id",id);
        productMapper.update(product,wrapper);
        return brandMapper.updateById(brand);
    }

    /**
     * 删除品牌
     *
     * @param id    品牌编号
     */
    @Override
    public int delete(Long id) {
        return brandMapper.deleteById(id);
    }

    /**
     * 批量删除品牌
     *
     * @param ids   品牌编号集合
     */
    @Override
    public int deleteBatch(List<Long> ids) {
        return brandMapper.deleteBatchIds(ids);
    }

    /**
     * 批量更新显示状态 验证是否更新其他字段
     *
     * @param ids   品牌编号集合
     * @param showStatus    显示状态
     */
    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsBrand brand = new PmsBrand();
        brand.setShowStatus(showStatus);
        UpdateWrapper<PmsBrand> wrapper = new UpdateWrapper<>();
        wrapper.in("id" ,ids);
        return brandMapper.update(brand,wrapper);
    }

    /**
     * 批量更新厂家制造商状态 验证是否更新其他字段
     *
     * @param ids   品牌编号集合
     * @param factoryStatus 厂家制造商状态
     */
    @Override
    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        PmsBrand brand = new PmsBrand();
        brand.setFactoryStatus(factoryStatus);
        UpdateWrapper<PmsBrand> wrapper = new UpdateWrapper<>();
        wrapper.in("id" ,ids);
        return brandMapper.update(brand,wrapper);
    }

    /**
     * 设置首字母
     * @param brand 品牌实体
     */
    private void setFistLetter(PmsBrand brand) {
        if (StringUtils.isBlank(brand.getFirstLetter())) {
            brand.setFirstLetter(brand.getName().substring(0,1));
        }
    }
}
