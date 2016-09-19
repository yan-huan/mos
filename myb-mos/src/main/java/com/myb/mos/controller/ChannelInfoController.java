package com.myb.mos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.ArgsService;
import com.myb.accounts.service.ChannelInfoService;
import com.myb.accounts.service.ContractService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.OpenaccountChannelService;
import com.myb.accounts.service.ShopService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Args;
import com.myb.entity.pojo.mos.ChannelInfo;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.OpenaccountChannel;
import com.myb.entity.pojo.mos.Shop;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.mos.VO.ChannelVO;
import com.myb.mos.VO.OpenAccountVO;
import com.myb.mos.VO.ShopVO;

/**
 * 渠道信息
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/channelInfo")
public class ChannelInfoController {
	
	@Autowired
	private ChannelInfoService channelInfoService;
	
	@Autowired
	private OpenAccountService openAccountService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OpenaccountChannelService openaccountChannelService;
	
	@Autowired
	private ArgsService argserService;
	
	@Autowired
	private ContractService contractService;
	
	/**
	 * 保存渠道的信息
	 * @param request
	 * @param response
	 * @param channelVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveChannelInfo")
	public String saveChannelInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("channelVO") ChannelVO channelVO){
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 ChannelInfo channelInfo = new ChannelInfo();
		 if (channelVO.getDiscountRate() < 1) {
			 channelVO.setDiscountRate(channelVO.getDiscountRate());
		 } else {
//			 channelVO.setDiscountRate(channelVO.getDiscountRate()/100);
		 }
		 Double d= 0D;
		 BeanUtils.copyProperties(channelVO, channelInfo);
		 d=channelVO.getDiscountRate()/100D;
		 channelInfo.setDiscountRate(Double.parseDouble(String.valueOf(d)));
		 channelInfo.setStatus(1);
			
			if (channelInfo.getChannelId() != 0){
				channelInfo.setUpdateTime(new Date());
				Employee employee = (Employee)request.getSession().getAttribute("loginUser");
				channelInfo.setEmpId(employee.getEmpId());
				int updateChannel = channelInfoService.update(channelInfo);
				if (updateChannel == 1) {
					return "1";
				} else {
					return "0";
				}
			}
		 try {
			 channelInfo.setCreateTime(sdf.parse(sdf.format(new Date())));
			 channelInfo.setUpdateTime(sdf.parse(sdf.format(new Date())));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			Employee employee = (Employee)request.getSession().getAttribute("loginUser");
			channelInfo.setEmpId(employee.getEmpId());
			 int saveChannel = channelInfoService.insert(channelInfo);
			 if (saveChannel == 1) {
					return "1";
			 } else {
					return "0";
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		
		
	}
	/**
	 * 根据登陆人所开通的渠道列表
	 * @param request
	 * @param response
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value="/searchChannelList")
	public ModelAndView searchChannelList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
		ModelAndView mav = new ModelAndView("/channelInfo/ChannelInfoList");
		if (pageIndex <= 0) {
			pageIndex = 1;
		}
		Employee employee = (Employee)request.getSession().getAttribute("loginUser");
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setPageSize(10);
		queryCondition.setPageIndex(pageIndex);
		SortParameter sortParameter = new SortParameter();
		sortParameter.add("updateTime", SqlOrder.DESC);
		queryCondition.setSortParameter(sortParameter);
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("empId", employee.getEmpId());
		queryCondition.setQueryParameter(queryParameter);
		PagedList<ChannelInfo> pagedList = channelInfoService.searchByPage(queryCondition);
		if (pagedList.getContent().size() > 0) {
			mav.addObject("pagedList", pagedList);
			mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
			return mav;
		}
		return mav;
		
	}
	/**
	 * 财务审批渠道开通账号的展示详情
	 * @param request
	 * @param response
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value="/findAllChannelInfo")
	public ModelAndView findAllChannelInfo(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="accountId") String accountId){
		String finance = request.getParameter("finance");
		String qudao = request.getParameter("qudao");
		//渠道展示审核的页面包括账号信息和渠道的信息
		ModelAndView mav = new ModelAndView("/channelInfo/ChannelAllInfo");
		//账号信息
		OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("openAccountId", accountId);
		List<OpenaccountChannel> openaccountChannelsList = openaccountChannelService.searchList(queryParameter);
		if (openaccountChannelsList != null && openaccountChannelsList.size() > 0) {
			Long channelId = openaccountChannelsList.get(0).getChannelId();
			//渠道的信息
			ChannelInfo channelInfo = channelInfoService.searchByChannelId(Integer.valueOf(String.valueOf(channelId)));
			mav.addObject("channelInfo", channelInfo);
		}
		
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		OpenAccountVO openAccountVO = new OpenAccountVO();
		BeanUtils.copyProperties(openAccount, openAccountVO);
		//存儲汉字的省份和城市
		List<AddressAreaDef>  provinceAndCity = StartupController.getProvinceAndCity();
		if (provinceAndCity != null && provinceAndCity.size() > 0) {
			List<AddressAreaDef> citys =	provinceAndCity.parallelStream().filter(e->e.getCode().equals(openAccount.getCity())).collect(Collectors.toList());
			if (citys != null && citys.size() > 0) {
				openAccountVO.setCityName(citys.get(0).getObjName());
			}
			List<AddressAreaDef> provinces = provinceAndCity.parallelStream().filter(e->e.getCode().equals(openAccount.getProvince())).collect(Collectors.toList());
			if (provinces != null && provinces.size() > 0) {
				openAccountVO.setProvinceName(provinces.get(0).getObjName());
			}
		}
		//查询当前账号所开的店信息
		List<ShopVO> shopVOsList = new ArrayList<ShopVO>(); 
		QueryParameter parameter = new QueryParameter();
		parameter.eq("accountId", accountId);
		List<Shop> shopsList = shopService.searchList(parameter);
		if (shopsList != null && shopsList.size() > 0) {
			Double allMoney = 0d;
			for (int i = 0; i < shopsList.size(); i++) {
				ShopVO shopVO = new ShopVO();
				BeanUtils.copyProperties(shopsList.get(i), shopVO);
				shopVO.getDuration();
				QueryParameter queryParameter1 = new QueryParameter();
				queryParameter1.eq("argName", shopVO.getDuration());
				queryParameter1.and();
				queryParameter1.eq("argType", "nianxian");
				List<Args> argsList = argserService.searchList(queryParameter1);
				if (argsList != null && argsList.size() > 0) {
					//实际的费用
					Double argValue = Double.valueOf(argsList.get(0).getArgValue());
					if (shopVO.getCurrentRate() != null) {
						shopVO.setShijiMoney(argValue*shopVO.getCurrentRate());
					}
					
				}
				shopVOsList.add(shopVO);
				if (shopVO != null && shopVO.getShijiMoney() != null ) {
					allMoney+=shopVO.getShijiMoney();
				}
			}
			//合计金额
			shopVOsList.get(0).setAllMoney(allMoney);
			mav.addObject("shopsList", shopVOsList);
		}
		mav.addObject("openAccount", openAccountVO);
		if (StringUtils.isNotBlank(finance) && finance.equals("1")) {
			mav.addObject("finance", 1);
		}
		if (StringUtils.isNotBlank(qudao) && qudao.equals("1")) {
			mav.addObject("qudao", 1);
		}
		return mav;
		
	}
	
	/**
	 * 登录人所有的账号列表
	 * @param request
	 * @param response
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value="/allOpenAccountList")
	public ModelAndView allOpenAccountList(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
		ModelAndView mav = new ModelAndView("/channelInfo/AllChannelOpenAccountList");
		if (pageIndex <= 0) {
			pageIndex = 1;
		}
		Employee employee = (Employee)request.getSession().getAttribute("loginUser");
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setPageSize(10);
		queryCondition.setPageIndex(pageIndex);
		SortParameter sortParameter = new SortParameter();
		sortParameter.add("updateDate", SqlOrder.DESC);
		queryCondition.setSortParameter(sortParameter);
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("empId", employee.getEmpId());
		queryParameter.and();
		queryParameter.eq("isChannel", "isqudao");
		queryParameter.and();
		queryParameter.ne("approvalStatus", -1);
		queryCondition.setQueryParameter(queryParameter);
		PagedList<OpenAccount> pagedList = openAccountService.searchByPage(queryCondition);
		
		if (pagedList.getContent().size() > 0) {
			List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
			for (int i = 0; i < pagedList.getContent().size(); i++) {
				String cityCode = pagedList.getContent().get(i).getCity();
				String provinceCode = pagedList.getContent().get(i).getProvince();
				pagedList.getContent().get(i)
				        .setCityName(addressAreaDefs.parallelStream()
						.filter(e->e.getCode().equals(cityCode))
						.collect(Collectors.toList()).get(0).getObjName()
						);
				pagedList.getContent().get(i)
				.setProvinceName(addressAreaDefs.parallelStream()
				.filter(e->e.getCode().equals(provinceCode))
				.collect(Collectors.toList()).get(0).getObjName());
			}
			mav.addObject("openAccountPageList", pagedList); 
			mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
			return mav;
		}
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		return mav;
		
	}
	/**
	 * 渠道销售提交给财务的方法设置openAccount的isShowQudaoList为1 显示为1 不显示为0
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/setisShowQudaoList")
	public String setisShowQudaoList(HttpServletRequest request,HttpServletResponse response) {
		String accountId = request.getParameter("accountId");
		OpenAccount openAccount = openAccountService.searchByAccountId(Integer.parseInt(accountId));
		//已经提交过
		if (openAccount.getIsShowQudaoList() == 1 && openAccount.getApprovalStatus() == 1) {
			return "istj";
		}
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("accountId", accountId);
		List<Shop> shopsList = shopService.searchList(queryParameter);
		//判断店数是否等于账号的填入店数
		if (shopsList != null && shopsList.size() > 0) {
			if (shopsList.size() != openAccount.getShopCount()) {
				return "qudaoErrShopCount";
			}
		} else {
			return "qudaoErrShopCount";
		}
		//判断合同是否添加
		List<Contract> contracts = contractService.searchList(new QueryParameter().eq("accountId",accountId));
		if (contracts == null || contracts.size() <= 0) {
			return "qudaoErrContract";
		}
		//判断渠道的余额是否大于店数*900
		QueryParameter queryParameter1 = new QueryParameter();
		queryParameter1.eq("openAccountId", accountId);
		List<OpenaccountChannel> openaccountChannelsList = openaccountChannelService.searchList(queryParameter1);
		if (openaccountChannelsList != null && openaccountChannelsList.size() > 0){
			Long channelId = openaccountChannelsList.get(0).getChannelId();
			ChannelInfo channelInfo = channelInfoService.searchByChannelId(Integer.parseInt(channelId.toString()));
			if (channelInfo != null) {
				Double allMoney = 0D;
				for (int i = 0; i < shopsList.size(); i++) {
					QueryParameter queryParameter2 = new QueryParameter();
					queryParameter2.eq("argName", shopsList.get(i).getDuration());
					//匹配店数的年限对应的金额
					allMoney+=Double.valueOf(argserService.searchList(queryParameter2).get(0).getArgValue())*channelInfo.getDiscountRate();
				}
				if (Double.valueOf(channelInfo.getReadyDepositMoney().toString()) < allMoney ) {
					return "qudaoErrMoney";
				} else {
					openAccount.setIsShowQudaoList(1);
					openAccount.setApprovalStatus(1);
					openAccountService.update(openAccount);
					return "success";
				}
				
			}
		}
		return "err";
	}
	/**
	 * 查询所有的渠道列表条件查询使用
	 * @param request
	 * @param response
	 * @param channelVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/searchAllChannel")
	public String searchAllChannel(HttpServletRequest request, HttpServletResponse response){
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("status", 1);
		Employee employee = (Employee)request.getSession().getAttribute("loginUser");
		queryParameter.and();
		queryParameter.eq("empId", employee.getEmpId());
		List<ChannelInfo> channelInfos = channelInfoService.searchList(queryParameter);
		JSONArray.toJSONString(channelInfos);
		return JSONArray.toJSONString(channelInfos);
				
	}
	
	/**
	 * 根据id查询渠道信息
	 * @param request
	 * @param response
	 * @param pageIndex
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/searchByChannelId")
	public String searchByChannelId(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="channelId") int channelId ){
		ChannelInfo channelInfo = channelInfoService.searchByChannelId(channelId);
		if (channelInfo != null) {
			channelInfo.setOpenTimeStr(channelInfo.getOpenTime().toString());
			channelInfo.setEndTimeStr(channelInfo.getEndTime().toString());
			return JSONObject.toJSONString(channelInfo);
		}
		return "";
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param channelId
	 * @return
	 */
	@RequestMapping(value="/modifyChannel")
	public ModelAndView modifyChannel(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="channelId") int channelId){
		ChannelInfo channelInfo = channelInfoService.searchByChannelId(channelId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/channelInfo/AddChannelInfo");
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		channelInfo.setDiscountRate(Double.parseDouble(String.valueOf(Math.round(channelInfo.getDiscountRate()*100))));
		ChannelVO channelVO = new ChannelVO();
		BeanUtils.copyProperties(channelInfo, channelVO);
		channelVO.setDiscountRate((int)Math.floor(channelInfo.getDiscountRate()));
		mav.addObject("channelInfo", channelVO);
		return mav;
	}
	
	
	/**
	 * 账号转向渠道或渠道转直营
	 * @param request
	 * @param response
	 * @param channelId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/toForword")
	public String toForword(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="channelId") int channelId
			
			,@RequestParam(value="accountId") int accountId){
		
		if (channelId == -1) {
			OpenAccount openAccount = openAccountService.searchByAccountId(accountId);
			openAccount.setIsChannel("");
			int openAccountByAccountId = openAccountService.update(openAccount);
			List<OpenaccountChannel> openaccountChannels = openaccountChannelService.searchList(new QueryParameter().eq("openAccountId", accountId));
			int ocs = openaccountChannelService.delete(openaccountChannels.get(0).getId());
			if (openAccountByAccountId == 1 && ocs == 1) {
				return "1";
			} else {
				return "0";
			}
		}
		//转移到渠道
		OpenAccount openAccount = openAccountService.searchByAccountId(accountId);
		openAccount.setIsChannel("isqudao");
		openAccount.setIsShowQudaoList(1);
		int updateOC = openAccountService.update(openAccount);
		OpenaccountChannel openaccountChannel = new OpenaccountChannel();
		openaccountChannel.setChannelId(channelId);
		openaccountChannel.setOpenAccountId(accountId);
		openaccountChannel.setStatus(1);
		int saveOC = openaccountChannelService.insert(openaccountChannel);
		if (updateOC == 1 && saveOC == 1) {
			return "1";
		} else {
			return "0";
		}
		
	}
	
}
