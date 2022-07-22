package cn.sq.mall.service.impl;

import cn.sq.mall.mapper.CmsPrefrenceAreaMapper;
import cn.sq.mall.pojo.CmsPrefrenceArea;
import cn.sq.mall.service.PrefrenceAreaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优选管理
 * @date 2022/7/16 01:08
 */
@Service
public class PrefrenceAreaServiceImpl implements PrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper mapper;
    /**
     * 获取全部优选
     *
     * @return
     */
    @Override
    public List<CmsPrefrenceArea> getAll() {
        QueryWrapper<CmsPrefrenceArea> wrapper = new QueryWrapper<>();
        wrapper.eq("1","1");
        return mapper.selectList(wrapper);
    }
}
