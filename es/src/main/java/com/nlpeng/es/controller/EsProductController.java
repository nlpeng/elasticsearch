package com.nlpeng.es.controller;

import com.nlpeng.es.common.CommonPage;
import com.nlpeng.es.common.CommonResult;
import com.nlpeng.es.domain.EsProduct;
import com.nlpeng.es.domain.EsProductRelatedInfo;
import com.nlpeng.es.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索商品管理Controller
 *
 * @author Ferry NLP
 * @create 2019-09-22
 * @see
 * @since 1.0v
 **/
@RestController
@Api(tags = "EsProductController", description = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {
	
	@Autowired
	private EsProductService esProductService;
	
	@ApiOperation(value = "导入所有数据库中商品到ES")
	@PostMapping(value = "/importAll")
	public CommonResult<Integer> importAllList() {
		int count = esProductService.importAll();
		return CommonResult.success(count);
	}
	
	@ApiOperation(value = "")
	@GetMapping(value = "")
	public CommonResult<Object> delete(@PathVariable Long id) {
		esProductService.delete(id);
		return CommonResult.success(null);
	}
	
	@ApiOperation(value = "")
	@GetMapping(value = "")
	public CommonResult<Object> delete(@PathVariable("ids") List<Long> ids) {
		esProductService.delete(ids);
		return CommonResult.success(null);
	}
	
	@ApiOperation(value = "")
	@GetMapping(value = "")
	public CommonResult<EsProduct> create(@PathVariable Long id) {
		EsProduct esProduct = esProductService.create(id);
		if (esProduct != null) {
			return CommonResult.success(esProduct);
		} else {
			return CommonResult.failed();
		}
	}
	
	@ApiOperation(value = "")
	@GetMapping(value = "")
	public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false)String keyword,
													  @RequestParam(required = false,defaultValue = "0") Integer pageNum,
													  @RequestParam(required = false,defaultValue = "5") Integer pageSize) {
		Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
		return CommonResult.success(CommonPage.restPage(esProductPage));
	}
	
	@ApiOperation(value = "")
	@GetMapping(value = "")
	public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false)String keyword,
													  @RequestParam(required = false)Long brandId,
													  @RequestParam(required = false)Long productCategoryId,
													  @RequestParam(required = false,defaultValue = "0") Integer pageNum,
													  @RequestParam(required = false,defaultValue = "5") Integer pageSize,
													  @RequestParam(required = false,defaultValue = "0") Integer sort) {
		Page<EsProduct> esProductPage = esProductService.search(keyword, brandId,productCategoryId,pageNum, pageSize,sort);
		return CommonResult.success(CommonPage.restPage(esProductPage));
	}
	
	@ApiOperation(value = "")
	@GetMapping(value = "")
	public CommonResult<CommonPage<EsProduct>> recommend(@PathVariable Long id,
														 @RequestParam(required = false,defaultValue = "0")Integer pageNum,
														 @RequestParam(required = false,defaultValue = "5")Integer pageSize){
		Page<EsProduct> esProductPage =esProductService.recommed(id,pageNum,pageSize);
		return CommonResult.success(CommonPage.restPage(esProductPage));
	}
	
	@ApiOperation(value = "")
	@GetMapping(value = "")
	public CommonResult<EsProductRelatedInfo> searchRelatedInfo(@RequestParam(required = false)String keyword){
		EsProductRelatedInfo productRelatedInfo = esProductService.searchRelatedInfo(keyword);
		return CommonResult.success(productRelatedInfo);
	}
	
}
