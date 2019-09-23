package com.nlpeng.es.repository;

import com.nlpeng.es.domain.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 *
 * @author Ferry NLP
 * @create 2019-09-22
 * @since 1.0v
 **/
public interface EsProductRepostictory extends ElasticsearchRepository<EsProduct,Long> {
	
	/**
	 * 搜索查询
	 *
	 * @param name    			商品名称
	 * @param subTitle			商品标题
	 * @param keyword			商品关键字
	 * @param page				分页信息
	 * @return
	 */
	Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keyword, Pageable page);
}
