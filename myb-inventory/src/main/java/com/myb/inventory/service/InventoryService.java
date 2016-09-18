package com.myb.inventory.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.myb.commons.dto.DataTransferObject;

public interface InventoryService {

	/**
	 * 01.根据院code，店code，仓库类型查询仓库信息
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findInventory(JSONObject jsonObj);
	
	/**
	 * 02.根据库存code查询库存商品品牌集合
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findProductBrandListByInventoryCode(JSONObject jsonObj);
	
	/**
	 * 03.根据商品品牌code查询库存商品集合
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findProductListByBrandCode(JSONObject jsonObj);
	
	/**
	 * 04.入库
	 * @author hailin.liu 2016年5月16日 下午5:34:16 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> inventoryIn(JSONObject jsonObj);
	
	/**
	 * 05.根据入库单号查询入库单详情
	 * @author hailin.liu 2016年5月17日 下午1:11:58 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findInventoryIn(JSONObject jsonObj);
	
	/**
	 * 06.查询某一个商品的库存详情
	 * @author hailin.liu 2016年5月16日 下午4:17:56 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findByProductCode(JSONObject jsonObj);
	
	/**
	 * 07.查询入库单列表
	 * @author hailin.liu 2016年5月17日 下午2:32:17 <br/>
	 * @param jsonOb
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findInventoryInList(JSONObject jsonObj);
	
	/**
	 * 08.查询库存中的商品列表
	 * @author hailin.liu 2016年5月17日 下午3:19:34 <br/>
	 * @param jsonOb
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findProductList(JSONObject jsonObj);
	
	/**
	 * 09.查询美容院下的所有商品品牌集合
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findAllProductBrandListByParentCode(JSONObject jsonObj);
	
	
	/**
	 * 10.根据商品code查询库存中的商品数量
	 * @author hailin.liu 2016年5月17日 下午4:36:56 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findStockNumberBySkuCodes(JSONObject jsonObj);
	
	/**
	 * 11.商品出库
	 * @author hailin.liu 2016年5月17日 下午5:33:08 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> inventoryOut(JSONObject jsonObj);
	
	/**
	 * 12.根据出库单号查询出库单详情
	 * @author hailin.liu 2016年5月17日 下午8:43:57 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findInventoryOut(JSONObject jsonObj);
	
	/**
	 * 13.查询出库单列表
	 * @author hailin.liu 2016年5月18日 上午10:23:42 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findInventoryOutList(JSONObject jsonObj);
	
	/**
	 * 14.提交盘点
	 * @author hailin.liu 2016年5月18日 下午12:41:39 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> stockCheck(JSONObject jsonObj);
	
	/**
	 * 15.查询盘点明细列表
	 * @author hailin.liu 2016年5月18日 下午2:30:27 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findStockCheckItems(JSONObject jsonObj);
	
	/**
	 * 16.查询盘点明细详情
	 * @author hailin.liu 2016年5月18日 下午4:00:54 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findStockCheckItem(JSONObject jsonObj);
	
	/**
	 * 17.平仓操作
	 * @author hailin.liu 2016年5月18日 下午6:38:19 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> coverStockCheck(JSONObject jsonObj);
	
	/**
	 * 18.查询盘盈盘亏详情
	 * @author hailin.liu 2016年5月18日 下午9:18:27 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findProfitShortage(JSONObject jsonObj);
	
	/**
	 * 19.根据库存商品code查询该商品的出入库记录
	 * @author hailin.liu 2016年5月19日 上午11:07:51 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findInAndOutList(JSONObject jsonObj);
	
	/**
	 * 20.查询盘点记录列表
	 * @author hailin.liu 2016年5月19日 下午12:26:14 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findStockCheckList(JSONObject jsonObj); 
	
	/**
	 * 21.申请入库
	 * @author hailin.liu 2016年5月19日 下午7:44:42 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> addApply(JSONObject jsonObj);
	
	/**
	 * 22.查询审批列表
	 * @author hailin.liu 2016年5月19日 下午2:49:59 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findApplyList(JSONObject jsonObj); 
	
	/**
	 * 23.查询申请单明细列表
	 * @author hailin.liu 2016年5月19日 下午4:43:36 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findApplyItemList(JSONObject jsonObj);
	
	/**
	 * 24.审批
	 * @author hailin.liu 2016年5月19日 下午6:05:25 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> approve(JSONObject jsonObj);
	
	/**
	 * 25.查询提醒列表
	 * @author hailin.liu 2016年5月20日 下午1:52:32 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findWarnningList(JSONObject jsonObj);
	
	/**
	 * 26.查询提醒详情
	 * @author hailin.liu 2016年5月20日 下午3:37:59 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<Map<String, Object>> findWarnningItem(JSONObject jsonObj);
	
	/**
	 * 27.是否存在提醒
	 * @author hailin.liu 2016年5月20日 下午5:45:31 <br/>
	 * @param jsonObj
	 * @return
	 */
	public DataTransferObject<String> countWarnning(JSONObject jsonObj);
}

