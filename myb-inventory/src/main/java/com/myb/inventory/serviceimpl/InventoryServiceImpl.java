package com.myb.inventory.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.DataTransferObject;
import com.myb.commons.exception.dto.BusinessException;
import com.myb.commons.utils.CodeUtil;
import com.myb.commons.utils.ValidateUtil;
import com.myb.entity.pojo.inventory.InoutLog;
import com.myb.entity.pojo.inventory.InoutLogMapping;
import com.myb.entity.pojo.inventory.Inventory;
import com.myb.entity.pojo.inventory.InventoryApply;
import com.myb.entity.pojo.inventory.InventoryApplyItem;
import com.myb.entity.pojo.inventory.InventoryApplyItemMapping;
import com.myb.entity.pojo.inventory.InventoryApplyLog;
import com.myb.entity.pojo.inventory.InventoryApplyMapping;
import com.myb.entity.pojo.inventory.InventoryIn;
import com.myb.entity.pojo.inventory.InventoryInItem;
import com.myb.entity.pojo.inventory.InventoryInItemMapping;
import com.myb.entity.pojo.inventory.InventoryInMapping;
import com.myb.entity.pojo.inventory.InventoryItem;
import com.myb.entity.pojo.inventory.InventoryItemMapping;
import com.myb.entity.pojo.inventory.InventoryMapping;
import com.myb.entity.pojo.inventory.InventoryOut;
import com.myb.entity.pojo.inventory.InventoryOutItem;
import com.myb.entity.pojo.inventory.InventoryOutItemMapping;
import com.myb.entity.pojo.inventory.InventoryOutMapping;
import com.myb.entity.pojo.inventory.InventorySku;
import com.myb.entity.pojo.inventory.InventorySkuMapping;
import com.myb.entity.pojo.inventory.InventoryStockCheck;
import com.myb.entity.pojo.inventory.InventoryStockCheckItem;
import com.myb.entity.pojo.inventory.InventoryStockCheckItemMapping;
import com.myb.entity.pojo.inventory.InventoryStockCheckLog;
import com.myb.entity.pojo.inventory.InventoryStockCheckMapping;
import com.myb.entity.pojo.inventory.InventoryStockCheckProfitShortages;
import com.myb.entity.pojo.inventory.InventoryWarning;
import com.myb.entity.pojo.inventory.InventoryWarningMapping;
import com.myb.entity.pojo.inventory.InventoryWarnningSetting;
import com.myb.entity.pojo.inventory.InventoryWarnningSettingMapping;
import com.myb.entity.pojo.inventory.model.InventoryApplyItemModel;
import com.myb.entity.pojo.inventory.model.InventoryApplyModel;
import com.myb.entity.pojo.inventory.model.InventoryInModel;
import com.myb.entity.pojo.inventory.model.InventoryInProductModel;
import com.myb.entity.pojo.inventory.model.InventoryItemModel;
import com.myb.entity.pojo.inventory.model.InventoryModel;
import com.myb.entity.pojo.inventory.model.InventoryOutItemModel;
import com.myb.entity.pojo.inventory.model.InventoryOutItemResultModel;
import com.myb.entity.pojo.inventory.model.InventoryOutModel;
import com.myb.entity.pojo.inventory.model.InventoryOutResultModel;
import com.myb.entity.pojo.inventory.model.InventorySkuModel;
import com.myb.entity.pojo.inventory.model.InventoryStockCheckItemModel;
import com.myb.entity.pojo.inventory.model.InventoryStockCheckItemResultModel;
import com.myb.entity.pojo.inventory.model.InventoryStockCheckModel;
import com.myb.entity.pojo.inventory.model.ProductBrandModel;
import com.myb.entity.pojo.inventory.model.ProductModel;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.data.UpdateParameter;
import com.myb.inventory.cons.Cons;
import com.myb.inventory.dao.InoutLogDao;
import com.myb.inventory.dao.InventoryApplyDao;
import com.myb.inventory.dao.InventoryApplyItemDao;
import com.myb.inventory.dao.InventoryApplyLogDao;
import com.myb.inventory.dao.InventoryDao;
import com.myb.inventory.dao.InventoryInDao;
import com.myb.inventory.dao.InventoryInItemDao;
import com.myb.inventory.dao.InventoryItemDao;
import com.myb.inventory.dao.InventoryOutDao;
import com.myb.inventory.dao.InventoryOutItemDao;
import com.myb.inventory.dao.InventorySkuDao;
import com.myb.inventory.dao.InventoryStockCheckDao;
import com.myb.inventory.dao.InventoryStockCheckItemDao;
import com.myb.inventory.dao.InventoryStockCheckLogDao;
import com.myb.inventory.dao.InventoryStockCheckProfitShortagesDao;
import com.myb.inventory.dao.InventoryWarningDao;
import com.myb.inventory.dao.InventoryWarnningSettingDao;
import com.myb.inventory.service.InventoryService;

/**
 * 
 * Description : 库存服务实现 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午3:44:48 <br/>
 * @version 1.0
 */
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService{
	
	private static final Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private InventoryItemDao inventoryItemDao;
    @Autowired
    private InventorySkuDao inventorySkuDao;
    @Autowired
    private InventoryInDao inventoryInDao;
    @Autowired
    private InventoryInItemDao inventoryInItemDao;
    @Autowired
    private InoutLogDao inoutLogDao;
    @Autowired
    private InventoryOutDao inventoryOutDao;
    @Autowired
    private InventoryOutItemDao inventoryOutItemDao;
    @Autowired
    private InventoryStockCheckDao inventoryStockCheckDao;
    @Autowired
    private InventoryStockCheckItemDao inventoryStockCheckItemDao;
    @Autowired
    private InventoryStockCheckLogDao inventoryStockCheckLogDao;
    @Autowired
    private InventoryStockCheckProfitShortagesDao inventoryStockCheckProfitShortagesDao;
    @Autowired
    private InventoryApplyDao inventoryApplyDao;
    @Autowired
    private InventoryApplyItemDao inventoryApplyItemDao;
    @Autowired
    private InventoryApplyLogDao inventoryApplyLogDao;
    @Autowired
    private InventoryWarningDao inventoryWarningDao;
    @Autowired
    private InventoryWarnningSettingDao inventoryWarnningSettingDao;
    
    
    @Override
	public DataTransferObject<Map<String, Object>> findProductBrandListByInventoryCode(JSONObject jsonObj) {
    	log.info("开始执行findProductBrandList＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
    	log.info("参数：" + jsonObj.toJSONString());
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		//品牌code -- 品牌名称
		Map<String, Object> resultMap = Maps.newHashMap();
		Map<String, String> productBrandMap = Maps.newHashMap();
		
		//获取参数
		String inventoryCode = jsonObj.getString("inventoryCode"); //库存code
		String productType = jsonObj.getString("productType");	//商品类型：院装，客装
//		String status = jsonObj.getString("status");	//状态
//		Integer startTime = jsonObj.getInteger("startTime");
//		Integer endTime = jsonObj.getInteger("endTime");
		
		//验证参数
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(productType, CodeConst.PRODUCT_TYPE_NULL_ERROR, dto);
		
		//如果验证通过
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			
			//获取总成本
			Double totalCost = findTotalCost(inventoryCode, productType, null, null);
			resultMap.put("totalCost", totalCost);
			
			//根据库存code查询库存商品集合
			List<InventorySku> inventorySkuList = inventorySkuDao.searchProductListR(inventoryCode, productType);
			if(inventorySkuList != null && inventorySkuList.size() > 0) {
				for (InventorySku inventorySku : inventorySkuList) {
					String brandCode = inventorySku.getProductBrandCode();
					Object brandName = resultMap.get(brandCode);
					if(brandName == null) {
						productBrandMap.put(brandCode, inventorySku.getProductBrandName());
					}
				}
				resultMap.put("brandMap", productBrandMap);
			} else {
				//如果验证未通过
				throw new BusinessException(CodeConst.INVENTORY_NOT_EXIST_ERROR, ValidateUtil.get(CodeConst.INVENTORY_NOT_EXIST_ERROR));
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		log.info("返回结果：" + resultMap.toString());
		dto.setData(resultMap);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		log.info("执行完成findProductBrandList＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
		return dto;
	}
    


	@Override
	public DataTransferObject<Map<String, Object>> findProductListByBrandCode(JSONObject jsonObj) {
		log.info("开始执行findProductListByBrandCode＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
    	log.info("参数：" + jsonObj.toJSONString());
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> resultMap = Maps.newHashMap();
		
		String productBrandCode = jsonObj.getString("productBrandCode");
		String inventoryCode = jsonObj.getString("inventoryCode");
		String productType = jsonObj.getString("productType");
		Integer page = jsonObj.getInteger("page");
		Integer pageSize = jsonObj.getInteger("pageSize");
		
		ValidateUtil.validateNullProperty(productBrandCode, CodeConst.PRODUCT_BRAND_CODE_NULL_ERRO, dto);
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(productType, CodeConst.PRODUCT_TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(page, CodeConst.PAGE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			
			PagedList<InventorySku> pageList = inventorySkuDao.searchPage(inventoryCode, productType, productBrandCode, page, pageSize);
			resultMap.put("pageList", pageList);
			
			//获取库存数量
			Map<String, Integer> countMap = Maps.newHashMap();
			List<InventorySku> skus = pageList.getContent();
			if(skus != null && skus.size() > 0) {
				List<String> skuCodes = Lists.newArrayList();
				for (InventorySku inventorySku : skus) {
					skuCodes.add(inventorySku.getInventorySkuCode());
				}
				
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.in(InventoryItemMapping.InventorySkuCode, skuCodes.toArray());
				List<InventoryItem> inventoryItemList = inventoryItemDao.searchListR(queryParameter);
				if(inventoryItemList != null && inventoryItemList.size() > 0) {
					for (InventoryItem inventoryItem : inventoryItemList) {
						countMap.put(inventoryItem.getInventorySkuCode(), inventoryItem.getStockNumber());
					}
				}
			}
			
			
			
			//计算品牌总成本
			Double productBrandCost = this.findTotalCost(inventoryCode, productType, productBrandCode, null);
			resultMap.put("productBrandCost", productBrandCost);
			resultMap.put("countMap", countMap);
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		dto.setData(resultMap);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}
    
//	@Override
//	public DataTransferObject<Map<String, Object>> findInventoryItem(
//			JSONObject jsonObj) {
//		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
//		Map<String, Object> resultMap = Maps.newHashMap();
//		//获取参数
//		String parentCode = jsonObj.getString("parentCode");	//父仓code
//		String inventoryType = jsonObj.getString("inventoryType"); //仓库类型：父仓；子仓；
//		String productType = jsonObj.getString("productType");	//商品类型：院装，客装
//		String childCode = jsonObj.getString("childCode");	//子仓code
//		String status = jsonObj.getString("status");	//状态
//		Integer startTime = jsonObj.getInteger("startTime");
//		Integer endTime = jsonObj.getInteger("endTime");
//		
//		//验证参数
//		ValidateUtil.validateNullProperty(parentCode, CodeConst.PARENT_CODE_NULL_ERROR, dto);
//		ValidateUtil.validateNullProperty(inventoryType, CodeConst.INVENTORY_TYPE_NULL_ERROR, dto);
//		ValidateUtil.validateNullProperty(productType, CodeConst.PRODUCT_TYPE_NULL_ERROR, dto);
//		
//		//如果验证通过
//		if(CodeConst.SUCCESS.equals(dto.getCode())) {
//			//查询库存信息
//			Inventory inventory = inventoryDao.getInventory(parentCode, childCode, inventoryType);
//			//查询库存商品详情
//			List<InventorySkuModel> list = inventoryDao.getInventorySkuList(parentCode, childCode, inventoryType, productType, status, startTime, endTime);
//			if(list != null && list.size() > 0) {
//				//商品品牌集合
//				Map<String, ProductBrandModel> productBrandModelsMap = Maps.newHashMap();
//				//商品map。key为商品品牌code，value为商品集合
//				Map<String, List<ProductModel>> productMap = Maps.newHashMap();
//				for (InventorySkuModel inventorySkuModel : list) {
//					ProductBrandModel productBrandModel = productBrandModelsMap.get(inventorySkuModel.getProductBrandCode());
//					if(productBrandModel == null) {
//						productBrandModel = new ProductBrandModel();
//					}
//					productBrandModel.setProductBrandCode(inventorySkuModel.getProductBrandCode());
//					productBrandModel.setProductBrandName(inventorySkuModel.getProductBrandName());
//					productBrandModelsMap.put(inventorySkuModel.getProductBrandCode(), productBrandModel);
//					
//					//取出map中的商品集合，如果集合不存在，则创建新的，并放入map中。
//					//将遍历的商品加入集合。
//					List<ProductModel> productModels = productMap.get(inventorySkuModel.getProductBrandCode());
//					if(productModels == null) {
//						productModels = Lists.newArrayList();
//					}
//					ProductModel productModel = new ProductModel();
//					productModel.setProductCode(inventorySkuModel.getProductCode());
//					productModel.setProductName(inventorySkuModel.getProductName());
//					productModel.setProductUnit(inventorySkuModel.getProductUnit());
//					productModel.setStockNumber(inventorySkuModel.getStockNumber());
//					productModel.setProductCost(inventorySkuModel.getStockNumber() * inventorySkuModel.getMarketPrice());
//					productModels.add(productModel);
//					productMap.put(inventorySkuModel.getProductBrandCode(), productModels);
//				}
//				
//				//总成本
//				Double totalCost = 0.0;
//				//匹配商品品牌和商品
//				if(productBrandModelsMap != null && productBrandModelsMap.size() > 0) {
//					List<ProductBrandModel> productBrandModels = Lists.newArrayList();
//					for (String productBrandCode : productBrandModelsMap.keySet()) {
//						List<ProductModel> pList = productMap.get(productBrandCode);
//						ProductBrandModel productBrandModel = productBrandModelsMap.get(productBrandCode);
//						productBrandModel.setProductList(pList);
//						//计算品牌成本
//						Double cost = 0.0;
//						if(pList != null && pList.size() > 0) {
//							for (ProductModel pm : pList) {
//								cost = cost + pm.getProductCost();
//							}
//							productBrandModel.setProductBrandCost(cost);
//							
//							//计算总成本
//							totalCost = totalCost + productBrandModel.getProductBrandCost();
//							
//							productBrandModels.add(productBrandModel);
//						}
//					}
//					resultMap.put("cost", totalCost);
//					resultMap.put("inventoryCode", inventory.getInventoryCode());
//					resultMap.put("productBrandList", productBrandModels);
//				}
//				
//				dto.setData(resultMap);
//				dto.setMsg(ValidateUtil.get(dto.getCode()));
//			}
//		} else {
//			//如果验证未通过
//			throw new BusinessException(dto.getCode(), dto.getMsg());
//		}
//		
//		return dto;
//	}


	@Override
	public DataTransferObject<Map<String, Object>> findByProductCode(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		//获取参数
		String productCode = jsonObj.getString("productCode");	//商品code
		String inventoryCode = jsonObj.getString("inventoryCode");	//库存code
		String status = jsonObj.getString("status");	//状态
		
		//验证参数
		ValidateUtil.validateNullProperty(productCode, CodeConst.PRODUCT_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		
		//如果验证通过
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			Map<String, Object> map = Maps.newHashMap();
			//根据商品code查询库存商品信息
			InventorySku inventorySku = inventorySkuDao.searchByProductCode(productCode, status);
			if(inventorySku != null) {
				map.put("productName", inventorySku.getProductName());
				
				//根据库存商品code和库存code查询库存明细
				List<InventoryItem> inventoryItems = inventoryItemDao.searchBySkuCode(inventorySku.getInventorySkuCode(),inventoryCode, status);
				
				Integer inventoryCount = 0;	//库存总量
				Double productCost = 0.0;		//商品成本
				//遍历库存明细
				if(inventoryItems != null && inventoryItems.size() > 0) {
					List<InventoryModel> inventoryModels = Lists.newArrayList();
					for (InventoryItem inventoryItem : inventoryItems) {
						inventoryCount = inventoryCount + inventoryItem.getStockNumber();		//计算总库存
						productCost = productCost + (inventoryItem.getStockNumber() * inventoryItem.getAveragePrice());		//计算总成本
						Inventory inventory = inventoryDao.searchByInventoryCode(inventoryItem.getInventoryCode());
						InventoryModel inventoryModel = new InventoryModel();
						inventoryModel.setInventoryName(inventory.getInventoryName());
						inventoryModel.setStockNumber(inventoryItem.getStockNumber());
						inventoryModel.setInventoryProductCost(inventoryItem.getStockNumber() * inventoryItem.getAveragePrice());
						inventoryModel.setVersion(inventoryItem.getVersion());
						inventoryModels.add(inventoryModel);
					}
					map.put("inventoryCount", inventoryCount);
					map.put("productCost", productCost);
					map.put("inventoryDetail", inventoryModels);
				}
				
				dto.setData(map);
				dto.setMsg(ValidateUtil.get(dto.getCode()));
			}
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		return dto;
	}


	@Override
	@Transactional
	public DataTransferObject<Map<String, Object>> inventoryIn(JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		//获取参数
		InventoryInModel inventoryInModel = jsonObj.toJavaObject(InventoryInModel.class);
		
		
		
		//获取库存code
		Inventory inventory = inventoryDao.getInventoryR(inventoryInModel.getInventoryCode(), inventoryInModel.getInventoryType());
		String inventoryCode = "";
		if(inventory != null) {		//如果库存信息不为空
			//获取库存code
			inventoryCode = inventory.getInventoryCode();
		} else {
			inventory = saveInventory(inventoryInModel);
			inventoryCode = inventory.getInventoryCode();
		}
		
		//插入入库单和入库单明细
		List<InventoryInProductModel> inventoryInProductModels = inventoryInModel.getInventoryInProductModels();
		if(inventoryInProductModels != null && inventoryInProductModels.size() > 0) {
			//插入入库单
			InventoryIn inventoryIn = saveInventoryIn(inventoryInModel, inventory);
			
			Map<String, Object> map = Maps.newHashMap();
			map.put("inCode", inventoryIn.getInCode());
			dto.setData(map);
			
			//插入入库单明细
			for (InventoryInProductModel inventoryInProductModel : inventoryInProductModels) {
				//获取库存商品code
				InventorySku inventorySku = inventorySkuDao.searchByProductCode(inventoryInProductModel.getProductCode(), Cons.STATUS_NORMAL);
				
				//查询库存明细，如果存在，则更新。如果不存在，则新建
				List<InventoryItem> inventoryItems = inventoryItemDao.searchBySkuCode(inventorySku.getInventorySkuCode(), inventoryCode, Cons.STATUS_NORMAL);
				Integer inventoryItemId = null;
				InventoryItem inventoryItem = null;
				if(inventoryItems != null && inventoryItems.size() > 0) {
					inventoryItem = inventoryItems.get(0);
					inventoryItemId = inventoryItem.getId();
				} else {
					//如果明细不存在，则插入
					inventoryItem = saveInventoryItem(inventory);
					inventoryItemId  = inventoryItem.getId();
				}
				
				//插入入库单明细
				InventoryInItem inventoryInItem = saveInventoryInItem(inventory, inventoryIn,
						inventoryInProductModel, inventorySku);
				
				inventoryInProductModel.getVersion();
				//更新库存数量
				int count = inventoryItemDao.updateAddInventoryQuantity(inventoryItemId, inventoryInItem.getQuantity(), inventoryItem.getVersion(), inventoryIn.getCreateUserCode(), inventoryIn.getCreateUserName(), inventoryIn.getCreateTime());
				if(count == 0) {
					throw new BusinessException(CodeConst.STOCK_VERSION_ERROR, ValidateUtil.get(CodeConst.STOCK_VERSION_ERROR));
				}
				InventoryItem newInventoryItem = inventoryItemDao.searchByIdW(inventoryItemId);
				
				//记录流水
				saveInoutLog(inventory, inventoryItem, newInventoryItem, inventoryIn.getInType(), Cons.CAIGOURUKU, inventoryInItem.getInCode(), inventoryInItem.getInventorySkuCode(), inventoryInItem.getQuantity());
			
				//重新计算加权平均价
				//查询该商品的所有入库单明细（主库）
				List<InventoryInItem> inventoryInItemList = inventoryInItemDao.searchListW(inventoryCode, inventoryInItem.getInventorySkuCode());
				Double totalPrice = 0.0;
				for (InventoryInItem inItem : inventoryInItemList) {
					totalPrice = totalPrice + (inItem.getSinglePrice()*inItem.getQuantity());
				}
				log.info("入库单明细中该商品的总价格为" + totalPrice);
				//查询库存明细的库存数量（主库）
				InventoryItem item = inventoryItemDao.searchByIdW(inventoryItemId);
				Integer stockNumber = item.getStockNumber();	//库存数量
				log.info("库存数量为：" + stockNumber);
				
				//加权平均价
				Double averagePrice = totalPrice/new Double(stockNumber);
				//更新库存的加权平均价
				int result = inventoryItemDao.updateAveragePrice(inventoryItemId, averagePrice);
				if(result > 0) {
					log.info("更新加权平均价为" + averagePrice);
				}
			}
		}
		
		return dto;
	}

	//保存出库入库流水
	private void saveInoutLog(Inventory inventory, InventoryItem oldInventoryItem, InventoryItem newInventoryItem,
			String type, String reason, String itemCode, String skuCode, Integer quantity) {
		InoutLog inoutLog = new InoutLog();
		inoutLog.setInoutCode(itemCode);
		inoutLog.setInventorySkuCode(skuCode);
		inoutLog.setInventoryCode(inventory.getInventoryCode());
		inoutLog.setInventoryItemCode(newInventoryItem.getInventoryItemCode());
		inoutLog.setType(type);
		inoutLog.setReason(reason);
		inoutLog.setOldStockNumber(oldInventoryItem.getStockNumber());
		inoutLog.setOldAvailableStockNumber(oldInventoryItem.getAvailableStockNumber());
		inoutLog.setOldOccupyStockNumber(oldInventoryItem.getOccupyStockNumber());
		inoutLog.setChangeStockNumber(quantity);
		inoutLog.setNewStockNumber(newInventoryItem.getStockNumber());
		inoutLog.setNewAvailableStockNumber(newInventoryItem.getAvailableStockNumber());
		inoutLog.setNewOccupyStockNumber(newInventoryItem.getOccupyStockNumber());
		inoutLog.setCreateTime(inventory.getCreateTime());
		inoutLog.setCreateUserCode(inventory.getCreateUserCode());
		inoutLog.setCreateUserName(inventory.getCreateUserName());
		inoutLogDao.insert(inoutLog);
	}

	//保存入库明细
	private InventoryInItem saveInventoryInItem(Inventory inventory,
			InventoryIn inventoryIn,
			InventoryInProductModel inventoryInProductModel,
			InventorySku inventorySku) {
		InventoryInItem inventoryInItem = new InventoryInItem();
		inventoryInItem.setInItemCode(CodeUtil.genCode(InventoryInItem.class.getSimpleName().toUpperCase()));
		inventoryInItem.setInCode(inventoryIn.getInCode());
		inventoryInItem.setInventorySkuCode(inventorySku.getInventorySkuCode());
		inventoryInItem.setProductionTime(inventoryInProductModel.getProductionTime());
		inventoryInItem.setProductExpiredTime(inventoryInProductModel.getProductExpiredime());
		inventoryInItem.setSinglePrice(inventoryInProductModel.getSinglePrice());
		inventoryInItem.setQuantity(inventoryInProductModel.getQuantity());
		inventoryInItem.setStatus(Cons.STATUS_NORMAL);
		inventoryInItem.setCreateTime(inventory.getCreateTime());
		inventoryInItem.setCreateUserCode(inventory.getCreateUserCode());
		inventoryInItem.setCreateUserName(inventory.getCreateUserName());
		
		inventoryInItemDao.insert(inventoryInItem);
		return inventoryInItem;
	}

	//初始化库存明细
	private InventoryItem saveInventoryItem(Inventory inventory) {
		InventoryItem item = new InventoryItem();
		item.setInventoryItemCode(CodeUtil.genCode(InventoryItem.class.getSimpleName().toUpperCase()));
		item.setInventoryCode(inventory.getInventoryCode());
		item.setStockNumber(0);
		item.setAvailableStockNumber(0);
		item.setOccupyStockNumber(0);
		item.setStatus(Cons.STATUS_NORMAL);
		item.setCreateTime(inventory.getCreateTime());
		item.setCreateUserCode(inventory.getCreateUserCode());
		item.setCreateUserName(inventory.getCreateUserName());
		int id = inventoryItemDao.insert(item);
		item.setId(id);
		return item;
	}

	//插入入库单
	private InventoryIn saveInventoryIn(InventoryInModel inventoryInModel,
			Inventory inventory) {
		InventoryIn inventoryIn = new InventoryIn();
		inventoryIn.setInCode(CodeUtil.genCode(InventoryIn.class.getSimpleName().toUpperCase()));
		inventoryIn.setOriginalDocument(inventoryInModel.getOriginalDocument());
		inventoryIn.setProductType(inventoryInModel.getProductType());
		inventoryIn.setStatus(Cons.STATUS_NORMAL);
		inventoryIn.setInventoryCode(inventoryInModel.getInventoryCode());
		inventoryIn.setInType(inventoryInModel.getInType());
		inventoryIn.setFromCode(inventoryInModel.getFromCode());
		inventoryIn.setCreateUserCode(inventoryInModel.getFromCode());
		inventoryIn.setCreateUserName(inventoryInModel.getCreateUserName());
		inventoryIn.setCreateTime((int)(new Date().getTime()/1000));
		int id = inventoryInDao.insert(inventoryIn);
		inventoryIn.setId(id);
		return inventoryIn;
	}


	/**
	 * 创建仓库
	 * @author hailin.liu 2016年5月16日 下午7:17:15 <br/>
	 * @param inventoryInModel
	 */
	private Inventory saveInventory(InventoryInModel inventoryInModel) {
		Inventory inventory = new Inventory();
		inventory.setInventoryCode(CodeUtil.genCode(Inventory.class.getSimpleName()));
		inventory.setInventoryName(inventoryInModel.getInventoryName());
		inventory.setInventoryType(inventoryInModel.getInventoryType());
		inventory.setStatus(Cons.STATUS_NORMAL);
		Long time = new Date().getTime();
		inventory.setCreateTime((int) (time/1000));
		inventory.setCreateUserCode(inventoryInModel.getCreateUserCode());
		inventory.setCreateUserName(inventoryInModel.getCreateUserName());
		inventory.setInventoryCode(CodeUtil.genCode(Inventory.class.getSimpleName().toUpperCase()));
		
		//保存库存信息
		inventoryDao.insert(inventory);
		return inventory;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findInventoryIn(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		String inCode = jsonObj.getString("inCode");
		
		ValidateUtil.validateNullProperty(inCode, CodeConst.PARENT_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			//查询入库单
			InventoryIn inventoryIn = inventoryInDao.findByInCode(inCode);
			if(inventoryIn != null) {
				map.put("inCode", inCode);
				map.put("originalDocument", inventoryIn.getOriginalDocument());
				map.put("productType", inventoryIn.getProductType());
				map.put("createUserCode", inventoryIn.getCreateUserCode());
				map.put("createUserName", inventoryIn.getCreateUserName());
				map.put("createTime", inventoryIn.getCreateTime());
				
				//查询入库单明细
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq(InventoryInItemMapping.InCode, inCode);
				List<InventoryInItem> inventoryInItems = inventoryInItemDao.searchListW(queryParameter);
				if(inventoryInItems != null && inventoryInItems.size() > 0) {
					List<Object> objs = Lists.newArrayList();
					Map<String, InventorySku> skuMap = Maps.newHashMap();
					Map<String, InventoryItem> inventoryItemMap = Maps.newHashMap();
					for (InventoryInItem inventoryInItem : inventoryInItems) {
						objs.add(inventoryInItem.getInventorySkuCode());
					}
					
					//查询库存商品信息（从库）
					queryParameter = new QueryParameter();
					queryParameter.in(InventorySkuMapping.InventorySkuCode, objs.toArray());
					List<InventorySku> inventorySkuList = inventorySkuDao.searchListR(queryParameter);
					if(inventorySkuList != null && inventorySkuList.size() > 0) {
						for (InventorySku inventorySku : inventorySkuList) {
							skuMap.put(inventorySku.getInventorySkuCode(), inventorySku);
						}
					}
					
					//查询库存信息
					queryParameter = new QueryParameter();
					queryParameter.in(InventoryItemMapping.InventorySkuCode, objs.toArray());
					List<InventoryItem> inventoryItemList = inventoryItemDao.searchListR(queryParameter);
					if(inventoryItemList != null && inventoryItemList.size() > 0) {
						for (InventoryItem inventoryItem : inventoryItemList) {
							inventoryItemMap.put(inventoryItem.getInventorySkuCode(), inventoryItem);
						}
					}
					
					
					//遍历入库单明细，赋值
					List<InventoryItemModel> inItemList = Lists.newArrayList();
					for (InventoryInItem inventoryInItem : inventoryInItems) {
						String skuCode = inventoryInItem.getInventorySkuCode();
						InventorySku inventorySku = skuMap.get(skuCode);
						InventoryItem inventoryItem = inventoryItemMap.get(skuCode);
						
						InventoryItemModel inventoryItemModel = new InventoryItemModel();
						inventoryItemModel.setProductBrandCode(inventorySku.getProductBrandCode());
						inventoryItemModel.setProductBrandName(inventorySku.getProductBrandName());
						inventoryItemModel.setProductCode(inventorySku.getProductCode());
						inventoryItemModel.setProductName(inventorySku.getProductName());
						inventoryItemModel.setStockNumber(inventoryItem.getStockNumber());
						inventoryItemModel.setProductionTime(inventoryInItem.getProductionTime());
						inventoryItemModel.setSinglePrice(inventoryInItem.getSinglePrice());
						inventoryItemModel.setQuantity(inventoryInItem.getQuantity());
						inItemList.add(inventoryItemModel);
					}
					
					map.put("inItemList", inItemList);
				}
			}
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findInventoryInList(
			JSONObject jsonOb) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String inventoryCode = jsonOb.getString("inventoryCode");		//仓库code。必填
		String inventoryType = jsonOb.getString("inventoryType");	//父仓，子仓。必填
		String productType = jsonOb.getString("productType");	//院装，客装。选填。如果不填，查全部
		Integer startTime = jsonOb.getInteger("startTime");			//开始时间。选填
		Integer endTime = jsonOb.getInteger("endTime");			//结束时间。选填
		Integer page = jsonOb.getInteger("page");			//页码。必填
		Integer pageSize = jsonOb.getInteger("pageSize");			//每页显示记录数。选填
		
		ValidateUtil.validateNullProperty(inventoryType, CodeConst.INVENTORY_TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(productType, CodeConst.PRODUCT_TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(page, CodeConst.PAGE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			if(CodeConst.SUCCESS.equals(dto.getCode())) {
				//设置分页条件
				QueryCondition queryCondition = new QueryCondition();
				queryCondition.setPageIndex(page);
				queryCondition.setPageSize(pageSize == null ? Cons.PAGE_SIZE : pageSize);
				
				//设置排序规则
				SortParameter sortParameter = new SortParameter();
				sortParameter.add(InventoryInMapping.CreateTime, SqlOrder.DESC);
				queryCondition.setSortParameter(sortParameter);
				
				//设置查询参数
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq(InventoryInMapping.InventoryCode, inventoryCode);
				if(productType != null && !"".equals(productType)) {
					queryParameter.and().eq(InventoryInMapping.ProductType, productType);
				}
				if(startTime != null) {
					queryParameter.and().ge(InventoryInMapping.CreateTime, startTime);
				}
				if(endTime != null) {
					queryParameter.and().le(InventoryInMapping.CreateTime, endTime);
				}
				queryCondition.setQueryParameter(queryParameter);
				PagedList<InventoryIn> pagedList = inventoryInDao.searchByPage(queryCondition);
				map.put("pagedList", pagedList);
			} else {
				//如果验证未通过
				throw new BusinessException(dto.getCode(), dto.getMsg());
			}
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findProductList(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> resultMap = Maps.newHashMap();
		
		String inventoryCode = jsonObj.getString("inventoryCode");
		String productType = jsonObj.getString("productType");
		
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(productType, CodeConst.PRODUCT_TYPE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			//根据库存code查询库存明细
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryItemMapping.InventoryCode, inventoryCode);
			List<InventorySku> skuList = inventorySkuDao.searchProductListR(inventoryCode, productType);
			if(skuList != null && skuList.size() > 0) {
				Map<String, String> productBrandMap = Maps.newHashMap();
				for (InventorySku sku : skuList) {
					String brandName = productBrandMap.get(sku.getProductBrandCode());
					if(brandName == null) {
						productBrandMap.put(sku.getProductBrandCode(), sku.getProductBrandName());
					}
				}
				resultMap.put("productBrands", productBrandMap);
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		dto.setData(resultMap);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findStockNumberBySkuCodes(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String inventorySkuCodes = jsonObj.getString("inventorySkuCodes");
		
		ValidateUtil.validateNullProperty(inventorySkuCodes, CodeConst.SKU_CODES_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			String[] skuCodeArr = inventorySkuCodes.split(",");
			
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.in(InventoryItemMapping.InventorySkuCode, skuCodeArr);
			List<InventoryItem> inventoryItems = inventoryItemDao.searchListR(queryParameter);
			if(inventoryItems != null && inventoryItems.size() > 0) {
				for (InventoryItem inventoryItem : inventoryItems) {
					InventorySkuModel is = new InventorySkuModel();
					is.setStockNumber(inventoryItem.getStockNumber());
					is.setVersion(inventoryItem.getVersion());
					map.put(inventoryItem.getInventorySkuCode(), is);
				}
			}
			
			dto.setData(map);
			dto.setMsg(ValidateUtil.get(dto.getCode()));
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		return dto;
	}

//	private Map<String, InventorySkuModel> findStockNumberBySkuCodes(String skuCodes) {
//		Map<String, InventorySkuModel> map = Maps.newHashMap();
//		String[] skuCodeArr = skuCodes.split(",");
//		
//		QueryParameter queryParameter = new QueryParameter();
//		queryParameter.in(InventoryItemMapping.InventorySkuCode, skuCodeArr).and()
//								  .eq(InventoryItemMapping.Status, Cons.STATUS_NORMAL);
//		List<InventoryItem> inventoryItems = inventoryItemDao.searchListR(queryParameter);
//		if(inventoryItems != null && inventoryItems.size() > 0) {
//			for (InventoryItem inventoryItem : inventoryItems) {
//				InventorySkuModel is = new InventorySkuModel();
//				is.setStockNumber(inventoryItem.getStockNumber());
//				is.setVersion(inventoryItem.getVersion());
//				map.put(inventoryItem.getInventorySkuCode(), is);
//			}
//		}
//		return map;
//	}

	@Override
	@Transactional("db_transaction")
	public DataTransferObject<Map<String, Object>> inventoryOut(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		//获取参数
		InventoryOutModel inventoryOutModel = jsonObj.toJavaObject(InventoryOutModel.class);
		List<InventoryOutItemModel> list = inventoryOutModel.getInventoryOutItems();
		
		int now = (int)(new Date().getTime()/1000);
		InventoryOut inventoryOut = new InventoryOut();
		inventoryOut.setOutCode(CodeUtil.genCode(InventoryOut.class.getSimpleName().toUpperCase()));
		inventoryOut.setOutType(inventoryOutModel.getOutType());
		inventoryOut.setOutPattern(inventoryOutModel.getOutPattern());
		inventoryOut.setProductType(inventoryOutModel.getProductType());
		inventoryOut.setOriginalDocument(inventoryOutModel.getOriginalDocument());
		inventoryOut.setToCode(inventoryOutModel.getToCode());
		inventoryOut.setToName(inventoryOutModel.getToName());
		inventoryOut.setInventoryCode(inventoryOutModel.getInventoryCode());
		inventoryOut.setStatus(Cons.STATUS_NORMAL);
		inventoryOut.setJingshourenCode(inventoryOutModel.getJingshourenCode());
		inventoryOut.setJingshourenName(inventoryOutModel.getJingshourenName());
		inventoryOut.setCreateUserCode(inventoryOutModel.getCreateUserCode());
		inventoryOut.setCreateUserName(inventoryOutModel.getCreateUserName());
		inventoryOut.setCreateTime(now);
		inventoryOutDao.insert(inventoryOut);
		
		//如果是下发到店，需要生成调度单
		InventoryApply apply = new InventoryApply();
		if(inventoryOutModel.getOutType().equals(Cons.XIAFADAODIAN)) {
			Date date = new Date();
			apply.setApplyCode(CodeUtil.genCode(InventoryApply.class.getSimpleName()));
			apply.setComments("下发到店");
			apply.setCreateTime((int)(date.getTime()/1000));
			apply.setCreateUserCode(inventoryOutModel.getCreateUserCode());
			apply.setCreateUserName(inventoryOutModel.getCreateUserName());
			apply.setInventoryCode(inventoryOutModel.getInventoryCode());
			apply.setInventoryName(inventoryOutModel.getInventoryName());
			apply.setOriginalDocument(inventoryOutModel.getOriginalDocument());
			apply.setStatus(Cons.STATUS_XIAFADAODIANWAIT);
			apply.setToCode(inventoryOutModel.getToCode());
			apply.setToName(inventoryOutModel.getToName());
			apply.setType(Cons.XIAFADAODIAN);
			inventoryApplyDao.insert(apply);
		}
		
		if(list != null && list.size() > 0) {
			for (InventoryOutItemModel inventoryOutItemModel : list) {
				Inventory inventory = inventoryDao.getInventoryR(inventoryOutModel.getInventoryCode(), inventoryOutModel.getInventoryType());
				System.out.println(inventoryOutItemModel.getInventorySkuCode());
				System.out.println(inventory.getInventoryCode());
				List<InventoryItem> inventoryItems = inventoryItemDao.searchBySkuCode(inventoryOutItemModel.getInventorySkuCode(), inventory.getInventoryCode(), Cons.STATUS_NORMAL);
				InventoryItem inventoryItem = inventoryItems.get(0);
				//更新库存
				int count = inventoryItemDao.updateReduceInventoryQuantity(inventoryItem.getId(), inventoryOutItemModel.getQuantity(), inventoryOutItemModel.getVersion(), inventoryOut.getCreateUserCode(), inventoryOut.getCreateUserName(), inventoryOut.getCreateTime());
				if(count == 0) {
					throw new BusinessException(CodeConst.STOCK_VERSION_ERROR, ValidateUtil.get(CodeConst.STOCK_VERSION_ERROR));
				}
				InventoryItem inventoryItemNew = inventoryItemDao.searchByIdW(inventoryItem.getId());
				
				//检测是否需要发送存量提醒
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq(InventoryWarnningSettingMapping.InventoryCode, inventoryOut.getInventoryCode()).and().eq(InventoryWarnningSettingMapping.IsSend, Cons.UNSEND).and().eq(InventoryWarnningSettingMapping.Type, Cons.STOCK_WARNNING).and().eq(InventoryWarnningSettingMapping.InventorySkuCode, inventoryItemNew.getInventorySkuCode());
				List<InventoryWarnningSetting> inventoryWarnningSettings = inventoryWarnningSettingDao.searchList(queryParameter);
				if(inventoryWarnningSettings != null && inventoryWarnningSettings.size() > 0) {
					InventoryWarnningSetting inventoryWarnningSetting = inventoryWarnningSettings.get(0);
					Integer stockMin = Integer.parseInt(inventoryWarnningSetting.getCondition());
					if(inventoryItemNew.getStockNumber() <= stockMin) {
						//插入提醒信息
						InventoryWarning inventoryWarning = new InventoryWarning();
						inventoryWarning.setInventoryWarnningCode(CodeUtil.genCode(InventoryWarning.class.getSimpleName()));
						inventoryWarning.setInventoryCode(inventoryOut.getInventoryCode());
						inventoryWarning.setInventorySkuCode(inventoryWarning.getInventorySkuCode());
						inventoryWarning.setIsRead(Cons.UN_READ);
						inventoryWarning.setType(Cons.STOCK_WARNNING);
						inventoryWarning.setCreateTime(now);
						inventoryWarningDao.insert(inventoryWarning);
						
						//更新预警设置的更新时间
						inventoryWarnningSetting.setUpdateTime(now);
						inventoryWarnningSettingDao.update(inventoryWarnningSetting);
					}
				}
				
				//如果更新成功，插入出库单
				InventoryOutItem inventoryOutItem = new InventoryOutItem();
				inventoryOutItem.setOutItemCode(CodeUtil.genCode(InventoryOutItem.class.getSimpleName().toUpperCase()));
				inventoryOutItem.setInventorySkuCode(inventoryOutItemModel.getInventorySkuCode());
				inventoryOutItem.setOutCode(inventoryOut.getOutCode());
				inventoryOutItem.setInventorySkuCode(inventoryOutItemModel.getInventorySkuCode());
				inventoryOutItem.setQuantity(inventoryOutItemModel.getQuantity());
				inventoryOutItem.setStatus(Cons.STATUS_NORMAL);
				inventoryOutItem.setCreateUserCode(inventoryOut.getCreateUserCode());
				inventoryOutItem.setCreateUserName(inventoryOut.getCreateUserName());
				inventoryOutItem.setCreateTime(inventoryOut.getCreateTime());
				inventoryOutItemDao.insert(inventoryOutItem);
				
				
				//记录流水
				InventoryItem newInventoryItem = inventoryItemDao.searchByIdW(inventory.getId());
				saveInoutLog(inventory, inventoryItem, newInventoryItem, inventoryOut.getOutType(), Cons.RENGONGCHUKU, inventoryOutItem.getOutCode(), inventoryOutItem.getInventorySkuCode(), inventoryOutItem.getQuantity());
			
				//如果是下发到店
				if(inventoryOutModel.getOutType().equals(Cons.XIAFADAODIAN)) {
					//插入调度单明细和申请单日志
					InventoryApplyItem aItem = new InventoryApplyItem();
					aItem.setApplyCode(apply.getApplyCode());
					aItem.setApplyItemCode(CodeUtil.genCode(InventoryApplyItem.class.getSimpleName()));
					aItem.setCreateTime(apply.getCreateTime());
					aItem.setCreateUserCode(apply.getCreateUserCode());
					aItem.setCreateUserName(apply.getCreateUserName());
					aItem.setInventorySkuCode(inventoryOutItem.getInventorySkuCode());
					aItem.setQuantity(inventoryOutItem.getQuantity());
					inventoryApplyItemDao.insert(aItem);
					
					InventoryApplyLog log = new InventoryApplyLog();
					log.setApplyCode(apply.getApplyCode());
					log.setApplyLogCode(CodeUtil.genCode(InventoryApplyLog.class.getSimpleName()));
					log.setDescription(apply.getCreateUserName() + "下发到店：商品code为：" + inventoryOutItem.getInventorySkuCode() + "，数量为：" + inventoryOutItem.getQuantity());
					log.setNewStatus(apply.getStatus());
					log.setOperateTime(apply.getCreateTime());
					log.setOperatorCode(apply.getCreateUserCode());
					inventoryApplyLogDao.insert(log);
				}
			}
		}
		
		map.put("outCode", inventoryOut.getOutCode());
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findInventoryOut(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String outCode = jsonObj.getString("outCode");	//出库单号
		
		ValidateUtil.validateNullProperty(outCode, CodeConst.CHILD_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			
			//查询出库单
			InventoryOut inventoryOut = inventoryOutDao.searchByOutCode(outCode);
			
			InventoryOutResultModel inventoryOutResultModel = new InventoryOutResultModel();
			inventoryOutResultModel.setOutCode(inventoryOut.getOutCode());
			inventoryOutResultModel.setOutType(inventoryOut.getOutType());
			inventoryOutResultModel.setProductType(inventoryOut.getProductType());
			inventoryOutResultModel.setOriginalDocument(inventoryOut.getOriginalDocument());
			inventoryOutResultModel.setCreateUserName(inventoryOut.getCreateUserName());
			inventoryOutResultModel.setCreateTime(inventoryOut.getCreateTime());
			
			//查询出库明细
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryOutItemMapping.OutCode, inventoryOut.getOutCode());
			List<InventoryOutItem> inventoryOutItems = inventoryOutItemDao.searchList(queryParameter);
			if(inventoryOutItems != null && inventoryOutItems.size() > 0) {
				List<InventoryOutItemResultModel> inventoryOutItemResultModels = Lists.newArrayList();
				List<String> skuCodeList = Lists.newArrayList();
				for (InventoryOutItem inventoryOutItem : inventoryOutItems) {
					skuCodeList.add(inventoryOutItem.getInventorySkuCode());
				}
				
				////查询库存
				Inventory inventory = inventoryDao.getInventoryR(inventoryOut.getInventoryCode(),null);
				
				//查询库存明细
				queryParameter = new QueryParameter();
				queryParameter.in(InventoryItemMapping.InventorySkuCode, skuCodeList.toArray()).and().eq(InventoryItemMapping.InventoryCode, inventory.getInventoryCode()).and().eq(InventoryItemMapping.Status, Cons.STATUS_NORMAL);
				List<InventoryItem> inventoryItems = inventoryItemDao.searchListR(queryParameter);
				
				if(inventoryItems != null && inventoryItems.size() > 0) {
					InventoryItem inventoryItem = inventoryItems.get(0);
					
					//查询商品信息
					InventorySku sku = inventorySkuDao.searchByInventorySkuCode(inventoryItem.getInventorySkuCode());
					
					for (InventoryOutItem inventoryOutItem : inventoryOutItems) {
						InventoryOutItemResultModel inventoryOutItemResultModel = new InventoryOutItemResultModel();
						inventoryOutItemResultModel.setQuantity(inventoryOutItem.getQuantity());
						inventoryOutItemResultModel.setStockNumber(inventoryItem.getStockNumber());
						inventoryOutItemResultModel.setProductBrandName(sku.getProductBrandName());
						inventoryOutItemResultModel.setProductName(sku.getProductName());
						inventoryOutItemResultModels.add(inventoryOutItemResultModel);
					}
				}
				inventoryOutResultModel.setOutItemList(inventoryOutItemResultModels);
			}
			map.put("inventoryOutResult", inventoryOutResultModel);
			dto.setData(map);
			dto.setMsg(ValidateUtil.get(dto.getCode()));
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findInventoryOutList(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String inventoryCode = jsonObj.getString("inventoryCode");	//库存code
		String productType = jsonObj.getString("productType");		//院装，客装
		Integer startTime = jsonObj.getInteger("startTime");		//开始时间
		Integer endTime = jsonObj.getInteger("endTime");		//结束时间
		Integer page = jsonObj.getInteger("page");		//页码
		Integer pageSize = jsonObj.getInteger("pageSize");		//每页显示记录数
		
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(page, CodeConst.PAGE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			pageSize = (pageSize == null) ? Cons.PAGE_SIZE : pageSize;
			
			QueryCondition queryCondition = new QueryCondition();
			//设置分页信息
			queryCondition.setPageIndex(page);
			queryCondition.setPageSize(pageSize);
			//设置排序信息
			SortParameter sortParameter = new SortParameter();
			sortParameter.add(InventoryOutMapping.CreateTime, SqlOrder.DESC);
			queryCondition.setSortParameter(sortParameter);
			//设置查询参数
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryOutMapping.InventoryCode, inventoryCode);
			if(StringUtils.isNotEmpty(productType)) {
				queryParameter.and().eq(InventoryOutMapping.ProductType, productType);
			}
			if(startTime != null) {
				queryParameter.and().ge(InventoryOutMapping.CreateTime, startTime);
			}
			if(endTime != null) {
				queryParameter.and().le(InventoryOutMapping.CreateTime, endTime);
			}
			queryCondition.setQueryParameter(queryParameter);
			PagedList<InventoryOut> pageList = inventoryOutDao.searchByPage(queryCondition);
			map.put("pageList", pageList);
			dto.setData(map);
			dto.setMsg(ValidateUtil.get(dto.getCode()));
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		return dto;
	}


	@Override
	@Transactional
	public DataTransferObject<Map<String, Object>> stockCheck(JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		int now = (int)(new Date().getTime() / 1000);
		
		InventoryStockCheckModel inventoryStockCheckModel = jsonObj.toJavaObject(InventoryStockCheckModel.class);
		
		//保存盘点
		InventoryStockCheck inventoryStockCheck = new InventoryStockCheck();
		inventoryStockCheck.setStockCheckCode(CodeUtil.genCode(InventoryStockCheck.class.getSimpleName()));
		inventoryStockCheck.setInventoryCode(inventoryStockCheckModel.getInventoryCode());
		inventoryStockCheck.setStatus(Cons.UN_PROCESS);
		inventoryStockCheck.setStartTime(inventoryStockCheckModel.getStartTime());
		inventoryStockCheck.setEndTime(inventoryStockCheckModel.getEndTime());
		inventoryStockCheck.setCreateUserCode(inventoryStockCheckModel.getCreateUserCode());
		inventoryStockCheck.setCreateUserName(inventoryStockCheckModel.getCreateUserName());
		inventoryStockCheck.setCreateTime(now);
		inventoryStockCheck = inventoryStockCheckDao.insert(inventoryStockCheck);
		
		map.put("stockCheckCode", inventoryStockCheck.getStockCheckCode());
		
		
		//保存盘点明细
		List<InventoryStockCheckItemModel> InventoryStockCheckItemModels = inventoryStockCheckModel.getInventorySkuList();
		if(InventoryStockCheckItemModels != null && InventoryStockCheckItemModels.size() > 0) {
			
			for (InventoryStockCheckItemModel inventoryStockCheckItemModel : InventoryStockCheckItemModels) {
				InventoryStockCheckItem inventoryStockCheckItem = new InventoryStockCheckItem();
				inventoryStockCheckItem.setStockCheckItemCode(CodeUtil.genCode(InventoryStockCheckItem.class.getSimpleName()));
				inventoryStockCheckItem.setStockCheckCode(inventoryStockCheck.getStockCheckCode());
				inventoryStockCheckItem.setInventorySkuCode(inventoryStockCheckItemModel.getInventorySkuCode());
				inventoryStockCheckItem.setStockQuantity(inventoryStockCheckItemModel.getStockNumber());
				inventoryStockCheckItem.setFactQuantity(inventoryStockCheckItemModel.getQuantity());
				inventoryStockCheckItem.setDifferenceQuantity(inventoryStockCheckItemModel.getDifferenceQuantity());
				inventoryStockCheckItem.setStatus(inventoryStockCheckItemModel.getDifferenceQuantity() == 0 ? Cons.STOCK_CHECK_COVER : Cons.UN_STOCK_CHECK_COVER);
				inventoryStockCheckItem.setCreateUserCode(inventoryStockCheckModel.getCreateUserCode());
				inventoryStockCheckItem.setCreateUserName(inventoryStockCheckModel.getCreateUserName());
				inventoryStockCheckItem.setCreateTime(now);
				inventoryStockCheckItem = inventoryStockCheckItemDao.insert(inventoryStockCheckItem);
				
				//保存盘点日志
				String descripe = inventoryStockCheckItem.getCreateUserName() + " 盘点了商品编码为" + inventoryStockCheckItem.getInventorySkuCode() + "的商品。";
				saveInventoryStockCheckLog(inventoryStockCheckItem.getStockCheckItemCode(), descripe, inventoryStockCheckItem.getCreateUserCode(), inventoryStockCheckItem.getCreateTime());
			}
		}
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}
	
	/**
	 * 保存盘点日志
	 * @author hailin.liu 2016年5月18日 下午2:27:22 <br/>
	 * @param stockCheckItemCode
	 * @param descripe
	 * @param operatorCode
	 * @param operateTime
	 */
	private void saveInventoryStockCheckLog(String stockCheckItemCode, String descripe, String operatorCode, Integer operateTime) {
		InventoryStockCheckLog inventoryStockCheckLog = new InventoryStockCheckLog();
		inventoryStockCheckLog.setStockCheckItemCode(stockCheckItemCode);
		inventoryStockCheckLog.setDescripe(descripe);
		inventoryStockCheckLog.setOperatorCode(operatorCode);
		inventoryStockCheckLog.setOperateTime(operateTime);
		inventoryStockCheckLogDao.insert(inventoryStockCheckLog);
	}


	@Override
	public DataTransferObject<Map<String, Object>> findStockCheckItems(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String stockCheckCode = jsonObj.getString("stockCheckCode");
		
		System.out.println(stockCheckCode);
		
		ValidateUtil.validateNullProperty(stockCheckCode, CodeConst.STOCK_CHECK_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			//查询从库
			InventoryStockCheck inventoryStockCheck = inventoryStockCheckDao.searchByCodeR(stockCheckCode);
			if(inventoryStockCheck != null) {
				InventoryStockCheckModel inventoryStockCheckModel = new InventoryStockCheckModel();
				inventoryStockCheckModel.setStartTime(inventoryStockCheck.getStartTime());
				inventoryStockCheckModel.setEndTime(inventoryStockCheck.getEndTime());
				
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq(InventoryStockCheckItemMapping.StockCheckCode, inventoryStockCheck.getStockCheckCode());
				List<InventoryStockCheckItem> inventoryStockCheckItems = inventoryStockCheckItemDao.searchListR(queryParameter);
				if(inventoryStockCheckItems != null && inventoryStockCheckItems.size() > 0) {
					Map<String, ProductBrandModel> brandMap = Maps.newHashMap();
					Map<String, List<ProductModel>> productMap = Maps.newHashMap();
					for (InventoryStockCheckItem inventoryStockCheckItem : inventoryStockCheckItems) {
						InventorySku inventorySku = inventorySkuDao.searchByInventorySkuCode(inventoryStockCheckItem.getInventorySkuCode());
						
						ProductBrandModel productBrandModel = brandMap.get(inventorySku.getInventorySkuCode());
						if(productBrandModel == null) {
							productBrandModel = new ProductBrandModel(); 
							productBrandModel.setProductBrandCode(inventorySku.getProductBrandCode());
							productBrandModel.setProductBrandName(inventorySku.getProductBrandName());
							brandMap.put(inventoryStockCheckItem.getInventorySkuCode(), productBrandModel);
						}
						
						List<ProductModel> productModels = productMap.get(inventoryStockCheckItem.getInventorySkuCode());
						if(productModels == null) {
							productModels = Lists.newArrayList();
						}
						ProductModel productModel = new ProductModel();
						productModel.setProductName(inventorySku.getProductName());
						productModel.setStockNumber(inventoryStockCheckItem.getStockQuantity());
						productModel.setFactStockNumber(inventoryStockCheckItem.getFactQuantity());
						productModel.setStatus(inventoryStockCheckItem.getStatus());
						productModel.setInventorySkuCode(inventoryStockCheckItem.getInventorySkuCode());
						productModel.setStockCheckItemCode(inventoryStockCheckItem.getStockCheckItemCode());
						productModels.add(productModel);
						productMap.put(inventoryStockCheckItem.getInventorySkuCode(), productModels);
					}
					
					List<ProductBrandModel> productBrandModels = Lists.newArrayList();
					for (String skuCode : brandMap.keySet()) {
						ProductBrandModel productBrandModel = brandMap.get(skuCode);
						List<ProductModel> productModels = productMap.get(skuCode);
						int unNormalProductTypeNumber = 0;
						for (ProductModel productModel : productModels) {
							if(Cons.UN_STOCK_CHECK_COVER.equals(productModel.getStatus())) {
								unNormalProductTypeNumber = unNormalProductTypeNumber + 1;
							}
						}
						productBrandModel.setUnNormalProductTypeNumber(unNormalProductTypeNumber);
						productBrandModel.setProductTypeNumber(productModels.size());   //设置品牌下的商品数量
						productBrandModel.setProductList(productModels);
						productBrandModels.add(productBrandModel);
					}
					
					inventoryStockCheckModel.setStockCheckItemList(productBrandModels);
				}
				map.put("inventoryStockCheck", inventoryStockCheckModel);
			}
			dto.setData(map);
			dto.setMsg(ValidateUtil.get(dto.getCode()));
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findStockCheckItem(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String stockCheckItemCode = jsonObj.getString("stockCheckItemCode");
		
		ValidateUtil.validateNullProperty(stockCheckItemCode, CodeConst.STOCK_CHECK_ITEM_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			
			//查询盘点明细(从库)
			InventoryStockCheckItem inventoryStockCheckItem = inventoryStockCheckItemDao.searchByCode(stockCheckItemCode);
			
			//查询盘点（从库）
			InventoryStockCheck inventoryStockCheck = inventoryStockCheckDao.searchByCodeR(inventoryStockCheckItem.getStockCheckCode());
			
			//查询库存
			List<InventoryItem> inventoryItems = inventoryItemDao.searchBySkuCode(inventoryStockCheckItem.getInventorySkuCode(), inventoryStockCheck.getInventoryCode(), Cons.STATUS_NORMAL);
			
			InventoryItem inventoryItem = inventoryItems.get(0);
			
			//查询库存商品(从库)
			InventorySku  inventorySku = inventorySkuDao.searchByInventorySkuCode(inventoryStockCheckItem.getInventorySkuCode());
			
			InventoryStockCheckItemResultModel inventoryStockCheckItemResultModel = new InventoryStockCheckItemResultModel();
			inventoryStockCheckItemResultModel.setStockCheckItemCode(inventoryStockCheckItem.getStockCheckItemCode());
			inventoryStockCheckItemResultModel.setInventorySkuCode(inventoryStockCheckItem.getInventorySkuCode());
			inventoryStockCheckItemResultModel.setProductBrandCode(inventorySku.getProductBrandCode());
			inventoryStockCheckItemResultModel.setProductBrandName(inventorySku.getProductBrandName());
			inventoryStockCheckItemResultModel.setProductCode(inventorySku.getProductCode());
			inventoryStockCheckItemResultModel.setProductName(inventorySku.getProductName());
			inventoryStockCheckItemResultModel.setStockQuantity(inventoryStockCheckItem.getStockQuantity());
			inventoryStockCheckItemResultModel.setFactQuantity(inventoryStockCheckItem.getFactQuantity());
			inventoryStockCheckItemResultModel.setDifferenceuantity(inventoryStockCheckItem.getDifferenceQuantity());
			inventoryStockCheckItemResultModel.setVersion(inventoryItem.getVersion());
			
			map.put("inventoryStockCheckItem", inventoryStockCheckItemResultModel);
			dto.setData(map);
			dto.setMsg(ValidateUtil.get(dto.getCode()));
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		return dto;
	}


	@Override
	@Transactional
	public DataTransferObject<Map<String, Object>> coverStockCheck(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		InventoryStockCheckProfitShortages inventoryStockCheckProfitShortages = jsonObj.getJSONObject("stockCheckProfitShortages").toJavaObject(InventoryStockCheckProfitShortages.class);
		
		Integer version = jsonObj.getInteger("version");
		Integer differenceQuantity = jsonObj.getInteger("differenceQuantity");
		
		ValidateUtil.validateNullPropertyNumber(version, CodeConst.VERSION_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(differenceQuantity, CodeConst.DIFFERENCE_QUANTITY_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			inventoryStockCheckProfitShortages.setProfitShortagesCode(CodeUtil.genCode(InventoryStockCheckProfitShortages.class.getSimpleName()));
			
			InventorySku inventorySku = inventorySkuDao.searchByInventorySkuCode(inventoryStockCheckProfitShortages.getInventorySkuCode());
			String productType = inventorySku.getProductType();
			
			inventoryStockCheckProfitShortages.setWarehouseCode(productType);
			String warehouseName = "";
			if(Cons.PRODUCT_COMPANY.equals(productType)) {
				warehouseName = "院装仓";
			} else {
				warehouseName = "客装仓";
			}
			inventoryStockCheckProfitShortages.setWarehouseName(warehouseName);
			inventoryStockCheckProfitShortages.setCreateTime((int)(new Date().getTime()/1000));
			
			inventoryStockCheckProfitShortagesDao.insert(inventoryStockCheckProfitShortages);
			
			InventoryStockCheckItem inventoryStockCheckItem = inventoryStockCheckItemDao.searchByCode(inventoryStockCheckProfitShortages.getStockCheckItemCode());
			InventoryStockCheck inventoryStockCheck = inventoryStockCheckDao.searchByCodeR(inventoryStockCheckItem.getStockCheckCode());
			List<InventoryItem> inventoryItems = inventoryItemDao.searchBySkuCode(inventoryStockCheckProfitShortages.getInventorySkuCode(), inventoryStockCheck.getInventoryCode(), Cons.STATUS_NORMAL);
			InventoryItem inventoryItem = inventoryItems.get(0);
			//更新库存
			//如果是盘盈，要减掉库存
			if(Cons.PROFIT.equals(inventoryStockCheckProfitShortages.getType())) {
				int count = inventoryItemDao.updateReduceInventoryQuantity(inventoryItem.getId(), differenceQuantity, version, inventoryStockCheckProfitShortages.getCreateUserCode(), inventoryStockCheckProfitShortages.getCreateUserName(), inventoryStockCheckProfitShortages.getCreateTime());
				if(count == 0) {
					throw new BusinessException(CodeConst.STOCK_VERSION_ERROR, ValidateUtil.get(CodeConst.STOCK_VERSION_ERROR));
				}
			}
			//如果是盘亏，要增加库存
			if(Cons.SHORTAGES.equals(inventoryStockCheckProfitShortages.getType())) {
				int count = inventoryItemDao.updateAddInventoryQuantity(inventoryItem.getId(), differenceQuantity, version, inventoryStockCheckProfitShortages.getCreateUserCode(), inventoryStockCheckProfitShortages.getCreateUserName(), inventoryStockCheckProfitShortages.getCreateTime());
				if(count == 0) {
					throw new BusinessException(CodeConst.STOCK_VERSION_ERROR, ValidateUtil.get(CodeConst.STOCK_VERSION_ERROR));
				}
			}
			
			//更新盘点明细状态为已平仓
			inventoryStockCheckItemDao.updateStatusById(inventoryStockCheckItem.getId(), Cons.STOCK_CHECK_COVER, inventoryStockCheckProfitShortages.getCreateUserCode(),
					inventoryStockCheckProfitShortages.getCreateUserName(), inventoryStockCheckProfitShortages.getCreateTime());
			
			//记录日志
			String descripe = inventoryStockCheckProfitShortages.getCreateUserName() + "进行了平仓操作。";
			this.saveInventoryStockCheckLog(inventoryStockCheckProfitShortages.getStockCheckItemCode(), descripe, 
					inventoryStockCheckProfitShortages.getCreateUserCode(), inventoryStockCheckProfitShortages.getCreateTime());
			
			map.put("profitShortagesode", inventoryStockCheckProfitShortages.getProfitShortagesCode());
			dto.setData(map);
			dto.setMsg(ValidateUtil.get(dto.getCode()));
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findProfitShortage(
			JSONObject jsonObj) {
		
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String profitShortagesCode = jsonObj.getString("profitShortagesCode");
		
		ValidateUtil.validateNullProperty(profitShortagesCode, CodeConst.CHILD_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			InventoryStockCheckProfitShortages inventoryStockCheckProfitShortages = inventoryStockCheckProfitShortagesDao.searchByCode(profitShortagesCode);
			if(inventoryStockCheckProfitShortages != null) {
				map.put("profitShortages", inventoryStockCheckProfitShortages);
				
				InventoryStockCheckItem inventoryStockCheckItem = inventoryStockCheckItemDao.searchByCode(inventoryStockCheckProfitShortages.getStockCheckItemCode());
				map.put("stockCheckItem", inventoryStockCheckItem);
				
				InventorySku inventorySku = inventorySkuDao.searchByInventorySkuCode(inventoryStockCheckProfitShortages.getInventorySkuCode());
				map.put("inventorySku", inventorySku);
			}
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(map);
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findInAndOutList(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String inventorySkuCode = jsonObj.getString("inventorySkuCode");
		String inventoryCode = jsonObj.getString("inventoryCode");
		String InventoryType = jsonObj.getString("InventoryType");
		Integer page = jsonObj.getInteger("page");
		Integer pageSize = jsonObj.getInteger("pageSize");
		
		ValidateUtil.validateNullProperty(inventorySkuCode, CodeConst.SKU_CODES_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(InventoryType, CodeConst.INVENTORY_TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(page, CodeConst.PAGE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			pageSize = (pageSize == null) ? Cons.PAGE_SIZE : pageSize;
			
			//查询商品信息
			InventorySku inventorySku = inventorySkuDao.searchByInventorySkuCode(inventorySkuCode);
			map.put("inventorySku", inventorySku);
			
			QueryCondition queryCondition = new QueryCondition();
			//设置分页信息
			queryCondition.setPageIndex(page);
			queryCondition.setPageSize(pageSize);
			//设置排序信息
			SortParameter sortParameter = new SortParameter();
			sortParameter.add(InoutLogMapping.CreateTime, SqlOrder.DESC);
			queryCondition.setSortParameter(sortParameter);
			//设置查询参数
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InoutLogMapping.InventorySkuCode, inventorySkuCode).and().eq(InoutLogMapping.InventoryCode, inventoryCode);
			queryCondition.setQueryParameter(queryParameter);
			//查询从库
			PagedList<InoutLog> pageList = inoutLogDao.searchByPage(queryCondition);
			
			map.put("pageList", pageList);
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findStockCheckList(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		Map<String, InventoryStockCheckModel> resultMap = Maps.newHashMap();
		
		String inventoryCode = jsonObj.getString("inventoryCode");
		Integer page = jsonObj.getInteger("page");
		Integer pageSize = jsonObj.getInteger("pageSize");
		
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(page, CodeConst.PAGE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			pageSize = (pageSize == null)?Cons.PAGE_SIZE : pageSize;
			
			QueryCondition queryCondition = new QueryCondition();
			//设置分页信息
			queryCondition.setPageIndex(page);
			queryCondition.setPageSize(pageSize);
			//设置排序信息
			SortParameter sortParameter = new SortParameter();
			sortParameter.add(InventoryStockCheckMapping.CreateTime, SqlOrder.DESC);
			queryCondition.setSortParameter(sortParameter);
			//设置查询参数,查询盘点列表
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryStockCheckMapping.InventoryCode, inventoryCode);
			queryCondition.setQueryParameter(queryParameter);
			PagedList<InventoryStockCheck> pageList = inventoryStockCheckDao.searchByPage(queryCondition);
			
			map.put("pageList", pageList);
			
			List<InventoryStockCheck> inventoryStockChecks = pageList.getContent();
			if(inventoryStockChecks != null && inventoryStockChecks.size() > 0) {
				for (InventoryStockCheck inventoryStockCheck : inventoryStockChecks) {
					queryParameter = new QueryParameter();
					queryParameter.eq(InventoryStockCheckItemMapping.StockCheckCode, inventoryStockCheck.getStockCheckCode());
					List<InventoryStockCheckItem> inventoryStockCheckItems = inventoryStockCheckItemDao.searchListR(queryParameter);
					
					String status = Cons.PROCESS;
					int unNormalNumber = 0;
					
					if(inventoryStockCheckItems != null && inventoryStockCheckItems.size() > 0) {
						for (InventoryStockCheckItem inventoryStockCheckItem : inventoryStockCheckItems) {
							if(Cons.UN_STOCK_CHECK_COVER.equals(inventoryStockCheckItem.getStatus())) {
								status = Cons.UN_PROCESS;
								unNormalNumber++;
							}
						}
					}
					
					InventoryStockCheckModel inventoryStockCheckModel = new InventoryStockCheckModel();
					inventoryStockCheckModel.setStatus(status);
					inventoryStockCheckModel.setUnNormalNumber(unNormalNumber);
					inventoryStockCheckModel.setStockCheckCode(inventoryStockCheck.getStockCheckCode());
					resultMap.put(inventoryStockCheck.getStockCheckCode(), inventoryStockCheckModel);
					
					map.put("resultMap", resultMap);
				}
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findApplyList(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String statuses = jsonObj.getString("statuses");
		Integer page = jsonObj.getInteger("page");
		Integer pageSize = jsonObj.getInteger("pageSize");
		String types = jsonObj.getString("types");
		String fromCode = jsonObj.getString("fromCode");
		String toCode = jsonObj.getString("toCode");
		
		ValidateUtil.validateNullProperty(statuses, CodeConst.STATUS_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(types, CodeConst.TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(page, CodeConst.PAGE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			pageSize = (pageSize == null) ? Cons.PAGE_SIZE : pageSize;
			
			QueryCondition queryCondition = new QueryCondition();
			//设置分页信息
			queryCondition.setPageIndex(page);
			queryCondition.setPageSize(pageSize);
			//设置排序信息
			SortParameter sortParameter = new SortParameter();
			sortParameter.add(InventoryApplyMapping.CreateTime, SqlOrder.DESC);
			queryCondition.setSortParameter(sortParameter);
			//设置查询参数
			
			String[] typeArr = types.split(",");
			String[] statusArr = statuses.split(",");
			
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq("1", "1");
			if(StringUtils.isNotEmpty(fromCode)) {
				queryParameter.and().eq(InventoryApplyMapping.InventoryCode, fromCode);
			}
			if(StringUtils.isNotEmpty(toCode)) {
				queryParameter.and().eq(InventoryApplyMapping.ToCode, toCode);
			}
			if(typeArr != null && typeArr.length > 0) {
				queryParameter.and();
				for (int i = 0; i < statusArr.length; i++) {
					queryParameter.eq(InventoryApplyMapping.Type, typeArr[i]);
					if(i != typeArr.length - 1) {
						queryParameter.or();
					}
				}
			}
			
			if(statusArr != null && statusArr.length > 0) {
				queryParameter.and();
				for (int i = 0; i < statusArr.length; i++) {
					queryParameter.eq(InventoryApplyMapping.Status, statusArr[i]);
					if(i != statusArr.length - 1) {
						queryParameter.or();
					}
				}
			}
			queryCondition.setQueryParameter(queryParameter);
			PagedList<InventoryApply> pageList = inventoryApplyDao.searchByPage(queryCondition);
			map.put("pageList", pageList);
			
			List<InventoryApply> inventoryApplys = pageList.getContent();
			if(inventoryApplys != null && inventoryApplys.size() > 0) {
				Map<String, InventorySku> inventorySkuMap = Maps.newHashMap();
				List<String> applyCodeList = Lists.newArrayList();
				for (InventoryApply inventoryApply : inventoryApplys) {
					applyCodeList.add(inventoryApply.getApplyCode());
				}
				
				queryParameter = new QueryParameter();
				queryParameter.in(InventoryApplyItemMapping.ApplyCode, applyCodeList.toArray());
				List<InventoryApplyItem> inventoryApplyItems = inventoryApplyItemDao.searchList(queryParameter);
				if(inventoryApplyItems != null && inventoryApplyItems.size() > 0) {
					List<String> skuCodeList = Lists.newArrayList();
					Map<String,List<InventoryApplyItem>> inventoryApplyItemMap = Maps.newHashMap();
					for (InventoryApplyItem inventoryApplyItem : inventoryApplyItems) {
						skuCodeList.add(inventoryApplyItem.getInventorySkuCode());
						
						List<InventoryApplyItem> itemList = inventoryApplyItemMap.get(inventoryApplyItem.getApplyCode());
						if(itemList == null) {
							itemList = Lists.newArrayList();
						}
						itemList.add(inventoryApplyItem);
						inventoryApplyItemMap.put(inventoryApplyItem.getApplyCode(), itemList);
					}
					
					map.put("inventoryApplyItemMap", inventoryApplyItemMap);
					
					queryParameter = new QueryParameter();
					queryParameter.in(InventorySkuMapping.InventorySkuCode, skuCodeList.toArray());
					List<InventorySku> inventorySkuList = inventorySkuDao.searchListR(queryParameter);
					if(inventorySkuList != null && inventorySkuList.size() > 0) {
						for (InventorySku inventorySku : inventorySkuList) {
							InventorySku sku = inventorySkuMap.get(inventorySku.getInventorySkuCode());
							if(sku == null) {
								inventorySkuMap.put(inventorySku.getInventorySkuCode(), inventorySku);
							}
						}
						map.put("InventorySkuMap", inventorySkuMap);
					}
				}
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findApplyItemList(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String applyCode = jsonObj.getString("applyCode");
		
		ValidateUtil.validateNullProperty(applyCode, CodeConst.CHILD_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			
			InventoryApply inventoryApply = inventoryApplyDao.searchByCode(applyCode);
			map.put("inventoryApply", inventoryApply);
			
			List<InventoryApplyLog> logList = inventoryApplyLogDao.findListR(inventoryApply.getApplyCode());
			map.put("logList", logList);
			
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryApplyItemMapping.ApplyCode, inventoryApply.getApplyCode());
			List<InventoryApplyItem> inventoryApplyItems = inventoryApplyItemDao.searchList(queryParameter);
			
			if(inventoryApplyItems != null && inventoryApplyItems.size() > 0) {
				StringBuilder skuCodes = new StringBuilder();
				Map<String, Integer> applyNumberMap = Maps.newHashMap();
				for (InventoryApplyItem inventoryApplyItem : inventoryApplyItems) {
					skuCodes.append(inventoryApplyItem.getInventorySkuCode()).append(",");
					applyNumberMap.put(inventoryApplyItem.getInventorySkuCode(), inventoryApplyItem.getQuantity());
				}
				skuCodes.deleteCharAt(skuCodes.length() - 1);
				
				queryParameter = new QueryParameter();
				queryParameter.in(InventorySkuMapping.InventorySkuCode, skuCodes.toString().split(","));
				List<InventorySku> inventorySkus = inventorySkuDao.searchListR(queryParameter);
				
				if(inventorySkus != null && inventorySkus.size() > 0) {
					Map<String, InventorySku> productBrandsMap = Maps.newHashMap();
					Map<String, List<InventorySku>> productsMap = Maps.newHashMap();
					List<String> skuCodeList = Lists.newArrayList();
					
					for (InventorySku inventorySku : inventorySkus) {
						InventorySku inventorySkuTemp = productBrandsMap.get(inventorySku.getInventorySkuCode());
						if(inventorySkuTemp == null) {
							productBrandsMap.put(inventorySku.getInventorySkuCode(), inventorySku);
						}
						
						List<InventorySku> inventorySkusTemp = productsMap.get(inventorySku.getInventorySkuCode());
						if(inventorySkusTemp == null) {
							inventorySkusTemp = Lists.newArrayList();
						}
						inventorySkusTemp.add(inventorySku);
						productsMap.put(inventorySku.getInventorySkuCode(), inventorySkusTemp);
						
						skuCodeList.add(inventorySku.getInventorySkuCode());
						
					}
					
					queryParameter = new QueryParameter();
					queryParameter.eq(InventoryItemMapping.InventoryCode, inventoryApply.getToCode()).and().in(InventoryItemMapping.InventorySkuCode, skuCodeList.toArray());
					
					List<InventoryItem> inventoryItemList = inventoryItemDao.searchListR(queryParameter);
					
					if(inventoryItemList != null && inventoryItemList.size() > 0) {
						Map<String, List<InventoryItem>> inventoryItemMap = Maps.newHashMap();
						for (InventoryItem inventoryItem : inventoryItemList) {
							List<InventoryItem> itemList = inventoryItemMap.get(inventoryItem.getInventorySkuCode());
							if(itemList == null) {
								itemList = Lists.newArrayList();
							}
							itemList.add(inventoryItem);
							inventoryItemMap.put(inventoryItem.getInventorySkuCode(), itemList);
						}
						map.put("inventoryItemMap", inventoryItemMap);
					}
					
					map.put("productBrands", productBrandsMap.values());
					map.put("productsMap", productsMap);
					
				}
				
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	@Transactional
	public DataTransferObject<Map<String, Object>> approve(JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String applyCode = jsonObj.getString("applyCode");
		String status = jsonObj.getString("status");
		String updateUserCode = jsonObj.getString("updateUserCode");
		String updateUserName = jsonObj.getString("updateUserName");
		//JSONObject inventoryOutModelJsonObject = jsonObj.getJSONObject("inventoryOutModel");
		
		ValidateUtil.validateNullProperty(applyCode, CodeConst.APPLY_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(status, CodeConst.STATUS_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(updateUserCode, CodeConst.USER_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(updateUserName, CodeConst.USER_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			//更新申请单状态
			UpdateParameter updateParameter = new UpdateParameter();
			updateParameter.add(InventoryApplyMapping.Status, status);
			updateParameter.add(InventoryApplyMapping.UpdateUserCode, updateUserCode);
			updateParameter.add(InventoryApplyMapping.UpdateUserName, updateUserName);
			updateParameter.add(InventoryApplyMapping.UpdateTime, (int)(new Date().getTime()/1000));
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryApplyMapping.ApplyCode, applyCode);
			updateParameter.setQueryParameter(queryParameter);
			inventoryApplyDao.update(updateParameter);
			
			//出库
			//this.inventoryOut(inventoryOutModelJsonObject);
			
			//添加日志
			InventoryApplyLog inventoryApplyLog = new InventoryApplyLog();
			inventoryApplyLog.setApplyLogCode(CodeUtil.genCode(InventoryApplyLog.class.getSimpleName()));
			inventoryApplyLog.setApplyCode(applyCode);
			inventoryApplyLog.setNewStatus(status);
			inventoryApplyLog.setDescription(updateUserName + "更改了申请单状态。");
			inventoryApplyLog.setOperatorCode(updateUserCode);
			inventoryApplyLog.setOperateTime((int)(new Date().getTime()/1000));
			
			inventoryApplyLogDao.insert(inventoryApplyLog);
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	@Transactional
	public DataTransferObject<Map<String, Object>> addApply(JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		InventoryApplyModel inventoryApplyModel = jsonObj.toJavaObject(InventoryApplyModel.class);
		
		ValidateUtil.validateNullProperty(inventoryApplyModel.getApplyProductType(), CodeConst.PRODUCT_TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryApplyModel.getInventoryCode(), CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryApplyModel.getToCode(), CodeConst.TO_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryApplyModel.getToName(), CodeConst.TO_NAME_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryApplyModel.getType(), CodeConst.TYPE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryApplyModel.getCreateUserCode(), CodeConst.USER_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryApplyModel.getCreateUserName(), CodeConst.USER_NAME_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryApplyModel.getStatus(), CodeConst.STATUS_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			int now = (int)(new Date().getTime()/1000);
			//保存申请单
			InventoryApply inventoryApply = new InventoryApply();
			inventoryApply.setApplyCode(CodeUtil.genCode(InventoryApply.class.getSimpleName()));
			inventoryApply.setInventoryCode(inventoryApplyModel.getInventoryCode());
			inventoryApply.setInventoryName(inventoryApplyModel.getInventoryName());
			inventoryApply.setToCode(inventoryApplyModel.getToCode());
			inventoryApply.setToName(inventoryApplyModel.getToName());
			inventoryApply.setComments(inventoryApplyModel.getComments());
			inventoryApply.setOriginalDocument(inventoryApplyModel.getOriginalDocument());
			inventoryApply.setType(inventoryApplyModel.getType());
			inventoryApply.setStatus(inventoryApplyModel.getStatus());
			inventoryApply.setCreateUserCode(inventoryApplyModel.getCreateUserCode());
			inventoryApply.setCreateUserName(inventoryApplyModel.getCreateUserName());
			inventoryApply.setCreateTime(now);
			inventoryApplyDao.insert(inventoryApply);
			
			map.put("applyCode", inventoryApply.getApplyCode());
			
			List<InventoryApplyItemModel> inventoryApplyItemModels = inventoryApplyModel.getInventoryApplyItemModels();
			if(inventoryApplyItemModels != null && inventoryApplyItemModels.size() > 0) {
				for (InventoryApplyItemModel inventoryApplyItemModel : inventoryApplyItemModels) {
					InventoryApplyItem inventoryApplyItem = new InventoryApplyItem();
					inventoryApplyItem.setApplyItemCode(CodeUtil.genCode(InventoryApplyItem.class.getSimpleName()));
					inventoryApplyItem.setApplyCode(inventoryApply.getApplyCode());
					inventoryApplyItem.setInventorySkuCode(inventoryApplyItemModel.getInventorySkuCode());
					inventoryApplyItem.setQuantity(inventoryApplyItemModel.getQuantity());
					inventoryApplyItem.setCreateUserCode(inventoryApply.getCreateUserCode());
					inventoryApplyItem.setCreateUserName(inventoryApply.getCreateUserName());
					inventoryApplyItem.setCreateTime(now);
					inventoryApplyItemDao.insert(inventoryApplyItem);
					
					//插入日志
					InventoryApplyLog inventoryApplyLog = new InventoryApplyLog();
					inventoryApplyLog.setApplyLogCode(CodeUtil.genCode(InventoryApplyLog.class.getSimpleName()));
					inventoryApplyLog.setApplyCode(inventoryApply.getApplyCode());
					inventoryApplyLog.setNewStatus(inventoryApply.getStatus());
					inventoryApplyLog.setDescription(inventoryApply.getCreateUserName() + "发起了类型为" + inventoryApply.getType() + "的申请。申请的库存商品code为" + inventoryApplyItem.getInventorySkuCode() + ", 数量为" + inventoryApplyItem.getQuantity());
					inventoryApplyLog.setOperatorCode(inventoryApply.getCreateUserCode());
					inventoryApplyLog.setOperateTime(now);
					inventoryApplyLogDao.insert(inventoryApplyLog);
				}
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findWarnningList(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		String inventoryCode = jsonObj.getString("inventoryCode");
		Integer page = jsonObj.getInteger("page");
		Integer pageSize = jsonObj.getInteger("pageSize");
		
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.PARENT_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullPropertyNumber(page, CodeConst.PAGE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			pageSize = (pageSize == null) ? Cons.PAGE_SIZE : pageSize;
			
			QueryCondition queryCondition = new QueryCondition();
			//设置分页信息
			queryCondition.setPageIndex(page);
			queryCondition.setPageSize(pageSize);
			//设置排序信息
			SortParameter sortParameter = new SortParameter();
			sortParameter.add(InventoryWarningMapping.CreateTime, SqlOrder.DESC);
			queryCondition.setSortParameter(sortParameter);
			//设置查询参数
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryWarningMapping.InventoryCode, inventoryCode);
			
			queryCondition.setQueryParameter(queryParameter);
			PagedList<InventoryWarning> pageList = inventoryWarningDao.searchByPage(queryCondition);
			map.put("pageList", pageList);
			
			List<InventoryWarning> inventoryWarnings = pageList.getContent();
			if(inventoryWarnings != null && inventoryWarnings.size() > 0) {
				StringBuilder skuCodes = new StringBuilder();
				for (InventoryWarning inventoryWarning : inventoryWarnings) {
					skuCodes.append(inventoryWarning.getInventorySkuCode()).append(",");
				}
				skuCodes.deleteCharAt(skuCodes.length() - 1);

				queryParameter = new QueryParameter();
				queryParameter.in(InventorySkuMapping.InventorySkuCode, skuCodes.toString().split(","));
				List<InventorySku> inventorySkus =  inventorySkuDao.searchListR(queryParameter);
				if(inventorySkus != null && inventorySkus.size() > 0) {
					Map<String, String> skuMap = Maps.newHashMap();
					for (InventorySku inventorySku : inventorySkus) {
						skuMap.put(inventorySku.getInventorySkuCode(), inventorySku.getProductBrandName() + "-" + inventorySku.getProductName());
					}
					map.put("skuMap", skuMap);
				}
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<Map<String, Object>> findWarnningItem(
			JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> map = Maps.newHashMap();
		
		Integer warnningId = jsonObj.getInteger("warnningId");
		
		ValidateUtil.validateNullPropertyNumber(warnningId, CodeConst.WARNNING_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			
			InventoryWarning inventoryWarning = inventoryWarningDao.searchById(warnningId);
			
			InventorySku inventorySku = inventorySkuDao.searchByInventorySkuCode(inventoryWarning.getInventorySkuCode());
			map.put("inventorySku", inventorySku);
			
			List<InventoryItem> inventoryItems = inventoryItemDao.searchBySkuCode(inventoryWarning.getInventorySkuCode(), inventoryWarning.getInventoryCode(), Cons.STATUS_NORMAL);
			if(inventoryItems != null && inventoryItems.size() > 0) {
				InventoryItem inventoryItem = inventoryItems.get(0);
				map.put("inventoryItem", inventoryItem);
			}
			
			//更新为已读
			UpdateParameter updateParameter = new UpdateParameter();
			updateParameter.add(InventoryWarningMapping.IsRead, Cons.READED);
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryWarningMapping.Id, warnningId);
			updateParameter.setQueryParameter(queryParameter);
			inventoryWarningDao.update(updateParameter);
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(map);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	@Override
	public DataTransferObject<String> countWarnning(
			JSONObject jsonObj) {
		
		DataTransferObject<String> dto = new DataTransferObject<String>();
		
		String inventoryCode = jsonObj.getString("inventoryCode");
		
		ValidateUtil.validateNullProperty(inventoryCode, CodeConst.INVENTORY_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			
			Long count = inventoryWarningDao.countWarnning(inventoryCode);
			if(count > 0) {
				//有提醒
				dto.setData("YES");
			} else {
				//没有提醒
				dto.setData("NO");
			}
			
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}


	/**
	 * 计算总成本
	 * @param inventoryCode
	 * @return
	 */
	private Double findTotalCost(String inventoryCode, String productType, String productBrandcode, String productCode) {
		Double totalCost = inventorySkuDao.totalCost(inventoryCode, productType, productBrandcode, productCode);
		return totalCost;
	}



	@Override
	public DataTransferObject<Map<String, Object>> findInventory(JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> resultMap = Maps.newHashMap();
		
		String parentCode = jsonObj.getString("parentCode");
		String childCode = jsonObj.getString("childCode");
		String inventoryType = jsonObj.getString("inventoryType");
		String createUserCode = jsonObj.getString("createUserCode");
		String createUserName = jsonObj.getString("createUserName");
		String inventoryName = jsonObj.getString("inventoryName");
		
		ValidateUtil.validateNullProperty(parentCode, CodeConst.PARENT_CODE_NULL_ERROR, dto);
		ValidateUtil.validateNullProperty(inventoryType, CodeConst.INVENTORY_TYPE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventoryMapping.ParentCode, parentCode).and().eq(InventoryMapping.InventoryType, inventoryType);
			if(StringUtils.isNotEmpty(childCode)) {
				queryParameter.and().eq(InventoryMapping.ChildCode, childCode);
			}
			Inventory inventory = inventoryDao.searchInventory(queryParameter);
			if(inventory == null) {
				//如果不存在库存，则创建库存
				int now = (int)(new Date().getTime()/1000);
				
				inventory = new Inventory();
				inventory.setChildCode(childCode);
				inventory.setCreateTime(now);
				inventory.setCreateUserCode(createUserCode);
				inventory.setCreateUserName(createUserName);
				inventory.setInventoryCode(CodeUtil.genCode(Inventory.class.getSimpleName()));
				inventory.setInventoryName(inventoryName);
				inventory.setInventoryType(inventoryType);
				inventory.setParentCode(parentCode);
				inventory.setStatus(Cons.STATUS_NORMAL);
				
				inventoryDao.insert(inventory);
			}
			
			resultMap.put("inventory", inventory);
		} else {
			//如果验证未通过
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		dto.setData(resultMap);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}



	@Override
	public DataTransferObject<Map<String, Object>> findAllProductBrandListByParentCode(JSONObject jsonObj) {
		DataTransferObject<Map<String, Object>> dto = new DataTransferObject<Map<String, Object>>();
		Map<String, Object> resultMap = Maps.newHashMap();
		
		String parentCode = jsonObj.getString("parentCode");
		
		ValidateUtil.validateNullProperty(parentCode, CodeConst.PARENT_CODE_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq(InventorySkuMapping.ParentCode, parentCode);
			List<InventorySku> inventorySkuList = inventorySkuDao.searchListR(queryParameter);
			if(inventorySkuList != null && inventorySkuList.size() > 0) {
				Map<String, String> skuMap = Maps.newHashMap();
				for (InventorySku sku : inventorySkuList) {
					String brandName = skuMap.get(sku.getProductBrandCode());
					if(brandName == null) {
						skuMap.put(sku.getProductBrandCode(), sku.getProductBrandName());
					}
				}
				resultMap.put("productBrands", skuMap);
			}
		}
		
		dto.setData(resultMap);
		dto.setMsg(ValidateUtil.get(dto.getCode()));
		return dto;
	}
	
}

