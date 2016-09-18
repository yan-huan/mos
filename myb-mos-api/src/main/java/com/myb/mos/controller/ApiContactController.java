package com.myb.mos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myb.entity.pojo.mos.FreshShop;
import com.myb.entity.pojo.mos.ShopContact;
import com.myb.entity.pojo.mos.ShopContactMapping;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.web.models.JsonModel;
import com.myb.framework.web.models.JsonModel.JsonModelStatus;
import com.myb.mos.VO.MyShop;
import com.myb.mos.VO.ShopList;
import com.myb.mos.component.PageListCom;
import com.myb.mos.service.ShopContactService;
import com.myb.mos.service.ShopProcessService;
import com.myb.mos.service.ShopService;

@Controller
@RequestMapping("/contact")
public class ApiContactController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopContactService shopContactService;
	@Autowired
	private ShopProcessService shopProcessService;
	@Autowired
	private PageListCom pageListCOM;
	/**
	 * shopId
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/contactList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public JsonModel contactList(@RequestParam Map<String,Object> data) {
		JsonModel jsonModel=new JsonModel();
		 Long shopId = Long.parseLong(data.get("shopId")+"");
		 
		 PagedList<ShopContact> pageList = pageListCOM.contactPageList(shopId);
		 
		 //装配返回的data数据
		 ShopList contactList = new ShopList();
		 contactList.setRecordCount(pageList.getRecordCount());
		 contactList.setTotalPage(pageList.getTotalPage());
		 List<ShopContact> contacts = pageList.getContent();
		 contactList.setContent(contacts);
		 
		 jsonModel.setCode("100000");
		 jsonModel.setStatus(JsonModelStatus.SUCCESS);
		 jsonModel.setData(contactList);
		return jsonModel;
	}

	
}
