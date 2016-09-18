package com.myb.mos.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myb.entity.pojo.mos.FreshShop;
import com.myb.entity.pojo.mos.FreshShopMapping;
import com.myb.entity.pojo.mos.ShopContact;
import com.myb.entity.pojo.mos.ShopProcess;
import com.myb.entity.pojo.mos.VisitRecord;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.web.models.JsonModel;
import com.myb.framework.web.models.JsonModel.JsonModelStatus;
import com.myb.mos.VO.FinishShopVO;
import com.myb.mos.VO.MyShop;
import com.myb.mos.VO.ShopContactVO;
import com.myb.mos.VO.ShopDetailVO;
import com.myb.mos.VO.ShopList;
import com.myb.mos.VO.ShopProcessVO;
import com.myb.mos.component.CityCom;
import com.myb.mos.component.PageListCom;
import com.myb.mos.service.ShopContactService;
import com.myb.mos.service.ShopProcessService;
import com.myb.mos.service.ShopService;
import com.myb.mos.service.VisitRecordService;
import com.myb.mos.utils.MapUtil;


@Controller
@RequestMapping("/shop")
public class ApiShopController {
	
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
	@Autowired
	private CityCom cityCOM;
	/**
	 * 保存店的信息
	 * @param request
	 * @param response
	 * @param shopVo
	 * @return
	 */
	
	@RequestMapping(value="/createShop",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel createShop(@RequestParam Map<String,Object> data) {
		 JsonModel jsonModel=new JsonModel();
		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<name:"+data.get("name"));

		 boolean flag =isHadcreateShop((String)data.get("name"));
		 if(flag){//已经录入过该美容院
//			return new JsonModel(JsonModelStatus.FAIL,"已经录入过该美容院");
			 jsonModel.setCode("-1");
			 jsonModel.setStatus(JsonModelStatus.FAIL);
			 jsonModel.setData("");
			 jsonModel.setMessage("已经录入过该美容院");
			 return jsonModel;
		 }
		 insertShop(data);
		 
		 jsonModel.setCode("100000");
		 jsonModel.setStatus(JsonModelStatus.SUCCESS);
		 jsonModel.setData("");
		 jsonModel.setMessage("");
		return jsonModel;
	}
	/**
	 * shopId
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/shopContact",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel saveShopContact(@RequestParam Map<String,Object> data) {
		 JsonModel jsonModel=new JsonModel();
		 //手机号查重。
		 ShopContact contact = new ShopContact();
		 ShopContact con = shopContactService.searchByMobile(data.get("telephone")+"");
		 if(con!=null){
			 jsonModel.setCode("-1");
			 jsonModel.setStatus(JsonModelStatus.FAIL);
			 jsonModel.setData("");
			 jsonModel.setMessage("已经录入过该电话号码");
			 return jsonModel;
		 }
		 contact.setShopId(Long.parseLong(data.get("shopId")+""));
		 contact.setDuty((Integer.parseInt(data.get("duty")+"")));
		 contact.setName(data.get("name")+"");
		 contact.setTelephone(data.get("telephone")+"");
		 if(data.get("wechat")!=null){
			 contact.setWechat(data.get("wechat")+"");
		 }
		 shopContactService.insert(contact);
		 jsonModel.setCode("100000");
		 jsonModel.setStatus(JsonModelStatus.SUCCESS);
		return jsonModel;
	}
	@RequestMapping(value="/myShop",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel myShops(@RequestParam Map<String,Object> data) {
		 JsonModel jsonModel=new JsonModel();
		 Long employeeId = Long.parseLong(data.get("employeeId")+"");
		 int pageIndex = Integer.parseInt(data.get("pageIndex")+"");
		 PagedList<FreshShop> pageList = pageListCOM.myShopPageList(employeeId, pageIndex);
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
	
	/**
	 * pageIndex
	 * cityId=0的时候是其他
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/publicShop",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel publicShops(@RequestParam Map<String,Object> data) {
		 JsonModel jsonModel=new JsonModel();
		 Long cityId= Long.parseLong(data.get("cityId")+"");
		 int pageIndex = Integer.parseInt(data.get("pageIndex")+"");
		 PagedList<FreshShop> pageList = pageListCOM.publicShopPageList(cityId, pageIndex);
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
			 s.setShopLevel("D");
			 reShopList.add(s);
		 }
		 shopList.setContent(reShopList);
		 
		 jsonModel.setCode("100000");
		 jsonModel.setStatus(JsonModelStatus.SUCCESS);
		 jsonModel.setData(shopList);
		return jsonModel;
	}

	@RequestMapping(value="/shopDetail",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel shopDetail(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		ShopDetailVO sd = new ShopDetailVO();
		Long shopId = Long.parseLong(data.get("shopId")+"");
		 Long employeeId = Long.parseLong(data.get("employeeId")+"");
		 int pageIndex =1;
		 ShopProcess process = shopProcessService.searchByShopId(shopId);
		 FreshShop shop = shopService.searchById(shopId);
		 //visitTimesList
		 PagedList<VisitRecord> visitPageList = pageListCOM.getVisitTimesListInfo(shopId, employeeId);
		 PagedList<ShopContact> contactPageList = pageListCOM.contactPageList(shopId);
		 List<ShopContact> contactList = contactPageList.getContent();
		 //封装vo
		 ShopDetailVO vo= new ShopDetailVO();
		 vo.setContactNum(contactPageList.getRecordCount());
		 if(contactList.size()!=0){
			 vo.setDuty(contactList.get(0).getDuty());
		 }
		 vo.setIsFinish(shop.getIsFinish());
		 vo.setLatitude(shop.getLatitude());
		 vo.setLongitude(shop.getLongitude());
		 vo.setProcess(process.getProcess());
		 vo.setShopAddress(shop.getAddress());
		 vo.setShopLevel(process.getClientLevel());
		 vo.setShopName(shop.getName());
		 vo.setVisitTimes(visitPageList.getRecordCount());
		 
		 jsonModel.setCode("100000");
		 jsonModel.setStatus(JsonModelStatus.SUCCESS);
		 jsonModel.setData(vo);
		return jsonModel;
	}
	/**
	 * 公海变私海
	 * shopId
	 * employeeId
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/shopPrivate",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel publicToPrivate(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		//个人的私海数量要做限制。
		int Max=30;
		Long shopId = Long.parseLong(data.get("shopId")+"");
		Long employeeId = Long.parseLong(data.get("employeeId")+"");
		PagedList<FreshShop> pageList = pageListCOM.myShopPageList(employeeId, 1);
		int sumShop= pageList.getRecordCount();
		if(sumShop>Max){
			jsonModel.setCode("-1");
			jsonModel.setStatus(JsonModelStatus.FAIL);
			jsonModel.setMessage("私海数量不能超过"+Max);
			return jsonModel;
		}
		FreshShop shop= shopService.searchById(shopId);
		shop.setIsPublic(0);//0私海。
		shop.setEmployeeId(employeeId);
		shopService.update(shop);
		
		jsonModel.setCode("100000");
		jsonModel.setStatus(JsonModelStatus.SUCCESS);
		return jsonModel;
	}
	@RequestMapping(value="/quitShop",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel quitShop(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		Long shopId = Long.parseLong(data.get("shopId")+"");
		FreshShop shop= shopService.searchById(shopId);
		shop.setIsPublic(1);//1公海
		shop.setEmployeeId(0);
		shop.setVisitTimes(0);//拜访次数重置零。
		shop.setProcess("翻土");
		
		shopService.update(shop);
		//visitRecord记录无效isdel=1
		 PagedList<VisitRecord> pageList = pageListCOM.getVisitTimesListInfoMax(shopId, 1);
		 List<VisitRecord> doList = pageList.getContent();
		 for(VisitRecord vr:doList){
			 vr.setIsdel(1);
			 visitService.update(vr);
		 }
		jsonModel.setCode("100000");
		jsonModel.setStatus(JsonModelStatus.SUCCESS);
		return jsonModel;
	}
	/**
	 * shopId
	 * employeeId
	 * amount
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/shopFinish",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel okShop(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		Long employeeId = Long.parseLong(data.get("employeeId")+"");
		Long shopId = Long.parseLong(data.get("shopId")+"");
		//更新freshShop
		FreshShop shop= shopService.searchById(shopId);
		shop.setIsFinish(1);//签单
		shopService.update(shop);
		//shopProcess表更新
		ShopProcess process = shopProcessService.searchByShopId(shopId);
		process.setShopId(shopId);
		process.setEmployeeId(employeeId);
		process.setFinishTime(new Date());
		process.setAmount( new BigDecimal( (String)data.get("amount") ));
		shopProcessService.update(process);
		
		jsonModel.setCode("100000");
		jsonModel.setStatus(JsonModelStatus.SUCCESS);
		return jsonModel;
	}
	/**
	 * 已签单列表
	 * employeeId
	 * pageIndex
	 * @param data
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/finishList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel hasFinishedShops(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		Long employeeId = Long.parseLong(data.get("employeeId")+"");
		int pageIndex = Integer.parseInt(data.get("pageIndex")+"");
		PagedList<FreshShop> shopPageList = pageListCOM.finishPageList(employeeId, pageIndex);
		PagedList<ShopProcess> processList = pageListCOM.getMonthFinish(employeeId, 1);
		ShopList reData = new ShopList<>();
		List<FreshShop> shops = shopPageList.getContent();
		reData.setRecordCount(shopPageList.getRecordCount());
		reData.setTotalPage(shopPageList.getTotalPage());
		List<FinishShopVO> reContent = new ArrayList<FinishShopVO>();
		for(FreshShop s:shops){ 
			FinishShopVO vo = new FinishShopVO();
			vo.setMonthFinishNum(processList.getRecordCount());
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
	/**
	 * shopId
	 * employeeId
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/saveProcess",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel updateProcess(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		Long employeeId = Long.parseLong(data.get("employeeId")+"");
		Long shopId = Long.parseLong(data.get("shopId")+"");
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
		process.setEmployeeId(employeeId);
		process.setProcess((String)data.get("process"));
		process.setReason((String)data.get("reason"));
		process.setShopId(shopId);
		shopProcessService.update(process);
		jsonModel.setCode("100000");
		jsonModel.setStatus(JsonModelStatus.SUCCESS);
		return jsonModel;
	}
	@RequestMapping(value="/shopProcess",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel shopProcessInfo(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		Long shopId = Long.parseLong(data.get("shopId")+"");
		ShopProcess process = shopProcessService.searchByShopId(shopId);
		FreshShop shop = shopService.searchById(shopId);
		ShopProcessVO vo = new ShopProcessVO();
		vo.setClientLevel(process.getClientLevel());
		vo.setIsEscort(process.getIsEscort());
		vo.setIsValide(process.getIsValide());
		vo.setProcess(process.getProcess());
		vo.setReason(process.getReason());
		vo.setVisitTimes(shop.getVisitTimes());
		
		jsonModel.setData(vo);
		jsonModel.setCode("100000");
		jsonModel.setStatus(JsonModelStatus.SUCCESS);
		
		return jsonModel;
	}
	@SuppressWarnings("static-access")
	private void insertShop(Map<String,Object> params) {
		 FreshShop shop = new FreshShop();
		 String cName = (String)params.get("cName");
		 String pName=(String)params.get("pName");
		 Long cityId = getCityIdByName(cName, pName);
		 shop.setAddress((String)params.get("address"));
		 shop.setBusinessArea((String)params.get("businessArea"));
		 shop.setCityId(cityId);
		 shop.setEmployeeId(Long.parseLong(params.get("employeeId")+""));
		 shop.setIsFinish(0);
		 shop.setIsPublic((Integer.parseInt(params.get("isPublic")+"")));
		 shop.setName((String)params.get("name"));
		 shop.setVisitTimes(0);//默认
		 shop.setCreateTime(new Date());
		 shop.setIsLink((Integer.parseInt(params.get("isLink")+"")));
		 shop.setIsArea((Integer.parseInt(params.get("isArea")+"")));
		 shop.setLatitude((String)params.get("latitude"));
		 shop.setLongitude((String)params.get("longitude"));
		 shop.setLinkNum((Integer.parseInt(params.get("linkNum")+"")));
		 shop.setSource((String)params.get("source"));
		 shop.setTelephone((String)params.get("telephone"));
		 shop.setProcess("翻土");//默认
		 Long shopId = shopService.insert(shop);
		 
		 //插入shopProcess表数据
		 ShopProcess process = new ShopProcess();
		 process.setClientLevel("D");
		 process.setCreateTime(new Date());
		 process.setShopId(shopId);
		 process.setProcess("翻土");
		 shopProcessService.insert(process);
		 
		 System.out.println("=========================================contactList:"+params.get("contactList"));
		 if(params.get("contactList")!=null){
			 JSONObject jsb = new JSONObject(); 
			 String content = params.get("contactList").toString();
			 List<ShopContactVO> contactListVo = jsb.parseArray(content, ShopContactVO.class);
			 List<ShopContact> contacts = new ArrayList<ShopContact>();
			 org.springframework.beans.BeanUtils.copyProperties(contactListVo, contacts);
			 
			  for(ShopContactVO contactVo :contactListVo){
				//插入
				  ShopContact contact = new ShopContact();
				  org.springframework.beans.BeanUtils.copyProperties(contactVo, contact);
				 contact.setShopId(shopId);
				 shopContactService.insert(contact);
			 }
		 }
		
		 
	}
	public Long getCityIdByName(String cName, String pName) {
		String cityName;
		switch (pName) {
		case "北京":
			cityName="北京";
			break;
		case "上海":
			cityName="上海";
			break;
		case "天津":
			cityName="天津";
			break;
		case "重庆":
			cityName="重庆";
			break;
		default:
			cityName=cName;
			break;
		}

		Long cityId = cityCOM.getCityId(cityName);
		return cityId;
	}
	public boolean isHadcreateShop(String shopName){
		boolean flag = true;
		FreshShop shop = shopService.searchByShopName(shopName);
		if(shop==null){
			flag=false;
		}
		return flag;
	}
}
