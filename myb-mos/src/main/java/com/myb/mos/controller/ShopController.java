package com.myb.mos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.ArgsService;
import com.myb.accounts.service.ChannelInfoService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.OpenaccountChannelService;
import com.myb.accounts.service.RecordlogsService;
import com.myb.accounts.service.ShopService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Args;
import com.myb.entity.pojo.mos.ChannelInfo;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.OpenaccountChannel;
import com.myb.entity.pojo.mos.Recordlogs;
import com.myb.entity.pojo.mos.Shop;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.CityVO;
import com.myb.mos.VO.ShopVO;
import com.myb.mos.utils.BaseProUtill;
import com.myb.mos.utils.DesUtill;
import com.myb.mos.utils.HttpClientUtil;

/**
 * 开通店
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/Shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OpenAccountService openAccountService;
	
	@Autowired
	private RecordlogsService recordlogsService;
	
	@Autowired
	private ChannelInfoService channelInfoService;
	
	@Autowired
	private OpenaccountChannelService openaccountChannelService;
	
	@Autowired
	private ArgsService argsService;
	/**
	 * 保存店的信息
	 * @param request
	 * @param response
	 * @param shopVo
	 * @return 0表示失败 1表示首次添店成功，2表示不是首次添店成功，3表示记录log日志失败
	 */
	@ResponseBody
	@RequestMapping(value="/saveShop")
	public String saveShop(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("shopVo") ShopVO shopVo ) {
		
		//获取后期添加的店
		String afterAddShop = request.getParameter("afterAddShop");
		//是否渠道
		String isqudao = request.getParameter("isqudao");
		OpenAccount openAccount = openAccountService.searchByMobile(shopVo.getMobile());
		Shop shop = new Shop();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		shopVo.setStatus(1);
			try {
				Date beginDate = sdf.parse(shopVo.getBeginDate());
				Date endDate = sdf.parse(shopVo.getEndDate());
				shop.setBeginDate(beginDate);
				shop.setEndDate(endDate);
				shop.setCreateTime(new Date());
				shop.setUpdateTime(new Date());
				
			} catch (ParseException e) { 
				e.printStackTrace();
			}
		
		BeanUtils.copyProperties(shopVo, shop);
		//获取参数表的单价信息
		 QueryParameter queryParameter1 = new QueryParameter();
		 queryParameter1.eq("argName",shop.getDuration());
		 queryParameter1.and();
		 queryParameter1.eq("argType", "nianxian");
		 List<Args> argsList = argsService.searchList(queryParameter1);
		 if (argsList != null && argsList.size() > 0) {
			 shop.setDanjia(Double.valueOf(argsList.get(0).getArgValue()));
		 }
		if (openAccount != null) {
			shop.setAccountId(openAccount.getAccountId());
			shopVo.setAccountId(openAccount.getAccountId());
		}
		
		Map<String, String>  map = new HashMap<String, String>();
		
		if (openAccount.getIsOpenStatus() == 1) {
			map.put("status", "NORMAL");
		} else {
			map.put("status", "LOCKED");
		}
	      map.put("buyerPartyType", "CLERK");
	      map.put("cityName", shopVo.getCityName());
	      map.put("provinceCode", shopVo.getProvince());
	      map.put("cityCode", shopVo.getCity());
	      map.put("mobile", shopVo.getMobile());
	      map.put("areaCount", "500.00");
	      map.put("provinceName", shopVo.getProvinceName());
	      map.put("objName", shopVo.getShopName());
	      map.put("address", shopVo.getAddress());
	      map.put("description","");
	      map.put("servicePhone", "00000000000");
	      map.put("belongToPartyType", "CLERK");
	      map.put("bedCount", "1");
	      map.put("startTime", shopVo.getBeginDate()+" 00:00:00");
	      map.put("endTime", shopVo.getEndDate()+" 00:00:00");
	      map.put("duration", String.valueOf(shopVo.getDuration()));
	      map.put("versionType", "NORMAL");
	      try {
			map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//后期添加的店
	      JSONObject jsonObject = new JSONObject();
		if (afterAddShop.equals("2")) {//http://192.168.2.93/myb-web
			 String resultData = null;
			try {
				resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/addShop.jhtml", map, "utf-8","utf-8");
			} catch (Exception e) {
				e.printStackTrace();
				
				return "0";
			}
			JSONObject data = jsonObject.parseObject(resultData);
			 if (StringUtils.isNotBlank(resultData) && data != null && data.get("code").equals("1000000")) {
				 if (data.getString("data") != null) {
					 shop.setShopcode(data.getString("data"));
				 }
				 int shopSaveStatus = 0;
				 //渠道会存入标识 isqudao
				 if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {
					 shop.setIsChannel("isqudao");
					 QueryParameter queryParameter = new QueryParameter();
					 queryParameter.eq("openAccountId", shopVo.getAccountId());
					 //查询中间表得到渠道的id查询渠道的信息
					 List<OpenaccountChannel> openaccountChannelsList = openaccountChannelService.searchList(queryParameter);
					 if (openaccountChannelsList != null && openaccountChannelsList.size() > 0) {
						 Long channelId = openaccountChannelsList.get(0).getChannelId();
						 ChannelInfo channelInfo = channelInfoService.searchByChannelId(Integer.parseInt(String.valueOf(channelId))); 
						 if (channelInfo != null) {
							 shop.setCurrentRate(channelInfo.getDiscountRate());
						 }
					 }
					 
					 shopSaveStatus = shopService.insert(shop);
				 } else {
					  shopSaveStatus = shopService.insert(shop);
				 }
				//saas录入成功 mos 失败
				 if (shopSaveStatus != 1) {
					shopVo.setShopcode(data.getString("data"));
					shopVo.setGiveAway(shopVo.getGiveAway().trim());
					int AddshopErr = getLogInfo(request, shopVo);
					if (AddshopErr != 1) {
						return "3";
					}
					 return "0";
				 } else {
					 return "2";
				 } 
			 } else {
				 return "0";
			 }
		} else if (! afterAddShop.equals("2")) {
		
////	       新增美容店
			 String resultData = null;
			try {
				resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/addShop.jhtml", map, "utf-8","utf-8");
			} catch (Exception e) {
				e.printStackTrace();
				return "0";
			}
			 if (StringUtils.isNotBlank(resultData)) {
				JSONObject data = jsonObject.parseObject(resultData);
				if (data.get("code").equals("1000000")) {
					int shopSaveStatus = shopService.insert(shop);
					if (shopSaveStatus != 1) {
						shopVo.setShopcode(data.getString("data"));
						int addshopErr = getLogInfo(request, shopVo);
						if (addshopErr != 1) {
							return "3";
						} else {
							return "0";
						}
					} else {
						return "1";
					}
				} else {
					return "0";
				}
			 }
			return "1";
		} else {
			return "0";
		}
	}
	
	
	/**异常处理
	 * 修改店的显示信息
	 * @param request
	 * @param response
	 * @param shopVo
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="/modifyViewShop")
	public String modifyViewShop(HttpServletRequest request, HttpServletResponse response,@RequestParam("shopId") int shopId) {
		
		Shop shop = shopService.searchByShopId(shopId);
		ShopVO shopVO = new ShopVO();
		BeanUtils.copyProperties(shop, shopVO);
		List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
		List<AddressAreaDef> cityName = addressAreaDefs.parallelStream().filter(e->e.getCode().equals(shop.getCity())).collect(Collectors.toList());
		List<AddressAreaDef> provinceName = addressAreaDefs.parallelStream().filter(e->e.getCode().equals(shop.getProvince())).collect(Collectors.toList());
		//查询省对应的所有城市
		if (provinceName != null && provinceName.size() > 0) {
			List<AddressAreaDef> cityListVo = addressAreaDefs.parallelStream().filter(e->e.getParentCode().equals(provinceName.get(0).getCode())).collect(Collectors.toList());
			List<CityVO> cityVosList = new ArrayList<CityVO>();
			for (int i = 0; i < cityListVo.size(); i++) {
				CityVO cityvo = new CityVO();
				cityvo.setCityCode(cityListVo.get(i).getCode());
				cityvo.setCityName(cityListVo.get(i).getObjName());
				cityVosList.add(cityvo);
			}
			shopVO.setCityVos(cityVosList);
			shopVO.setCityName(cityName.get(0).getObjName());
			shopVO.setProvinceName(provinceName.get(0).getObjName());
		}
		if (shop.getBeginDate() != null && shop.getEndDate() != null) {
			
			shopVO.setBeginDate(shop.getBeginDate().toString().split(" ")[0]);
			shopVO.setEndDate(shop.getEndDate().toString().split(" ")[0]);
		}
		String type = request.getParameter("type");
		if (type != null && type.equals("delay")) {
			
			shopVO.setModifyType("delay");//店的延期操作
		}
		if (shop != null) {
			
			return 	JSONObject.toJSONString(shopVO);
		} else {
			return "0";
		}
	}
	
	
	/**异常处理
	 * 修改 店延期
	 * @param request
	 * @param response
	 * @param shopVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/modifyShop")
	public String modifyShop(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("shopVo") ShopVO shopVo) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Shop shoppre = shopService.searchByShopId(shopVo.getShopId());
		Date bd = null,ed = null;
		try {
			if(shopVo.getBeginDate() == null) {
				bd = shoppre.getBeginDate();
			} else {
				bd = format.parse(shopVo.getBeginDate());
			}
			
			if(shopVo.getEndDate() == null) {
				ed = shoppre.getEndDate();
			} else {
				ed = format.parse(shopVo.getEndDate());
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Shop shop = new Shop();
		BeanUtils.copyProperties(shopVo, shop);
		shop.setBeginDate(bd);
		shop.setEndDate(ed);
		shop.setShopcode(shoppre.getShopcode());
		shop.setDanjia(shoppre.getDanjia());
		shop.setCreateTime(shoppre.getCreateTime());
		shop.setAccountId(shoppre.getAccountId());
		String type = request.getParameter("type");
		int f = 0;
		int var=0;
		if (type != null && type.equals("delay")) {
			
			shop.setEndDate(ed);
			shop.setShopName(shoppre.getShopName());
			shop.setProvince(shoppre.getProvince());
			shop.setCity(shoppre.getCity());
			shop.setAddress(shoppre.getAddress());
			shop.setExceptionStatus(2);//2代表延期
			shop.setIspass(3);
			OpenAccount openAccount = openAccountService.searchByAccountId(shoppre.getAccountId());
			openAccount.setUpdateDate(new Date());
			openAccountService.update(openAccount);
			f = 1;
		} else if(type != null && type.equals("modify")){
			
			
			OpenAccount openAccount = openAccountService.searchByAccountId(shoppre.getAccountId());
			openAccount.setUpdateDate(new Date());
			openAccountService.update(openAccount);
			shop.setExceptionStatus(4);//4代表修改
			shop.setIspass(3);
		}
		
			shop.setUpdateTime(new Date());
			int updateShop = shopService.update(shop);
			if (updateShop == 1) {
				if (f==1) {
					return "5";
				}
				return "1";
			} else {
				return "0"; 
			}
	}
	
	/**
	 * 日志录入
	 * @param request
	 * @param shopVO
	 * @return
	 */
	public int getLogInfo(HttpServletRequest request, ShopVO shopVO){
		 SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
		Recordlogs recordlogs = new Recordlogs();
		recordlogs.setShopName(shopVO.getShopName());
		recordlogs.setProvinceCodeShop(Integer.parseInt(shopVO.getProvince()));
//		recordlogs.setCityCode(Integer.parseInt(shopVO.getCity()));
		recordlogs.setCityCodeShop(Integer.parseInt(shopVO.getCity()));
		recordlogs.setDetailAddressShop(shopVO.getAddress());//地址
		recordlogs.setDuration(shopVO.getDuration());//期限
		recordlogs.setGiveAway(Integer.parseInt(shopVO.getGiveAway())); //赠送
		recordlogs.setMobile(shopVO.getMobile());	
		recordlogs.setRemark("openShopErr");
		recordlogs.setAddInfoUser(((Employee)request.getSession().getAttribute("loginUser")).getEmpName());
		recordlogs.setCreateTime(new Date());
		recordlogs.setStatus(1);
		recordlogs.setType(2);
		recordlogs.setAccountId(shopVO.getAccountId());
		recordlogs.setShopCode(shopVO.getShopcode());
		try {
			recordlogs.setStartDate(sdf.parse(shopVO.getBeginDate()));
			recordlogs.setEndDate(sdf.parse(shopVO.getEndDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int logErr = recordlogsService.insert(recordlogs);
		if (logErr != 1){
			return 0;
		} else {
			return 1;
		}
	}
	
	
	
	
}
