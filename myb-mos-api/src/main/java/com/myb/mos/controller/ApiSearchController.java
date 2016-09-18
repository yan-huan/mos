package com.myb.mos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myb.entity.pojo.mos.FreshShop;
import com.myb.entity.pojo.mos.ShopProcess;
import com.myb.framework.data.PagedList;
import com.myb.framework.web.models.JsonModel;
import com.myb.framework.web.models.JsonModel.JsonModelStatus;
import com.myb.mos.VO.FinishShopVO;
import com.myb.mos.VO.MyShop;
import com.myb.mos.VO.ShopList;
import com.myb.mos.component.PageListCom;
import com.myb.mos.service.ShopProcessService;
import com.myb.mos.service.ShopService;

@Controller
@RequestMapping("/search")
public class ApiSearchController {
	@Autowired
	private ShopService shopService;
	@Autowired 
	private PageListCom pagelistCOM;
	@Autowired
	private ShopProcessService shopProcessService;
	@RequestMapping(value="/getShops",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel searchShop(@RequestParam Map<String,Object> data) {
		 JsonModel jsonModel=new JsonModel();
		 String shopName= (String)data.get("shopName");
		 String businessName= (String)data.get("businessName");
		 int pageIndex = Integer.parseInt(data.get("pageIndex")+"");
		 Long employeeId = Long.parseLong(data.get("employeeId")+"");
		 Long cityId = Long.parseLong(data.get("cityId")+"");
		 //0,私海，1：公海，2：已完成
		 int searchType= Integer.parseInt(data.get("searchType")+"");
		 if(searchType==0){
			 PagedList<FreshShop> pageList = pagelistCOM.findMyShopPageList(employeeId, pageIndex, shopName, businessName);
			//装配返回的data数据
			 ShopList shopList = new ShopList();
			 shopList.setRecordCount(pageList.getRecordCount());
			 shopList.setTotalPage(pageList.getTotalPage());
			 List<FreshShop> shops = pageList.getContent();
			 List<MyShop> reShopList = new ArrayList<MyShop>();
			 for(FreshShop shop:shops){
				 MyShop s = new MyShop();
				 s.setShopId(shop.getId());
				 s.setShopAddress(shop.getAddress());
				 //根据shopid查找shopProcess里的等级ABCD
				 ShopProcess process = shopProcessService.searchByShopId(shop.getId());
				 s.setShopLevel(process.getClientLevel());
				 s.setShopName(shop.getName());
				 reShopList.add(s);
			 }
			 shopList.setContent(reShopList);
			 
			 jsonModel.setCode("100000");
			 jsonModel.setStatus(JsonModelStatus.SUCCESS);
			 jsonModel.setData(shopList);
			return jsonModel;
		 }
		 if(searchType==1){
			 PagedList<FreshShop> pageList = pagelistCOM.findPublicShopPageList(cityId, pageIndex, shopName, businessName);
			 //装配返回的data数据
			 ShopList shopList = new ShopList();
			 shopList.setRecordCount(pageList.getRecordCount());
			 shopList.setTotalPage(pageList.getTotalPage());
			 List<FreshShop> shops = pageList.getContent();
			 List<MyShop> reShopList = new ArrayList<MyShop>();
			 for(FreshShop shop:shops){
				 MyShop s = new MyShop();
				 s.setShopId(shop.getId());
				 s.setShopAddress(shop.getAddress());
				 s.setShopName(shop.getName());
				 //根据shopid查找shopProcess里的等级ABCD
				 ShopProcess process = shopProcessService.searchByShopId(shop.getId());
				 s.setShopLevel(process.getClientLevel());
				 reShopList.add(s);
			 }
			 shopList.setContent(reShopList);
			 
			 jsonModel.setCode("100000");
			 jsonModel.setStatus(JsonModelStatus.SUCCESS);
			 jsonModel.setData(shopList);
			return jsonModel;
		 }
		 if(searchType==2){
			 PagedList<FreshShop> shopPageList = pagelistCOM.findFinishPageList(employeeId, pageIndex, shopName, businessName);
			 ShopList reData = new ShopList<>();
				List<FreshShop> shops = shopPageList.getContent();
				reData.setRecordCount(shopPageList.getRecordCount());
				reData.setTotalPage(shopPageList.getTotalPage());
				List<FinishShopVO> reContent = new ArrayList<FinishShopVO>();
				for(FreshShop s:shops){
					FinishShopVO vo = new FinishShopVO();
					vo.setShopAddress(s.getAddress());
					vo.setShopName(s.getName());
					ShopProcess process = shopProcessService.searchByShopId(s.getId());
					vo.setAmount(process.getAmount());
					vo.setFinishTime(process.getFinishTime());
					reContent.add(vo);
				}
				reData.setContent(reContent);
				jsonModel.setCode("100000");
				jsonModel.setData(reData);
				jsonModel.setStatus(JsonModelStatus.SUCCESS);
				return jsonModel;
		 }
		 	jsonModel.setCode("100000");
			jsonModel.setStatus(JsonModelStatus.FAIL);
			jsonModel.setMessage("searchType:"+searchType);
			return jsonModel;
	}
}
