package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.UmsResourceCategoryMapper;
import cn.sq.mall.pojo.entity.UmsResourceCategory;
import cn.sq.mall.service.ResourceCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台资源分类管理API
 * @date 2022/7/16 15:25
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {
    @Autowired
    private UmsResourceCategoryMapper mapper;

    /**
     * 查询所有后台资源分类
     *
     * @return
     */
    @Override
    public List<UmsResourceCategory> all() {
        QueryWrapper<UmsResourceCategory> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        wrapper.eq("1", "1");
        return mapper.selectList(wrapper);
    }

    /**
     * 添加后台资源分类
     *
     * @param param
     *         后台资源
     *
     * @return
     */
    @Override
    public int add(UmsResourceCategory param) {
        return mapper.insert(param);
    }

    /**
     * 更新后台资源
     *
     * @param id
     *         资源id
     * @param param
     *         后台资源
     *
     * @return
     */
    @Override
    public int update(Long id, UmsResourceCategory param) {
        param.setId(id);
        return mapper.updateById(param);
    }

    /**
     * 删除后台资源
     *
     * @param id
     *         资源id
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return mapper.deleteById(id);
    }
}
