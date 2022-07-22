package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.ProductParam;
import cn.sq.mall.pojo.dto.ProductQueryParam;
import cn.sq.mall.pojo.dto.ProductResult;
import cn.sq.mall.pojo.entity.PmsProduct;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0.0
 * @description 商品接口API
 * @date 2022/7/15 17:55
 */
public interface ProductService {
    /**
     * 分页查询商品
     * @param param 分页查询参数
     * @param pageNum   页码
     * @param pageSize 每页大小
     * @return
     */
    PageResponse list(ProductQueryParam param, Integer pageNum, Integer pageSize);

    /**
     * 根据商品名称或货号模糊查询
     * @param keyword   关键字
     * @return
     */
    List<PmsProduct> list(String keyword);

    /**
     * 根据id查询商品编辑信息
     * @param id    商品编号
     * @return
     */
    ProductResult getItem(Long id);

    /**
     * 添加商品
     * @param param 商品相关信息
     * @return
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int add(ProductParam param);

    /**
     * 修改商品
     * @param id    商品编号
     * @param param 商品相关信息
     * @return
     */
    @Transactional
    int update(Long id, ProductParam param);

    /**
     * 批量审核
     * @param ids   商品编号集合
     * @param verifyStatus  审核标志
     * @param detail    审核意见
     * @return
     */
    @Transactional
    int verify(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量上下架
     * @param ids   商品编号集合
     * @param publishStatus 上下架标志
     * @return
     */
    int publish(List<Long> ids, Integer publishStatus);

    /**
     * 批量推荐
     * @param ids   商品编号集合
     * @param recommendStatus   推荐集合
     * @return
     */
    int recommend(List<Long> ids, Integer recommendStatus);

    /**
     * 批量设置新品
     * @param ids   商品编号集合
     * @param newStatus  新品标志
     * @return
     */
    int newest(List<Long> ids, Integer newStatus);

    /**
     * 批量逻辑删除
     * @param ids   商品编号集合
     * @param deleteStatus  删除标志
     * @return
     */
    int delete(List<Long> ids, Integer deleteStatus);
}
