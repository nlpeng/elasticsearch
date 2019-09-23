package com.nlpeng.es.dao;

import com.nlpeng.es.domain.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 *
 * @author Ferry NLP
 * @create 2019-09-22
 * @since 1.0v
 **/
public interface EsProductDao {
	List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
