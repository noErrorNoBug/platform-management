package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.BrandParam;
import cn.sq.mall.pojo.entity.PmsBrand;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0.0
 * @description 品牌管理接口
 * @date 2022/7/14 16:10
 */
public interface BrandService {
    /**
     * 根据品牌名称分页获取品牌列表
     *
     * @param keyword 搜索关键字
     * @param pageNum 页码
     * @param pageSize 每页数量
     */
    PageResponse<PmsBrand> getRecords(String keyword, int pageNum, int pageSize);

    /**
     * 根据编号查询品牌信息
     *
     * @param id 品牌编号
     */
    PmsBrand getItem(Long id);

    /**
     * 创建品牌
     *
     * @param brandParam 品牌参数
     */
    int add(BrandParam brandParam);

    /**
     * 修改品牌
     *
     * @param id    品牌编号
     * @param brandParam    品牌参数
     */
    @Transactional
    int update(Long id, BrandParam brandParam);

    /**
     * 删除品牌
     *
     * @param id    品牌编号
     */
    int delete(Long id);

    /**
     * 批量删除品牌
     *
     * @param ids   品牌编号集合
     */
    int deleteBatch(List<Long> ids);

    /**
     * 批量更新显示状态
     *
     * @param ids   品牌编号集合
     * @param showStatus    显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 批量更新厂家制造商状态
     *
     * @param ids   品牌编号集合
     * @param factoryStatus 厂家制造商状态
     */
    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
