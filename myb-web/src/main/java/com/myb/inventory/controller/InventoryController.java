package com.myb.inventory.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.myb.commons.dto.DataTransferObject;
import com.myb.inventory.service.InventoryService;
import com.myb.web.util.DtoUtil;

@Controller
@RequestMapping("/inventory")
public class InventoryController extends BaseController {
    @Autowired
    private InventoryService inventoryService;
    
    /**
     * 1.查询库存信息
     * @param json
     * @return
     */
    @RequestMapping("/findInventory.jhtml")
    public @ResponseBody String findInventory(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInventory(jsonObject.getJSONObject("body"));
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 2.根据库存code查询库存商品品牌集合
     * @param json
     * @return
     */
    @RequestMapping("/findProductBrandListByInventoryCode.jhtml")
    public @ResponseBody String findProductBrandListByInventoryCode(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findProductBrandListByInventoryCode(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 3.根据商品品牌code查询库存商品集合
     * @param json
     * @return
     */
    @RequestMapping("/findProductListByBrandCode.jhtml")
    public @ResponseBody String findProductListByBrandCode(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findProductListByBrandCode(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 4.入库
     * @author hailin.liu 2016年5月21日 上午11:28:44 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/inventoryIn.jhtml")
    public @ResponseBody String inventoryIn(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.inventoryIn(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 5.根据入库单号查询入库单详情
     * @author hailin.liu 2016年5月21日 上午11:32:44 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findInventoryIn.jhtml")
    public @ResponseBody String findInventoryIn(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryIn(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 6.查询某一个商品的库存详情
     * @author hailin.liu 2016年5月21日 上午11:27:47 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findByProductCode.jhtml")
	public @ResponseBody String findByProductCode(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findByProductCode(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 7.查询入库单列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findInventoryInList.jhtml")
    public @ResponseBody String findInventoryInList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryInList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 8.查询库存中的商品列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findProductList.jhtml")
    public @ResponseBody String findProductList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findProductList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 9.查询美容院下的所有商品品牌集合
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findAllProductBrandListByParentCode.jhtml")
    public @ResponseBody String findAllProductBrandListByParentCode(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findAllProductBrandListByParentCode(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 10.根据商品code查询库存中的商品数量
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findStockNumberBySkuCodes.jhtml")
    public @ResponseBody String findStockNumberBySkuCodes(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findStockNumberBySkuCodes(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 11.商品出库
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/inventoryOut.jhtml")
    public @ResponseBody String inventoryOut(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.inventoryOut(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 12.根据出库单号查询出库单详情
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findInventoryOut.jhtml")
    public @ResponseBody String findInventoryOut(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryOut(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 13.查询出库单列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findInventoryOutList.jhtml")
    public @ResponseBody String findInventoryOutList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryOutList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 14.提交盘点
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/stockCheck.jhtml")
    public @ResponseBody String stockCheck(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.stockCheck(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 15.查询盘点明细列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findStockCheckItems.jhtml")
    public @ResponseBody String findStockCheckItems(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findStockCheckItems(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 16.查询盘点明细详情
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findStockCheckItem.jhtml")
    public @ResponseBody String findStockCheckItem(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findStockCheckItem(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 17.平仓操作
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/coverStockCheck.jhtml")
    public @ResponseBody String coverStockCheck(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.coverStockCheck(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 18.查询盘盈盘亏详情
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findProfitShortage.jhtml")
    public @ResponseBody String findProfitShortage(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findProfitShortage(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 19.根据库存商品code查询该商品的出入库记录
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findInAndOutList.jhtml")
    public @ResponseBody String findInAndOutList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInAndOutList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 20.查询盘点记录列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findStockCheckList.jhtml")
    public @ResponseBody String findStockCheckList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findStockCheckList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 21.发起申请
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/addApply.jhtml")
    public @ResponseBody String addApply(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.addApply(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 22.查询审批列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findApplyList.jhtml")
    public @ResponseBody String findApplyList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findApplyList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 23.查询申请单明细列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findApplyItemList.jhtml")
    public @ResponseBody String findApplyItemList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findApplyItemList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 24.审批
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/approve.jhtml")
    public @ResponseBody String approve(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.approve(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 25.查询提醒列表
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findWarnningList.jhtml")
    public @ResponseBody String findWarnningList(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findWarnningList(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 26.查询提醒详情
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/findWarnningItem.jhtml")
    public @ResponseBody String findWarnningItem(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findWarnningItem(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }
    
    /**
     * 27.是否存在提醒
     * @author hailin.liu 2016年5月21日 下午2:23:46 <br/>
     * @param json
     * @return
     */
    @RequestMapping("/countWarnning.jhtml")
    public @ResponseBody String countWarnning(@RequestBody String json) {
    	JSONObject jsonObject = JSONObject.parseObject(json);
    	DataTransferObject<String> dto = inventoryService.countWarnning(jsonObject);
    	return JSONObject.toJSONString(DtoUtil.convert(dto));
    }

}