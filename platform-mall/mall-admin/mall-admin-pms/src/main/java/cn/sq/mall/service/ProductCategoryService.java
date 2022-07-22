package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.ProductCategoryParam;
import cn.sq.mall.pojo.entity.PmsProductCategory;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0.0
 * @description 商品分类接口
 * @date 2022/7/14 23:31
 */
public interface ProductCategoryService {

    /**
     * 分页查询商品分类
     * @param parentId  父级分类编号
     * @param pageSize  每页数量
     * @param pageNum   页数
     * @return
     */
    PageResponse list(Long parentId, Integer pageNum, Integer pageSize);

    /**
     * 根据id查询商品分类
     * @param id    商品分类编号
     * @return
     */
    PmsProductCategory getItem(Long id);

    /**
     * 添加商品分类
     * @param param 商品分类参数
     * @return
     */
    @Transactional
    int add(ProductCategoryParam param);

    /**
     * 修改商品分类
     * @param id    商品分类编号
     * @param param 商品分类参数
     * @return
     */
    @Transactional
    int update(Long id,ProductCategoryParam param);

    /**
     * 删除商品分类
     * @param id    商品分类编号
     * @return
     */
    int delete(Long id);

    /**
     * 批量修改导航栏显示状态
     * @param ids   商品分类编号集合
     * @param navStatus 导航栏显示状态
     * @return
     */
    int updateNavStatus(List<Long> ids,Integer navStatus);

    /**
     * 批量修改显示状态
     * @param ids   商品分类编号
     * @param showStatus    导航栏显示状态
     * @return
     */
    int updateShowStatus(List<Long> ids,Integer showStatus);
}
