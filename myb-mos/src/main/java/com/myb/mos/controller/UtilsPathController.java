package com.myb.mos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.myb.accounts.service.AccountsAccountService;
import com.myb.accounts.service.ContractService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.RoleVO;
/**
 * 公共跳转方法
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/utils")
public class UtilsPathController {
    @Autowired
    private AccountsAccountService accountsAccountService;

    @Autowired
    private OpenAccountService openAccountService;
    
    @Resource
    private ContractService contractService;
    
    @Resource
    private EmployeeService employeeService;
    
    @RequestMapping(value="/{path}",method={RequestMethod.POST,RequestMethod.GET})
    public  ModelAndView login( HttpServletRequest request, HttpServletResponse response, @PathVariable("path") String path) {
    	
    	ModelAndView mav = new ModelAndView();
    	String reqUrl = request.getRequestURI();
    	//可加判断区分路径
    	
    	//注册页面
    	if (path.equals("register")) {
    		mav.setViewName("login/"+path);
    		return mav;
    	}
    	//开通账号 
    	if (path.contains("OpenAccount")) {
    		String isqudao = request.getParameter("isqd");
    		String channelId = request.getParameter("channelId");
    		Employee employee = (Employee)request.getSession().getAttribute("loginUser");
    		mav.setViewName("account/"+path);
    		List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
    		 List<AddressAreaDef>  addressAreaDefParent = addressAreaDefs.parallelStream().filter(e -> e.getParentCode().equals("1")).collect(Collectors.toList());
    		List<RoleVO> roleVOs = (List<RoleVO>)request.getSession().getAttribute("roleVOs");
    		mav.addObject("roleVOs", roleVOs);
    		mav.addObject("addressAreaDefParent", addressAreaDefParent);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao") && StringUtils.isNotBlank(channelId)) {
    			mav.addObject("isqudao", "isqudao");
    			mav.addObject("channelId", channelId);
    		}
    		return mav;
    	}
    	//美容院查询
    	if (path.contains("BeautifulYardSearch")) {
    		mav.setViewName("account/"+path);
    		List<RoleVO> roleVOs = (List<RoleVO>)request.getSession().getAttribute("roleVOs");
    		mav.addObject("roleVOs", roleVOs);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		return mav;
    	}
    	//创建合同
    	if (path.contains("contractSave")) {
    		String edit = request.getParameter("edit");
    		String accountId = request.getParameter("accountId");

    		//可编辑合同
    		if (StringUtils.isNotBlank(edit) && edit.equals("1")) {
    			QueryParameter queryParameter = new QueryParameter();
    			queryParameter.eq("accountId", accountId);
    			List<Contract> contractsList = contractService.searchList(queryParameter);
    			if (contractsList != null &&  contractsList.size() > 0) {
    				
    				Contract contract = contractService.searchByContractId(contractsList.get(0).getContractId());
    				mav.addObject("contract", contract);
    			}
    		}
    		mav.setViewName("contract/"+path);
    		List<RoleVO> roleVOs = (List<RoleVO>)request.getSession().getAttribute("roleVOs");
    		mav.addObject("roleVOs", roleVOs);
    		
    		if (StringUtils.isNotBlank(accountId)) {
    			OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
    			QueryParameter queryParameter = new QueryParameter();
    			queryParameter.eq("userName",openAccount.getMarket());
    			List<Employee> employeesList = employeeService.searchList(queryParameter);
    			if (employeesList != null && employeesList.size() > 0) {
    				openAccount.setMarket(employeesList.get(0).getEmpName()+"("+openAccount.getMarket()+")");
    			}
    			mav.addObject("openAccount", openAccount);
    		}
    		
    		String tuihui = request.getParameter("th");
	      	if (StringUtils.isNotBlank(tuihui) && tuihui.equals("1")) {
	      		 mav.addObject("tuihui", "1");
	      	  }
	      	String type = request.getParameter("type");//续签合同标识
	      	String shopId = request.getParameter("shopId");//续签合同标识
	      	if (type != null && type.equals("delay")) {
	      		mav.addObject("type", "delay");
	      		mav.addObject("shopId", shopId);
	      	}
      	   	 mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
      	   	 String isqudao = request.getParameter("isqudao");
      	   	 if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {
	      		 mav.addObject("isqudao", "isqudao");
	      	  }
      	   	 
    		return mav;
    	}
    	
    	//渠道信息页面
    	if (path.contains("AddChannelInfo")) {
    		mav.setViewName("channelInfo/"+path);
    		List<RoleVO> roleVOs = (List<RoleVO>)request.getSession().getAttribute("roleVOs");
    		mav.addObject("roleVOs", roleVOs);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		return mav;
    	}
    	//关闭账号
    	if (path.contains("CloseAccountList")) {
    		mav.setViewName("account/"+path);
    		return mav;
    	}
    	//修改密码
    	if (path.contains("modifyPwd")) {
    		mav.setViewName("login/"+path);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		return mav;
    	}
    	//懒人
    	if (path.contains("lanren")) {
    		mav.setViewName("../lanren/"+path);
//    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		return mav;
    	}
    	//crm 人员管理
    	if (path.contains("crm_user_infos")) {
    		mav.setViewName("crmRelation/"+path);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		return mav;
    	}
    	//直营账号转给渠道
    	if (path.contains("channelAccountToChannel")) {
    		mav.setViewName("channelInfo/"+path);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		mav.addObject("channelId", request.getParameter("channelId").equals("")?"":request.getParameter("channelId"));//渠道的id;
    		return mav;
    	}
    	if (path.contains("searchAccount")) {
    		mav.setViewName("exceptionCompany/"+path);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		return mav;
    	}
    	
    	if (path.contains("registerFree")) {//免费版注册
    		String mobile = request.getParameter("mobile");
    		mav.setViewName("registerFree/"+path);
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		mav.addObject("mobile", mobile);
    		return mav;
    	}
    	if (path.contains("bmap")) {//调用百度地图
    		mav.setViewName("registerFree/"+path);
    		String address = request.getParameter("address");
    		mav.addObject("address", address);
    		return mav;
    	}
    	return mav;
    	
    }
    
    /**
     * 获取对应省code的city的集合
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
	@RequestMapping(value="/getCityList",method = {RequestMethod.POST , RequestMethod.GET})
	public String openAccount(HttpServletRequest request, HttpServletResponse response) {
	
			String parentCode = request.getParameter("parentCode");
			if (StringUtils.isNotBlank(parentCode)) {
				List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
				List<AddressAreaDef> addressAreaDefsCity = addressAreaDefs.parallelStream().filter(e -> e.getParentCode().equals(parentCode)).collect(Collectors.toList());
				String  jsonArr = JSONArray.toJSONString(addressAreaDefsCity);
				return jsonArr;
			} else {
				return "0";
			}
    	
		}
}
