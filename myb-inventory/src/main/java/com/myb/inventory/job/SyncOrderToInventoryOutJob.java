package com.myb.inventory.job;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myb.commons.utils.CodeUtil;
import com.myb.commons.utils.DateConvert;
import com.myb.entity.pojo.inventory.BillsBill;
import com.myb.entity.pojo.inventory.BillsBillMapping;
import com.myb.entity.pojo.inventory.BillsBillitem;
import com.myb.entity.pojo.inventory.BillsBillitemMapping;
import com.myb.entity.pojo.inventory.CompaniesShop;
import com.myb.entity.pojo.inventory.CompaniesShopMapping;
import com.myb.entity.pojo.inventory.InventoryOut;
import com.myb.entity.pojo.inventory.InventoryOutItem;
import com.myb.entity.pojo.inventory.InventorySku;
import com.myb.framework.data.QueryParameter;
import com.myb.inventory.cons.Cons;
import com.myb.inventory.dao.BillsBillDao;
import com.myb.inventory.dao.BillsBillitemDao;
import com.myb.inventory.dao.CompaniesShopDao;
import com.myb.inventory.dao.InventoryOutDao;
import com.myb.inventory.dao.InventoryOutItemDao;
import com.myb.inventory.dao.InventorySkuDao;

/**
 * 
 * Description : 订单--->出库单 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月21日 下午3:25:50 <br/>
 * @version 1.0
 */

@Component("syncOrderToInventoryOutJob")
@Transactional
public class SyncOrderToInventoryOutJob {
	
	private BillsBillitemDao billsBillitemDao;
	private BillsBillDao billsBillDao;
	private InventorySkuDao inventorySkuDao;
	private InventoryOutDao inventoryOutDao;
	private InventoryOutItemDao inventoryOutItemDao;
	private CompaniesShopDao companiesShopDao;
	
	/** 每天凌晨1点执行 **/
	@SuppressWarnings("resource")
	@Scheduled(cron = "0 0 1 * * ?") 
	public void doSync(){/*
		ApplicationContext cxt = new ClassPathXmlApplicationContext("config/sp/application_inventory.xml");
		billsBillitemDao = (BillsBillitemDao) cxt.getBean("billsBillitemDao");
		billsBillDao = (BillsBillDao) cxt.getBean("billsBillDao");
		inventorySkuDao = (InventorySkuDao) cxt.getBean("inventorySkuDao");
		companiesShopDao = (CompaniesShopDao) cxt.getBean("companiesShopDao");
		inventoryOutItemDao = (InventoryOutItemDao) cxt.getBean("inventoryOutItemDao");
		
		int now = (int)(new Date().getTime()/1000);
		
		//1.查询bills_bill表，查询条件为status='PAYED' and created_at在昨天的
		Date yestorday = DateConvert.getDateToDay(-1, new Date());
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq(BillsBillMapping.Status, Cons.PAYED).and().bw(BillsBillMapping.CreatedAt, yestorday + " 00:00:00", yestorday + " 23:59:59");
		List<BillsBill> billsBills = billsBillDao.searchList(queryParameter);
		
		if(billsBills != null && billsBills.size() > 0) {
			for (BillsBill billsBill : billsBills) {
				//1.查询bills_billitem表，查询条件goods_meta_type='PRODUCT' and billCode = billsBill.getCode
				queryParameter = new QueryParameter();
				queryParameter.eq(BillsBillitemMapping.GoodsMetaType, Cons.PRODUCT).and().eq(BillsBillitemMapping.BillCode, billsBill.getCode());
				List<BillsBillitem> billsBillitems = billsBillitemDao.searchList(queryParameter);
				if(billsBillitems != null && billsBillitems.size() > 0) {
					//说明该账单下有客装产品出售，则生成出库单和出库明细
					//生成出库单
					InventoryOut inventoryOut = new InventoryOut();
					inventoryOut.setOutCode(CodeUtil.genCode(InventoryOut.class.getSimpleName()));
					inventoryOut.setOutType(Cons.XIAOSHOUCHUKU);
					inventoryOut.setProductType(Cons.PRODUCT_CUSTOM);
					inventoryOut.setToCode(billsBill.getCode());
					inventoryOut.setToName("账单");
					
					
					queryParameter = new QueryParameter();
					queryParameter.eq(CompaniesShopMapping.Code, billsBill.getCode());
					List<CompaniesShop> companiesShops = companiesShopDao.searchList(queryParameter);
					CompaniesShop companiesShop = new CompaniesShop();
					if(companiesShops != null && companiesShops.size() > 0) {
						companiesShop = companiesShops.get(0);
					}
					inventoryOut.setParentCode(companiesShop.getCompanyCode());
					inventoryOut.setChildCode(billsBill.getPayeePartyCode());
					inventoryOut.setStatus(Cons.STATUS_NORMAL);
					inventoryOut.setCreateUserCode(Cons.SYSTEM);
					inventoryOut.setCreateUserName(Cons.SYSTEM);
					inventoryOut.setCreateTime(now);
					inventoryOutDao.insert(inventoryOut);
					
					//生成出库明细，不扣减库存
					for (BillsBillitem billsBillitem : billsBillitems) {
						InventoryOutItem inventoryOutItem = new InventoryOutItem();
						inventoryOutItem.setOutItemCode(CodeUtil.genCode(InventoryOutItem.class.getSimpleName()));
						inventoryOutItem.setOutCode(inventoryOut.getOutCode());
						
						//根据商品code查询库存商品code
						InventorySku inventorySku = inventorySkuDao.searchByProductCode(billsBillitem.getGoodsCode(), Cons.STATUS_NORMAL);
						inventoryOutItem.setInventorySkuCode(inventorySku.getInventorySkuCode());
						
						inventoryOutItem.setQuantity(billsBillitem.getQuantity());
						inventoryOutItem.setStatus(Cons.STATUS_NORMAL);
						inventoryOutItem.setCreateUserCode(Cons.SYSTEM);
						inventoryOutItem.setCreateUserName(Cons.SYSTEM);
						inventoryOutItem.setCreateTime(now);
						inventoryOutItemDao.insert(inventoryOutItem);
					}
					
				}
			}
		}*/
	}
}
