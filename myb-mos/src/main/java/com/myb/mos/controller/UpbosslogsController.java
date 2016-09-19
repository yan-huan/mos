package com.myb.mos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myb.accounts.service.UpbosslogsService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.Upbosslogs;
import com.myb.framework.data.QueryParameter;

/**
 * 升级老板号
 * @author yanhuan
 *
 */
@Controller
@RequestMapping(value="/upBoss")
public class UpbosslogsController {
	
    @Resource
    private UpbosslogsService upbosslogsService;

    /**
     * 查询升级老板号失败的列表
     * @param request
     * @return
     */
    @RequestMapping("/upbosslogsSearch")
    public ModelAndView upbosslogsSearch(HttpServletRequest request)
    {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("errorHandling/OpenAccountList");
    	QueryParameter queryParameter = new QueryParameter();
    	queryParameter.eq("status", 1);
    	List<Upbosslogs> upbosslogsList = upbosslogsService.searchList(queryParameter);
    	
    	for (int i = 0; i < upbosslogsList.size(); i++) {
    		List<AddressAreaDef>  addressAreaDefs = StartupController.getProvinceAndCity();
    		int cityCode = upbosslogsList.get(i).getCityCode();
    		int provinceCode = upbosslogsList.get(i).getProvinceCode();
    		List<AddressAreaDef> cityList = addressAreaDefs.parallelStream().filter(e->e.getCode().equals(cityCode)).collect(Collectors.toList());
    		List<AddressAreaDef> provinceList = addressAreaDefs.parallelStream().filter(e->e.getCode().equals(provinceCode)).collect(Collectors.toList());
    		if (cityList != null && cityList.size() > 0) {
    			upbosslogsList.get(i).setCityName(cityList.get(0).getObjName());	
    		}
    		if (provinceList != null && provinceList.size() > 0) {
    			upbosslogsList.get(i).setProvinceName(provinceList.get(0).getObjName());	
    		}
    	}
    	mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    	mav.addObject("upbosslogsList", upbosslogsList);
        return mav;
    }

  
}
