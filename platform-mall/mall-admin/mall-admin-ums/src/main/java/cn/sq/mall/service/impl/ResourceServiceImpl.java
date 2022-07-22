package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.UmsResourceMapper;
import cn.sq.mall.pojo.entity.UmsResource;
import cn.sq.mall.service.ResourceService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 后台资源管理API
 * @date 2022/7/16 15:25
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private UmsResourceMapper mapper;
    /**
     * 查询所有后台资源
     *
     * @return
     */
    @Override
    public List<UmsResource> all() {
        QueryWrapper<UmsResource> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        wrapper.eq("1", "1");
        return mapper.selectList(wrapper);
    }

    /**
     * 分页查询后台资源
     *
     * @param categoryId
     *         后台资源分类编号
     * @param nameKeyword
     *         名称关键字
     * @param urlKeyword
     *         url 关键字
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageNum, Integer pageSize) {
        Page<UmsResource> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<UmsResource> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (StringUtils.isNotBlank(nameKeyword)) {
            wrapper.like("name",nameKeyword);
        }
        if (StringUtils.isNotBlank(urlKeyword)) {
            wrapper.like("url",urlKeyword);
        }
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据资源编号查询后台资源
     *
     * @param id
     *         资源编号
     *
     * @return
     */
    @Override
    public UmsResource getItem(Long id) {
        return null;
    }

    /**
     * 添加后台资源
     *
     * @param param
     *         后台资源参数
     *
     * @return
     */
    @Override
    public int add(UmsResource param) {
        return mapper.insert(param);
    }

    /**
     * 修改后台资源
     *
     * @param id
     *         后台资源编号
     * @param param
     *         后台资源参数
     *
     * @return
     */
    @Override
    public int update(Long id, UmsResource param) {
        return 0;
    }

    /**
     * 删除后台资源
     *
     * @param id
     *         后台资源编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return 0;
    }
}
