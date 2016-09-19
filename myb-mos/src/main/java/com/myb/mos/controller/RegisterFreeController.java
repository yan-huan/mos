package com.myb.mos.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.myb.accounts.service.ArgsService;
import com.myb.accounts.service.ChannelInfoService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.OpenaccountChannelService;
import com.myb.accounts.service.ShopService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.Shop;
import com.myb.entity.pojo.mos.ShopMapping;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.mos.VO.OpenAccountVO;
import com.myb.mos.utils.AliyunOSSUtil;
import com.myb.mos.utils.BaseProUtill;
import com.myb.mos.utils.DesUtill;
import com.myb.mos.utils.HttpClientUtil;
import com.myb.mos.utils.RegexUtils;
import com.thoughtworks.xstream.core.util.Base64Encoder;

/**
 * 注册免费版账号
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/free")
public class RegisterFreeController {
	
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
	
	private String fileUrl;
	
	/**
	 * 注册免费版的h5
	 * @param request
	 * @param response
	 * @param channelVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/register")
	public String register(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="openNumber") String openNumber,
			@RequestParam(value="beautifulyard") String beautifulyard,
			@RequestParam(value="zongbuAddress") String zongbuAddress,
			@RequestParam(value="provinceAndCity") String provinceAndCity,
			@RequestParam(value="mobile") String mobile
			){
		System.out.println("1111111111111111111");
		OpenAccount openAccount= new OpenAccount();
		if (StringUtils.isNotBlank(provinceAndCity)) {
			String[] pac = provinceAndCity.split(" ");
			List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
			
			if (pac[0].contains("市")) {
				List<AddressAreaDef> pacByPro = addressAreaDefs.parallelStream().filter(e->e.getObjName().equals(pac[0].substring(0, pac[0].length()-1))).collect(Collectors.toList());	
				List<AddressAreaDef> pacByCity = addressAreaDefs.parallelStream().filter(e->e.getObjName().equals(pac[2])).collect(Collectors.toList());	
				if (pacByPro != null && pacByPro.size() > 0) {
					openAccount.setProvince(pacByPro.get(0).getId()+"");
				}
				if (pacByCity != null && pacByCity.size() >0) {
					openAccount.setCity(pacByCity.get(0).getId()+"");
				}
			} else {
				List<AddressAreaDef> pacByPro = addressAreaDefs.parallelStream().filter(e->e.getObjName().equals(pac[0].substring(0, pac[0].length()-1))).collect(Collectors.toList());	
				List<AddressAreaDef> pacByCity = addressAreaDefs.parallelStream().filter(e->e.getObjName().equals(pac[1])).collect(Collectors.toList());	
				if (pacByPro != null && pacByPro.size() > 0) {
					openAccount.setProvince(pacByPro.get(0).getId()+"");
				}
				if (pacByCity != null && pacByCity.size() >0) {
					openAccount.setCity(pacByCity.get(0).getId()+"");
				}
				
			}
		}
		System.out.println("22222222222222");
//		if(!RegexUtils.checkMobile(openNumber) ){
//			return "11";
//		}
		if(StringUtils.isBlank(beautifulyard) ){
			return "12";
		}
		if(StringUtils.isBlank(fileUrl) && fileUrl.contains("1102or_a22-192s_632p589wq") ){
			System.out.println("youtupian!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return "13";
		}
		if(StringUtils.isBlank(zongbuAddress) ){
			return "14";
		}
		
		OpenAccount accountByMobile = openAccountService.searchByMobile(mobile);
		if (accountByMobile != null) {//手机号已存在
			return "2";
		}
		System.out.println("333333333333333333");
		openAccount.setOpenNumber(mobile);
		openAccount.setZongbuAddress(zongbuAddress);
		openAccount.setBeautifulyard(beautifulyard);
		openAccount.setIsChannel("free");
		openAccount.setApprovalStatus(1);
		openAccount.setUpdateDate(new Date());
		openAccount.setFilePath(fileUrl);
		openAccount.setTouchMobile(mobile);
		openAccount.setCreateTime(new Date());
		int insertOA = openAccountService.insert(openAccount);
		System.out.println("gggggggggg"+insertOA);
		System.out.println("444444444444444444444");
		String ss = "{status:302,location:../free/register.jhtml}";
		if (insertOA == 1) {
			return "1";
		} else {
			return "0";
		}
	}
	
	/**
	 * 展示免费版的账号列表
	 * @param request
	 * @param response
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value="/showFreeListOpenAccount")
	public ModelAndView showFreeListOpenAccount(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
		 
		ModelAndView mav = new ModelAndView("/registerFree/freeOpenAccountList");
		if (pageIndex <= 0) {
			pageIndex = 1;
		}
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setPageSize(10);
		queryCondition.setPageIndex(pageIndex);
		QueryParameter queryParameter = new QueryParameter();
		queryParameter.eq("isChannel", "free");
		queryCondition.setQueryParameter(queryParameter);
		queryCondition.setSortParameter(new SortParameter().add("updateDate", SqlOrder.DESC));
		PagedList<OpenAccount> pagedList = openAccountService.searchByPage(queryCondition);
		List<AddressAreaDef> cityAndProvince = StartupController.getProvinceAndCity();
		pagedList.getContent().parallelStream().forEach(e->e.setCityName(
				cityAndProvince.parallelStream().filter(
						f->f.getId()==Integer.parseInt(e.getCity())).collect(Collectors.toList()).get(0).getObjName())
				);
		pagedList.getContent().parallelStream().forEach(e->e.setProvinceName(
				cityAndProvince.parallelStream().filter(
						f->f.getId()==Integer.parseInt(e.getProvince())).collect(Collectors.toList()).get(0).getObjName())
				);
		mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
		mav.addObject("openAccountPageList", pagedList);
		return mav;
	}
	
	/**
	 * 账号是否通过
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/freeIsOk",method = {RequestMethod.POST,RequestMethod.GET})
	public String freeIsOk(HttpServletRequest request, HttpServletResponse response) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String type = request.getParameter("type");
		String accountId = request.getParameter("accountId");
		OpenAccount openAccount =openAccountService.searchByAccountId(Integer.parseInt(accountId));
		if (StringUtils.isNotBlank(type) && type.equals("ispass")) {//通过
			openAccount.setApprovalStatus(2);
		} else {//拒绝
			openAccount.setApprovalStatus(3);
		}
		
		String isOkCreateBoss = createBossAccount(openAccount);
		if (StringUtils.isNotBlank(isOkCreateBoss) && isOkCreateBoss.equals("1")) {
			String addShop = createShop(openAccount);
			if (StringUtils.isNotBlank(addShop) && addShop.equals("1")) {
				openAccountService.update(openAccount);
				return "1";
			}
		}
		
		return "0";
	}
	
	/**
	 * 注册免费版的上传图片
	 * @param myfile
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping(value="/fileRisterUpload",method={RequestMethod.POST,RequestMethod.GET})
    public String fileUpload(@RequestParam("myfile") MultipartFile myfile,HttpServletRequest request, HttpServletResponse response) {
		
		String fileUrl = request.getParameter("fileUrl");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		InputStream inputs = null;
		try {
			inputs = myfile.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Date date = new Date();
		Base64Encoder decoder = new Base64Encoder();  
	        try {
	            // Base64解码
	            byte[] bytes = decoder.decode(fileUrl);
	            for (int i = 0; i < bytes.length; ++i) {
	              if (bytes[i] < 0) {// 调整异常数据
	                bytes[i] += 256;
	              }
	            }
	            // 生成jpeg图片
	            String filePath = "registerFree/"+simpleDateFormat.format(date)+"/"+UUID.randomUUID()+"1102or_a22-192s_632p589wq.jpg";//新生成的图片  
	            
	            System.out.println("ffffffff"+filePath);
	            this.fileUrl = filePath;
	            String isOk = AliyunOSSUtil.save(filePath,inputs);
	            String realPath = AliyunOSSUtil.httpUrl+"/"+filePath;
	          } catch (Exception e) {
	        	  e.printStackTrace();
	          }
//		return " <div id='sss'>"+realPath+"</div>";
		return "";
	}
	
	
	/**
	 * 升级免费版
	 * @param openAccount
	 * @return
	 */
	public String createBossAccount (OpenAccount openAccount) {
		
		Map<String, String>  map1 = new HashMap<String, String>();
    	map1.put("mobile", openAccount.getOpenNumber());
    	map1.put("shopNums", ""+0);
    	map1.put("objName", ""+openAccount.getBeautifulyard());
    	map1.put("Type", "1");
    	map1.put("companyCode", "1");
    	map1.put("status", "NORMAL");
    	map1.put("page", "1");
    	map1.put("pageSize", "5");
    	map1.put("provinceCode", "2");
    	map1.put("address", openAccount.getZongbuAddress());
    	map1.put("systemType", "MOS");
    	map1.put("cityCode", openAccount.getCity());
    	List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
    	List<AddressAreaDef>  addressAreaDefsProvince = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(openAccount.getProvince())).collect(Collectors.toList());
		 if (addressAreaDefsProvince != null && addressAreaDefsProvince.size() > 0 ) {
			 
			 map1.put("provinceName", addressAreaDefsProvince.get(0).getObjName());
		 }
    	List<AddressAreaDef>  addressAreaDefsCity = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(openAccount.getCity())).collect(Collectors.toList());
    	if (addressAreaDefsCity != null && addressAreaDefsCity.size() > 0 ) {
			 map1.put("cityName", addressAreaDefsCity.get(0).getObjName());
		 }
    	try {
			map1.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String resultData1 = null;
		try {
			resultData1 = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/createBossAndCompany.jhtml", map1, "utf-8","utf-8");
		
			JSONObject data = (JSONObject) JSONObject.parse(resultData1);
			if (data.get("code").equals("1000000")) {
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		
		return  "0";
	}
	
	
	/**
	 * 创建免费的店
	 * @param openAccount
	 * @return
	 */
	public String createShop (OpenAccount openAccount) {
		List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
		  String provinceName = addressAreaDefs.parallelStream().filter(e->e.getId()==Integer.parseInt(openAccount.getProvince())).collect(Collectors.toList()).get(0).getObjName();
		  String cityName = addressAreaDefs.parallelStream().filter(e->e.getId()==Integer.parseInt(openAccount.getCity())).collect(Collectors.toList()).get(0).getObjName();
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  Map<String, String>  map = new HashMap<String, String>();
		  map.put("status", "NORMAL");
	      map.put("buyerPartyType", "CLERK");
	      map.put("cityName", cityName);
	      map.put("provinceCode", openAccount.getProvince());
	      map.put("cityCode", openAccount.getCity());
	      map.put("mobile", openAccount.getOpenNumber());
	      map.put("areaCount", "500.00");
	      map.put("provinceName", provinceName);
	      map.put("objName", openAccount.getBeautifulyard());
	      map.put("address", openAccount.getZongbuAddress());
	      map.put("description","");
	      map.put("servicePhone", "00000000000");
	      map.put("belongToPartyType", "CLERK");
	      map.put("bedCount", "1");
	      map.put("startTime", simpleDateFormat.format(new Date())+" 00:00:00");
		  map.put("endTime", "2066-12-31 00:00:00");
	      map.put("duration", "50");
	      map.put("versionType", "FREE");
	      try {
		  map.put("secretCode", DesUtill.encrypt((String.valueOf(new Date().getTime()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	      JSONObject jsonObject = new JSONObject();
			 String resultData = null;
			try {
				resultData = HttpClientUtil.sendPostRequest(BaseProUtill.httpUrl+"/clerk/addShop.jhtml", map, "utf-8","utf-8");
				JSONObject data = (JSONObject) JSONObject.parse(resultData);
				if (data.get("code").equals("1000000")) {
					return "1";
				}
			} catch (Exception e) {
				e.printStackTrace();
				
				return "0";
			}
			
			return "0";
	}
	
}
