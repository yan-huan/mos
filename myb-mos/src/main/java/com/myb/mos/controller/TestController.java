package com.myb.mos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.Aaemployee1Service;
import com.myb.accounts.service.AaexceptionopenaccountService;
import com.myb.accounts.service.AaopenAccountSaasService;
import com.myb.accounts.service.AaquitService;
import com.myb.accounts.service.AashopSaasService;
import com.myb.accounts.service.AbcaiwuallService;
import com.myb.accounts.service.AbopenaccountDataService;
import com.myb.accounts.service.AbopenaccountMoneyBjService;
import com.myb.accounts.service.AbopenaccountMoneyGjService;
import com.myb.accounts.service.AbopenaccountMoneyHzService;
import com.myb.accounts.service.AbopenaccountMoneyShService;
import com.myb.accounts.service.AbopenaccountMoneySzService;
import com.myb.accounts.service.AccountsAccountService;
import com.myb.accounts.service.AddressAreaDefService;
import com.myb.accounts.service.ArgsService;
import com.myb.accounts.service.ContractService;
import com.myb.accounts.service.DutyService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.Sheet1Service;
import com.myb.accounts.service.ShopService;
import com.myb.accounts.service.UserInfoService;
import com.myb.entity.pojo.mos.Aaexceptionopenaccount;
import com.myb.entity.pojo.mos.AaopenAccountSaas;
import com.myb.entity.pojo.mos.Aaquit;
import com.myb.entity.pojo.mos.AashopSaas;
import com.myb.entity.pojo.mos.Abcaiwuall;
import com.myb.entity.pojo.mos.AbopenaccountData;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.Shop;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.utils.BaseProUtill;
import com.myb.mos.utils.DesUtill;
import com.myb.mos.utils.HttpClientUtil;
import com.myb.mos.utils.MD5Util;
/**
 * 公共跳转方法
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private AccountsAccountService accountsAccountService;

    @Autowired
    private OpenAccountService openAccountService;
    
    @Resource
    private ContractService contractService;
    
    @Resource
    private EmployeeService employeeService;
    
    @Resource
    private Sheet1Service sheet1Service;
    
    @Resource
    private DutyService dutyService;
    
    @Resource
    private UserInfoService sheet0Service;
    
    @Resource
    private AddressAreaDefService addressAreaDefService;
    
    @Resource
    private ArgsService argsService;
    
    @Autowired
    private AaopenAccountSaasService openAccountSaasService;
    
    @Autowired
    private AashopSaasService shopsaasService;
    
    @Autowired
    private ShopService shopService;
    
    @Autowired
    private AbopenaccountDataService abopenaccountDataService;
    @Autowired
    private AbopenaccountMoneyBjService abopenaccountMoneyBjService;
    @Autowired
    private AbopenaccountMoneyGjService abopenaccountMoneyGjService;
    @Autowired
    private AbopenaccountMoneyShService abopenaccountMoneyShService;
    @Autowired
    private AbopenaccountMoneyHzService abopenaccountMoneyHzService;
    @Autowired
    private AbopenaccountMoneySzService abopenaccountMoneySzService;
    @Autowired
    private AbcaiwuallService abcaiwuallService;
    @Autowired
    private Aaemployee1Service aaemployee1Service;
    @Autowired
    private AaquitService aaquitService;
    @Autowired
    private AaexceptionopenaccountService aaexceptionopenaccountService;
    
    private List<AbopenaccountData> storageOpenAccountList = new ArrayList<AbopenaccountData>();
    private List<Abcaiwuall> caiwuList = new ArrayList<Abcaiwuall>();
    
    
    @RequestMapping("/inex")//saas店和院的信息存到mos里面
    public  ModelAndView login( HttpServletRequest request, HttpServletResponse response) {
    	//添加saas的美容院的名称
    	List<OpenAccount> openAccountsList = openAccountService.searchList(new QueryParameter());
    	List<AaopenAccountSaas> openAccountSaas = openAccountSaasService.searchList(new QueryParameter());
    	List<AddressAreaDef> addressAreaDefsList = addressAreaDefService.searchList(new QueryParameter());
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	for (int i = 0; i < openAccountsList.size(); i++) {
    		for (int f = 0; f < openAccountSaas.size(); f++) {
    			if (openAccountsList.get(i).getCompanyCode().equals(openAccountSaas.get(f).getCOMPANYCODE())) {
    				openAccountSaas.remove(f);
    			}
    		}
    	}
    	for (int i = 0; i < openAccountSaas.size(); i++) {
    		OpenAccount openAccount = new OpenAccount();
    		AaopenAccountSaas openAccountSaas2 = openAccountSaas.get(i);
    		openAccount.setApprovalStatus(2);
    		openAccount.setBeautifulyard(openAccountSaas2.getBEAUTIFULYARD());
    		String city = openAccountSaas2.getCITY();
    		String province = openAccountSaas2.getPROVINCE();
    		if (StringUtils.isNotBlank(city)) {
//    			List<AddressAreaDef> addressAreaDefsByCity = addressAreaDefsList.parallelStream().filter(e->e.getId()==Integer.parseInt(city)).collect(Collectors.toList());
    			openAccount.setCity(city);
    		}
    		if (StringUtils.isNotBlank(province)) {
//    			List<AddressAreaDef> addressAreaDefsByProvince = addressAreaDefsList.parallelStream().filter(e->e.getId()==Integer.parseInt(province)).collect(Collectors.toList());
    			openAccount.setProvince(province);
    		}
    		openAccount.setCompanyCode(openAccountSaas2.getCOMPANYCODE());
				openAccount.setCreateTime(openAccountSaas2.getaNOCREATETIME());
//    		openAccount.setKefumobile(openAccountSaas2.getKefumobile());
    		openAccount.setIsAddAccount(1);
    		openAccount.setIsChannel("saas");
    		openAccount.setIsOpenStatus(0);
    		openAccount.setRefuseInfo("请添加合同");
    		openAccount.setIsShowQudaoList(0);
    		openAccount.setOpenNumber(openAccountSaas2.getOPENNUMBER());
			
    		openAccount.setPayDate(openAccountSaas2.getaNOCREATETIME());
    		
    		if (StringUtils.isNotBlank(openAccountSaas2.getSHOPCOUNT())) {
    			openAccount.setShopCount(Integer.parseInt(openAccountSaas2.getSHOPCOUNT()));
    		}
				openAccount.setUpdateDate(openAccountSaas2.getaNOCREATETIME());
    		openAccount.setZongbuAddress(openAccountSaas2.getZONGBUADDRESS());
    		openAccountService.insert(openAccount);
    	}
    	
    	System.out.println("美容院账号录入成功");
    	
    	//===============================================================店处理
    	//添加saas的店的名称
    	//所有的店saas信息
    	List<AashopSaas> shopsaasList = shopsaasService.searchList(new QueryParameter());
    	List<Shop> shopsList = shopService.searchList(new QueryParameter());
    	//处理mos库已经存在移除saaslist的数据
    	for ( int f = 0; f < shopsList.size(); f++){
    	for (int i = 0 ; i < shopsaasList.size(); i++) {
    			if (shopsList.get(f).getShopcode()!= null && shopsList.get(f).getShopcode().equalsIgnoreCase(shopsaasList.get(i).getShopcode())) {
    			System.out.println(i);
    				shopsaasList.remove(i);
    			}
    		}
    	}
    	
    	for ( int i = 0 ; i < shopsaasList.size(); i++) {
    		AashopSaas shopsaas = shopsaasList.get(i);
    		System.out.println(shopsaas+"gggggggggg");
    		Shop sp = new Shop();
    		BeanUtils.copyProperties(shopsaas, sp);
    		if (shopsaas != null && shopsaas.getaNOENDDATE() != null ) {
    			if (shopsaas.getaNOENDDATE().toString().contains("2016") || shopsaas.getaNOENDDATE().toString().contains("2017")) {
    				sp.setDanjia(3000D);
    				sp.setDuration(1);
    			}
    		}
    		else if (shopsaas != null && shopsaas.getaNOENDDATE() != null ) {
    			if ( shopsaas.getaNOENDDATE().toString().contains("2020") || shopsaas.getaNOENDDATE().toString().contains("2019") || shopsaas.getaNOENDDATE().toString().contains("2021")){
    				sp.setDanjia(6800D);
    				sp.setDuration(3);
    			}
    		}
    		else {
    			sp.setDanjia(9800D);
    			sp.setDuration(50);
    		}
    		if (shopsaas != null) {
    			sp.setAddress(shopsaas.getAddress());
    			sp.setCity(shopsaas.getCity());
    			sp.setBeginDate(shopsaas.getaNOBEGINDATE());
    			sp.setEndDate(shopsaas.getaNOENDDATE());
    			sp.setCreateTime(shopsaas.getaNOCREATETIME());
    			sp.setShopName(shopsaas.getSHOPNAME());
    			sp.setShopcode(shopsaas.getShopcode());
    			sp.setProvince(shopsaas.getProvince());
    			String companyCode = shopsaas.getCompanycode();
    			//
    			List<OpenAccount> openAccountsByCompantCode = openAccountsList.parallelStream().filter(e->e.getCompanyCode().equals(companyCode)).collect(Collectors.toList());
    			if (openAccountsByCompantCode != null && openAccountsByCompantCode.size() > 0) {
    				sp.setAccountId(openAccountsByCompantCode.get(0).getAccountId());
    			}
    		}
    		shopService.insert(sp);
    	}
    	
    	ModelAndView mav = new ModelAndView();
    	return mav;
    }
    
    
    
    
    @RequestMapping("/testData")
    public  String testData( HttpServletRequest request, HttpServletResponse response) {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	
    	List<String> caiwuNum = new ArrayList<String>();
    	List<String> saasNum = new ArrayList<String>();
    	List<String> saasNum1 = new ArrayList<String>();
    	List<String> caiwuNum1 = new ArrayList<String>();
    	List<Abcaiwuall> abcaiwualls = abcaiwuallService.searchList(new QueryParameter());
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
    	for (int i = 0; i < abcaiwualls.size(); i++) {
    		if (abcaiwualls.get(i).getUpdateEndTime() != null) {

        		Date da = abcaiwualls.get(i).getUpdateEndTime();
        		Calendar calendar = Calendar.getInstance();
        		calendar.setTime(da);
        		
        		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 7);
        		try {
        			Date endDate = sdf.parse(sdf.format(calendar.getTime()));
        			System.out.println(sdf.format(endDate));
        			abcaiwualls.get(i).setRealEndTime(sdf.format(endDate));
        		} catch (ParseException e) {
        			e.printStackTrace();
        		}
    		}
    	}
    	
    	for (int i = 0; i < abcaiwualls.size(); i++) {
    		try {
				if (abcaiwualls.get(i).getUpdateEndTime() != null && abcaiwualls.get(i).getUpdateEndTime().getTime() > simpleDateFormat.parse("2020-01-01").getTime() ) {
					abcaiwualls.remove(i);
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
    		
    	}
    	abcaiwualls.stream().forEach(e->caiwuNum.add(e.getKthm()));
    	List<AbopenaccountData> abopenaccountDatas = null;
		try {
			abopenaccountDatas = abopenaccountDataService.searchList(new QueryParameter().gt("CREATETIME", simpleDateFormat.parse("2015-04-30")));
		
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		for (int f = 0; f < abopenaccountDatas.size(); f++) {
			try {
				if (abopenaccountDatas.get(f).geteNDTIME() != null && abopenaccountDatas.get(f).geteNDTIME().getTime() > simpleDateFormat.parse("2020-01-01").getTime() ) {
					abopenaccountDatas.remove(f);
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		List<String> openNum = new ArrayList<String>();
		this.caiwuList = abcaiwualls;
		for (int i = 0; i < abcaiwualls.size(); i++) {
			for (int f = 0; f < abopenaccountDatas.size(); f++) {
				if (abcaiwualls.get(i).getKthm().equals(abopenaccountDatas.get(f).getoPENNUMBER())) {
					if (abcaiwualls.get(i).getUpdateEndTime() != null &&  !abcaiwualls.get(i).getUpdateEndTime().equals(abopenaccountDatas.get(f).geteNDTIME())) {
						//截止时间不相同的筛选出来
						System.out.println("手机号"+abcaiwualls.get(i).getKthm()+"截止时间财务"+abcaiwualls.get(i).getUpdateEndTime()+"===saas"+abopenaccountDatas.get(f).geteNDTIME()+"实际的截止时间"+abcaiwualls.get(i).getRealEndTime());
						openNum.add(abcaiwualls.get(i).getKthm());
					}
				}
			}
		}
		
		this.storageOpenAccountList = abopenaccountDatas;//saas的数据
		abopenaccountDatas.stream().forEach(e->saasNum.add(e.getoPENNUMBER()));
    	List<String> noOk = new ArrayList<String>();
    	for (int i = 0; i < saasNum.size(); i++) {
    		if (caiwuNum.contains(saasNum.get(i))) {//判断财务的数据不包含
    			caiwuNum1.add(saasNum.get(i));
    		} else 
    		{
    			saasNum1.add(saasNum.get(i));
    		}    			
    		
    	}
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("bbh", saasNum1);
    	System.out.println(jsonObject.toJSONString());
    	return jsonObject.toJSONString();
//    	List<String> list1 = new ArrayList<String>();
//    	List<String> list2 = new ArrayList<String>();
//    	List<String> list3 = new ArrayList<String>();
//    	
//    	//saas数据北京的
//    	List<AbopenaccountData> abopenaccountDatasList = null;
//		try {
//			abopenaccountDatasList = abopenaccountDataService.searchList(new QueryParameter().eq("PROVINCE", "2").and().gt("CREATETIME", simpleDateFormat.parse("2015-04-30")));
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//
//    	List<AbopenaccountMoneyBj> abopenaccountMoneyBjs = abopenaccountMoneyBjService.searchList(new QueryParameter().eq("shengfen", "北京"));
//    	
//    	abopenaccountDatasList.forEach(e->list1.add(e.getOPENNUMBER()));//
//    	abopenaccountMoneyBjs.forEach(e->list2.add(e.getKaitonghaoma()));
//    	list1.removeAll(list2);
//    	
//    	
////    	abopenaccountMoneyGjService
////    	abopenaccountMoneyHzService
////    	abopenaccountMoneyShService
////    	abopenaccountMoneySzService
//    	return "";
    }
    
    
public static void main(String[] args) {
	
	
//	String da = "2016-08-01";
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	Calendar calendar = Calendar.getInstance();
//	try {
//		calendar.setTime(sdf.parse(da));
//	} catch (ParseException e1) {
//		e1.printStackTrace();
//	}
//	
//	calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 7);
//	try {
//		Date endDate = sdf.parse(sdf.format(calendar.getTime()));
//		System.out.println(sdf.format(endDate));
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}
//	
//	//修改美容院的信息
//	Map<String, String>  map1 = new HashMap<String, String>();
//	map1.put("companyName", "喔");
//	map1.put("mobile", "15811347889");
//	map1.put("companyCode", "COMPANIESCOMPANY2016083116434000538");
//	map1.put("address", "421421");
//	map1.put("provinceCode", "2");
//	map1.put("cityCode", "3");
//	map1.put("expiredDate", "2016-08-31");
//	try {
//		map1.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
//	} catch (Exception e1) {
//		e1.printStackTrace();
//	}

	
//	String resultData1 = null;
//	try {
//		resultData1 = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/updateClerkInfoForMos.jhtml", map1, "utf-8","utf-8");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	System.out.println(resultData1);
//	
//	
//	
//	Map<String, String>  map = new HashMap<String, String>();
//	CompaniesShopModel csm = new CompaniesShopModel();
//	//修改店的信息
//	try {
//		resultData1 = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/company/updateCompaniesShop.jhtml", map1, "utf-8","utf-8");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
	
	Map<String, String>  map = new HashMap<String, String>();
	
		map.put("status", "NORMAL");
      map.put("buyerPartyType", "CLERK");
      map.put("cityName", "123");
      map.put("provinceCode", "123");
      map.put("cityCode", "21");
      map.put("mobile", "15811347889");
      map.put("areaCount", "500.00");
      map.put("provinceName","21241");
      map.put("objName", "1232141");
      map.put("address", "1231231");
      map.put("description","");
      map.put("servicePhone", "00000000000");
      map.put("belongToPartyType", "CLERK");
      map.put("bedCount", "1");
      map.put("startTime", "2016-06-5"+" 00:00:00");
      map.put("endTime", "2016-07-3"+" 00:00:00");
      map.put("duration", "12");
      map.put("versionType", "FREE");
      try {
		map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
	} catch (Exception e) {
		e.printStackTrace();
	}
	//后期添加的店
      JSONObject jsonObject = new JSONObject();
		 String resultData = null;
		try {
			resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/addShop.jhtml", map, "utf-8","utf-8");
		}finally{
			
		}
	
}

@RequestMapping(value="/setData")
public String setData(HttpServletRequest request, HttpServletResponse response) {
	
	List<Employee> employeesList = employeeService.searchList(new QueryParameter());
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//先存储openAccount 
	//店的信息
	//合同的信息
	List<AbopenaccountData> saasData = this.storageOpenAccountList;
	List<OpenAccount> openAccountsList = openAccountService.searchList(new QueryParameter());
	for (int i = 0; i < saasData.size(); i++) {
		String openNumber = saasData.get(i).getoPENNUMBER();
		List<OpenAccount> openAccountsByNumber = openAccountsList.parallelStream().filter(e->e.getOpenNumber().equals(openNumber)).collect(Collectors.toList());	//判断手机号是否已存在数据库 不存在数据库存入数据
		
		if (openAccountsByNumber != null && openAccountsByNumber.size()  > 0 ) {
			
			String openNum = openAccountsByNumber.get(0).getOpenNumber();
			List<Contract> contracts = contractService.searchList(new QueryParameter().eq("openNumber", openNum));//判断是否有合同
			if (contracts == null || contracts != null && contracts.size() ==0) {//说明账号没有合同
				List<Abcaiwuall> abcaiwualls = this.caiwuList;		//财务的数据去除终身的
				List<Abcaiwuall> abcaiwuallsByOpenNum = abcaiwualls.parallelStream().filter(e->e.getKthm().equals(openNum)).collect(Collectors.toList());
				
				if (abcaiwuallsByOpenNum != null && abcaiwuallsByOpenNum.size() > 0){
					Contract contract = new Contract();
					contract.setAccountId(openAccountsByNumber.get(0).getAccountId());
					if (abcaiwuallsByOpenNum.get(0).getUpdateStartTime() != null) {
						contract.setBeginDate(abcaiwuallsByOpenNum.get(0).getUpdateStartTime());//开始时间
						contract.setCreateTime(abcaiwuallsByOpenNum.get(0).getUpdateStartTime());//
					} else {
						try {
							contract.setCreateTime(simpleDateFormat.parse("1980-01-01"));
							contract.setBeginDate(simpleDateFormat.parse("1980-01-01"));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}//开始时间
						
					}
					if (abcaiwuallsByOpenNum.get(0).getKthm() == null) {
						
						contract.setBossAccount("0000000000");
					} else {
						contract.setBossAccount(abcaiwuallsByOpenNum.get(0).getKthm());
					}
					String xsry = abcaiwuallsByOpenNum.get(0).getXsry();
					List<Employee> employeesByEmpName =	employeesList.parallelStream().filter(e->e.getEmpName().equals(xsry)).collect(Collectors.toList());
					if (employeesByEmpName != null && employeesByEmpName.size() > 0) {
						contract.setOwnerName(employeesByEmpName.get(0).getUserName());
					} else {
						contract.setOwnerName("");
					}
					contract.setCompanyName(abcaiwuallsByOpenNum.get(0).getDianming());
					if (abcaiwuallsByOpenNum.get(0).getJine() != null && !abcaiwuallsByOpenNum.get(0).getJine().equals("")) {
						contract.setContractMoney(Integer.parseInt(abcaiwuallsByOpenNum.get(0).getJine()));
					}
					contract.setContractType(1);
					contract.setCreateTime(abcaiwuallsByOpenNum.get(0).getUpdateStartTime());
					if (abcaiwuallsByOpenNum.get(0).getUpdateEndTime() != null) {
						contract.setEndDate(abcaiwuallsByOpenNum.get(0).getUpdateEndTime());
					} else {
						try {
							contract.setEndDate(simpleDateFormat.parse("1980-01-01"));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
					contract.setOpenNumber(abcaiwuallsByOpenNum.get(0).getKthm());
					contract.setPayAccountName("");
					try {
						if (abcaiwuallsByOpenNum.get(0).getDzrq() != null) {
							contract.setPayDate(simpleDateFormat.parse(abcaiwuallsByOpenNum.get(0).getDzrq()));
						} else {
							contract.setPayDate(simpleDateFormat.parse("1988-01-01"));
							
						}
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if (abcaiwuallsByOpenNum.get(0).getDzje() != null && !abcaiwuallsByOpenNum.get(0).getDzje().equals("")) {
						
						contract.setPayMoney(Double.parseDouble(abcaiwuallsByOpenNum.get(0).getDzje()));
					}
					
					contract.setPayRemark(abcaiwuallsByOpenNum.get(0).getBeizhu());
					contract.setPayType(abcaiwuallsByOpenNum.get(0).getDzje());
					contract.setRemark(abcaiwuallsByOpenNum.get(0).getBeizhu());
					contract.setShopCount(1);
					contract.setStatus(1);
					contract.setUpdateDate(abcaiwuallsByOpenNum.get(0).getUpdateStartTime());
					if (abcaiwuallsByOpenNum.get(0).getHth() != null) {
						contract.setContractCode(abcaiwuallsByOpenNum.get(0).getHth());
					} else{
						contract.setContractCode("0000000");
					}
					contract.setDiscount(0);
					contractService.insert(contract);
				}
			}
		} else {//没有注册到数据库的账号
			
			System.out.println("未开通的手机号"+openAccountsByNumber.get(0).getOpenNumber());
			//openAccount没有的手机号存入数据
			
		}
	}
	
	return "";
}
 
	@RequestMapping(value="/chuliData")
	public String chuliData() {
		//mos的合同
//		List<Contract>  contractsAllData = contractService.searchList(new QueryParameter());
//		//财务合同
//		List<Abcaiwuall> abcaiwuallsAllData = abcaiwuallService.searchList(new QueryParameter());
//		List<OpenAccount> openAccountsAll = openAccountService.searchList(new QueryParameter());
//		List<Employee> employeesList = employeeService.searchList(new QueryParameter());
//		//处理mos不存在的合同
//		for (int i = 0; i < contractsAllData.size(); i++) {
//			for (int f =0; f < abcaiwuallsAllData.size(); f++) {
//				if (contractsAllData.get(i).getOpenNumber() != null && contractsAllData.get(i).getOpenNumber().equals(abcaiwuallsAllData.get(f).getKthm())) {
//					abcaiwuallsAllData.remove(f);
//				}
//			}
//		}
//		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////		//应该会多一千多个合同才对
//		for (int i = 0; i < abcaiwuallsAllData.size(); i++) {
//			String kaitonghaoma = abcaiwuallsAllData.get(i).getKthm();
//			List<OpenAccount> openAccountsByOpenNumber = openAccountsAll.stream().filter(e->e.getOpenNumber().equals(kaitonghaoma)).collect(Collectors.toList());
//			Contract contract = new Contract();
//			if (openAccountsByOpenNumber != null && openAccountsByOpenNumber.size() >0) {
//				contract.setAccountId(openAccountsByOpenNumber.get(0).getAccountId());
//			} else {
//				contract.setAccountId(00000);
//			}
//			if (abcaiwuallsAllData.get(i).getUpdateStartTime() != null) {
//				contract.setBeginDate(abcaiwuallsAllData.get(i).getUpdateStartTime());//开始时间
//				contract.setCreateTime(abcaiwuallsAllData.get(i).getUpdateStartTime());//
//			} else {
//				try {
//					contract.setCreateTime(simpleDateFormat.parse("1980-01-01"));
//					contract.setBeginDate(simpleDateFormat.parse("1980-01-01"));
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				}//开始时间
//				
//			}
//			if (abcaiwuallsAllData.get(i).getKthm() == null) {
//				
//				contract.setBossAccount("0000000000");
//			} else {
//				contract.setBossAccount(abcaiwuallsAllData.get(i).getKthm());
//			}
//			String xsry = abcaiwuallsAllData.get(i).getXsry();
//			List<Employee> employeesByEmpName =	employeesList.parallelStream().filter(e->e.getEmpName().equals(xsry)).collect(Collectors.toList());
//			if (employeesByEmpName != null && employeesByEmpName.size() > 0) {
//				contract.setOwnerName(employeesByEmpName.get(0).getUserName());
//			} else {
//				contract.setOwnerName("");
//			}
//			contract.setCompanyName(abcaiwuallsAllData.get(i).getDianming());
//			if (abcaiwuallsAllData.get(i).getJine() != null && !abcaiwuallsAllData.get(i).getJine().equals("")) {
//				contract.setContractMoney(Integer.parseInt(abcaiwuallsAllData.get(i).getJine()));
//			}
//			contract.setContractType(1);
//			contract.setCreateTime(abcaiwuallsAllData.get(i).getUpdateStartTime());
//			if (abcaiwuallsAllData.get(i).getUpdateEndTime() != null) {
//				contract.setEndDate(abcaiwuallsAllData.get(i).getUpdateEndTime());
//			} else {
//				try {
//					contract.setEndDate(simpleDateFormat.parse("1980-01-01"));
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				}
//			}
//			contract.setOpenNumber(abcaiwuallsAllData.get(i).getKthm());
//			contract.setPayAccountName("");
//			try {
//				if (abcaiwuallsAllData.get(i).getDzrq() != null) {
//					contract.setPayDate(simpleDateFormat.parse(abcaiwuallsAllData.get(i).getDzrq()));
//				} else {
//					contract.setPayDate(simpleDateFormat.parse("1988-01-01"));
//					
//				}
//			} catch (ParseException e1) {
//				e1.printStackTrace();
//			}
//			if (abcaiwuallsAllData.get(i).getDzje() != null && !abcaiwuallsAllData.get(i).getDzje().equals("")) {
//				
//				contract.setPayMoney(Double.parseDouble(abcaiwuallsAllData.get(i).getDzje()));
//			}
//			
//			contract.setPayRemark(abcaiwuallsAllData.get(i).getBeizhu());
//			contract.setPayType(abcaiwuallsAllData.get(i).getDzje());
//			contract.setRemark(abcaiwuallsAllData.get(i).getBeizhu());
//			contract.setShopCount(1);
//			contract.setStatus(1);
//			contract.setUpdateDate(abcaiwuallsAllData.get(i).getUpdateStartTime());
//			if (abcaiwuallsAllData.get(i).getHth() != null) {
//				contract.setContractCode(abcaiwuallsAllData.get(i).getHth());
//			} else{
//				contract.setContractCode("0000000");
//			}
//			contract.setDiscount(0);
//			contractService.insert(contract);
//		}
////		
//		
//		System.out.println();
//		
//		//=============================================店的信息补全=============================================================
//		System.out.println();
//		List<Contract>  contractsNewAllData = contractService.searchList(new QueryParameter());//导入过之后的所有合同
//		
//		for (int i = 0; i < contractsNewAllData.size(); i++)  {
//			Contract contract =	contractsNewAllData.get(i);
//			int shopCount = contractsNewAllData.get(i).getShopCount();//匹配合同里的店数是否和开通账号的店数一样
//			List<OpenAccount> openAccountsByOpenNum = openAccountsAll.parallelStream().filter(e->e.getOpenNumber().equals(contract.getOpenNumber())).collect(Collectors.toList());
//			if (openAccountsByOpenNum != null && openAccountsByOpenNum.size() > 0 &&contract.getShopCount() != openAccountsByOpenNum.get(0).getShopCount()) {
//				if (contract.getCreateTime() != null) {
//					System.out.println("手机号=" +contract.getOpenNumber()+"   合同店数"+contract.getShopCount()+"   开通账号的的店数="+openAccountsByOpenNum.get(0).getShopCount()+"  创建时间"+simpleDateFormat.format(contract.getCreateTime()));
//				} else {
//					System.out.println("手机号=" +contract.getOpenNumber()+"   合同店数"+contract.getShopCount()+"   开通账号的的店数="+openAccountsByOpenNum.get(0).getShopCount()+"  创建时间"+"n u ll");
//					
//				}
//			} else if(openAccountsByOpenNum == null || openAccountsByOpenNum.size()==0){
//				if (contract.getCreateTime() != null) {
//					System.out.println("异常手机号=" +contract.getOpenNumber()+"   合同店数"+contract.getShopCount()+"    开通账号的的店数="+"未知数"+"   创建时间"+simpleDateFormat.format(contract.getCreateTime()));
//				} else {
//					System.out.println("异常手机号=" +contract.getOpenNumber()+"   合同店数"+contract.getShopCount()+"    开通账号的的店数="+"未知数"+"   创建时间"+" n u l l");
//					
//				}
//				
//			}
//		}
		
		//美容院的信息是对的但是添加的店的数量不对的数据统计
//		List<Shop> shopsAll = shopService.searchList(new QueryParameter());
//		for (int i = 0; i < contractsNewAllData.size(); i++) {
//			String openNumber = contractsNewAllData.get(i).getOpenNumber();
//			List<OpenAccount>  openAccounts = openAccountsAll.parallelStream().filter(e->e.getOpenNumber().equals(openNumber)).collect(Collectors.toList());
//			if (openAccounts != null && openAccounts.size() > 0) {
//				int accountId = openAccounts.get(0).getAccountId();
//				List<Shop> shopsByAccountId = shopsAll.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
//				int shopCount=0;
//				for (int f = 0; f < caiwuList.size(); f++) {
//					if (caiwuList.get(f).getKthm().equals(openNumber)) {
//						shopCount++;
//					}
//				}
////				System.out.println(shopCount);
//				if (shopsByAccountId != null && shopsByAccountId.size() > 0) {//店的数量
//					if (shopCount != shopsByAccountId.size()) {
//						System.out.println("填写店数不同"+"手机号"+contractsNewAllData.get(i).getOpenNumber()+"  财务的店数"+shopCount+ "  mos的实际店数" +shopsByAccountId.size());
//					}
//				} else {
//					
//					System.out.println("填写店数不同11"+"手机号"+contractsNewAllData.get(i).getOpenNumber()+"  财务的店数"+shopCount+ "  mos的实际店数" +"null");
//				}
//			}
//			
//		}
//		Set<String> allException = new HashSet<String>();
//		List<Abcaiwuall> abcaiwualls = abcaiwuallService.searchList(new QueryParameter());
//    	List<AbopenaccountData> abopenaccountDatas = null;
//		try {
//			abopenaccountDatas = abopenaccountDataService.searchList(new QueryParameter().gt("CREATETIME", simpleDateFormat.parse("2015-04-30")));
//		
//		} catch (ParseException e2) {
//			e2.printStackTrace();
//		}
//		for (int f = 0; f < abcaiwualls.size(); f++) {//财务的所有数据
//			for (int i = 0; i < abopenaccountDatas.size(); i++) {
//				if (abcaiwualls.get(f).getKthm().equals(abopenaccountDatas.get(i).getoPENNUMBER())){
//					String mobile = abcaiwualls.get(f).getKthm();
//					List<Abcaiwuall> abcaiwualls2 = abcaiwualls.parallelStream().filter(e->e.getKthm().equals(mobile)).collect(Collectors.toList());
//					
//					abcaiwualls.get(f).setDanshu(String.valueOf(abcaiwualls2.size()));//店数
//					if (abcaiwualls.get(f).getDanshu() != null && !abcaiwualls.get(f).getDanshu().equals(abopenaccountDatas.get(i).getsHOPCOUNT())){//店数不相等的提取出来
//						allException.add("手机号"+abcaiwualls.get(f).getKthm()+"财务的数量"+abcaiwualls.get(f).getDanshu()+"saas"+abopenaccountDatas.get(i).getsHOPCOUNT());
//					}
//				}
//			}
//		}
//		
//		Iterator<String> it = allException.iterator();  
//		while (it.hasNext()) {  
//		  String str = it.next();  
//		  System.out.println(str);  
//		}  
//		
		return "";
	}
	
	/**
	 * 新员工录入数据库操作
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/chuliEmployee")
	public String chuliEmployee(HttpServletRequest request, HttpServletResponse response) {
		List<Employee> employeesList = employeeService.searchList(new QueryParameter());
		List<Aaquit> aaquits = aaquitService.searchList(new QueryParameter());
	
//		for (int i = 0; i < aaquits.size(); i++) {
//			String name = aaquits.get(i).getAa();
//			List<Employee> employees = employeesList.parallelStream().filter(e->e.getEmpName().equals(name)).collect(Collectors.toList());
//			if (employees != null  &&employees.size()>0) {
//				employees.get(0).setIsUsed(0);
//				employeeService.update(employees.get(0));//退出的员工
//			}
//		}
		
//		List<Aaemployee1> aaemployee1s = aaemployee1Service.searchList(new QueryParameter());//所有的员工
//		for (int i = 0; i < aaemployee1s.size(); i++) {
//			String mobile = aaemployee1s.get(i).getMobile();
//			List<Employee> employees = employeesList.parallelStream().filter(e->e.getUserName().equals(mobile)).collect(Collectors.toList());
//			
//			if (employees != null && employees.size() > 0) {//判断财务给的员工表在mos库里面进行更新 反之就是插入数据
////				
////				Employee employee = employees.get(0);
////				
////				
////				employee.setEmpName(aaemployee1s.get(i).getXingming());
////				employee.setEntryTime(aaemployee1s.get(i).getRuzhishijian());
////				employee.setEmpCode(aaemployee1s.get(i).getGonghao());
////				employee.setUserName(aaemployee1s.get(i).getMobile());
////				employee.setCreateTime(aaemployee1s.get(i).getRuzhishijian());
////				employee.setStatus(1);
////				
		
				Employee employee = employeeService.searchByUserName("18512218182");
				Random random = new Random();
				int rd = random.nextInt(10);
				String ran = String.valueOf(rd);
				StringBuilder stringBuilder = new StringBuilder();
				if (StringUtils.isNotBlank(employee.getUserName())) {
					String pwd = employee.getUserName().substring(5, employee.getUserName().length());
					stringBuilder.append(pwd);
				}
				stringBuilder.append(ran);
				String newPWD = stringBuilder.toString();
				employee.setPassWord(MD5Util.string2MD5(newPWD));
				employee.setIsUsed(1);
				employee.setRan(rd);
				employeeService.update(employee);
////				
//			} else {
//				
//				//新数据的insert操作
//				Employee employee = new Employee();
//				employee.setEmpName(aaemployee1s.get(i).getXingming());
//				employee.setEntryTime(aaemployee1s.get(i).getRuzhishijian());
//				employee.setEmpCode(aaemployee1s.get(i).getGonghao());
//				employee.setUserName(aaemployee1s.get(i).getMobile());
//				employee.setCreateTime(aaemployee1s.get(i).getRuzhishijian());
//				employee.setStatus(1);
//				
//				Random random = new Random();
//				int rd = random.nextInt(10);
//				String ran = String.valueOf(rd);
//				StringBuilder stringBuilder = new StringBuilder();
//				if (StringUtils.isNotBlank(aaemployee1s.get(0).getMobile())) {
//					String pwd = aaemployee1s.get(0).getMobile().substring(5, aaemployee1s.get(0).getMobile().length());
//					stringBuilder.append(pwd);
//				}
//				stringBuilder.append(ran);
//				String newPWD = stringBuilder.toString();
//				employee.setPassWord(MD5Util.string2MD5(newPWD));
//				employee.setIsUsed(1);
//				employee.setRan(rd);
//				employeeService.insert(employee);
//			}
//			
//		}
//				13720619631
//				15502969150
//				18192319868
//				18966576057
//				18591940984
//				13991733126
//				13389257289
//				18629555919
//				14700966000

		
		List<Employee> employeesList1 = employeeService.searchList(new QueryParameter());
		for (int i = 0; i < employeesList1.size(); i++) {
			String empName = employeesList1.get(i).getEmpName();
			
			List<Employee> employeesByEmpName = employeesList1.parallelStream().filter(e->e.getEmpName().equals(empName)).collect(Collectors.toList());
			if (employeesByEmpName != null && employeesByEmpName.size() > 1) {
				System.out.println(employeesByEmpName.get(0).getEmpName());
			}
			
		}
		
		
	return "";
	}
	
	
	@RequestMapping(value="/Lifelong")
	public String setLifelong(HttpServletRequest request, HttpServletResponse response) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Shop> shops = shopService.searchList(new QueryParameter());
		List<Aaexceptionopenaccount> aaexceptionopenaccounts = aaexceptionopenaccountService.searchList(new QueryParameter());
		List<OpenAccount> openAccounts = openAccountService.searchList(new QueryParameter());
		for (int i = 0; i < aaexceptionopenaccounts.size(); i++) {
			String mobile = aaexceptionopenaccounts.get(i).getMobile();
			List<OpenAccount> accounts =openAccounts.parallelStream().filter(e->e.getOpenNumber().equals(mobile)).collect(Collectors.toList());
			if (accounts != null && accounts.size() > 0) {
				int accountId = accounts.get(0).getAccountId();
				System.out.println(accounts.get(0).getOpenNumber());
				List<Shop> shops2 = shops.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
				for (int f = 0; f < shops2.size(); f++) {
					try {
						
						shops2.get(f).setEndDate(format.parse("2016-09-30"));
						shopService.update(shops2.get(f));
						
				    	Map<String, String>  map = new HashMap<String, String>();	
						map.put("shopCode", shops2.get(f).getShopcode());
						map.put("employeeId", "1");
						map.put("employeeName", "2");
						map.put("endDate", format.format(shops2.get(f).getEndDate()));
						try {
							map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
							String resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/company/delayCompanyShopEndDate.jhtml", map, "utf-8", "utf-8");
					
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		
		return "";
	}
	
	
	
	
	
    
}