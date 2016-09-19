package com.myb.mos.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.ArgsService;
import com.myb.accounts.service.CityService;
import com.myb.accounts.service.CrmUserinfoService;
import com.myb.accounts.service.CrmVisitrecordService;
import com.myb.accounts.service.EmployeeService;
import com.myb.entity.pojo.mos.Args;
import com.myb.entity.pojo.mos.CrmUserinfo;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.CrmUserinfoVO;
import com.myb.mos.VO.ExcelAreaCustomerVO;
import com.myb.mos.utils.BaseProUtill;
import com.myb.mos.utils.HttpClientUtil;
import com.myb.mos.utils.ListSort;

/**
 *
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/crm")
public class CrmController {
	
	@Autowired
	private ArgsService argserService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CrmUserinfoService crmUserinfoService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CrmVisitrecordService crmVisitrecordService;
	
    /**
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/consumer")
    public String consumer(){
    	
    	Map<String, String> map = new HashMap<String, String>();
    	String resultData = null;
		try {
			resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpCrmUrl+"/afterSale/getSaledShops", map, "utf-8", "utf-8");
			JSONObject data = (JSONObject) JSONObject.parse(resultData);
			if (data != null && data.get("status").equals("SUCCESS")) {
				JSONObject data1 = (JSONObject) JSONObject.parse(data.get("data").toString());
				List<OpenAccount>  openAccounts = JSONArray.parseArray(data1.get("content").toString(), OpenAccount.class);
				
				return com.alibaba.fastjson.JSONArray.toJSONString(openAccounts);
			} else {
				return "0";
			}
		} catch (Exception e1) {
			
			e1.printStackTrace();
			return "0";
		}
    	
    }
    
    /**
     * 客户
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/openConsumer")
    public String openConsumer(){
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("consumerId", "44212");
    	String resultData = null;
		try {
			resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpCrmUrl+"/afterSale/passCheck", map, "utf-8", "utf-8");
			JSONObject data = (JSONObject) JSONObject.parse(resultData);
			if (data.get("status").equals("SUCCESS")) {
				JSONObject data1 = (JSONObject) JSONObject.parse(data.get("data").toString());
				List<OpenAccount>  openAccounts = JSONArray.parseArray(data1.get("content").toString(), OpenAccount.class);
				
				return com.alibaba.fastjson.JSONArray.toJSONString(openAccounts);
			} else {
				return "0";
			}
		} catch (Exception e1) {
			
			e1.printStackTrace();
			return "0";
		}
    }
    
    
    /**
     * 客户管理列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/showListCustomer")
    public ModelAndView showListCustomer(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
    	ModelAndView mav = new ModelAndView("/customerVisit/CustomerVisitList");

    	Map<String, String> map = new HashMap<String, String>();
    	String area = "1";
    	if (pageIndex <= 0) {
    		pageIndex = 1;
    	}
    	String resultData = null;
    	PagedList pagedList = new PagedList();
		try {
			resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpCrmUrl+"/file/getCustomerPool?area="+area+"&pageIndex="+pageIndex, map, "utf-8", "utf-8");
			JSONObject data = (JSONObject) JSONObject.parse(resultData);
			if (data.get("status").equals("SUCCESS")) {
				JSONObject data1 = (JSONObject) JSONObject.parse(data.get("data").toString());
				int recordCount = Integer.parseInt(data1.get("recordCount").toString());
				int totalPage = Integer.parseInt(data1.get("totalPage").toString());
				
				List<ExcelAreaCustomerVO>  excelAreaCustomerVO = JSONArray.parseArray(data1.get("content").toString(), ExcelAreaCustomerVO.class);
				pagedList.setContent(excelAreaCustomerVO);
				pagedList.setPageIndex(pageIndex);
				pagedList.setPageSize(10);
				pagedList.setRecordCount(recordCount);
				pagedList.setTotalPage(totalPage);
				mav.addObject("openAccountPageList", pagedList);
				mav.addObject("area", area);
				Employee employee = (Employee)request.getSession().getAttribute("loginUser");
				if (employee != null) {
					mav.addObject("employee", employee);
				}
				
			} 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	return mav;
    }
    
    
    /**
     * 创建userInfo表信息前提是empyoo表已经注册过的员工
     * 展示信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/manageUserInfo")
    public String manageUserInfo(HttpServletRequest request , HttpServletResponse response){
    	List<Args> argsList = argserService.searchList(new QueryParameter().eq("argType", "gangwei").or().eq("argType", "xz").or().eq("argType", "bumen").or().eq("argType", "daqu"));
    	List<Args> listByGW = argsList.parallelStream().filter(e->e.getArgType().equals("gangwei")).collect(Collectors.toList());//岗位
    	List<Args> listByXZ = argsList.parallelStream().filter(e->e.getArgType().equals("xz")).collect(Collectors.toList());//小组
    	List<Args> listByBM = argsList.parallelStream().filter(e->e.getArgType().equals("bumen")).collect(Collectors.toList());//部门
    	List<Args> listByQY = argsList.parallelStream().filter(e->e.getArgType().equals("daqu")).collect(Collectors.toList());//部门
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("gangwei", listByGW);
//    	listByXZ.sort((Args h1, Args h2) -> h1.getArgValue().compareTo(h2.getArgValue()));
    	String visitRecode = request.getParameter("visitRecode");
    	if (StringUtils.isNotBlank(visitRecode) && visitRecode.equals("1")) {
    		Employee employee = (Employee)request.getSession().getAttribute("loginUser");
    		if (employee != null) {
    			List<CrmUserinfo> crmUserinfos = crmUserinfoService.searchList(new QueryParameter().eq("empId",employee.getEmpId() ));
    			if (crmUserinfos != null && crmUserinfos.size() > 0) {
    				if (crmUserinfos.get(0).getGangwei().equals("大区经理")) {
    					List<Args> args = listByXZ.parallelStream().filter(e->e.getArgName().contains(crmUserinfos.get(0).getXiaozu())).collect(Collectors.toList());
    					listByXZ = args;
    				} else if (crmUserinfos.get(0).getGangwei().equals("BD")) {
    					List<Args> args = listByXZ.parallelStream().filter(e->e.getArgName().equals(crmUserinfos.get(0).getXiaozu())).collect(Collectors.toList());
    					listByXZ.clear();
    					listByXZ.add(args.get(0));
    				}
    			}
    			jsonObject.put("xz", listByXZ);
    		}
    	} else {
    		jsonObject.put("xz", listByXZ);
    	}
    	
    	
    	jsonObject.put("bumen", listByBM);
    	jsonObject.put("quyu", listByQY);
    	
		return jsonObject.toJSONString();
    }
    
    /**
     * 保存信息
     * @param request
     * @param response
     * @param crmUserinfoVO
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/saveManageUserInfo",method = {RequestMethod.POST,RequestMethod.GET})
    public String saveManageUserInfo(HttpServletRequest request , HttpServletResponse response,CrmUserinfoVO crmUserinfoVO ){
    	System.out.println(crmUserinfoVO);
    	
    	CrmUserinfo crmUserinfo = new CrmUserinfo();
    	BeanUtils.copyProperties(crmUserinfoVO, crmUserinfo);
    	String xsry = request.getParameter("xsry");
    	String name = xsry.split("[(]")[0];
    	String a1 = xsry.split("[(]")[1];
    	String a2 = a1.split("[)]")[0];
    	Employee employee = employeeService.searchByUserName(a2);
    	crmUserinfo.setEmpId(employee.getEmpId());
    	crmUserinfo.setMobile(a2);
    	crmUserinfo.setXingming(name);
    	List<CrmUserinfo> crmUserinfosByMobile = crmUserinfoService.searchList(new QueryParameter().eq("mobile", a2));
    	if (crmUserinfosByMobile != null && crmUserinfosByMobile.size() > 0) {
    		return "2";                                                                                                                                                                      
    	}
    	int saveUserInfo = crmUserinfoService.insert(crmUserinfo);
    	if (saveUserInfo == 1) {
    		return "1";
    	} else {
    		return "0";
    	}
    }
    
    
    @RequestMapping(value="/crmVisitRecode",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView crmVisitRecode(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
//    	 WHERE a.createTime BETWEEN '2016-09-02' AND '2016-09-03' and a.isValide=0
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	String xiaozu = request.getParameter("xiaozu");
    	if (StringUtils.isNotBlank(startDate)) {
    		
    	}
    	ModelAndView mav = new ModelAndView("/customerVisit/CustomerVisitList");
    	QueryParameter queryParameter = new QueryParameter();
    	if (StringUtils.isBlank(startDate) && StringUtils.isBlank(endDate) || StringUtils.isNotBlank(startDate) && StringUtils.isBlank(endDate)) {
    		  Calendar   cal_1=Calendar.getInstance();//获取当前日期 
    		  Calendar   cal_2=Calendar.getInstance();//获取当前日期 
    	        cal_1.add(Calendar.MONTH, 0);
    	        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
    	        cal_1.set(Calendar.HOUR_OF_DAY, 00);
    	        cal_1.set(Calendar.MINUTE, 00);
    	        cal_1.set(Calendar.SECOND, 0);
    	        cal_2.set(Calendar.HOUR_OF_DAY, 23);
    	        cal_2.set(Calendar.MINUTE, 59);
    	        cal_2.set(Calendar.SECOND, 59);
    	        startDate =  format.format(cal_1.getTime());
    	        endDate =  format.format(cal_2.getTime());
    	        queryParameter.bw("createTime", startDate, endDate);
    	} else {
    		
    		queryParameter.bw("createTime", startDate+" 00:00:00", endDate+" 23:59:59");
    	}
    	if (StringUtils.isNotBlank(xiaozu) && !xiaozu.equals("全部")) {
    		queryParameter.and();
    		queryParameter.eq("xiaozu", xiaozu);
    	}
    	Employee employee = (Employee)request.getSession().getAttribute("loginUser");
    	
    	List<CrmUserinfo> visitrecords = crmVisitrecordService.searchListByCondition(queryParameter, "crm_visitrecord", CrmUserinfo.class,employee.getEmpId());
    	Set<Integer> setByShopId = new HashSet<Integer>();
    	visitrecords.parallelStream().forEach(e->setByShopId.add(e.getShopId()));
    	
    	//判断当前登录人是否在userInfo里并判断他的角色
    	List<CrmUserinfo> crmUserinfosByEmpId =	crmUserinfoService.searchList(new QueryParameter().eq("empId", employee.getEmpId()));
//    	List<CrmUserinfo> crmUserinfosByMobile = visitrecords.parallelStream().filter(e->e.getMobile().equals(employee.getUserName())).collect(Collectors.toList());
    	if (crmUserinfosByEmpId != null && crmUserinfosByEmpId.size() > 0) {
    		if (crmUserinfosByEmpId.get(0).getXiaozu().contains("北京")||
    				crmUserinfosByEmpId.get(0).getXiaozu().contains("上海")||
    				crmUserinfosByEmpId.get(0).getXiaozu().contains("广州")||
    				crmUserinfosByEmpId.get(0).getXiaozu().contains("深圳")||
    				crmUserinfosByEmpId.get(0).getXiaozu().contains("杭州")||
    				crmUserinfosByEmpId.get(0).getXiaozu().contains("西安")||
    				crmUserinfosByEmpId.get(0).getXiaozu().contains("KA")
    				) {
    			
    		} else {
    			visitrecords.clear();
    		}
    	} else {
    		visitrecords.clear();
    	}
    	List<CrmUserinfo> crmUserinfos = crmUserinfoService.searchList(new QueryParameter().eq("mobile", employee.getUserName()));
//    	CrmUserinfo CrmUserinfo = new CrmUserinfo();
//    	CrmUserinfo.setGangwei("大区经理");
//    	CrmUserinfo.setQuyu("1");
//    	CrmUserinfo.setMobile("15244355253");
//    	crmUserinfos.add(CrmUserinfo);
    	if (crmUserinfos != null && crmUserinfos.size() > 0 && crmUserinfos.get(0).getGangwei().equals("大区经理")) {
    		if (crmUserinfos.get(0).getQuyu().equals("1")) {//北京
    			visitrecords = visitrecords.parallelStream().filter(e->e.getQuyu().equals("1")).collect(Collectors.toList()); 
    			mav.addObject("belongTeam", "belongTeamBossBj");
    		}
    	} else if (crmUserinfos != null && crmUserinfos.size() > 0 && crmUserinfos.get(0).getGangwei().equals("BD")) {
    		if (crmUserinfos.get(0).getQuyu().equals("1")) {//北京
    			visitrecords = visitrecords.parallelStream().filter(e->e.getEmpId()==289).collect(Collectors.toList()); 
    			mav.addObject("belongTeam", "belongTeamBj");
    		}
    	}
    	
    	Map<String, Integer> mapAllCount = new HashMap<String, Integer>();
    	Map<String, Integer> mapValideCount = new HashMap<String, Integer>();
    	 
    	 for (int f = 0; f < visitrecords.size(); f++) {
    		 if(mapAllCount.containsKey(visitrecords.get(f).getXingming())){//判断是否已经有该数值，如有，则将次数加1
    			 mapAllCount.put(visitrecords.get(f).getXingming(), mapAllCount.get(visitrecords.get(f).getXingming()).intValue() + 1);
             }else{
            	 mapAllCount.put(visitrecords.get(f).getXingming(), 1);
             }
    		 if (!mapValideCount.containsKey(visitrecords.get(f).getXingming())) {
    			 mapValideCount.put(visitrecords.get(f).getXingming(), 0);
    		 }
    		 if(mapValideCount.containsKey(visitrecords.get(f).getXingming()) && visitrecords.get(f).getIsValide() == 0){//判断是否已经有该数值，如有，则将次数加1
    			 mapValideCount.put(visitrecords.get(f).getXingming(), mapValideCount.get(visitrecords.get(f).getXingming()).intValue() + 1);
    		 }
    		 
    		 for (Integer str : setByShopId) { 
    			 if (str == visitrecords.get(f).getShopId()) {
    				 int shopCount = visitrecords.parallelStream().filter(e->e.getShopId()==str).collect(Collectors.toList()).size();
    				 int shopValideCount = visitrecords.parallelStream().filter(e->e.getIsValide()==0 && e.getShopId()==str).collect(Collectors.toList()).size();
    				 visitrecords.get(f).setShopAllCount(shopCount);
    				 visitrecords.get(f).setShopValideCount(shopValideCount);
    			 } 
    		}  
 		}
    	 
    	 for (Entry<String, Integer> entry : mapAllCount.entrySet()) {
    		 for (int i = 0; i < visitrecords.size(); i++) {
    			 if (entry.getKey().equals(visitrecords.get(i).getXingming())) {
    				 visitrecords.get(i).setAllCount(entry.getValue());
    			 }
    		 }
    	 }
    	 
    	 for (Entry<String, Integer> entry : mapValideCount.entrySet()) {//有效次数
    		 for (int i = 0; i < visitrecords.size(); i++) {
    			 if (entry.getKey().equals(visitrecords.get(i).getXingming())) {
    				 visitrecords.get(i).setIsValideCount(entry.getValue());
    			 }
    		 }
    	 }

    	 for  ( int  i  =   0 ; i  <  visitrecords.size()  -   1 ; i ++ )   { 
    		    for  ( int  j  =  visitrecords.size()  -   1 ; j  >  i; j -- )   { 
    		      if  (visitrecords.get(j).getXingming().equals(visitrecords.get(i).getXingming()))   { 
    		    	  visitrecords.remove(j); 
    		      } 
    		    } 
    		  } 
    	 
    	 ListSort<CrmUserinfo> listSort= new ListSort<CrmUserinfo>(); 
 		listSort.Sort(visitrecords, "getIsValideCount", "desc");
    	mav.addObject("visitrecords", visitrecords);
    	mav.addObject("startDate", startDate);
    	mav.addObject("endDate", endDate);
    	mav.addObject("employee", employee);
    	return mav;
    }
    
}
