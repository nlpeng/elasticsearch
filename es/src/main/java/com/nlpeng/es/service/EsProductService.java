package com.nlpeng.es.service;

import com.nlpeng.es.domain.EsProduct;
import com.nlpeng.es.domain.EsProductRelatedInfo;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * 商品搜索管理Service
 *
 * @author Ferry NLP
 * @create 2019-09-22
 * @see
 * @since 1.0v
 **/
public interface EsProductService {
	
	/**
	 * 从数据库中导出所有商品到ES
	 */
	int importAll();
	
	/**
	 * 根据id删除商品
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 根据id创建商品
	 * @param id
	 * @return
	 */
	EsProduct create(Long id);
	
	/**
	 * 批量删除商品
	 * @param ids
	 */
	void delete(List<Long> ids);
	
	/**
	 * 根据关键字搜索名称或副标题
	 * @param keyword
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	Page<EsProduct> search(String keyword,Integer pageNum,Integer pageSize);
	
	/**
	 * 根据关键字搜索名称或者副标题复合查询
	 * @param keyword
	 * @param brandId
	 * @param productCategoryId
	 * @param pageNum
	 * @param pageSize
	 * @param sort
	 * @return
	 */
	Page<EsProduct> search(String keyword,Long brandId,Long productCategoryId,Integer pageNum,Integer pageSize,Integer sort);
	
	/**
	 * 根据商品ID推荐相关商品
	 * @param id
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	Page<EsProduct> recommed(Long id,Integer pageNum,Integer pageSize);
	
	/**
	 *获取搜索词相关品牌、分类、属性
	 * @param keyword
	 * @return
	 */
	EsProductRelatedInfo searchRelatedInfo(String keyword);
	
	
	
	
	
	
	
	
	
	
	
	
}
