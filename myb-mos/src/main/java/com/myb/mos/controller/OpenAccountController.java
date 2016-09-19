package com.myb.mos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.ArgsService;
import com.myb.accounts.service.ChannelInfoService;
import com.myb.accounts.service.ContractService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.OpenaccountChannelService;
import com.myb.accounts.service.RecordlogsService;
import com.myb.accounts.service.ShopService;
import com.myb.accounts.service.UpbosslogsService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.ChannelInfo;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.OpenaccountChannel;
import com.myb.entity.pojo.mos.Recordlogs;
import com.myb.entity.pojo.mos.Shop;
import com.myb.entity.pojo.mos.ShopMapping;
import com.myb.entity.pojo.mos.Upbosslogs;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.data.SqlSort;
import com.myb.mos.VO.OpenAccountVO;
import com.myb.mos.VO.ShopVO;
import com.myb.mos.utils.BaseProUtill;
import com.myb.mos.utils.DesUtill;
import com.myb.mos.utils.HttpClientUtil;
import com.myb.mos.utils.RedisUtil;
import com.myb.mos.utils.RegexUtils;
import com.myb.mos.utils.SortClassUtils;

/**
 * 开通账号
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/Account")
public class OpenAccountController {
	
	
	@Autowired
	private OpenAccountService openAccountService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private RecordlogsService recordlogsService;
	
	@Autowired
	private UpbosslogsService upbosslogsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private OpenaccountChannelService openaccountChannelService;
	
	@Autowired
	private ChannelInfoService channelInfoService;
	
	@Autowired
	private ArgsService argserService;
	
	/**
	 * 保存之后跳转页面
	 * @param request
	 * @param response
	 * @param openAccount
	 * @return
	 */
	@RequestMapping(value="/index")
	public ModelAndView openAccount(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("openAccount") OpenAccountVO openAccountVO ) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ModelAndView mav = new ModelAndView();
		String isqudao = request.getParameter("isqudao");
		if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {
			mav.setViewName("channelInfo/AddChannelShop");
			mav.addObject("isqudao", "isqudao");
		} else {
			mav.setViewName("account/AddShop");
		}
		List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
		List<AddressAreaDef> addressAreaDefParent = addressAreaDefs.parallelStream().filter(e -> e.getParentCode().equals("1")).collect(Collectors.toList());
		mav.addObject("addressAreaDefParent", addressAreaDefParent);
		//已开通后添加的
		String type = request.getParameter("type");
		int isContainShopOperation = 0;//是否操作过店的延期或修改
		if (StringUtils.isNotBlank(type) && type.equals("2")) {
			
			String accountId = request.getParameter("accountId");
			if (StringUtils.isNotBlank(accountId)) {
				OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq("accountId", openAccount.getAccountId());
				List<Shop> shopsList = shopService.searchList(queryParameter);
				List<ShopVO> shopVOsList = new ArrayList<ShopVO>();
				for (int i=0; i <shopsList.size(); i++) {
					
					if (shopsList.get(i).getIspass() == 1) {
						isContainShopOperation = 1;
					}
					ShopVO shopVO = new ShopVO();
					BeanUtils.copyProperties(shopsList.get(i), shopVO);
					if (null != shopsList.get(i).getBeginDate()) {
						shopVO.setBeginDate(sdf.format(shopsList.get(i).getBeginDate()));
					}
					if (null != shopsList.get(i).getEndDate()) {
						shopVO.setEndDate(sdf.format(shopsList.get(i).getEndDate()));
					}
					shopVOsList.add(shopVO);
				}
				
				for (int i=0; i < shopVOsList.size(); i++) {
					String cy = shopVOsList.get(i).getCity();
					String pv = shopVOsList.get(i).getProvince();
					List<AddressAreaDef>  provinceAndCity = StartupController.getProvinceAndCity();
					List<AddressAreaDef> addressAreaDefsCityList = provinceAndCity.
							parallelStream().
							filter(e -> e.getCode().equals(cy)).
							collect(Collectors.toList());
					StringBuffer cityName = new StringBuffer();
					StringBuffer provinceName = new StringBuffer();
					if (addressAreaDefsCityList != null && addressAreaDefsCityList.size()>0) {
						AddressAreaDef	addressAreaDefCity = addressAreaDefsCityList.get(0);
						cityName.append(addressAreaDefCity.getObjName());
					}
					List<AddressAreaDef> addressAreaDefProvinceList = provinceAndCity.
							parallelStream().
							filter(e -> e.getCode().equals(pv)).
							collect(Collectors.toList());
					if (addressAreaDefProvinceList != null && addressAreaDefProvinceList.size()>0) {
						AddressAreaDef	addressAreaDefProvince = addressAreaDefProvinceList.get(0);
						provinceName.append(addressAreaDefProvince.getObjName());
					}
					shopVOsList.get(i).setCityName(provinceName+"-"+cityName);	
				}
				
				OpenAccountVO accountVO = new OpenAccountVO();
				BeanUtils.copyProperties(openAccount, accountVO);
				accountVO.setPayDate(openAccount.getPayDate().toString());
				List<String> list = getProvinceAndCity(accountVO);
				if (list != null && list.size() > 0) {
					accountVO.setProvinceName(list.get(0));
					accountVO.setCityName(list.get(1));
				}
				
				QueryParameter queryParameter1 = new QueryParameter();
				queryParameter1.eq("userName",accountVO.getMarket());
				List<Employee> employeesList = employeeService.searchList(queryParameter1);
				if (employeesList != null && employeesList.size() > 0) {
					accountVO.setMarket(employeesList.get(0).getEmpName()+"("+accountVO.getMarket()+")");
				}
				mav.addObject("openAccount", accountVO);
				mav.addObject("shopList", shopVOsList);
			}
		//新开通的账号
		} else {
			OpenAccount  openAccount = openAccountService.searchByMobile(openAccountVO.getOpenNumber());
			if (openAccount != null) {
				
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq("accountId", openAccount.getAccountId());
				List<Shop> shopsList = shopService.searchList(queryParameter);
				List<ShopVO> shopVOsList = new ArrayList<ShopVO>();
				
				for (int i=0; i <shopsList.size(); i++) {
					
					if (shopsList.get(i).getIspass() == 1) {
						isContainShopOperation = 1;
					}
					ShopVO shopVO = new ShopVO();
					BeanUtils.copyProperties(shopsList.get(i), shopVO);
					shopVO.setBeginDate(sdf.format(shopsList.get(i).getBeginDate()));
					shopVO.setEndDate(sdf.format(shopsList.get(i).getEndDate()));
					shopVOsList.add(shopVO);
				}
				
				for (int i=0; i < shopVOsList.size(); i++) {
					String cy = shopVOsList.get(i).getCity();
					String pv = shopVOsList.get(i).getProvince();
					List<AddressAreaDef>  provinceAndCity = StartupController.getProvinceAndCity();
					if (provinceAndCity != null && provinceAndCity.size() > 0) {
						AddressAreaDef addressAreaDefPv = null ;
						AddressAreaDef addressAreaDef = null;
						List<AddressAreaDef> addressAreaDefsList = provinceAndCity.
						parallelStream().
						filter(e -> e.getCode().equals(cy)).
						collect(Collectors.toList());
						if (addressAreaDefsList != null && addressAreaDefsList.size() > 0 ){
							 addressAreaDef = addressAreaDefsList.get(0);
						}
						List<AddressAreaDef> addressAreaDefsList1 =	provinceAndCity.
						parallelStream().
						filter(e -> e.getCode().equals(pv)).
						collect(Collectors.toList());
						if (addressAreaDefsList1 != null && addressAreaDefsList1.size() > 0 ){
							 addressAreaDefPv = addressAreaDefsList1.get(0);
						}
						if (addressAreaDefPv != null && addressAreaDef != null) {
							
							shopVOsList.get(i).setCityName(addressAreaDefPv.getObjName()+"-"+addressAreaDef.getObjName());	
						}
					}
				}
				
				mav.addObject("shopList", shopVOsList);
			}
			
			List<String> list = getProvinceAndCity(openAccountVO);
			if (list != null && list.size() > 0) {
				
				openAccountVO.setProvinceName(list.get(0));
				openAccountVO.setCityName(list.get(1));
			}
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq("userName",openAccount.getMarket());
			List<Employee> employeesList = employeeService.searchList(queryParameter);
			
			if (employeesList != null && employeesList.size() > 0) {
				openAccountVO.setMarket(employeesList.get(0).getEmpName()+"("+openAccount.getMarket()+")");
			}
			openAccountVO.setAccountId(openAccount.getAccountId());
			if (isContainShopOperation == 1) {
				openAccountVO.setIspass(1);
			}
			mav.addObject("openAccount", openAccountVO);
		}
		//判断是销售助理还是财务进来的如果finance是1为财务
		String finance= request.getParameter("finance");
		if (StringUtils.isNotBlank(finance)) {
			mav.addObject("finance",  finance);
		}
		String exception = request.getParameter("exception");
		if (exception != null && exception.equals("1")){
			mav.addObject("exception", 1);
		}
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		return mav;
	}
	
	/**
	 * 保存账号
	 * @param request
	 * 
	 * @param response
	 * @param openAccountVO
	 * @return 0表示失败 1表示升级老板号成功3表示重复手机号 5code加密错误 6插入日志错误
	 */
	@ResponseBody
	@RequestMapping(value="/saveAccount", method=RequestMethod.POST)
	public String saveAccount(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("openAccount") OpenAccountVO openAccountVO ) {
		
//		RedisUtil.getJedis().set("openAccountList*", "");
		//手机号
//		if(!RegexUtils.checkMobile(openAccountVO.getOpenNumber()) ){
//			return "11";
//		}
		//院名称
		if(StringUtils.isBlank(openAccountVO.getBeautifulyard()) ){
			return "12";
		}
		//店的数量
		if(!RegexUtils.checkDigit(String.valueOf(openAccountVO.getShopCount())) ){
			return "13";
		}
		//付款日期
		if(StringUtils.isBlank(openAccountVO.getPayDate())) {
			return "14";
		}
		//销售
//		if(!RegexUtils.checkChinese(openAccountVO.getMarket()) ){
//			return "15";
//		}
		//客服电话
		/*if(!RegexUtils.checkMobileOrPhone(openAccountVO.getKefumobile()) ){
			return "16";
		}*/
		//城市
		if(StringUtils.isBlank(openAccountVO.getCity())){
			return "17";
		}
		//省份
		if(StringUtils.isBlank(openAccountVO.getProvince())){
			return "18";
		}
		//总部地址
		if(StringUtils.isBlank(openAccountVO.getZongbuAddress()) ){
			return "19";
		}
		
		//手机号重复
		if (openAccountVO.getOpenNumber() != null) {
			OpenAccount openAccount = openAccountService.searchByMobile(openAccountVO.getOpenNumber());
			if (openAccount != null && openAccount.getApprovalStatus() != -1) {
				return  "3";
			}
		}
		
		OpenAccount openAccount = new OpenAccount();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		openAccountVO.setCreateTime(new Date());
		openAccountVO.setStatus(1);
		BeanUtils.copyProperties(openAccountVO, openAccount);
		
		if (StringUtils.isNotBlank(openAccountVO.getConsumerId())) {
			openAccount.setConsumerId(Integer.parseInt(openAccountVO.getConsumerId()));
		}
		try {
			Date payDate = sdf.parse(openAccountVO.getPayDate());
			openAccount.setPayDate(payDate);
			openAccount.setIsAddAccount(2);//未创建合同
			openAccount.setApprovalStatus(1);//初始化未审批状态
		} catch (ParseException e) {
			e.printStackTrace();
		}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, String>  map = new HashMap<String, String>();
	    	map.put("objName", openAccount.getBeautifulyard());
	    	map.put("age", "1");
	    	map.put("gender", "1");
	    	map.put("birthday", format.format(new Date()));
	    	try {
				map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
	    	map.put("mobile", openAccount.getOpenNumber());
	    	map.put("expiredDate", "2025-12-31 00:00:00");
	    	map.put("password", openAccount.getOpenNumber().substring(openAccount.getOpenNumber().length()-6, openAccount.getOpenNumber().length()));
	    	map.put("seniority", "0");
	    	map.put("speciality", "0");
	    	map.put("title", "院长");
	    	map.put("accountType", "1");
	    	map.put("status", "LOCKED");
	    	try {
	    		map.put("securityCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	String resultData = null;
			try {
				resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/loginAccount/regist.jhtml", map, "utf-8", "utf-8");
			} catch (Exception e1) {
				
				e1.printStackTrace();
				return "0";
			}
			//接口调取成功
	    	if (StringUtils.isNotBlank(resultData)) {
	    		
				JSONObject jsonObject = new JSONObject();
				JSONObject data = (JSONObject) JSONObject.parse(resultData);
				if (data.get("code").equals("1000000")) {
					//升级老板
					String isok = isUpBoos(request, openAccount);
					return isok;
				//加密code返回码的错误
				} else if (data.get("code").equals("1000028")){
					return "5";
					
				} else {
					return "0";
				}
		 
			} else {
				return "0";
			}
	}
	
	/**
	 * 根据手机号查询美容院
	 * @param request
	 * @param response
	 * @param mobile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findByBeautifulId", method=RequestMethod.POST)
	public String findByBeautifulId(HttpServletRequest request, HttpServletResponse response){
		String accountName = request.getParameter("accountName");
		String dh = request.getParameter("dh");
		String mobile = request.getParameter("mobile");
		String beautifulName = request.getParameter("beautifulName");
		QueryParameter queryParameter = new QueryParameter();
		QueryParameter queryParameterByContract = new QueryParameter();
		if (StringUtils.isNotBlank(beautifulName)) {
			queryParameter.eq("beautifulyard", beautifulName);
		}
		if (StringUtils.isNotBlank(accountName )&&StringUtils.isBlank(dh)&&StringUtils.isBlank(mobile)) {
			queryParameterByContract.eq("payAccountName", accountName);
			List<Contract> contractsList = contractService.searchList(queryParameterByContract);
			// TODO: 2016/9/19   未查到数据时此处会报错
			Contract contract = contractsList.get(contractsList.size()-1);
			queryParameter.eq("openNumber", contract.getOpenNumber());
		}
		if (StringUtils.isBlank(accountName )&&StringUtils.isNotBlank(dh )&&StringUtils.isBlank(mobile )) {
			queryParameterByContract.eq("payNumber", dh);
			List<Contract> contractsList = contractService.searchList(queryParameterByContract);
			// TODO: 2016/9/19   未查到数据时此处会报错
			Contract contract = contractsList.get(contractsList.size()-1);
			queryParameter.eq("openNumber", contract.getOpenNumber());
		}
		if (StringUtils.isBlank(accountName )&&StringUtils.isBlank(dh )&&StringUtils.isNotBlank(mobile )) {
			queryParameter.eq("openNumber", mobile);
		}
		
		String finance = request.getParameter("finance");
		queryParameter.and();
		queryParameter.ne("approvalStatus", "-1");
		List<OpenAccount> openAccountsList = openAccountService.searchList(queryParameter);
		List<OpenAccountVO> openAccountVOsList = new ArrayList<OpenAccountVO>();
		OpenAccount openAccount = null; 
		if (openAccountsList != null && openAccountsList.size() > 0) {
				for (int i = 0; i < openAccountsList.size(); i++) {
				OpenAccountVO openAccountVO = new OpenAccountVO();
				BeanUtils.copyProperties(openAccountsList.get(i), openAccountVO);
				if (openAccountsList.get(i).getPayDate() != null) {
					openAccountVO.setPayDate(openAccountsList.get(i).getPayDate().toString().split(" ")[0]);
				}
				if (openAccountsList.get(i).getUpdateDate() != null) {
					openAccountVO.setUpdateDate(openAccountsList.get(i).getUpdateDate().toString().split(" ")[0]);
				}
				List<String>  list = getProvinceAndCity(openAccountVO);
				if (list != null && list.size() > 0) {
					openAccountVO.setProvinceName(list.get(0));
					openAccountVO.setCityName(list.get(1));
				}
				
				if (finance != null && finance.equals("1")){
					openAccountVO.setFinance(1);
				}
				 QueryParameter queryParameter1 = new QueryParameter();
				 queryParameter1.eq("userName", openAccountVO.getMarket());
				 List<Employee> employeesList = employeeService.searchList(queryParameter1);
				 if (employeesList != null && employeesList.size() >0) {
//					 employeesList.get(0);
					 openAccountVO.setMarket(employeesList.get(0).getEmpName()+"("+openAccountVO.getMarket()+")");
				 }
				 openAccountVOsList.add(openAccountVO);
			}
			
			return JSONObject.toJSONString(openAccountVOsList);
		} else {
			return "-1";
		}
	}
	
	/**
	 * 更新店的数量
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateshopCount", method={RequestMethod.POST,RequestMethod.GET})
	public String updateshopCount(HttpServletRequest request, HttpServletResponse response){
		
		String mobile = request.getParameter("mobile");
		String shopCount = request.getParameter("shopCount");
		
		if (StringUtils.isNotBlank(mobile)) {
			OpenAccount openAccount = openAccountService.searchByMobile(mobile);
			if (StringUtils.isNotBlank(shopCount)) {
				openAccount.setShopCount(Integer.parseInt(shopCount));
			}
			
			Map<String, String>  map = new HashMap<String, String>();	
			map.put("companyCode", openAccount.getCompanyCode());
			map.put("grade", "1");
			try {
				map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				String resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/addShopNum.jhtml", map, "utf-8", "utf-8");
				if (StringUtils.isNotBlank(resultData)) {
					JSONObject data = (JSONObject) JSONObject.parse(resultData);

					if (data.get("code").equals("1000000")) {
						int updateCode = openAccountService.update(openAccount);
						
						QueryParameter queryParameter = new QueryParameter();
						queryParameter.eq("openNumber", openAccount.getOpenNumber());
						List<Contract> contractsList = contractService.searchList(queryParameter);
						if (contractsList != null && contractsList.size() > 0) {
							contractsList.get(0).setShopCount(openAccount.getShopCount());
							contractService.update(contractsList.get(0));
						}
						if (updateCode == 1) {
							return "1";
						} else {
							return "0";
						}
						
					} else {
						return "0";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "0";
			}
		}
		return "0"; 
	}
	
	
	public List<String> getProvinceAndCity(OpenAccountVO accountVO){
		List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
		List<String> list = new ArrayList<String>();
		if (addressAreaDefs.size() > 0 && accountVO.getProvince() != null && accountVO.getCity() != null) {
			AddressAreaDef province = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(accountVO.getProvince())).collect(Collectors.toList()).get(0);
			AddressAreaDef city =addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(accountVO.getCity())).collect(Collectors.toList()).get(0);
			list.add(province.getObjName());
			list.add(city.getObjName());
		}
		
		return list;
	}
	
	/**
	 * 开通账号列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/showListOpenAccount")
	public ModelAndView showListOpenAccount(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
		
		ModelAndView mav = null;
		String isqudao = request.getParameter("isqd");
		if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {
			 mav = new ModelAndView("/channelInfo/ChannelOpenAccountList");
		} else {
			 mav = new ModelAndView("/account/OpenAccountList");
		}
		if (pageIndex <= 0) {
			pageIndex = 1;
		}
		//财务查看的内容可操作
		String finance = request.getParameter("finance");
		PagedList<OpenAccount> openAccountPageList = null;
		Employee employee =  (Employee)request.getSession().getAttribute("loginUser");  
		if (finance != null && finance.equals("1")) {
			QueryCondition queryCondition = new QueryCondition();
			QueryParameter queryParameter = new QueryParameter();
			mav.addObject("finance", finance);
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(10);
			String [] as = new String [] {"3"};
			queryParameter.ne("approvalStatus", 3);//查询不等于退回的，给财务审核看的
			queryParameter.and();
			queryParameter.ne("approvalStatus", "-1");//不等于开通再关闭的
			//渠道开通的账号
			if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {
			queryParameter.and();
			queryParameter.eq("isChannel", "isqudao");
			queryParameter.and();
			queryParameter.eq("isShowQudaoList", 1);
			} else {
			queryParameter.and();
			queryParameter.eq("isAddAccount", "1");//合同为已添加的
			queryParameter.and();
			queryParameter.ne("isChannel", "isqudao");
			}
			SortParameter sortParameter = new SortParameter();
			sortParameter.add("updateDate", SqlOrder.DESC);
			queryCondition.setSortParameter(sortParameter);
			queryCondition.setQueryParameter(queryParameter);
			openAccountPageList = openAccountService.searchByPage(queryCondition);
//			  RedisUtil.getJedis().set("newname", "中文测试");
			//获取所有渠道的
			
		} else {
			QueryCondition queryCondition = new QueryCondition();
			QueryParameter queryParameter = new QueryParameter();
			//销售看所有的
			queryCondition.setPageIndex(pageIndex);
			queryCondition.setPageSize(10);
			SortParameter sortParameter = new SortParameter();
			if (employee != null) {
				queryParameter.eq("empId", employee.getEmpId());//当前销售登录人员的列表
				queryParameter.and();
				queryParameter.ne("approvalStatus", "-1");//不等于开通再关闭的
				
				if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {//判断是否是渠道登录进来的
					queryParameter.and();
					queryParameter.eq("isChannel", "isqudao");
				} else {
					queryParameter.and();
					queryParameter.ne("isChannel", "isqudao");
				}
			}
			sortParameter.add("updateDate", SqlOrder.DESC);
			queryCondition.setSortParameter(sortParameter);
			queryCondition.setQueryParameter(queryParameter);
			openAccountPageList = openAccountService.searchByPage(queryCondition);
		}
		
		if (openAccountPageList.getContent() != null && openAccountPageList.getContent().size() > 0) {
			List<Shop> shops = shopService.searchList(new QueryParameter().ne(ShopMapping.ExceptionStatus, 0));
			
			for (int i = 0 ;i < openAccountPageList.getContent().size() ; i++) {
				//显示小圆点提示这个账号修改过或续签过或其他
				int accountId = openAccountPageList.getContent().get(i).getAccountId();
				List<Shop> shopsByException = shops.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
				
				if (shopsByException != null && shopsByException.size() > 0) {
					if (shopsByException.get(0).getIspass() == 1) {//1为通过
						openAccountPageList.getContent().get(i).setIspass("1");
					} else if (shopsByException.get(0).getIspass() == 2) {//2为未通过，修改信息的时候
						openAccountPageList.getContent().get(i).setIspass("2");
					} else {//3为未审核
						openAccountPageList.getContent().get(i).setIspass("3");
					}
					
					openAccountPageList.getContent().get(i).setIsException(1);
				}
				//
				String cityCode = openAccountPageList.getContent().get(i).getCity();
				String provinceCode = openAccountPageList.getContent().get(i).getProvince();
				List<AddressAreaDef>  addressAreaDefs = StartupController.getProvinceAndCity();
				
				 List<AddressAreaDef>  addressAreaDefs2 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(cityCode)).collect(Collectors.toList());
				 if (addressAreaDefs2 != null && addressAreaDefs2.size() > 0 ) {
					 AddressAreaDef addressAreaDefCity = addressAreaDefs2.get(0);
					 openAccountPageList.getContent().get(i).setCityName(addressAreaDefCity.getObjName());
				 }
				 List<AddressAreaDef>  addressAreaDefs3 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(provinceCode)).collect(Collectors.toList());
				 if (addressAreaDefs3 != null && addressAreaDefs3.size() > 0) {
					 AddressAreaDef addressAreaDefProvince =  addressAreaDefs3.get(0);
					 openAccountPageList.getContent().get(i).setProvinceName(addressAreaDefProvince.getObjName());
				 }
				 QueryParameter queryParameter = new QueryParameter();
				 queryParameter.eq("userName", openAccountPageList.getContent().get(i).getMarket());
				 List<Employee> employeesList = employeeService.searchList(queryParameter);
				 if (employeesList != null && employeesList.size() >0) {
					 openAccountPageList.getContent().get(i).setMarket(employeesList.get(0).getEmpName()+"("+openAccountPageList.getContent().get(i).getMarket()+")");
				 }
			}
		}
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		mav.addObject("openAccountPageList", openAccountPageList);
		mav.addObject("aaa", JSONObject.toJSONString(openAccountPageList));
		
		return mav;
	}
	
	
	/**
	 * 只有查看功能
	 * @param request
	 * @param response
	 * @param openAccount
	 * @return
	 */
	@RequestMapping(value="/watchIndex")
	public ModelAndView watchIndex(HttpServletRequest request, HttpServletResponse response ) {
		String openNumber = request.getParameter("openNumber");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("account/WatchShopAll");
		List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
		List<AddressAreaDef> addressAreaDefParent = addressAreaDefs.parallelStream().filter(e -> e.getParentCode().equals("1")).collect(Collectors.toList());
		mav.addObject("addressAreaDefParent", addressAreaDefParent);
		//已开通后添加的
		String type = request.getParameter("type");
		if (StringUtils.isNotBlank(type) && type.equals("2")) {
			
			String accountId = request.getParameter("accountId");
			if (StringUtils.isNotBlank(accountId)) {
				OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq("accountId", openAccount.getAccountId());
				
				List<Shop> shopsList = shopService.searchList(queryParameter);
				List<ShopVO> shopVOsList = new ArrayList<ShopVO>();
				for (int i=0; i <shopsList.size(); i++) {
					ShopVO shopVO = new ShopVO();
					BeanUtils.copyProperties(shopsList.get(i), shopVO);
					shopVO.setBeginDate(sdf.format(shopsList.get(i).getBeginDate()));
					shopVO.setEndDate(sdf.format(shopsList.get(i).getEndDate()));
					shopVOsList.add(shopVO);
				}
				
				for (int i=0; i < shopVOsList.size(); i++) {
					String cy = shopVOsList.get(i).getCity();
					String pv = shopVOsList.get(i).getProvince();
					List<AddressAreaDef>  provinceAndCity = StartupController.getProvinceAndCity();
					AddressAreaDef addressAreaDef = provinceAndCity.
							parallelStream().
							filter(e -> e.getCode().equals(cy)).
							collect(Collectors.toList()).
							get(0);
					AddressAreaDef addressAreaDefPv = provinceAndCity.
							parallelStream().
							filter(e -> e.getCode().equals(pv)).
							collect(Collectors.toList()).
							get(0);
					shopVOsList.get(i).setCityName(addressAreaDefPv.getObjName()+"-"+addressAreaDef.getObjName());	
				}
				
				OpenAccountVO accountVO = new OpenAccountVO();
				BeanUtils.copyProperties(openAccount, accountVO);
				accountVO.setPayDate(openAccount.getPayDate().toString());
				List<String> list = getProvinceAndCity(accountVO);
				accountVO.setProvinceName(list.get(0));
				accountVO.setCityName(list.get(1));
				mav.addObject("openAccount", accountVO);
				mav.addObject("shopList", shopVOsList);
			}
		//新开通的账号
		} else {
			OpenAccount  openAccount = openAccountService.searchByMobile(openNumber);
			if (openAccount != null) {
				
				QueryParameter queryParameter = new QueryParameter();
				queryParameter.eq("accountId", openAccount.getAccountId());
				List<Shop> shopsList = shopService.searchList(queryParameter);
				List<ShopVO> shopVOsList = new ArrayList<ShopVO>();
				
				for (int i=0; i <shopsList.size(); i++) {
					ShopVO shopVO = new ShopVO();
					BeanUtils.copyProperties(shopsList.get(i), shopVO);
					shopVO.setBeginDate(sdf.format(shopsList.get(i).getBeginDate()));
					shopVO.setEndDate(sdf.format(shopsList.get(i).getEndDate()));
					shopVOsList.add(shopVO);
				}
				
				for (int i=0; i < shopVOsList.size(); i++) {
					String cy = shopVOsList.get(i).getCity();
					String pv = shopVOsList.get(i).getProvince();
					List<AddressAreaDef>  provinceAndCity = StartupController.getProvinceAndCity();
					if (provinceAndCity != null && provinceAndCity.size() > 0) {
						AddressAreaDef addressAreaDefPv = null ;
						AddressAreaDef addressAreaDef = null;
						List<AddressAreaDef> addressAreaDefsList = provinceAndCity.
						parallelStream().
						filter(e -> e.getCode().equals(cy)).
						collect(Collectors.toList());
						if (addressAreaDefsList != null && addressAreaDefsList.size() > 0 ){
							 addressAreaDef = addressAreaDefsList.get(0);
						}
						List<AddressAreaDef> addressAreaDefsList1 =	provinceAndCity.
						parallelStream().
						filter(e -> e.getCode().equals(pv)).
						collect(Collectors.toList());
						if (addressAreaDefsList1 != null && addressAreaDefsList1.size() > 0 ){
							 addressAreaDefPv = addressAreaDefsList1.get(0);
						}
						if (addressAreaDefPv != null && addressAreaDef != null) {
							
							shopVOsList.get(i).setCityName(addressAreaDefPv.getObjName()+"-"+addressAreaDef.getObjName());	
						}
					}
				}
				
				mav.addObject("shopList", shopVOsList);
			}
			
			OpenAccount openAccountVO = openAccountService.searchByMobile(openNumber);
			OpenAccountVO accountVO = new OpenAccountVO();
			BeanUtils.copyProperties(openAccountVO, accountVO);
			List<String> list = getProvinceAndCity(accountVO);
			if (list != null && list.size() > 0) {
				
				openAccountVO.setProvinceName(list.get(0));
				openAccountVO.setCityName(list.get(1));
			}
			mav.addObject("openAccount", openAccountVO);
		}
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		return mav;
	}
	
	/**
	 * 开通账号成功升级老板失败
	 * @return
	 */
	@RequestMapping(value="/isUpBoos")
	@ResponseBody
	public String isUpBoos(HttpServletRequest request, OpenAccount openAccount){
		//升级老板号失败的话单独处理日志
		String upBossErrId = request.getParameter("upBossErrId");
		if (StringUtils.isNotBlank(upBossErrId)) {
			
			Upbosslogs upbosslogs = upbosslogsService.searchByUpBossId(Integer.parseInt(upBossErrId));
			BeanUtils.copyProperties(upbosslogs, openAccount);
			openAccount.setBeautifulyard(upbosslogs.getBeautifulYard());
			openAccount.setCity(String.valueOf(upbosslogs.getCityCode()));
			openAccount.setProvince(String.valueOf(upbosslogs.getProvinceCode()));
			openAccount.setMarket(upbosslogs.getMarker());
			openAccount.setPayDate(upbosslogs.getPayDate());
			
		}
		//正常开通情况下
		JSONObject jsonObject = new JSONObject();
		Map<String, String>  map1 = new HashMap<String, String>();
    	map1.put("mobile", openAccount.getOpenNumber());
    	map1.put("shopNums", ""+openAccount.getShopCount());
    	map1.put("objName", ""+openAccount.getBeautifulyard());
    	map1.put("Type", "1");
    	map1.put("companyCode", "1");
    	map1.put("status", "LOCKED");
    	map1.put("page", "1");
    	map1.put("pageSize", "5");
    	map1.put("provinceCode", "2");
    	map1.put("address", openAccount.getZongbuAddress());
    	map1.put("systemType", "MOS");
    	map1.put("cityCode", openAccount.getCity());
    	List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
    	List<AddressAreaDef>  addressAreaDefsProvince = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(openAccount.getProvince())).collect(Collectors.toList());
		 if (addressAreaDefsProvince != null && addressAreaDefsProvince.size() > 0 ) {
			 
			 map1.put("provinceName", addressAreaDefsProvince.get(0).getObjName());
		 }
    	List<AddressAreaDef>  addressAreaDefsCity = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(openAccount.getCity())).collect(Collectors.toList());
    	if (addressAreaDefsCity != null && addressAreaDefsCity.size() > 0 ) {
			 map1.put("cityName", addressAreaDefsCity.get(0).getObjName());
		 }
    	try {
			map1.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String resultData1 = null;
		try {
			resultData1 = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/createBossAndCompany.jhtml", map1, "utf-8","utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		
		JSONObject data1 = jsonObject.parseObject(resultData1);
		Recordlogs recordlogs = new Recordlogs();
		if (data1.get("code").equals("1000000") && StringUtils.isBlank(upBossErrId)) {
			//存入saas对应的companyCode 跟mos相同
			if (data1.getString("data") != null) {
				openAccount.setCompanyCode(data1.getString("data"));
			}
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq("openNumber", openAccount.getOpenNumber());
			queryParameter.and();
			queryParameter.ne("approvalStatus", -1);
			List<OpenAccount> openAccounts = openAccountService.searchList(queryParameter);
			int saveAccount = 0;
			//说明数据库已存在不进行插入操作
			if (openAccounts != null && openAccounts.size() > 0) {
				
				return "7";
			} else {
				 openAccount.setUpdateDate(new Date());
				 //存入录入人的id为查询当前销售人员的列表
				 Employee employee =  (Employee)request.getSession().getAttribute("loginUser");  
				 if (employee != null) {
					 openAccount.setEmpId(employee.getEmpId());
				 }
				 String sell = request.getParameter("sell");
				 if (StringUtils.isNotBlank(sell)) {
					 openAccount.setMarket(sell);
				 }
				 //判断是渠道还是直营
				 if (openAccount.getIsChannel().equals("isqudao")) {
					 //存到中间表一个渠道商对应多个开通账号
					 saveAccount = openAccountService.insert(openAccount);
					 if (saveAccount == 1) {
						 String channelId = request.getParameter("channelId");
						 if (StringUtils.isNotBlank(channelId)) {
							 OpenaccountChannel openaccountChannel = new OpenaccountChannel();
							 openaccountChannel.setChannelId(Long.valueOf(channelId));
							 openaccountChannel.setStatus(1);
							 OpenAccount openAccount2 = openAccountService.searchByMobile(openAccount.getOpenNumber());
							 openaccountChannel.setOpenAccountId(Long.valueOf(openAccount2.getAccountId()));
							 openaccountChannelService.insert(openaccountChannel);
						 }
						 
					 }
					 
				 } else {
					 saveAccount = openAccountService.insert(openAccount);
				 }
			}
			if (saveAccount==1 ) {
				return "1";
			//saas成功mos失败 要存入日志信息到logs 写入log日志
			} else {
				
				recordlogs.setBeautifulYard(openAccount.getBeautifulyard());
				recordlogs.setMobile(openAccount.getOpenNumber());	
				recordlogs.setOpenShopAmount(openAccount.getShopCount());
				recordlogs.setPayDate(openAccount.getPayDate());
				recordlogs.setMarket(openAccount.getMarket());
				recordlogs.setProvinceCode(Integer.parseInt(openAccount.getProvince()));
				recordlogs.setCityCode(Integer.parseInt(openAccount.getCity()));
				recordlogs.setZongbuAddress(openAccount.getZongbuAddress());
				recordlogs.setRemark(openAccount.getRemark());
//				recordlogs.setRemark("UpBossErr");
				recordlogs.setAddInfoUser(((Employee)request.getSession().getAttribute("loginUser")).getEmpName());
				recordlogs.setCompanyCode(data1.getString("data"));
				recordlogs.setCreateTime(new Date());
				recordlogs.setStatus(1);
				recordlogs.setType(1);//开通账号
				
				int logErr = recordlogsService.insert(recordlogs);
				//返回插入日志的
				if (logErr != 1){
					return "6";
				}
				return "0";
			}
		//保存saas库失败要留mos库的日志 注册成功 升级老板号失败
		}else if (data1.get("code").equals("1000000") && StringUtils.isNotBlank(upBossErrId)){
			Upbosslogs upbosslogs = upbosslogsService.searchByUpBossId(Integer.parseInt(upBossErrId));
			upbosslogs.setStatus(0);
			upbosslogsService.update(upbosslogs);
			return "upBossOk";
		//第一次升级老板号失败	
		}else {
			Upbosslogs upbosslogs = new Upbosslogs();
			BeanUtils.copyProperties(openAccount, upbosslogs);
			upbosslogs.setCityCode(Integer.parseInt(openAccount.getCity()));
			upbosslogs.setProvinceCode(Integer.parseInt(openAccount.getProvince()));
			upbosslogs.setBeautifulYard(openAccount.getBeautifulyard());
			upbosslogs.setPayDate(openAccount.getPayDate());
			upbosslogs.setMarker(openAccount.getMarket());
			
			try {
				upbosslogsService.insert(upbosslogs);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		return  "0";
	}
	
	/**
	 *更新开通账号状态
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateStatus" , method = {RequestMethod.POST,RequestMethod.GET})
	public String approvePassAndUpdateStatus(HttpServletRequest request,HttpServletResponse response) {
		
		String accountId = request.getParameter("accountId");
		String isOk = request.getParameter("isOk");
		String zhifuMoney = request.getParameter("zhifuMoney");
		String contractId = request.getParameter("contractId");
		String isqudao = request.getParameter("isqudao");//判断是否是渠道过来的开通账号
		if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {
			
			OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq("accountId", accountId);
			List<Shop> shopsList = shopService.searchList(queryParameter);
			//判断店数是否等于账号的填入店数
			if (shopsList != null && shopsList.size() > 0) {
				if (shopsList.size() != openAccount.getShopCount()) {
					return "qudaoErrShopCount";
				}
			} else {
				return "qudaoErrShopCount";
			}
			//判断渠道的余额是否大于店数*900
			QueryParameter queryParameter1 = new QueryParameter();
			queryParameter1.eq("openAccountId", accountId);
			List<OpenaccountChannel> openaccountChannelsList = openaccountChannelService.searchList(queryParameter1);
			if (openaccountChannelsList != null && openaccountChannelsList.size() > 0){
				Long channelId = openaccountChannelsList.get(0).getChannelId();
				ChannelInfo channelInfo = channelInfoService.searchByChannelId(Integer.parseInt(channelId.toString()));
				if (channelInfo != null) {
					Double allMoney = 0D;
					for (int i = 0; i < shopsList.size(); i++) {
						QueryParameter queryParameter2 = new QueryParameter();
						queryParameter2.eq("argName", shopsList.get(i).getDuration());
						//匹配店数的年限对应的金额
						allMoney+=Double.valueOf(argserService.searchList(queryParameter2).get(0).getArgValue())*channelInfo.getDiscountRate();
					}
					if (Double.valueOf(channelInfo.getReadyDepositMoney().toString()) < allMoney ) {
						return "qudaoErrMoney";
					}
					
				}
			}
		}
		
		if (StringUtils.isNotBlank(accountId)) {
			//更新NOMAL状态
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq("accountId",accountId);
			List<OpenAccount> openAccounts = openAccountService.searchList(queryParameter);
			if (openAccounts != null && openAccounts.size() > 0) {
				OpenAccount openAccount = openAccounts.get(0);
				if (isOk.equals("1")) {
					//财务通过是添加的支付金额start
					QueryParameter queryParameter2 = new QueryParameter();
					queryParameter2.eq("contractId", contractId);
					List<Contract> contractsList = contractService.searchList(queryParameter2);
					if (contractsList != null && contractsList.size() > 0) {
						contractsList.get(0).setPayMoney(Double.parseDouble(zhifuMoney));
						contractService.update(contractsList.get(0));
					}
					//财务通过是添加的支付金额end
					//退回之后通过的操作
					if (openAccount.getApprovalStatus() == 4 && openAccount.getIsOpenStatus() != 0) {
						openAccount.setApprovalStatus(2);
						if (openAccount.getIsOpenStatus() == 1) {
							openAccount.setFinanceSuccessDate(new Date());
							int updateStatus = openAccountService.update(openAccount);
							if (updateStatus == 1) {
								return "tg";
							}
						}
					}
					//调取crm接口设置状态
					Map<String, String> map = new HashMap<String, String>();
			    	map.put("consumerId", openAccount.getConsumerId()+"");
			    	String resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpCrmUrl+"/afterSale/passCheck", map, "utf-8", "utf-8");
					//直接审批通过
					return operationcenterOpen(openAccount);
					//未通过处理
				} else {
						openAccount.setApprovalStatus(3);
						int updateStatus = openAccountService.update(openAccount);
						if (updateStatus == 1) {
							return "wtg";
						}
				}
			}
		
		}
		return "0";
	}
	
	/**
	 * 更新拒绝原由
	 * @param request
	 * @param response
	 * @param refuseInfo
	 * @return
	 */
	@RequestMapping(value="/updateRefuseInfo")
	@ResponseBody
	public String updateRefuseInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="refuseInfo") String refuseInfo){
		
		String accountId = request.getParameter("accountId");
		if (StringUtils.isNotBlank(accountId)) {
			OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
			openAccount.setRefuseInfo(refuseInfo);
			openAccount.setApprovalStatus(3);
			openAccount.setUpdateDate(new Date());
			int updateOpenAccount = openAccountService.update(openAccount);
			if (updateOpenAccount == 1) {
				return "1";
			}
		}
		return "0";
	}
	/**
	 * 账号变成正常的
	 * @param openAccount
	 * @return
	 */
	public String operationcenterOpen(OpenAccount openAccount){
		
		Map<String, String>  map = new HashMap<String, String>();
		map.put("companyCode", openAccount.getCompanyCode());
		map.put("mobile", openAccount.getOpenNumber());
		map.put("status", "NORMAL");
		try {
			map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/updateClerkLoginStatus.jhtml", map, "utf-8","utf-8");
		if (StringUtils.isNotBlank(resultData)) {
			JSONObject jsonObject = new JSONObject();
			JSONObject data = jsonObject.parseObject(resultData);
			if (data.get("code").equals("1000000")) {
				openAccount.setApprovalStatus(2);
				openAccount.setIsOpenStatus(1);
				//为了展示渠道列表的 财务开号
				if (openAccount.getIsChannel().equals("isqudao")) {
					openAccount.setIsShowQudaoList(1);
				}
				int updateStatus = openAccountService.update(openAccount);
				if (updateStatus == 1) {
					
					return "tg";
				}
			}
		}
		return "0"; 
	}
	
	/**
	 * 关闭账号
	 * @param request
	 * @param response
	 * @param refuseInfo
	 * @return
	 */
	@RequestMapping(value="/closeAccount")
	@ResponseBody
	public String closeAccount(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="mobile") String mobile, @RequestParam(value="type") String type){

		Map<String, String>  map = new HashMap<String, String>();
		OpenAccount openAccount = openAccountService.searchByMobile(mobile);
		if (openAccount == null) {
			return "0";
		}
		map.put("companyCode",openAccount.getCompanyCode());
		map.put("mobile",mobile);
		if (type.equals("1")) {
		map.put("status", "DELETE");
		}
		try {
			map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/updateClerkLoginStatus.jhtml", map, "utf-8","utf-8");
		if (StringUtils.isNotBlank(resultData)) {
			JSONObject jsonObject = new JSONObject();
			JSONObject data = jsonObject.parseObject(resultData);
			if (data.get("code").equals("1000000")) { 
				openAccount.setApprovalStatus(-1);
				openAccount.setIsOpenStatus(0);
				int updateStatus = openAccountService.update(openAccount);
				if (updateStatus == 1) {
					
					return "ygb";
				}
			}
		}
		
		return "0";
	}
	
	/**
	 * 一个渠道开通的账号列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/showListOpenAccountChannel")
	public ModelAndView showListOpenAccountChannel(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
		
		String isqudao = request.getParameter("isqd");
		String channelId = request.getParameter("channelId");
		String finance = request.getParameter("finance");
		Employee employee =  (Employee)request.getSession().getAttribute("loginUser");  
		QueryParameter qp = new QueryParameter();
		qp.eq("channelId", channelId);
		//获取中间表的openAccountId
		List<OpenaccountChannel> openaccountChannelsList = openaccountChannelService.searchList(qp);
		List<OpenAccount> openAccountsList = new ArrayList<OpenAccount>();
		ModelAndView mav = new ModelAndView("/channelInfo/ChannelOnlyOpenAccountList");
		//财务查看的内容可操作
		if (finance != null && finance.equals("1")) {
			if (openaccountChannelsList != null && openaccountChannelsList.size() > 0) {
				for (int i = 0; i < openaccountChannelsList.size(); i++) {
					
					QueryParameter queryParameter = new QueryParameter();
					if (employee != null) {
						queryParameter.eq("empId", employee.getEmpId());//当前销售登录人员的列表
						queryParameter.and();
						queryParameter.ne("approvalStatus", "-1");//不等于开通再关闭的
					}
					queryParameter.and();
					queryParameter.eq("accountId", openaccountChannelsList.get(i).getOpenAccountId());
					List<OpenAccount>  openAccounts = openAccountService.searchList(queryParameter);
					if (openAccounts != null && openAccounts.size() > 0) {
						openAccountsList.add(openAccounts.get(0));
					}
				}
			}
			//不是财务看的
		} else {
			if (openaccountChannelsList != null && openaccountChannelsList.size() > 0) {
				for (int i = 0; i < openaccountChannelsList.size(); i++) {
					
					QueryParameter queryParameter = new QueryParameter();
					if (employee != null) {
//						queryParameter.eq("empId", employee.getEmpId());//当前销售登录人员的列表
//						queryParameter.and();
						queryParameter.ne("approvalStatus", "-1");//不等于开通再关闭的
					}
					queryParameter.and();
					queryParameter.eq("accountId", openaccountChannelsList.get(i).getOpenAccountId());
					List<OpenAccount>  openAccounts = openAccountService.searchList(queryParameter);
					if (openAccounts != null && openAccounts.size() > 0) {
						openAccountsList.add(openAccounts.get(0));
					}
				}
			}
			mav.addObject("qudao", "1");
		}
		//根据时间排序
		 SortClassUtils sort = new SortClassUtils();  
	     Collections.sort(openAccountsList,sort); 
		
		if (openAccountsList != null && openAccountsList.size() > 0) {
			
			for (int i = 0 ;i < openAccountsList.size() ; i++) {
				String cityCode = openAccountsList.get(i).getCity();
				String provinceCode = openAccountsList.get(i).getProvince();
				List<AddressAreaDef>  addressAreaDefs = StartupController.getProvinceAndCity();
				
				 List<AddressAreaDef>  addressAreaDefs2 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(cityCode)).collect(Collectors.toList());
				 if (addressAreaDefs2 != null && addressAreaDefs2.size() > 0 ) {
					 AddressAreaDef addressAreaDefCity = addressAreaDefs2.get(0);
					 openAccountsList.get(i).setCityName(addressAreaDefCity.getObjName());
				 }
				 List<AddressAreaDef>  addressAreaDefs3 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(provinceCode)).collect(Collectors.toList());
				 if (addressAreaDefs3 != null && addressAreaDefs3.size() > 0) {
					 AddressAreaDef addressAreaDefProvince =  addressAreaDefs3.get(0);
					 openAccountsList.get(i).setProvinceName(addressAreaDefProvince.getObjName());
				 }
				 QueryParameter queryParameter = new QueryParameter();
				 queryParameter.eq("userName", openAccountsList.get(i).getMarket());
				 List<Employee> employeesList = employeeService.searchList(queryParameter);
				 if (employeesList != null && employeesList.size() >0) {
					 openAccountsList.get(i).setMarket(employeesList.get(0).getEmpName()+"("+openAccountsList.get(i).getMarket()+")");
				 }
			}
		}
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		mav.addObject("openAccountPageList", openAccountsList);
		mav.addObject("finance", finance);
		return mav;
	}
	
	/**
	 * 存入open——account的market
	 * @param request
	 * @param response
	 * @param parameter
	 * @return
	 */
	 @RequestMapping(value="/test",method={RequestMethod.POST,RequestMethod.GET})
	    public String test(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String,Object> parameter) {
	    	
		 List<OpenAccount> openAccounts = openAccountService.searchList(new QueryParameter());
		
		 operationcenterOpen(new OpenAccount());
		 List<Employee> employees = employeeService.searchList(new QueryParameter());
		 
		 for (int i = 0 ; i < openAccounts.size() ;i++) {
			 String empName = openAccounts.get(i).getMarket();
			 List<Employee> employees2 = employees.parallelStream().filter(e -> e.getEmpName().equals(empName)).collect(Collectors.toList());
			 
			 openAccounts.get(i).setMarket(employees2.get(0).getUserName());
			 openAccountService.update( openAccounts.get(i));
			 
		 }
	    	return "";
	    }
	 
	 
	 
}
