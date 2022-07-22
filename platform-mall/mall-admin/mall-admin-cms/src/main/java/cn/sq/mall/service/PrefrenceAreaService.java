package cn.sq.mall.service;

import cn.sq.mall.pojo.CmsPrefrenceArea;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 优选管理接口
 * @date 2022/7/16 01:07
 */
public interface PrefrenceAreaService {
    /**
     * 获取全部优选
     * @return
     */
    List<CmsPrefrenceArea> getAll();

}
