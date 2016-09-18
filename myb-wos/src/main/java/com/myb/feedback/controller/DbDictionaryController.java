package com.myb.feedback.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.myb.feedback.service.DbDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.util.RequestUtil;

/**
 * 
 * Description : 数据字典处理类 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月3日 上午9:49:51 <br/>
 * @version 1.0
 */
@Controller
@RequestMapping("/manage/control/dictionary")
public class DbDictionaryController {
    @Autowired
    private DbDataDictionaryService dbDataDictionaryService;


    /**
     * 查询列表
     * @author hailin.liu 2016年4月27日 上午10:31:20 <br/>
     * @param request
     * @param model
     * @return
     */
	@RequestMapping("/list.jhtml")
    public String searchResult(HttpServletRequest request, Model model, @RequestParam(required = false)Integer tp)
    {
        QueryCondition queryCondition=new QueryCondition();
        queryCondition.setPageSize(Cons.PAGE_SIZE);
        queryCondition.setPageIndex(RequestUtil.getIntParameter(request,"page",1));
        
        if(tp != null) {
        	QueryParameter queryParameter = new QueryParameter();
            queryParameter.eq("type", tp);
            queryCondition.setQueryParameter(queryParameter);
            model.addAttribute("tp", tp);
        }
        
        SortParameter sortParameter = new SortParameter();
        sortParameter.add("id", SqlOrder.DESC);
        queryCondition.setSortParameter(sortParameter);
        
        PagedList<DbDataDictionary> pagedList=dbDataDictionaryService.searchByPage(queryCondition);
        model.addAttribute("pagedList", pagedList);
        
        	
			try {
				String firstPage = RequestUtil.getUrl(request, "page", "1");
				String prePage = RequestUtil.getUrl(request, "page", String.valueOf(RequestUtil.getIntParameter(request,"page",1) -1));
				String nextPage = RequestUtil.getUrl(request, "page", String.valueOf(RequestUtil.getIntParameter(request,"page",1) +1));
				String lastPage = RequestUtil.getUrl(request, "page", String.valueOf(pagedList.getTotalPage()));
				model.addAttribute("firstPage", firstPage);
				model.addAttribute("prePage", prePage);
				model.addAttribute("nextPage", nextPage);
				model.addAttribute("lastPage", lastPage);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
        return Cons.CONTROL + "/dictionary/list";
    }
    
    /**
     * 进入添加界面
     * @author hailin.liu 2016年4月27日 上午10:42:33 <br/>
     * @return
     */
    @RequestMapping("/addUI.jhtml")
    public String addUI(@RequestParam(required = false)Integer tp, Model model) {
    	model.addAttribute("tp", tp);
    	return Cons.CONTROL + "/dictionary/addUI";
    }
    
    /**
     * 新增
     * @author hailin.liu 2016年4月27日 上午11:19:48 <br/>
     * @param dbProblemType
     * @return
     */
    @RequestMapping("/add.jhtml")
    public String add(DbDataDictionary dbDataDictionary, @RequestParam(required = false)Integer tp, RedirectAttributes model) {
    	Timestamp ts = new Timestamp(new Date().getTime());
    	dbDataDictionary.setAddTime(ts);
    	dbDataDictionary.setModifyTime(ts);
    	dbDataDictionaryService.insert(dbDataDictionary);
    	model.addAttribute("tp", tp);
    	return "redirect:/manage/control/dictionary/list.jhtml";
    }
    
    /**
     * 进入编辑界面
     * @author hailin.liu 2016年4月27日 上午11:21:41 <br/>
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editUI.jhtml")
    public String editUI(Integer id, Model model, @RequestParam(required = false)Integer tp) {
    	DbDataDictionary dbDataDictionary = dbDataDictionaryService.searchById(id);
    	model.addAttribute("entity", dbDataDictionary);
    	model.addAttribute("tp", tp);
    	return Cons.CONTROL + "/dictionary/editUI";
    }

    /**
     * 更新
     * @author hailin.liu 2016年4月27日 上午11:24:14 <br/>
     * @param dbProblemType
     * @return
     */
    @RequestMapping("/edit.jhtml")
    public String edit(DbDataDictionary dbDataDictionary, @RequestParam(required = false)Integer tp, RedirectAttributes model) {
    	DbDataDictionary dd = dbDataDictionaryService.searchById(dbDataDictionary.getId());
    	Timestamp ts = new Timestamp(new Date().getTime());
    	dbDataDictionary.setAddTime(dd.getAddTime());
    	dbDataDictionary.setModifyTime(ts);
    	dbDataDictionaryService.update(dbDataDictionary);
    	model.addAttribute("tp", tp);
    	return "redirect:/manage/control/dictionary/list.jhtml";
    }
    
    /**
     * 删除
     * @author hailin.liu 2016年4月27日 上午11:25:13 <br/>
     * @param id
     * @return
     */
    @RequestMapping("/delete.jhtml")
    public String delete(Integer id, @RequestParam(required = false)Integer tp, RedirectAttributes model) {
    	dbDataDictionaryService.delete(id);
    	model.addAttribute("tp", tp);
    	return "redirect:/manage/control/dictionary/list.jhtml";
    }
    
    /**
     * 批量删除
     * @author hailin.liu 2016年4月27日 上午11:28:58 <br/>
     * @param ids
     * @return
     */
    @RequestMapping("/batchDelete.jhtml")
    public String batchDelete(Integer[] ids, @RequestParam(required = false)Integer tp, RedirectAttributes model) {
    	if(ids != null && ids.length > 0) {
    		for (Integer id : ids) {
    			dbDataDictionaryService.delete(id);
			}
    	}
    	model.addAttribute("tp", tp);
    	return "redirect:/manage/control/dictionary/list.jhtml";
    }
}
