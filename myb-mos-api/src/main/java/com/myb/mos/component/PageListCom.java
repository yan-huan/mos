package com.myb.mos.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myb.entity.pojo.mos.FreshShop;
import com.myb.entity.pojo.mos.FreshShopMapping;
import com.myb.entity.pojo.mos.ShopContact;
import com.myb.entity.pojo.mos.ShopContactMapping;
import com.myb.entity.pojo.mos.ShopProcess;
import com.myb.entity.pojo.mos.ShopProcessMapping;
import com.myb.entity.pojo.mos.VisitRecord;
import com.myb.entity.pojo.mos.VisitRecordMapping;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.mos.service.ShopContactService;
import com.myb.mos.service.ShopProcessService;
import com.myb.mos.service.ShopService;
import com.myb.mos.service.VisitRecordService;
import com.myb.mos.utils.DateUtil;

@Component
public class PageListCom {
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopContactService shopContactService;
	@Autowired
	private ShopProcessService shopProcessService;
	@Autowired
	private VisitRecordService visitService;
	/**
	 * 拜访记录PageList
	 * @param shopId
	 * @param employeeId
	 * @param pageIndex
	 * @return
	 */
	public PagedList<VisitRecord> getVisitTimesListInfo(Long shopId, Long employeeId) {
		//设置查询信息
		 QueryCondition query = new QueryCondition();
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(1);
		 query.setPageSize(20);
		 queryParam.eq(VisitRecordMapping.EmployeeId, employeeId);
		 queryParam.and();
		 queryParam.eq(VisitRecordMapping.ShopId, shopId);
		 queryParam.and();
		 queryParam.eq(VisitRecordMapping.Isdel, 0);
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(VisitRecordMapping.CreateTime, SqlOrder.ASC);
		 query.setSortParameter(sortParameter);
		 PagedList<VisitRecord> pageList = visitService.searchByPage(query);
		return pageList;
	}
	/**
	 * @param shopId
	 * @param pageIndex
	 * @return
	 */
	public PagedList<VisitRecord> getVisitTimesListInfoMax(Long shopId, int pageIndex) {
		//设置查询信息
		 QueryCondition query = new QueryCondition();
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(50);
		 queryParam.eq(VisitRecordMapping.ShopId, shopId);
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(VisitRecordMapping.CreateTime, SqlOrder.ASC);
		 query.setSortParameter(sortParameter);
		 PagedList<VisitRecord> pageList = visitService.searchByPage(query);
		return pageList;
	}
	/**
	 * 联系人PageList
	 * @param shopId
	 * @return
	 */
	public PagedList<ShopContact> contactPageList(Long shopId) {
		QueryCondition query = new QueryCondition();
		 //设置查询信息
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(1);
		 query.setPageSize(8);
		 queryParam.eq(ShopContactMapping.ShopId, shopId);
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(ShopContactMapping.Duty, SqlOrder.ASC);
		 query.setSortParameter(sortParameter);
		 PagedList<ShopContact> pageList = shopContactService.searchByPage(query);
		return pageList;
	}
	/**
	 * 公海PageList
	 * @param cityId
	 * @param pageIndex
	 * @return
	 */
	public PagedList<FreshShop> publicShopPageList(Long cityId, int pageIndex) {
		QueryCondition query = new QueryCondition();
		 //设置查询信息
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(8);
		 queryParam.eq(FreshShopMapping.IsPublic, 1);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.IsFinish, 0);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.CityId,cityId);
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(FreshShopMapping.CreateTime, SqlOrder.DESC);
		 query.setSortParameter(sortParameter);
		 PagedList<FreshShop> pageList = shopService.searchByPage(query);
		return pageList;
	}
	public PagedList<FreshShop> findPublicShopPageList(Long cityId, int pageIndex,String shopName,String businessName) {
		QueryCondition query = new QueryCondition();
		 //设置查询信息
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(8);
		 queryParam.eq(FreshShopMapping.IsPublic, 1);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.IsFinish, 0);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.CityId,cityId);
		 if(!"".equals(shopName)){
			 queryParam.and();
			 queryParam.co(FreshShopMapping.Name, shopName);
		 }
		 if(!"".equals(businessName)){
			 queryParam.and();
			 queryParam.co(FreshShopMapping.BusinessArea, businessName);
		 }
		 query.setQueryParameter(queryParam);
		 
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(FreshShopMapping.CreateTime, SqlOrder.DESC);
		 query.setSortParameter(sortParameter);
		 PagedList<FreshShop> pageList = shopService.searchByPage(query);
		return pageList;
	}
	/**
	 * 私海PageList
	 * @param employeeId
	 * @param pageIndex
	 * @return
	 */
	public PagedList<FreshShop> myShopPageList(Long employeeId, int pageIndex) {
		QueryCondition query = new QueryCondition();
		 //设置查询信息
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(8);
		 queryParam.eq(FreshShopMapping.EmployeeId, employeeId);
//		 queryParam.and();
//		 queryParam.eq(FreshShopMapping.IsFinish, 0);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.IsPublic, 0);
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(FreshShopMapping.CreateTime, SqlOrder.DESC);
		 query.setSortParameter(sortParameter);
		 PagedList<FreshShop> pageList = shopService.searchByPage(query);
		return pageList;
	}
	public PagedList<FreshShop> findMyShopPageList(Long employeeId, int pageIndex,String shopName,String businessName) {
		QueryCondition query = new QueryCondition();
		 //设置查询信息
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(8);
		 queryParam.eq(FreshShopMapping.EmployeeId, employeeId);
//		 queryParam.and();
//		 queryParam.eq(FreshShopMapping.IsFinish, 0);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.IsPublic, 0);
		 if(!"".equals(shopName)){
			 queryParam.and();
			 queryParam.co(FreshShopMapping.Name, shopName);
		 }
		 if(!"".equals(businessName)){
			 queryParam.and();
			 queryParam.co(FreshShopMapping.BusinessArea, businessName);
		 }
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(FreshShopMapping.CreateTime, SqlOrder.DESC);
		 query.setSortParameter(sortParameter);
		 PagedList<FreshShop> pageList = shopService.searchByPage(query);
		return pageList;
	}
	public PagedList<FreshShop> finishPageList(Long employeeId, int pageIndex) {
		QueryCondition query = new QueryCondition();
		 //设置查询信息
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(8);
		 queryParam.eq(FreshShopMapping.EmployeeId, employeeId);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.IsFinish, 1);
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(FreshShopMapping.CreateTime, SqlOrder.DESC);
		 query.setSortParameter(sortParameter);
		 PagedList<FreshShop> pageList = shopService.searchByPage(query);
		return pageList;
	}
	public PagedList<FreshShop> findFinishPageList(Long employeeId, int pageIndex,String shopName,String businessName) {
		QueryCondition query = new QueryCondition();
		 //设置查询信息
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(8);
		 queryParam.eq(FreshShopMapping.EmployeeId, employeeId);
		 queryParam.and();
		 queryParam.eq(FreshShopMapping.IsFinish, 1);
		 if(!"".equals(shopName)){
			 queryParam.and();
			 queryParam.co(FreshShopMapping.Name, shopName);
		 }
		 if(!"".equals(businessName)){
			 queryParam.and();
			 queryParam.co(FreshShopMapping.BusinessArea, businessName);
		 }
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(FreshShopMapping.CreateTime, SqlOrder.DESC);
		 query.setSortParameter(sortParameter);
		 PagedList<FreshShop> pageList = shopService.searchByPage(query);
		return pageList;
	}
	public PagedList<ShopProcess> getMonthFinish(Long employeeId, int pageIndex) {
		//设置查询信息
		String start = DateUtil.getMonthFirstDay(0);
		String end = DateUtil.getMonthFirstDay(1);
		 QueryCondition query = new QueryCondition();
		 QueryParameter queryParam = new QueryParameter();
		 query.setPageIndex(pageIndex);
		 query.setPageSize(10);
		 queryParam.eq(ShopProcessMapping.EmployeeId, employeeId);
		 queryParam.and();
		 queryParam.bw(ShopProcessMapping.FinishTime, start, end);
		 query.setQueryParameter(queryParam);
		//设置排序信息
		 SortParameter sortParameter = new SortParameter();
		 sortParameter.add(ShopProcessMapping.FinishTime, SqlOrder.ASC);
		 query.setSortParameter(sortParameter);
		 PagedList<ShopProcess> pageList = shopProcessService.searchByPage(query);
		return pageList;
	}
}
