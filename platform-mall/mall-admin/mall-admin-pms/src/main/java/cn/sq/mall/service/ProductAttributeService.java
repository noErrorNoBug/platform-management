package cn.sq.mall.service;

import cn.sq.mall.pojo.dto.ProductAttrInfo;
import cn.sq.mall.pojo.dto.ProductAttributeParam;
import cn.sq.mall.pojo.entity.PmsProductAttribute;
import cn.sq.platform.core.entity.PageResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商品属性管理接口
 * @date 2022/7/15 00:45
 */
public interface ProductAttributeService {
    /**
     * 根据查询分类进行分页查询
     * @param cid   商品分类编号
     * @param type 查询分类(0-属性，1-参数)
     * @param pageNum   页码
     * @param pageSize  每页条数
     * @return
     */
    PageResponse list(Long cid, Integer type, Integer pageNum, Integer pageSize);

    /**
     * 根据id查询商品属性
     * @param id    商品属性id
     * @return
     */
    PmsProductAttribute getItem(Long id);

    /**
     * 根据商品分类编号查询商品属性及属性分类
     *
     * @param cid
     *         商品分类编号
     *
     * @return
     */
    List<ProductAttrInfo> attrInfo(Long cid);

    /**
     * 添加商品属性
     * @param param 商品属性参数
     * @return
     */
    @Transactional
    int add(ProductAttributeParam param);

    /**
     * 修改商品属性
     * @param id    商品属性编号
     * @param param 商品属性参数
     * @return
     */
    int update(Long id, ProductAttributeParam param);

    /**
     * 批量删除商品属性
     * @param ids   商品属性编号合集
     * @return
     */
    @Transactional
    int deleteBatch(List<Long> ids);



}
