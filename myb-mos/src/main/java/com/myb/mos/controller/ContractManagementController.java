package com.myb.mos.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.ContractService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.ShopService;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.Shop;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.mos.VO.ContractVO;
import com.myb.mos.utils.AliyunOSSUtil;

/**
 * 合同管理
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/contract")
public class ContractManagementController {
	
    //合同管理
    @Autowired
    private ContractService contractService;
    
    @Autowired
    private OpenAccountService openAccountService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ShopService shopService;
    
    private String filePath;

    /**
     * 分页合同数据
     * @param request
     * @param response
     * @param session
     * @param pageIndex
     * @return
     */
    @RequestMapping("index")
    public ModelAndView getAccount(HttpServletRequest request, HttpServletResponse response,HttpSession session, @RequestParam(value="pageIndex",defaultValue="1") int pageIndex) {
    	
    	String accountId = request.getParameter("accountId");
    	ModelAndView mav = new ModelAndView();
    	Employee employee = (Employee)session.getAttribute("loginUser");
    	mav.addObject("employee", employee);
		
    	if (pageIndex <= 0) {
			pageIndex = 1;
		}
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(10);
		SortParameter sortParameter = new SortParameter();
		sortParameter.add("updateDate", SqlOrder.DESC);
		
		queryCondition.setSortParameter(sortParameter);
		queryCondition.setQueryParameter(new QueryParameter().eq("accountId", Integer.parseInt(accountId)));
		PagedList<Contract> pagedList = contractService.searchByPage(queryCondition);
		mav.addObject("Contract", pagedList);
		mav.setViewName("contract/contract");
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		mav.addObject("type", "1");
    	return mav;
    			
    }
    
    /**
     * 异步搜索合同详情
     * @param request
     * @param response
     * @param contractId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="searchByContractId" , method=RequestMethod.POST)
    public String searchByContractId(HttpServletRequest request, HttpServletResponse response,  String contractCode) {
    	
//    	Contract contract = contractService.searchByContractCode(contractCode);
//    	if (contract != null) {
//    		JSONObject jsonObject = new JSONObject();
//    		return jsonObject.toJSONString(contract);
//    	} else {
//    		return "-1";
//    	}
    	return "";
    }
    
    /**
     * 同步展示合同详情
     * @param request
     * @param response
     * @param contractId
     * @return
     */
    @RequestMapping(value="contractInfo" , method={RequestMethod.POST,RequestMethod.GET})
    public ModelAndView contractInfo(HttpServletRequest request, HttpServletResponse response,  String contractCode) {
    	String contractId = request.getParameter("contractId");
    	String accountId = request.getParameter("accountId");
    	List<Contract> contracts = new ArrayList<Contract>();
    	if (StringUtils.isNotBlank(contractId)) {
    		Contract contract = contractService.searchByContractId(Integer.parseInt(contractId));
    		contracts.add(contract);
    	} else {
    		
    		QueryParameter queryParameter = new QueryParameter();
    		queryParameter.eq("accountId", accountId);
    		QueryCondition queryCondition = new QueryCondition();
    		queryCondition.setSortParameter(new SortParameter().add("updateDate", SqlOrder.DESC));
    		queryCondition.setPageIndex(1);
    		queryCondition.setPageSize(1);
    		queryCondition.setQueryParameter(queryParameter);
    		PagedList<Contract> pagedList = contractService.searchByPage(queryCondition);
    		List<Contract> contracts1 = pagedList.getContent();
    		contracts = contracts1;
    	}
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("contract/contractInfo");
    	
    	if (contracts != null && contracts.size() > 0) {
    		Employee employee = (Employee)request.getSession().getAttribute("loginUser");
    		QueryParameter queryParameter1 = new QueryParameter();
    		queryParameter1.eq("userName", contracts.get(0).getOwnerName());
    		List<Employee> employeesList = employeeService.searchList(queryParameter1);
    		if (employeesList != null && employeesList.size() > 0) {
    			contracts.get(0).setOwnerName(employeesList.get(0).getEmpName()+"("+contracts.get(0).getOwnerName()+")");
    			contracts.get(0).setAccountId(contracts.get(0).getAccountId());
    			//存储创建合同人的名称
    			QueryParameter queryParameter2 = new QueryParameter();
    			queryParameter2.eq("empId", contracts.get(0).getCreater());
    			List<Employee> employeesList2= employeeService.searchList(queryParameter2);
    			if (employeesList2 != null && employeesList2.size() > 0) {
    				contracts.get(0).setCreater(employeesList2.get(0).getEmpName());
    			}
    		}
    		mav.addObject("contract", contracts.get(0));
    		mav.addObject("employee", employee);
    	} else {

    	}
    	
    	String finance = request.getParameter("finance");
    	if (finance != null && finance.equals("1")) {
    		mav.addObject("finance", finance);
    	}
    	mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    	//创建的合同是否通过财务审批
    	
    	QueryParameter queryParameter3 = new QueryParameter();
    	if (contracts != null && contracts.size() > 0) {
    		queryParameter3.eq("accountId", contracts.get(0).getAccountId());
    	}
    	List<OpenAccount> openAccountsList = openAccountService.searchList(queryParameter3);
    	if (openAccountsList != null && openAccountsList.size() > 0) {
    		//通过
    		if(openAccountsList.get(0).getApprovalStatus() == 2 && openAccountsList.get(0).getIsOpenStatus() == 1) {
    			mav.addObject("ispass", "1");
    		} else {
    			mav.addObject("ispass", "0");
    		}
    	}
    	
    	mav.addObject("httpUrl", AliyunOSSUtil.httpUrl);
    	return mav;
    }
    
    /**
     * 新增合同
     * @param request
     * @param response
     * @param contractCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value="saveContract" , method={RequestMethod.POST,RequestMethod.GET})
    public String saveContract(@ModelAttribute("contract") ContractVO contractVO, HttpServletRequest request, HttpServletResponse response) {
    	int channel = 0;
    	String isqudao = request.getParameter("isqudao");
    	if (StringUtils.isNotBlank(isqudao) && isqudao.equals("isqudao")) {//渠道添加合同
    		channel = 89;
    	}
    	int accountId = contractVO.getAccountId();
    	QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("accountId", accountId);
		List<Shop> shopsList = shopService.searchList(queryParameter);
		OpenAccount openAccount1 = openAccountService.searchByAccountId(accountId);
		//判断店数是否等于账号的填入店数
		if (shopsList != null && shopsList.size() > 0) {
			if (shopsList.size() != openAccount1.getShopCount()) {
				return "5";
			}
		} else {
			return "5";
		}
    	String sell = request.getParameter("sell");
    	contractVO.setOwnerName(sell);
    	Employee employee =  (Employee)request.getSession().getAttribute("loginUser"); 
    	Contract contract = new Contract();
    	if (contractVO != null) {
    		BeanUtils.copyProperties(contractVO, contract);
    	}
    	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date date = new Date();
    	   try {
    		contract.setCreateTime(date);
    		contract.setUpdateDate(format1.parse(format1.format(new Date())));
    	    date = format.parse(contractVO.getBeginDate());
    	    contract.setBeginDate(date);
    	    //时间暂未处理**因为表单没有框*********
    	    contract.setPayDate(date);
    	    contract.setEndDate(date);
    	   } catch (ParseException e) {
    	    e.printStackTrace();
    	   }
    	   //退回更新账号的状态变为为审核
    	   String tuihui = request.getParameter("th");
     	  if (StringUtils.isNotBlank(tuihui) && tuihui.equals("1")) {
     		 contractVO.getAccountId();
     		OpenAccount openAccount = openAccountService.searchByAccountId(contractVO.getAccountId());
     		if (openAccount != null) {
     			openAccount.setApprovalStatus(4);
     			try {
					openAccount.setUpdateDate(format1.parse(format1.format(new Date())));
				} catch (ParseException e) {
					e.printStackTrace();
				}
     			openAccountService.update(openAccount);
     		}
     	  }
     	 contract.setContractAnnex(filePath);
    	   //更新操作
    	   if(contract != null && contract.getContractId() != 0) {
    		   contract.setUpdateDate(new Date());
    		   contract.setCreater(String.valueOf(employee.getEmpId()));
    		 int updateContract = contractService.update(contract);
    		 if (updateContract == 1) {
    			 if (channel == 89){
    				 return "189";
    			 }
    			 return "1";
    		 } else {
    			 return "0";
    		 }
    	   }
    	 
    	  //插入操作 
	    contract.setCreater(String.valueOf(employee.getEmpId()));
    	int ins = contractService.insert(contract);
    	String type = request.getParameter("type");
    	//成功
    	if (ins == 1 && !type.equals("delay")) {
    		OpenAccount openAccount = openAccountService.searchByAccountId(contract.getAccountId());
    		//已添加合同的账号
    		openAccount.setIsAddAccount(1);
    		try {
				openAccount.setUpdateDate(format1.parse(format1.format(new Date())) );
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		int updateOpenAccount = openAccountService.update(openAccount);
    		if (updateOpenAccount != 1) {
    			return "0";
    		}
    		if (channel == 89){
				 return "189";
			 }
    		return "1";
    	//续签的操作
    	} else if(ins == 1 && type.equals("delay")) {
    		String shopId = request.getParameter("shopId");//添加完合同才显示到财务
    		if (StringUtils.isNotBlank(shopId)) {
    			Shop shop = shopService.searchByShopId(Integer.parseInt(shopId));
    			shop.setExceptionStatus(2);
    			shopService.update(shop);
    		}
    		if (channel == 89){
				 return "689";
			 }
    		return "6";
    	//失败
    	} else {
    		return "0";
    	}
    }
    
    /**
     * 上传合同文件
     * @param myfile
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/fileUpload",method={RequestMethod.POST,RequestMethod.GET})
    public String fileUpload(@RequestParam("myfile") MultipartFile myfile,HttpServletRequest request, HttpServletResponse response) {

    	if (myfile.getSize() == 0) {
    		return "<span id='siz'>0</span>";
    	}
    	if (myfile.getSize() > 10485760){
    		return "<span id='sizMax'>0</span>";
    	}
    	InputStream inputs = null;
		try {
			inputs = myfile.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Employee employee =  (Employee)request.getSession().getAttribute("loginUser"); 
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy年MM月dd日");
        String str = sdf.format(new Date());
    	String filePath = "contract/"+str+"/"+employee.getEmpName()+employee.getUserName()+"/"+myfile.getOriginalFilename();
    	String 	contractId = request.getParameter("contractId");
    	if (StringUtils.isNotBlank(contractId)) {
    		Contract contract = contractService.searchByContractId(Integer.parseInt(contractId));
    		contract.setContractAnnex(filePath);
    		contractService.update(contract);
    	}
    	String isOk = AliyunOSSUtil.save(filePath,inputs);   
    	this.filePath = filePath;
    	if (!isOk.equals("0")) {
    		return "<span id='www'>success</span><span id='filePath'>"+filePath+"</span>";
    	}else {
    		return "<span id='www'>error</span>";
    	}
    }
    
    @ResponseBody
    @RequestMapping(value="/test",method={RequestMethod.POST,RequestMethod.GET})
    public String test(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String,Object> parameter) {
    	
    	String aaa = (String) parameter.get("aaa");
    	String bbb = (String) parameter.get("bbb");
    	System.out.println(aaa+"bbb"+bbb);
    	
    	List<Employee> employees = new ArrayList<Employee>();
    	for(int i= 0; i < 10; i++) {
    		Employee employee = new Employee();
    		employee.setAccount("12");
    		employee.setCityId(2);
    		employee.setDepName("gaga");
    		employee.setEmpName("你好");
    		employees.add(employee);
    	}
    	
    	JSONObject.toJSONString(employees);
    	return JSONObject.toJSONString("aaa="+aaa+" bbb="+bbb);
    }
    
}
