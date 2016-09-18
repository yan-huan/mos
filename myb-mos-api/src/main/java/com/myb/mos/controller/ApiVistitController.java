package com.myb.mos.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.myb.entity.pojo.mos.VisitRecord;
import com.myb.framework.data.PagedList;
import com.myb.framework.web.models.JsonModel;
import com.myb.framework.web.models.JsonModel.JsonModelStatus;
import com.myb.mos.VO.ShopList;
import com.myb.mos.VO.VisitInfoVO;
import com.myb.mos.component.PageListCom;
import com.myb.mos.service.ShopContactService;
import com.myb.mos.service.ShopProcessService;
import com.myb.mos.service.ShopService;
import com.myb.mos.service.VisitRecordService;
import com.myb.mos.utils.MapUtil;

@Controller
@RequestMapping("/visit")
public class ApiVistitController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopContactService shopContactService;
	@Autowired
	private ShopProcessService shopProcessService;
	@Autowired
	private VisitRecordService visitService;
	@Autowired
	private PageListCom pageListCOM;
	
	
	@RequestMapping(value="/record",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel visitRecord(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		 Long shopId = Long.parseLong(data.get("shopId")+"");
		 insertVisitRecord(data);
		//freshshop更新拜访次数+1
		FreshShop shop =shopService.searchById(shopId);
		int visitNum = shop.getVisitTimes();
		shop.setVisitTimes(visitNum+1);
		shopService.update(shop);
		
		jsonModel.setCode("100000");
		jsonModel.setStatus(JsonModelStatus.SUCCESS);
		return jsonModel;
	}

	/**
	 * shopId;
	 * employeeId;
	 * pageIndex
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/recordList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel recordList(@RequestParam Map<String,Object> data) {
		 Long shopId = Long.parseLong(data.get("shopId")+"");
		 Long employeeId = Long.parseLong(data.get("employeeId")+"");
		 JsonModel jsonModel=new JsonModel();
		 ShopProcess process = shopProcessService.searchById(shopId);
		 FreshShop shop = shopService.searchById(shopId);
		 //visitPageList
		 PagedList<VisitRecord> pageList = pageListCOM.getVisitTimesListInfo(shopId, employeeId);
		 //封装返回vo
		 ShopList visitRecordList = new ShopList<>();
		 List<VisitRecord> orVisitList = pageList.getContent();
		 List<VisitInfoVO> reVisitList = new ArrayList<VisitInfoVO>();
		 visitRecordList.setRecordCount(pageList.getRecordCount());
		 visitRecordList.setTotalPage(pageList.getTotalPage());

		for(VisitRecord vr:orVisitList){
			 VisitInfoVO vo = new VisitInfoVO();
			 vo.setClientLevel(vr.getClientLevel());
			 vo.setIsValide(vr.getIsValide());
			 vo.setPicUrl(vr.getPicUrl());
			 vo.setRemark(vr.getRemark());
			 vo.setVisitTime(vr.getVisitTime());
			 vo.setShopAddress(shop.getAddress());
			 vo.setShopName(shop.getName());
			 reVisitList.add(vo);
		 }
		visitRecordList.setContent(reVisitList);
		jsonModel.setCode("100000");
		jsonModel.setData(visitRecordList);
		jsonModel.setStatus(JsonModelStatus.SUCCESS);
		return jsonModel;
	}

	
	private void insertVisitRecord(Map<String, Object> data) {
		 VisitRecord vr = new VisitRecord();
		 Long shopId = Long.parseLong(data.get("shopId")+"");
		 vr.setShopId(shopId);
		 vr.setCreateTime(new Date());
		 vr.setClientLevel((String)data.get("clientLevel"));//A,B,C,D
		 vr.setClientName((String)data.get("clientName"));//拜访的人
		 if(data.get("contactId")!=null){
			 vr.setContractId(Long.parseLong(data.get("contactId")+""));
		 }
		 vr.setEmployeeId(Long.parseLong(data.get("employeeId")+""));
		 vr.setIsEscort(Integer.parseInt(data.get("isEscort")+""));//是否陪访
		 vr.setIsValide(Integer.parseInt(data.get("isValide")+""));
		 vr.setLatitude((String)data.get("latitude"));
		 vr.setLongitude((String)data.get("longitude"));
		 vr.setPicUrl((String)data.get("picUrl"));
		 vr.setRemark((String)data.get("remark"));
		 vr.setVisitTime((String)data.get("visitTime"));
		 
		 visitService.insert(vr);
		 //更新process表clientLevel和isEscort;
		 ShopProcess process = shopProcessService.searchByShopId(shopId);
		 String clientLevel = process.getClientLevel();
		 int oldLevelNum = MapUtil.getClientLevelNum(clientLevel);
		 int newLevelNum = MapUtil.getClientLevelNum((String)data.get("clientLevel"));
		 if(newLevelNum>oldLevelNum){
			process.setClientLevel((String)data.get("clientLevel"));
		 }
		 int isEscort= Integer.parseInt(data.get("isEscort")+"");
		 if(isEscort==1){
			process.setIsEscort(1);
		 }
		 
		 shopProcessService.update(process);
	}
	
}
