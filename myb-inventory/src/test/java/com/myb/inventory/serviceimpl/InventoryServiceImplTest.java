package com.myb.inventory.serviceimpl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.myb.commons.dto.DataTransferObject;
import com.myb.entity.pojo.inventory.model.InventoryApplyItemModel;
import com.myb.entity.pojo.inventory.model.InventoryApplyModel;
import com.myb.entity.pojo.inventory.model.InventoryInModel;
import com.myb.entity.pojo.inventory.model.InventoryInProductModel;
import com.myb.entity.pojo.inventory.model.InventoryStockCheckItemModel;
import com.myb.entity.pojo.inventory.model.InventoryStockCheckModel;
import com.myb.inventory.cons.Cons;
import com.myb.inventory.service.InventoryService;

/**
 * Created by kangxiaorui on 16/5/21.
 */
public class InventoryServiceImplTest {

    private static final ApplicationContext cxt = new ClassPathXmlApplicationContext("config/sp/application_inventory.xml");

    InventoryService inventoryService = (InventoryService) cxt.getBean("inventoryService");
    
    /**
     * 查询库存信息时库存不存在便创建库存
     */
    @Test
    public void testFindInventory1() {
    	String json = "{\"parentCode\":\"1\",\"childCode\":\"\",\"inventoryType\":\"INVENTORY_PARENT\", \"createUserCode\":\"userCode01\", \"createUserName\":\"赛西施\", \"inventoryName\":\"大保健美容院\"}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInventory(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    
    
    /**
     * 查询库存信息
     */
    @Test
    public void testFindInventory() {
    	String json = "{\"parentCode\":\"1\",\"inventoryType\":\"INVENTORY_PARENT\"}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findInventory(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    @Test
    public void testFindProductBrandListByInventoryCode() {
    	String json = "{\"inventoryCode\":\"18273878478\",\"productType\":\"PRODUCT_CUSTOM\"}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findProductBrandListByInventoryCode(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    @Test
    public void testFindProductListByBrandCode() {
    	String json = "{\"inventoryCode\":\"18273878478\",\"productType\":\"PRODUCT_CUSTOM\", \"productBrandCode\":\"brand01\", \"page\":1, \"pageSize\":10}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findProductListByBrandCode(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    @Test
    public void testInventoryIn() {
    	InventoryInModel in = new InventoryInModel();
    	in.setInventoryCode("INVENTORY-93BA035FE41E41F9A5401E012A851C3B");
    	in.setCreateUserCode("userCode05");
    	in.setCreateUserName("大保健");
    	in.setFromCode("fromCode01");
    	in.setInType(Cons.CAIGOURUKU);
    	in.setInventoryName("大保健旗舰店");
    	in.setInventoryType(Cons.INVENTORY_PARENT);
    	in.setOriginalDocument("原始单据号01");
    	in.setProductType(Cons.PRODUCT_CUSTOM);
    	List<InventoryInProductModel> list = Lists.newArrayList();
    	InventoryInProductModel m1 = new InventoryInProductModel();
    	m1.setProductBrandCode("brand01");
    	m1.setProductCode("product01");
    	m1.setProductExpiredime(111111);
    	m1.setProductionTime(222222);
    	m1.setQuantity(20);
    	m1.setSinglePrice(10.0);
    	m1.setVersion(1);
    	list.add(m1);
    	
    	in.setInventoryInProductModels(list);
    	
    	String json = JSONObject.toJSON(in).toString();
    	System.out.println(json);
    	
    	JSONObject jsonObj = JSONObject.parseObject(json);
    	
    	DataTransferObject<Map<String, Object>> dto = inventoryService.inventoryIn(jsonObj);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 根据入库单号查询入库单详情
     */
    @Test
    public void testFindInventoryIn() {
        String json = "{\"inCode\":\"INVENTORYIN-12CFEBD832B24CAE88BE315C08480934\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryIn(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }

    /**
     * 查询某一个商品的库存详情
     */
    @Test
    public void testFindByProductCode() {
        //必填参数
        String json = "{\"productCode\":\"product01\"}";
        //全部参数
        //String json = "{\"productCode\":\"\",\"status\":\"\"}";
        JSONObject jsonObj  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findByProductCode(jsonObj);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询入库单列表
     */
    @Test
    public void testFindInventoryInList() {
        //全部参数
        String json = "{\"inventoryCode\":\"18273878478\",\"inventoryType\":\"INVENTORY_PARENT\",\"productType\":\"PRODUCT_CUSTOM\",\"startTime\":\"\",\"endTime\":\"\",\"page\":\"1\",\"pageSize\":\"\"}";
        //必填参数
        //String json = "{\"parentCode\":\"\",\"inventoryType\":\"\",\"productType\":\"\",\"page\":\"\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryInList(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询库存中的商品列表
     */
    @Test
    public void testFindProductList() {
        //必填参数
        String json = "{\"inventoryCode\":\"18273878478\",\"productType\":\"PRODUCT_CUSTOM\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findProductList(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    @Test
    public void testFindAllProductBrandListByParentCode() {
    	String json = "{\"parentCode\":\"1\"}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findAllProductBrandListByParentCode(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 根据商品code查询库存中的商品数量
     */
    @Test
    public void testFindStockNumberBySkuCodes() {
        String json = "{\"inventorySkuCodes\":\"01,02\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findStockNumberBySkuCodes(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 商品出库
     */
    @Test
    public void testInventoryOut() {
        String json = "{\"outType\":\"SHOUDONGCHUKU\"," +
                       "\"outPattern\":\"MEIRONGSHILINGQU\"," +
                       "\"productType\":\"PRODUCT_CUSTOM\"," +
                       "\"originalDocument\":\"1234567890\"," +
                       "\"createUserCode\":\"2322sdsds22\"," +
                       "\"createUserName\":\"sdcsd2e2weds2&\"," +
                       "\"toCode\":\"dfsdf34sdsd\"," +
                       "\"toName\":\"sdsdsd23424e\"," +
                       "\"inventoryCode\":\"18273878478\"," +
                       "\"inventoryType\":\"INVENTORY_PARENT\"," +
                       "\"jingshourenCode\":\"sdfsdas232sds\"," +
                       "\"jingshourenName\":\"sdcfsfas2323233sds\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        String jsonArrayStr = "[{\"inventorySkuCode\":\"01\",\"version\":\"17\",\"quantity\":\"10\"},{\"inventorySkuCode\":\"02\",\"version\":\"3\",\"quantity\":\"1\"}]";
        JSONArray jsonArray = JSONArray.parseArray(jsonArrayStr);
        jsonObject.put("inventoryOutItems",jsonArray);
        
        System.out.println(jsonObject.toJSONString());
        
        DataTransferObject<Map<String, Object>> dto = inventoryService.inventoryOut(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 根据出库单号查询出库单详情
     */
    @Test
    public void testFindInventoryOut() {
        String json = "{\"outCode\":\"INVENTORYOUT-863668030830408EADEE3F8B1CF32BA7\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryOut(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询出库单列表
     */
    @Test
    public void testFindInventoryOutList() {
        String json = "{\"inventoryCode\":\"18273878478\",\"productType\":\"PRODUCT_CUSTOM\",\"startTime\":\"\",\"endTime\":\"\",\"page\":\"1\",\"pageSize\":\"10\"}";
        //String json = "{\"parentCode\":\"\",\"inventoryType\",\"\",\"page\":\"\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findInventoryOutList(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 提交盘点
     */
    @Test
    public void testStockCheck() {
    	InventoryStockCheckModel check = new InventoryStockCheckModel();
    	check.setCreateUserCode("asddwdwdwdwdw");
    	check.setCreateUserName("dadiaosi");
    	check.setEndTime(111111111);
    	check.setInventoryCode("18273878478");
    	check.setStartTime(111111111);
    	List<InventoryStockCheckItemModel> InventoryStockCheckItemModels = Lists.newArrayList();
    	InventoryStockCheckItemModel item = new InventoryStockCheckItemModel();
    	item.setQuantity(80);
    	item.setStockNumber(70);
    	item.setDifferenceQuantity(10);
    	item.setInventorySkuCode("01");
    	InventoryStockCheckItemModels.add(item);
    	check.setInventorySkuList(InventoryStockCheckItemModels);
    	
    	String json = JSONObject.toJSON(check).toString();
    	System.out.println(json);
    	
    	JSONObject obj = JSONObject.parseObject(json);
    	
        DataTransferObject<Map<String, Object>> dto = inventoryService.stockCheck(obj);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询盘点明细列表
     */
    @Test
    public void testFindStockCheckItems() {
        String json = "{\"stockCheckCode\":\"INVENTORYSTOCKCHECK-12999897E5D74866A8999F6A60E7D443\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findStockCheckItems(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询盘点明细详情
     */
    @Test
    public void testFindStockCheckItem() {
        String json = "{\"stockCheckItemCode\":\"INVENTORYSTOCKCHECKITEM-A55A565C832245F3A304D97D0D2D9EE1\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findStockCheckItem(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 平仓操作
     */
    @Test
    public void testCoverStockCheck() {
    	String json = "{\"differenceQuantity\":\"10\",\"stockCheckProfitShortages\":{\"comment\":\"enenenenenene\",\"createTime\":0,\"createUserCode\":\"askljdklajslkdj\",\"createUserName\":\"ijijijijij\",\"id\":0,\"inventorySkuCode\":\"01\",\"originalDocument\":\"aksjdklajskld\",\"stockCheckItemCode\":\"INVENTORYSTOCKCHECKITEM-A55A565C832245F3A304D97D0D2D9EE1\",\"type\":\"PROFIT\",\"warehouseCode\":\"18273878478\",\"warehouseName\":\"牛逼的美容院\"},\"version\":\"14\"}";
    	JSONObject jsonObj = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.coverStockCheck(jsonObj);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询盘盈盘亏详情
     */
    @Test
    public void testFindProfitShortage() {
        String json = "{\"profitShortagesCode\":\"INVENTORYSTOCKCHECKPROFITSHORTAGES-847C1E63E2E94AFCBEB03E491E08510E\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findProfitShortage(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 根据库存商品code查询该商品的出入库记录
     */
    @Test
    public void testFindInAndOutList() {
        String json = "{\"inventorySkuCode\":\"01\",\"inventoryCode\":\"18273878478\",\"InventoryType\":\"INVENTORY_PARENT\",\"page\":\"1\",\"pageSize\":\"10\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findInAndOutList(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询盘点记录列表
     */
    @Test
    public void testFindStockCheckList() {
        String json = "{\"inventoryCode\":\"18273878478\",\"page\":\"1\",\"pageSize\":\"10\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findStockCheckList(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 申请入库
     */
    @Test
    public void testAddApply() {
    	InventoryApplyModel inventoryApplyModel = new InventoryApplyModel();
    	inventoryApplyModel.setApplyProductType(Cons.PRODUCT_CUSTOM);
    	inventoryApplyModel.setComments("dianliquehuo");
    	inventoryApplyModel.setCreateUserCode("asdwdwdwdwdw");
    	inventoryApplyModel.setCreateUserName("azxczxczxc");
    	inventoryApplyModel.setInventoryCode("zicang123");
    	inventoryApplyModel.setInventoryName("guomao1dian");
    	inventoryApplyModel.setOriginalDocument("kljkljkljlkjl");
    	inventoryApplyModel.setStatus(Cons.STATUS_DAIWOSHENPI);
    	inventoryApplyModel.setToCode("18273878478");
    	inventoryApplyModel.setToName("vvvv");
    	inventoryApplyModel.setType(Cons.SHENQINGRUKU);
    	
    	List<InventoryApplyItemModel> inventoryApplyItemModels = Lists.newArrayList();  	
    	InventoryApplyItemModel item = new InventoryApplyItemModel();
    	item.setInventorySkuCode("01");
    	item.setQuantity(10);
    	inventoryApplyItemModels.add(item);
    	
    	inventoryApplyModel.setInventoryApplyItemModels(inventoryApplyItemModels);
    	
    	String json = JSONObject.toJSON(inventoryApplyModel).toString();
    	System.out.println(json);
    	
    	DataTransferObject<Map<String, Object>> dto = inventoryService.addApply(JSONObject.parseObject(json));
    	System.out.println(JSONObject.toJSONString(dto));
    }
    
    /**
     * 查询调度列表
     */
    @Test
    public void testFindApplyList() {
        String json = "{\"toCode\":\"18273878478\",\"fromCode\":\"\",\"statuses\":\"DAIWOSHENPI\",\"page\":\"1\",\"pageSize\":\"10\",\"types\":\"SHENQINGRUKU\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findApplyList(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询申请单明细列表
     */
    @Test
    public void testFindApplyItemList() {
        String json = "{\"applyCode\":\"INVENTORYAPPLY-B418CE2EA15D40DD842AD906B792CBFA\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.findApplyItemList(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 审批
     */
    @Test
    public void testApprove() {
        //String json = "{\"applyCode\":\"INVENTORYAPPLY-B418CE2EA15D40DD842AD906B792CBFA\",\"status\":\"SHENPITONGGUO\",\"updateUserCode\":\"asdwdwdw\",\"updateUserName\":\"asdwdwdw\",\"inventoryOutModel\":{\"jingshourenName\":\"sdcfsfas2323233sds\",\"inventoryType\":\"INVENTORY_PARENT\",\"originalDocument\":\"1234567890\",\"inventoryCode\":\"18273878478\",\"toCode\":\"dfsdf34sdsd\",\"createUserCode\":\"2322sdsds22\",\"createUserName\":\"sdcsd2e2weds2&\",\"inventoryOutItems\":[{\"quantity\":\"10\",\"inventorySkuCode\":\"01\",\"version\":\"18\"},{\"quantity\":\"1\",\"inventorySkuCode\":\"02\",\"version\":\"4\"}],\"outType\":\"SHENQINGRUKU\",\"toName\":\"sdsdsd23424e\",\"jingshourenCode\":\"sdfsdas232sds\",\"outPattern\":\"MEIRONGSHILINGQU\",\"productType\":\"PRODUCT_CUSTOM\"}}";
        String json = "{\"applyCode\":\"INVENTORYAPPLY-B418CE2EA15D40DD842AD906B792CBFA\",\"status\":\"SHENPITONGGUO\",\"updateUserCode\":\"asdwdwdw\",\"updateUserName\":\"asdwdwdw\"}";
        JSONObject jsonObject  = JSONObject.parseObject(json);
        DataTransferObject<Map<String, Object>> dto = inventoryService.approve(jsonObject);
        System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询提醒列表
     */
    @Test
    public void testFindWarnningList() {
    	String json = "{\"inventoryCode\":\"18273878478\", \"page\":\"1\", \"pageSize\":\"10\"}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findWarnningList(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 查询提醒详情
     */
    @Test
    public void testFindWarnningItem() {
    	String json = "{\"warnningId\":1}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<Map<String, Object>> dto = inventoryService.findWarnningItem(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    /**
     * 是否存在提醒
     */
    @Test
    public void testCountWarnning() {
    	String json = "{\"inventoryCode\":\"18273878478\"}";
    	JSONObject jsonObject  = JSONObject.parseObject(json);
    	DataTransferObject<String> dto = inventoryService.countWarnning(jsonObject);
    	System.out.println(JSONObject.toJSON(dto));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

   

    

    

   

    


    

   

   

    

    

    

    
    
    

    

    

}