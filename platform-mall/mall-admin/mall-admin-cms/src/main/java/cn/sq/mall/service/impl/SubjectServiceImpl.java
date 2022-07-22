package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.CmsSubjectMapper;
import cn.sq.mall.pojo.CmsSubject;
import cn.sq.mall.service.SubjectService;
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
 * @description 专题管理
 * @date 2022/7/16 01:08
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private CmsSubjectMapper mapper;

    /**
     * 获取所有专题
     *
     * @return
     */
    @Override
    public List<CmsSubject> getAll() {
        QueryWrapper<CmsSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("1","1");
        return mapper.selectList(wrapper);
    }

    /**
     * 根据专题名称分页获取商品专题
     *
     * @param keyword
     *         专题名称关键字
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(String keyword, Integer pageNum, Integer pageSize) {
        QueryWrapper<CmsSubject> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            wrapper.like("title",keyword);
        }
        wrapper.eq("1","1");
        Page<CmsSubject> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }
}
