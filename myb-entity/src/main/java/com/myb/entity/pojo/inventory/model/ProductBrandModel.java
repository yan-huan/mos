package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Description : 商品品牌信息 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午1:23:32 <br/>
 * @version 1.0
 */
public class ProductBrandModel implements Serializable {
	private static final long serialVersionUID = 8073626176678849217L;
	/** 商品品牌code **/
	private String productBrandCode;
	/** 商品品牌名称 **/
	private String productBrandName;
	/** 商品品牌成本 **/
	private Double productBrandCost;
	/** 产品种类数量 **/
	private Integer productTypeNumber;
	/** 异常种类数量 **/
	private Integer unNormalProductTypeNumber;
	/** 商品集合 **/
	private List<ProductModel> productList = Lists.newArrayList();
	
	public String getProductBrandCode() {
		return productBrandCode;
	}
	public void setProductBrandCode(String productBrandCode) {
		this.productBrandCode = productBrandCode;
	}
	public String getProductBrandName() {
		return productBrandName;
	}
	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}
	public Double getProductBrandCost() {
		return productBrandCost;
	}
	public void setProductBrandCost(Double productBrandCost) {
		this.productBrandCost = productBrandCost;
	}
	public List<ProductModel> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductModel> productList) {
		this.productList = productList;
	}
	public Integer getProductTypeNumber() {
		return productTypeNumber;
	}
	public void setProductTypeNumber(Integer productTypeNumber) {
		this.productTypeNumber = productTypeNumber;
	}
	public Integer getUnNormalProductTypeNumber() {
		return unNormalProductTypeNumber;
	}
	public void setUnNormalProductTypeNumber(Integer unNormalProductTypeNumber) {
		this.unNormalProductTypeNumber = unNormalProductTypeNumber;
	}
}
