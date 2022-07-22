package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.SmsHomeAdvertiseMapper;
import cn.sq.mall.pojo.entity.SmsHomeAdvertise;
import cn.sq.mall.service.HomeAdvertiseService;
import cn.sq.platform.core.entity.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sunqiang
 * @version 1.0
 * @description 首页轮播广告管理API
 * @date 2022/7/16 15:04
 */
@Service
public class HomeAdvertiseServiceImpl implements HomeAdvertiseService {
    @Autowired
    private SmsHomeAdvertiseMapper mapper;
    /**
     * 分页查询广告
     *
     * @param name
     *         广告名称
     * @param type
     *         广告类型
     * @param endTime
     *         广告结束时间
     * @param pageNum
     *         页码
     * @param pageSize
     *         每页大小
     *
     * @return
     */
    @Override
    public PageResponse list(String name, Integer type, String endTime, Integer pageNum, Integer pageSize) {
        Page<SmsHomeAdvertise> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        QueryWrapper<SmsHomeAdvertise> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        if (StringUtils.isNotBlank(name)) {
            wrapper.like("name",name);
        }
        if (ObjectUtils.isNotEmpty(type)) {
            wrapper.like("type",type);
        }
        if (ObjectUtils.isNotEmpty(endTime)) {
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            LocalDateTime start = LocalDateTime.parse(startStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime end = LocalDateTime.parse(endStr,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            wrapper.between("end_time",start,end);
        }
        page = mapper.selectPage(page,wrapper);
        return PageResponse.success((long)pageNum,page.getSize(),page.getPages(), page.getTotal(), page.getRecords());
    }

    /**
     * 根据编号获取广告
     *
     * @param id
     *         编号
     *
     * @return
     */
    @Override
    public SmsHomeAdvertise getItem(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 添加广告
     *
     * @param param
     *         广告参数
     *
     * @return
     */
    @Override
    public int add(SmsHomeAdvertise param) {
        param.setClickCount(0);
        param.setOrderCount(0);
        return mapper.insert(param);
    }

    /**
     * 删除广告
     *
     * @param id
     *         id
     * @param param
     *         广告
     *
     * @return
     */
    @Override
    public int update(Long id, SmsHomeAdvertise param) {
        param.setId(id);
        return mapper.updateById(param);
    }

    /**
     * 删除广告
     *
     * @param id
     *         广告编号
     *
     * @return
     */
    @Override
    public int delete(Long id) {
        return mapper.deleteById(id);
    }

    /**
     * 修改广告上下线状态
     *
     * @param id
     *         编号
     * @param status
     *         上下线状态
     *
     * @return
     */
    @Override
    public int updateStatus(Long id, Integer status) {
        SmsHomeAdvertise advertise = new SmsHomeAdvertise();
        advertise.setId(id);
        advertise.setStatus(status);
        return mapper.updateById(advertise);
    }
}
