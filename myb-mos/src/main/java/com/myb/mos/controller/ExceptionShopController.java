package com.myb.mos.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.AccountsAccountService;
import com.myb.accounts.service.EmpRoleService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.RoleChildService;
import com.myb.accounts.service.RoleService;
import com.myb.accounts.service.ShopService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.EmpRole;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.Role;
import com.myb.entity.pojo.mos.RoleChild;
import com.myb.entity.pojo.mos.Shop;
import com.myb.entity.pojo.mos.ShopMapping;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.mos.VO.RoleVO;
import com.myb.mos.VO.ShopVO;
import com.myb.mos.utils.BaseProUtill;
import com.myb.mos.utils.DesUtill;
import com.myb.mos.utils.HttpClientUtil;
/**
 *加载用户权限
 */
@Controller
@RequestMapping("/ExceptionShop")
public class ExceptionShopController {

	@Autowired
    private RoleChildService childService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private EmpRoleService empRoleService;
    
    @Autowired
    private ShopService shopService;
	
    @Autowired
    private OpenAccountService openAccountService;
    
    @Autowired
    private EmployeeService employeeService;
    
   /**
    * 店的修改对应的美容院的列表
    * @param request
    * @param response
    * @return
    */
    @RequestMapping("/modifyShopList")
    public  ModelAndView modifyShopList( HttpServletRequest request, HttpServletResponse response,@RequestParam(value="pageIndex",defaultValue="1") int pageIndex) {
    	
    	if (pageIndex <= 0 ) {
    		pageIndex = 1;
    	}
    	ModelAndView mav = new ModelAndView("exceptionShop/deplayOpenAccountList");
    	String type = request.getParameter("type");
    	QueryParameter queryParameter = new QueryParameter();
    	if (type != null && type.equals("delay")) {
    		queryParameter.eq("exceptionStatus", 2);
    		mav.addObject("type", "delay");
    	} else {
    		queryParameter.eq("exceptionStatus", 4);
    	}
//    	queryParameter.and();
//		queryParameter.eq("ispass", 3);
    	List<Shop> shopsList = shopService.searchList(queryParameter);//修改过的店的
    	List<OpenAccount> openAccountsList = openAccountService.searchList(new QueryParameter());//所有的美容院账号
    	List<OpenAccount> openAccountsByModifyList = new ArrayList<OpenAccount>();//预先声明所有修改的列表
    	PagedList<OpenAccount> pagedList = new PagedList<OpenAccount>();
    	for (int i = 0; i < shopsList.size(); i++) {
    		int accountId = shopsList.get(i).getAccountId();
    		List<OpenAccount> openAccountsByAccountId = openAccountsList.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
    		if (openAccountsByAccountId != null && openAccountsByAccountId.size() > 0) {
    			int ispassStatus = shopsList.get(i).getIspass();//是否通过1为通过，2为未通过，修改信息的时候，3为未审核
    			if (ispassStatus == 1) {
    				openAccountsByAccountId.get(0).setIspass("1");
    			} else if (ispassStatus == 3) {
    				openAccountsByAccountId.get(0).setIspass("3");
    			} 
    			
    			
    			openAccountsByModifyList.add(openAccountsByAccountId.get(0));
    		}
    	}
    	List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
    	openAccountsByModifyList = new ArrayList<OpenAccount>(new HashSet<OpenAccount>(openAccountsByModifyList));
    	List<Employee> employeesList = employeeService.searchList(new QueryParameter());//员工的列表
    	for (int i = 0; i < openAccountsByModifyList.size(); i++) {
    		String cityCode = openAccountsByModifyList.get(i).getCity();
    		String provinceCode = openAccountsByModifyList.get(i).getProvince();
    		List<AddressAreaDef> areaDefsByCity = addressAreaDefs.parallelStream().filter(e->e.getCode().equals(cityCode)).collect(Collectors.toList());
    		List<AddressAreaDef> areaDefsByProvince = addressAreaDefs.parallelStream().filter(e->e.getCode().equals(provinceCode)).collect(Collectors.toList());
    		//设置城市的名称
    		if (areaDefsByCity != null && areaDefsByCity.size() > 0) {
    			openAccountsByModifyList.get(i).setCityName(areaDefsByCity.get(0).getObjName());
    		}
    		//设置省份的名称
    		if (areaDefsByProvince != null && areaDefsByProvince.size() > 0) {
    			openAccountsByModifyList.get(i).setProvinceName(areaDefsByProvince.get(0).getObjName());
    		}
    		String userName = openAccountsByModifyList.get(i).getMarket();
    		List<Employee> employees = employeesList.parallelStream().filter(e->e.getUserName().equals(userName)).collect(Collectors.toList());
    		if (openAccountsByModifyList.get(i) != null) {
    			if (employees != null && employees.size() > 0) {
    				
    				openAccountsByModifyList.get(i).setMarket(employees.get(0).getEmpName()+"("+userName+")");
    			}
    		}
    		
    	}
    	
    	//排序
    	Collections.sort(openAccountsByModifyList, (OpenAccount a, OpenAccount b) -> b.getUpdateDate().compareTo(a.getUpdateDate()));
    	int pageSize = 10;
    	List<OpenAccount> openAccounts = new ArrayList<OpenAccount>();
    	for (int i = 0; i < openAccountsByModifyList.size(); i++) {
    		
    		if(i >= pageIndex*pageSize-10 && i < pageIndex*pageSize) {
    			openAccounts.add(openAccountsByModifyList.get(i));
    		}
    	}
    	pagedList.setContent(openAccounts);
    	pagedList.setPageIndex(pageIndex);
    	pagedList.setPageSize(pageSize);
    	pagedList.setRecordCount(openAccountsByModifyList.size());
    	pagedList.setTotalPage(openAccountsByModifyList.size()%pageSize==0
    			?openAccountsByModifyList.size()/pageSize
    			:openAccountsByModifyList.size()/pageSize+1);
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		mav.addObject("openAccountPageList", pagedList);
		
		return mav;
    }
    /**
     * 审批通过
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/passedOk")
    public String passedOk (HttpServletRequest request, HttpServletResponse response){
    	
    	String accountId = request.getParameter("accountId");
    	List<Shop> shopsList = shopService.searchList(new QueryParameter().eq("accountId", accountId).and().ne("exceptionStatus", 0));
    	//调取saas接口
    	List<Integer> errorCode = new ArrayList<Integer>();
    	for (int i = 0; i < shopsList.size(); i++) {
    		String currentIsOk	= forShopUpdate(shopsList.get(i));
    		if (currentIsOk.equals("1")) {
    			errorCode.add(1);
    		} else {
    			errorCode.add(0);
    		}
    		
    	}
    	if (errorCode.contains("0")) {//循环出现过失败
    		return "0";
    	} else {
    		for (int i = 0; i < shopsList.size(); i++) { 
    			shopsList.get(i).setIspass(1);
        		shopService.update(shopsList.get(i));
    		}
    		return "1";
    	}
    	
    }
    
    /**
     * 拒绝通过
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/returnBack")
    public String returnBack (HttpServletRequest request, HttpServletResponse response){
    	
    	String refuse = request.getParameter("refuse");
    	String accountId = request.getParameter("accountId");
    	
    	OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
    	openAccount.setUpdateDate(new Date());
    	openAccountService.update(openAccount);
    	List<Shop> shops = shopService.searchList(new QueryParameter().eq("accountId", accountId));
    	
    	List<Integer> isError = new ArrayList<Integer>();
    	for (int i = 0; i < shops.size(); i++) {
    		if (shops.get(i).getIspass() != 0) {
    			shops.get(i).setIspass(2);
    			shops.get(i).setRefuse(refuse);
    			int isOk = shopService.update(shops.get(i));
    			if (isOk == 1) {
    				isError.add(1);
    			} else {
    				isError.add(0);
    			}
    		}
    	}
    	
    	//是否全部成功
    	if (isError.contains(0)) {
    		return "0";
    	} else {
    		return "1";
    	}
    }
    
    /**
     * 循环更新店调用saas接口
     * @param shoppre
     * @param shopVo
     * @return
     */
    public String forShopUpdate(Shop shop){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Map<String, String>  map = new HashMap<String, String>();	
		map.put("shopCode", shop.getShopcode());
		map.put("employeeId", "1");
		map.put("employeeName", "2");
		map.put("endDate", format.format(shop.getEndDate()));
		try {
			map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
			String resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/company/delayCompanyShopEndDate.jhtml", map, "utf-8", "utf-8");
	
		if (StringUtils.isNotBlank(resultData)) {
			JSONObject jsonObject = JSONObject.parseObject(resultData);
			if (jsonObject.get("code").equals("1000000")) {
				return "1";
			}
		}	
		return "0";
    }
    
    public static void main(String[] args) {
		
      	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Map<String, String>  map = new HashMap<String, String>();	
		map.put("shopCode", "SHOPSHOPS1389");
		map.put("employeeId", "1");
		map.put("employeeName", "2");
		map.put("endDate", "2017-09-30");
		try {
			map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
			String resultData = HttpClientUtil.sendPostRequest("http://192.168.1.84:8080/myb-web"+"/company/delayCompanyShopEndDate.jhtml", map, "utf-8", "utf-8");
	
		if (StringUtils.isNotBlank(resultData)) {
			JSONObject jsonObject = JSONObject.parseObject(resultData);
			if (jsonObject.get("code").equals("1000000")) {
//				return "1";
			}
			
		}	
    	
	}
    
}
