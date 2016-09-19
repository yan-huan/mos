package com.myb.mos.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myb.accounts.service.EmpRoleService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.RoleChildService;
import com.myb.accounts.service.RoleService;
import com.myb.accounts.service.ShopService;
import com.myb.entity.pojo.mos.EmpRole;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.Role;
import com.myb.entity.pojo.mos.RoleChild;
import com.myb.entity.pojo.mos.Shop;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.RoleVO;
/**
 *加载用户权限
 */
@Controller
@RequestMapping("/project")
public class IndexController {

	@Autowired
    private RoleChildService childService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private EmpRoleService empRoleService;
	
    @Autowired
    private OpenAccountService accountService;
    
    @Autowired
    private ShopService shopService;
    
    
    @RequestMapping("/index")
    public  ModelAndView login( HttpServletRequest request, HttpServletResponse response) {
    	
    		ModelAndView mav = new ModelAndView();
    		mav.setViewName("menu/headerNext");
    		Employee employee = (Employee)request.getSession().getAttribute("loginUser");
    		List<RoleVO> roleVOs1 = (List<RoleVO>)request.getSession().getAttribute("roleVOs");
    		List<RoleVO> roleVOs = new ArrayList<>();
    		if (roleVOs1 == null) {
    			if (employee != null) {
        	    	
            		QueryParameter queryParameter = new QueryParameter();
            		queryParameter.eq("empId", employee.getEmpId());
            		List<EmpRole>  empRolesList = empRoleService.searchList(queryParameter);
            	    
            		for(EmpRole er : empRolesList) {
            			Role role = roleService.searchByRoleId(er.getRoleId());	
            			RoleVO roleVO = new RoleVO();
            			if (role != null) {
            				BeanUtils.copyProperties(role, roleVO);
            				roleVOs.add(roleVO);
            			}
            		}
            		String currentVar="";
            		//遍历VO父角色
            		for (RoleVO rv : roleVOs) {
            			//子标签
            			QueryParameter queryParameter1 = new QueryParameter();
            			queryParameter1.eq("roleId",rv.getRoleId());
            			List<RoleChild> roleChildList =	childService.searchList(queryParameter1);
            			List<RoleChild> roleChilds = roleChildList.parallelStream().filter(e->e.getChildId()==3).collect(Collectors.toList());
            			if (roleChilds != null && roleChilds .size()>0) {
            				currentVar="1";
            			}
            			rv.setRoleChild(roleChildList);
            			
            		}
            		if (currentVar.equals("1")) {
            			QueryParameter parameter = new QueryParameter();
            			List<OpenAccount>  openAccounts = accountService.searchList(parameter);
            			List<OpenAccount>  openAccounts2 = openAccounts.parallelStream().
            					filter(e->e.getApprovalStatus()==1 || e.getApprovalStatus()==4).
            					filter(e->e.getIsShowQudaoList()==0).
            					filter(e->e.getStatus()==1).
            					filter(e->e.getIsAddAccount()==1).
            					collect(Collectors.toList());
            			List<OpenAccount>  openAccounts3 = openAccounts.parallelStream().
            					filter(e->e.getApprovalStatus()==1 || e.getApprovalStatus()==4).
            					filter(e->e.getIsShowQudaoList()==1).
            					filter(e->e.getStatus()==1).
            					collect(Collectors.toList());
            			List<Shop> shopsList = shopService.searchList(new QueryParameter().ne("exceptionStatus", 0).and().eq("ispass", 3));
            			List<OpenAccount>  openAccountsList = accountService.searchList(new QueryParameter().eq("approvalStatus", 2));
            			//异常处理 店的修改和店的延期
            			List<OpenAccount> openAccountsByModify = new ArrayList<OpenAccount>();
            			List<OpenAccount> openAccountsByDelay = new ArrayList<OpenAccount>();
            			for (int i = 0; i < shopsList.size(); i++) {
            				if (shopsList.get(i).getExceptionStatus() == 4) {//修改
            					int accountId = shopsList.get(i).getAccountId();
            					List<OpenAccount> accountsByAccountId = openAccountsList.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());	
            					openAccountsByModify.add(accountsByAccountId.get(0));
            				} else if(shopsList.get(i).getExceptionStatus() == 2) {//延期
            					
            					int accountId = shopsList.get(i).getAccountId();
            					List<OpenAccount> accountsByAccountId = openAccountsList.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());	
            					openAccountsByDelay.add(accountsByAccountId.get(0));
            					
            				}
            			}
            			openAccountsByModify = new ArrayList<OpenAccount>(new HashSet<OpenAccount>(openAccountsByModify));
            			openAccountsByDelay = new ArrayList<OpenAccount>(new HashSet<OpenAccount>(openAccountsByDelay));
                		roleVOs.get(0).setZhiyingCount(openAccounts2.size());
                		roleVOs.get(0).setQudaoCount(openAccounts3.size());
                		roleVOs.get(0).setExceptionModify(openAccountsByModify.size());
                		roleVOs.get(0).setExceptionDelay(openAccountsByDelay.size());
            		}
            		
            		request.getSession().setAttribute("roleVOs",roleVOs);
            		mav.addObject("roleVOs", roleVOs);
        		}
    		} else {
    			mav.addObject("roleVOs", roleVOs1);
    		}
    		
    		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    		return mav;
    }
    
    
    
}
