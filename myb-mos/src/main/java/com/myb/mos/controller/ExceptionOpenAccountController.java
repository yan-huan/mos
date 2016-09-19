package com.myb.mos.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.myb.mos.VO.CityVO;
import com.myb.mos.VO.OpenAccountVO;
import com.myb.mos.VO.RoleVO;
import com.myb.mos.VO.ShopVO;
import com.myb.mos.utils.BaseProUtill;
import com.myb.mos.utils.DesUtill;
import com.myb.mos.utils.HttpClientUtil;
/**
 *异常的美容院处理
 */
@Controller
@RequestMapping("/ExceptionCompany")
public class ExceptionOpenAccountController {

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
    
    
    
    @RequestMapping(value="/CompanyInfo", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView CompanyInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="accountId") int accountId) {
    	
    	ModelAndView mav = new ModelAndView("/exceptionCompany/showCompanyInfo");
    	OpenAccount openAccount = openAccountService.searchByAccountId(accountId);
    	Employee employee = employeeService.searchByUserName(openAccount.getMarket());
    	openAccount.setMarket(employee.getEmpName()+"("+employee.getUserName()+")");
    	mav.addObject("openAccount", openAccount);
    	//城市
    	List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
		List<AddressAreaDef> addressAreaDefParent = addressAreaDefs.parallelStream().filter(e -> e.getParentCode().equals("1")).collect(Collectors.toList());
		mav.addObject("addressAreaDefParent", addressAreaDefParent);
		
		List<AddressAreaDef> cityList = addressAreaDefs.parallelStream().filter(e->e.getParentCode().equals(openAccount.getProvince())).collect(Collectors.toList());
		mav.addObject("cityList", cityList);
		return mav;
    }
    /**
     * 修改美容院的信息
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/updateCompanyInfo")
    public String updateCompanyInfo (HttpServletRequest request, HttpServletResponse response,@ModelAttribute("openAccount") OpenAccountVO openAccountVO){
    	
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	OpenAccount openAccount = openAccountService.searchByAccountId(openAccountVO.getAccountId());

    	if (!openAccount.getOpenNumber().equals(openAccountVO.getOpenNumber())) {
    		OpenAccount openAccountByMobile = openAccountService.searchByMobile(openAccountVO.getOpenNumber());
    		if (openAccountByMobile != null) {
    			return "3";
    		}
    	}
    	openAccount.setZongbuAddress(openAccountVO.getZongbuAddress());
    	openAccount.setCity(openAccountVO.getCity());
    	openAccount.setProvince(openAccountVO.getProvince());
    	openAccount.setBeautifulyard(openAccountVO.getBeautifulyard());
    	openAccount.setRemark(openAccountVO.getRemark());
    	openAccount.setOpenNumber(openAccountVO.getOpenNumber());
    	openAccount.setOperationReason(openAccountVO.getOperationReason());
    	openAccount.setIsOperationException(1);
    	try {
			openAccount.setPayDate(simpleDateFormat.parse(openAccountVO.getPayDate()));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
    	openAccount.setShopCount(openAccountVO.getShopCount());
    	int mosUpdateAccount = openAccountService.update(openAccount);
    	
    	Map<String, String>  map1 = new HashMap<String, String>();
    	map1.put("companyName", openAccountVO.getBeautifulyard());
    	if (!openAccountVO.getOpenNumber().equals(openAccount.getOpenNumber())) {
    	map1.put("mobile", openAccountVO.getOpenNumber());
    	}
    	map1.put("companyCode", openAccount.getCompanyCode());
    	map1.put("address", openAccountVO.getZongbuAddress());
    	map1.put("provinceCode", openAccountVO.getProvince());
    	map1.put("cityCode", openAccountVO.getCity());
    	map1.put("expiredDate",openAccountVO.getPayDate());
    	try {
    		map1.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
    	} catch (Exception e1) {
    		e1.printStackTrace();
    	}
    	
    	String resultData = null;
    	try {
    		resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/updateClerkInfoForMos.jhtml", map1, "utf-8","utf-8");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	JSONObject jSONObject = (JSONObject)JSONObject.parse(resultData);
    	if (jSONObject.get("code").equals("1000000") && mosUpdateAccount == 1) {
    		return "1";
    	} else {
    		return "0";
    	}
    }
    
    @RequestMapping(value="/showExceptionAccountList", method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView showExceptionAccountList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="pageIndex",defaultValue="1") int pageIndex) {
    	
    	if (pageIndex <= 0) {
    		pageIndex = 1;
    	}
    	ModelAndView mav = new ModelAndView("/exceptionCompany/OpenAccountList");
    	QueryParameter queryParameter = new QueryParameter();
    	queryParameter.eq("isOperationException", 1);
    	QueryCondition queryCondition = new QueryCondition();
    	queryCondition.setPageIndex(pageIndex);
    	queryCondition.setPageSize(10);
    	queryCondition.setQueryParameter(queryParameter);
    	queryCondition.setSortParameter(new SortParameter().add("updateDate", SqlOrder.DESC));
    	PagedList<OpenAccount> openAccounts = openAccountService.searchByPage(queryCondition);
    	
		mav.addObject("openAccounts", openAccounts);
		return mav;
    }
    
}
