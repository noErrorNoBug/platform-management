package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.UmsMemberLevelMapper;
import cn.sq.mall.pojo.entity.UmsMemberLevel;
import cn.sq.mall.service.MemberLevelService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunqiang
 * @version 1.0
 * @description 会员等级管理API
 * @date 2022/7/16 15:25
 */
@Service
public class MemberLevelServiceImpl implements MemberLevelService {
    @Autowired
    private UmsMemberLevelMapper mapper;
    /**
     * 分页查询会员等级
     *
     * @param defaultStatus
     *         是否为默认等级
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(Integer defaultStatus, Integer pageNum, Integer pageSize) {
        Page<UmsMemberLevel> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<UmsMemberLevel> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (ObjectUtils.isNotEmpty(defaultStatus)) {
            wrapper.eq("default_status",defaultStatus);
        }
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }
}
