package com.myb.mos.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.myb.accounts.service.ContractService;
import com.myb.accounts.service.CrmUserinfoService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.ShopService;
import com.myb.accounts.service.UserInfoService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Args;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.CrmUserinfo;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.Shop;
import com.myb.entity.pojo.mos.UserInfo;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.data.SqlSort;
import com.myb.mos.VO.SalesPersonVO;
import com.myb.mos.utils.ListSort;
@Controller
@RequestMapping(value="/excel")
public class ExcelWriteController {
	
	@Autowired
	private OpenAccountService openAccountService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private ContractService contractService ;
	
	@Autowired
	private CrmUserinfoService crmUserinfoService ;
	
	private List<SalesPersonVO> salesPersonVOs = new ArrayList<SalesPersonVO>();
	
	private List<OpenAccount> openAccountsAll = new ArrayList<OpenAccount>(); 
	
	private List<CrmUserinfo> crmUserinfosList = new ArrayList<CrmUserinfo>(); 
	
	private List<Contract> contractsList = new ArrayList<Contract>(); 
	
	private List<Shop> shopList = new ArrayList<Shop>(); 
	
	int allMoney=0;
	int allCount;
	
	@RequestMapping(value="/index")
    public void createExcel(HttpServletResponse response) throws WriteException,IOException{
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM" ); 
	    String fname = "全国销售数据分析表"+sdf.format(new Date());
	    OutputStream os = response.getOutputStream();//取得输出流
	    response.reset();//清空输出流
	    //下面是对中文文件名的处理
	    response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
	    fname = java.net.URLEncoder.encode(fname,"UTF-8");
	    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
	    response.setContentType("application/msexcel");//定义输出类型
		
        //创建工作薄
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //创建新的一页
        WritableSheet sheet = workbook.createSheet("DB全国数据排行榜",0);
        jxl.write.WritableFont font = new jxl.write.WritableFont(jxl.write.WritableFont.createFont("微软雅黑"));
        font.setPointSize(10);
        
        WritableFont font0 = new WritableFont(WritableFont.ARIAL,13,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK); 
        WritableFont font2 = new WritableFont(WritableFont.TAHOMA,12,WritableFont.NO_BOLD,false);  
        WritableCellFormat cellFormat1 = new WritableCellFormat(font2);
        WritableCellFormat cellFormat2 = new WritableCellFormat(font0);
        WritableCellFormat cellFormat3 = new WritableCellFormat(font);
        WritableCellFormat cellFormatjp = new WritableCellFormat(font);
        WritableCellFormat cellFormatyp = new WritableCellFormat(font);
        WritableCellFormat cellFormattp = new WritableCellFormat(font);
        cellFormat3.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
//        cellFormatjp.setBackground(Colour.GOLD);
//        cellFormatyp.setBackground(Colour.GRAY_25);
//        cellFormattp.setBackground(Colour.GRAY_50);
        cellFormat2.setBackground(Colour.YELLOW);
        cellFormat2.setAlignment(Alignment.CENTRE);
       //设置背景颜色;  
        cellFormat1.setBackground(Colour.SKY_BLUE);  
        //设置边框;  
        cellFormat1.setBorder(Border.ALL, BorderLineStyle.DASH_DOT);  
        //设置自动换行;  
        cellFormat1.setWrap(false);  
        //设置文字居中对齐方式;  
        cellFormat1.setAlignment(Alignment.CENTRE);  
        
        //设置垂直居中;  
        cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
        sdf.format(new Date());
        Label bt = new Label(0,0,sdf.format(new Date())+"月美业邦全国BD数据排行榜（包括没签单的销售人员数据）（单位：元）",cellFormat2);
        sheet.addCell(bt);
        sheet.mergeCells(0, 0, 9, 0);
        Label xh = new Label(0,1,"序号",cellFormat1);
        sheet.addCell(xh);
        Label cs = new Label(1,1,"城市",cellFormat1);
        sheet.addCell(cs);
        Label ssxszj = new Label(2,1,"所属销售总监",cellFormat1);
        sheet.addCell(ssxszj);
  	    Label xsr = new Label(3,1,"销售人",cellFormat1);
        sheet.addCell(xsr);
        Label rzsj = new Label(4,1,"入职时间",cellFormat1);
        sheet.addCell(rzsj);
        Label cjds = new Label(5,1,"成交单数",cellFormat1);
        sheet.addCell(cjds);
        Label htje = new Label(6,1,"合同金额",cellFormat1);
        sheet.addCell(htje);
        Label bypj = new Label(7,1,"本月牌级",cellFormat1);
        sheet.addCell(bypj);
        Label byyj = new Label(8,1,"本月佣金",cellFormat1);
        sheet.addCell(byyj);
        Label tsbz = new Label(9,1,"特殊备注",cellFormat1);
        sheet.addCell(tsbz);
        sheet.getSettings().setDefaultColumnWidth(15);
        for (int s = 2; s < salesPersonVOs.size()+2; s++) {
        	 //序号
        	 Label xh1 = new Label(0,s,s-1+"",cellFormat3);
             sheet.addCell(xh1);
             //城市
        	 Label cs1 = new Label(1,s,salesPersonVOs.get(s-2).getCityName(),cellFormat3);
             sheet.addCell(cs1);
             //销售总监
        	 Label shxszj1 = new Label(2,s,salesPersonVOs.get(s-2).getSaleParent(),cellFormat3);
             sheet.addCell(shxszj1);
             //销售人
	    	 Label xsr1 = new Label(3,s,salesPersonVOs.get(s-2).getSalePerson(),cellFormat3);
	         sheet.addCell(xsr1);
	         //入职时间
	         Label rzsj1 = new Label(4,s,salesPersonVOs.get(s-2).getJoinTime(),cellFormat3);
	         sheet.addCell(rzsj1);
	         //成交单数
	         Label cjds1 = new Label(5,s,String.valueOf(salesPersonVOs.get(s-2).getSucessCount()),cellFormat3);
	         sheet.addCell(cjds1);
	         //合同金额
	         Label htje1 = new Label(6,s,String.valueOf(salesPersonVOs.get(s-2).getSaleMoney()),cellFormat3);
	         sheet.addCell(htje1);
	         //本月牌级
	         Label bypj1=null;
	         if (salesPersonVOs.get(s-2).getPaiji().equals("金牌")){
	        	  bypj1 = new Label(7,s,salesPersonVOs.get(s-2).getPaiji(),cellFormatjp);
	         }
	         else if (salesPersonVOs.get(s-2).getPaiji().equals("银牌")){
	        	  bypj1 = new Label(7,s,salesPersonVOs.get(s-2).getPaiji(),cellFormatyp);
	         }
	         else if (salesPersonVOs.get(s-2).getPaiji().equals("铜牌")){
	        	  bypj1 = new Label(7,s,salesPersonVOs.get(s-2).getPaiji(),cellFormattp);
	         } else {
	        	  bypj1 = new Label(7,s,salesPersonVOs.get(s-2).getPaiji(),cellFormat3);
	         }
	        
	         sheet.addCell(bypj1);
	         //本月佣金
	         Label byyj1 = new Label(8,s,"",cellFormat3);
	         sheet.addCell(byyj1);
	         //特殊备注
	         Label tsbz1 = new Label(9,s,"",cellFormat3);
	         sheet.addCell(tsbz1);
        }
          if (salesPersonVOs != null && salesPersonVOs.size() > 0) {
        	Label allCount = new Label(5,salesPersonVOs.size()+3,"总签单: "+salesPersonVOs.get(0).getAllSuccessCount(),cellFormat3);
        	Label allMoney = new Label(6,salesPersonVOs.size()+3,"总金额: "+salesPersonVOs.get(0).getAllMoney()+"",cellFormat3);
        	sheet.addCell(allCount);
        	sheet.addCell(allMoney);
          }
          
          if (salesPersonVOs != null && salesPersonVOs.size()>0) {
        	  for (int i = 0; i < openAccountsAll.size(); i++) {
        		  openAccountsAll.get(i).getMarket();
        		  System.out.println(openAccountsAll.get(i).getMarket());
        		  String cityCode = openAccountsAll.get(i).getCity();
        		  String provinceCode = openAccountsAll.get(i).getProvince();
        		  List<AddressAreaDef>  addressAreaDefs = StartupController.getProvinceAndCity();
        		  List<AddressAreaDef>  addressAreaDefs2 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(cityCode)).collect(Collectors.toList());
 				 if (addressAreaDefs2 != null && addressAreaDefs2.size() > 0 ) {
 					 AddressAreaDef addressAreaDefCity = addressAreaDefs2.get(0);
 					openAccountsAll.get(i).setCityName(addressAreaDefCity.getObjName());
 				 }
 				 List<AddressAreaDef>  addressAreaDefs3 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(provinceCode)).collect(Collectors.toList());
 				 if (addressAreaDefs3 != null && addressAreaDefs3.size() > 0) {
 					 AddressAreaDef addressAreaDefProvince =  addressAreaDefs3.get(0);
 					openAccountsAll.get(i).setProvinceName(addressAreaDefProvince.getObjName());
 				 }
 				 QueryParameter queryParameter = new QueryParameter();
				 queryParameter.eq("userName", openAccountsAll.get(i).getMarket());
				 List<Employee> employeesList = employeeService.searchList(queryParameter);
				 if (employeesList != null && employeesList.size() >0) {
					 openAccountsAll.get(i).setMarket(employeesList.get(0).getEmpName()+"("+openAccountsAll.get(i).getMarket()+")");
				 } 
        	  }
          }
          WritableSheet sheet1 = workbook.createSheet("总监全国数据排行版",1);
          Label xuhao = new Label(0,0,"序号",cellFormat2);
          sheet1.addCell(xuhao);
          Label mrymc = new Label(1,0,"美容院名称",cellFormat2);
          sheet1.addCell(mrymc);
          Label shopName = new Label(2,0,"店名称",cellFormat2);
          sheet1.addCell(shopName);
          Label shengfen = new Label(3,0,"省份",cellFormat2);
          sheet1.addCell(shengfen);
          Label chengshi = new Label(4,0,"城市",cellFormat2);
          sheet1.addCell(chengshi);
          Label shoujihao = new Label(5,0,"老板手机号",cellFormat2);
          sheet1.addCell(shoujihao);
          Label dianshu = new Label(6,0,"店数",cellFormat2);
          sheet1.addCell(dianshu);
          Label fukuanriqi = new Label(7,0,"付款日期",cellFormat2);
          sheet1.addCell(fukuanriqi);
          Label kaitongriqi = new Label(8,0,"开通日期",cellFormat2);
          sheet1.addCell(kaitongriqi);
          Label xiaoshou = new Label(9,0,"销售",cellFormat2);
          sheet1.addCell(xiaoshou);
          Label shyj = new Label(10,0,"所属城市业绩",cellFormat2);
          sheet1.addCell(shyj);
          Label zffs = new Label(11,0,"付款方式",cellFormat2);
          sheet1.addCell(zffs);
          Label yonghuming = new Label(12,0,"账户名",cellFormat2);
          sheet1.addCell(yonghuming);
          Label hetongMoney = new Label(13,0,"合同金额",cellFormat2);
          sheet1.addCell(hetongMoney);
          Label shijiMoney = new Label(14,0,"实际金额",cellFormat2);
          sheet1.addCell(shijiMoney);
          Label danhao = new Label(15,0,"单号",cellFormat2);
          sheet1.addCell(danhao);
          Label beizhu = new Label(16,0,"备注",cellFormat2);
          sheet1.addCell(beizhu);
          List<SalesPersonVO>  shopList =this.salesPersonVOs;
//          //条件查询所有
          QueryParameter queryParameter = new QueryParameter();
          queryParameter.eq("approvalStatus",2);
          List<OpenAccount> openAccountsList = openAccountService.searchList(queryParameter);
          List<Contract>  contractsList = contractService.searchList(new QueryParameter());
          //有开通账户的shopId
          List<SalesPersonVO> shopAll = shopList.parallelStream().filter(e->e.getSucessCount()!=0).collect(Collectors.toList());
          List<AddressAreaDef> addressAreaDefs = StartupController.getProvinceAndCity();
          List<Shop> shopsAno = new ArrayList<Shop>();
          
		  List<Employee> employeesList = employeeService.searchList(new QueryParameter());
          if (shopAll != null && shopAll.size() > 0) 
          {
        	  for (int i = 1; i < shopAll.size()+1; i++) {//所有的店
        		  List<Integer> shopAllId = shopAll.get(i-1).getShopIdByMarket();
        		  for (int f = 0; f < shopAllId.size(); f++) {
        			  //shopId值
        			  int shopId = shopAllId.get(f);
        			  List<Shop> shopsbyId = this.shopList.parallelStream().filter(e->e.getShopId()==shopId).collect(Collectors.toList());
        			  shopsAno.add(shopsbyId.get(0));
        			
        		  }
        		  
        	  }
          }
          List<Integer> htbhList = new ArrayList<Integer>();
          for (int i = 1 ; i < shopsAno.size()+1; i++) {
        	  int accountId = shopsAno.get(i-1).getAccountId();
        	  List<OpenAccount> openAccountsById = openAccountsList.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
        	  OpenAccount openAccount = openAccountsById.get(0);
        	  int provinceId = Integer.parseInt(shopsAno.get(i-1).getProvince());
        	  int cityId = Integer.parseInt(shopsAno.get(i-1).getCity());
			  sheet1.setColumnView(i-1, 20);
			  Label xh2 = new Label(0,i,i+"");
			  sheet1.addCell(xh2);
			  Label mrymc1 = new Label(1,i,openAccountsById.get(0).getBeautifulyard(),cellFormat3);
			  sheet1.addCell(mrymc1);
			  String provinceName = addressAreaDefs.parallelStream().filter(e->e.getId()==provinceId).collect(Collectors.toList()).get(0).getObjName();
			  String cityName = addressAreaDefs.parallelStream().filter(e->e.getId()==cityId).collect(Collectors.toList()).get(0).getObjName();
			  Label shengfen1 = new Label(2,i,shopsAno.get(i-1).getShopName(),cellFormat3);
			  sheet1.addCell(shengfen1);
			  Label chengshi1 = new Label(3,i,provinceName,cellFormat3);
			  sheet1.addCell(chengshi1);
			  Label shoujihao1 = new Label(4,i,cityName,cellFormat3);
			  sheet1.addCell(shoujihao1);
			  Label openNumber = new Label(5,i,openAccount.getOpenNumber(),cellFormat3);
			  sheet1.addCell(openNumber);
			  Label dianshu1 = new Label(6,i,"1");
			  sheet1.addCell(dianshu1);
			  Label fukuanriqi1 = new Label(7,i,openAccount.getPayDate()+"",cellFormat3);
			  sheet1.addCell(fukuanriqi1);
			  Label kaitongriqi1 = new Label(8,i,openAccount.getUpdateDate()+"",cellFormat3);
			  sheet1.addCell(kaitongriqi1);
			  String market = openAccountsById.get(0).getMarket();
			  List<Employee> employees = employeesList.parallelStream().filter(e->e.getUserName().equals(market)).collect(Collectors.toList());
			  if (employees != null && employees.size() > 0) {
				  Label xiaoshou1 = new Label(9,i,employees.get(0).getEmpName()+"("+market+")",cellFormat3);//销售
				  sheet1.addCell(xiaoshou1);
			  }
			  Label shyj1 = new Label(10,i,shopsAno.get(i-1).getBeLongCity(),cellFormat3);
			  sheet1.addCell(shyj1);	//业绩
			  List<Contract> contractsListById =  contractsList.parallelStream().filter(e->e.getAccountId()== openAccount.getAccountId()).collect(Collectors.toList());
			
			  //判断如果excel已经存在的合同编号就不在此导出到exccel
			  if (contractsListById != null && contractsListById.size() > 0) {
				  
				  List<Integer> htbhList1 = htbhList.parallelStream().filter(e->e.equals(contractsListById.get(0).getAccountId())).collect(Collectors.toList());
				  if (htbhList1 != null && htbhList1.size() > 0) {
					  
				  } else {
					  htbhList.add(contractsListById.get(0).getAccountId());
					  if (contractsListById.get(0).getPayType() != null && contractsListById.get(0).getPayType().equals("1")) {
						  
						  Label zffs1 = new Label(11,i,"支付宝",cellFormat3);
						  sheet1.addCell(zffs1);
					  }
					  if (contractsListById.get(0).getPayType() != null && contractsListById.get(0).getPayType().equals("2")) {
						  
						  Label zffs1 = new Label(11,i,"微信",cellFormat3);
						  sheet1.addCell(zffs1);
					  }
					  if (contractsListById.get(0).getPayType() != null && contractsListById.get(0).getPayType().equals("3")) {
						  
						  Label zffs1 = new Label(11,i,"刷卡",cellFormat3);
						  sheet1.addCell(zffs1);
					  }
					  if (contractsListById.get(0).getPayType() != null && contractsListById.get(0).getPayType().equals("4")) {
						  
						  Label zffs1 = new Label(11,i,"银行转账",cellFormat3);
						  sheet1.addCell(zffs1);
					  }
					  
					  Label zhanghuming1 = new Label(12,i,contractsListById.get(0).getPayAccountName(),cellFormat3);
					  sheet1.addCell(zhanghuming1);
					  Label hetongMoney1 = new Label(13,i,contractsListById.get(0).getContractMoney()+"",cellFormat3);
					  sheet1.addCell(hetongMoney1);
					  Label shijiMoney1 = new Label(14,i,contractsListById.get(0).getPayMoney()+"",cellFormat3);
					  sheet1.addCell(shijiMoney1);
					  Label danhao1 = new Label(15,i,contractsListById.get(0).getPayNumber(),cellFormat3);
					  sheet1.addCell(danhao1);
					  Label beizhu1 = new Label(16,i,contractsListById.get(0).getRemark(),cellFormat3);
					  sheet1.addCell(beizhu1);
				  }
				 
			  }
			
          }
        //把创建的内容写入到输出流中，并关闭输出流
        workbook.write();
        workbook.close();
        os.close();
    }
	
		/**
		 * 查询
		 * @param request
		 * @param response
		 * @param pageIndex
		 * @return
		 */
	    @RequestMapping(value="/salePersonList",method={RequestMethod.POST,RequestMethod.GET})
	    public ModelAndView salePersonList(HttpServletRequest request, HttpServletResponse response ) {
	    	
	    	List<CrmUserinfo> crmUserinfos = crmUserinfoService.searchList(new QueryParameter());
	    	crmUserinfosList = crmUserinfos;
	    	List<Contract> contracts = contractService.searchList(new QueryParameter());
	    	contractsList = contracts;
	    	List<Args> argsList = StartupController.getArgList();
	    	SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
	    	SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
	    	List<String> dateList = new ArrayList<String>();
	    	String type = request.getParameter("type");
	    	String xz = request.getParameter("xz");
	        //获取当前月第一天：
	        Calendar cd = Calendar.getInstance();    
	        cd.add(Calendar.MONTH, 0);
	        cd.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	        String first = sdf.format(cd.getTime());
	        
	        //获取当前月最后一天
	        Calendar ca = Calendar.getInstance();    
	        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	        String last = sdf.format(ca.getTime());
	        dateList.add(first);
	        dateList.add(last);
	        
	    	Date openDate = null ;
	    	Date endDate = null ;
	    	int pageSize = 15;
	    	String pageIndex = request.getParameter("pageIndex");
	    	int pageInx = 0;
	    	String openTime = request.getParameter("openTime");
	    	String endTime = request.getParameter("endTime");
	    	String salePersonMobile = request.getParameter("salePerson");
	    	String entryTime = request.getParameter("entryTime");
	    	QueryParameter queryParameter1 = new QueryParameter();
	     	queryParameter1.eq("status","1");
	     	List<Employee> employees = employeeService.searchList(queryParameter1);
	     	
    		//查询所有销售总监
    		QueryParameter queryParameterZJ = new QueryParameter();
    		queryParameterZJ.eq("gangwei", "xszj");
			List<UserInfo> userInfosXSZJ = userInfoService.searchList(queryParameterZJ);
			//查询所有的销售数据
			QueryParameter queryParameterAll = new QueryParameter();
			queryParameterAll.eq("bumen", "销售部");
			List<UserInfo> userInfosAll = userInfoService.searchList(queryParameterAll);
			
			 //条件查询所有店
	          QueryParameter queryParameterByShop = new QueryParameter();
	          List<Shop> shopsList = shopService.searchList(queryParameterByShop);
	         
	    	try {
	    		if (openTime != null) {
	    			openDate =	sdf1.parse(openTime+" 00:00:00");
	    		}
	    		if (endTime != null) {
	    			endDate =	sdf1.parse(endTime+" 23:59:59");
	    		}
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	
	    	if (StringUtils.isNotBlank(pageIndex)) {
	    		if (Integer.parseInt(pageIndex) <= 0){
	    			pageInx = 1;
	    		} else {
	    			pageInx = Integer.parseInt(pageIndex);
	    		}
			}
	    	String isSell = request.getParameter("isSell");//是销售助理可查看的
	    	ModelAndView mav = null;
	    	if (StringUtils.isNotBlank(isSell)) {
	    		
	    		 mav = new ModelAndView("/salesperson/SalesPersonListBySell");
	    		 Employee employee = (Employee)request.getSession().getAttribute("loginUser");
	    		 String userMobile = employee.getUserName();
	    		 List<CrmUserinfo> userinfosByMobile = crmUserinfoService.searchList(new QueryParameter().eq("mobile", userMobile));
	    		 if (userinfosByMobile != null && userinfosByMobile.size() > 0) {
	    			 if (userinfosByMobile.get(0).getXiaozu().contains("北京")) {
	    				 xz="全部(北京大区)";
	    				 mav.addObject("cs", "bj");
	    			 } else if (userinfosByMobile.get(0).getXiaozu().contains("上海")) {
	    				 xz="全部(上海大区)";
	    				 mav.addObject("cs", "sh");
	    			 } else if (userinfosByMobile.get(0).getXiaozu().contains("广州")) {
	    				 xz="全部(广州大区)";
	    				 mav.addObject("cs", "gz");
	    			 } else if (userinfosByMobile.get(0).getXiaozu().contains("杭州")) {
	    				 xz="全部(杭州大区)";
	    				 mav.addObject("cs", "hz");
	    			 } else if (userinfosByMobile.get(0).getXiaozu().contains("深圳")) {
	    				 xz="全部(深圳大区)";
	    				 mav.addObject("cs", "sz");
	    			 } else if (userinfosByMobile.get(0).getXiaozu().contains("KA")) {
	    				 xz="全部(KA)";
	    				 mav.addObject("cs", "KA");
	    			 }
	    		 }
	    		 
	    	} else {
	    		
	    		 mav = new ModelAndView("/salesperson/SalesPersonList");
	    	}
	    	
	    	QueryCondition queryCondition = new QueryCondition();
	    	queryCondition.setPageIndex(pageInx);
	    	queryCondition.setPageSize(10);
	    	//条件
	    	QueryParameter  queryParameter = new QueryParameter();
	    	queryParameter.eq("approvalStatus", 2);
	    	//时间阶段搜索
	    	if (openDate != null && endDate != null) {
	    		queryParameter.and();
	    		queryParameter.gt("updateDate", openDate);
	    		queryParameter.and();
	    		queryParameter.le("updateDate", endDate);
	    	}
	    	if (openDate == null && endDate != null) {
	    		queryParameter.and();
	    		queryParameter.lt("updateDate", openDate);
	    	}
	    	if (openDate != null && endDate == null) {
	    		queryParameter.and();
	    		queryParameter.gt("updateDate", openDate);
	    	}
	    	if (openDate == null && endDate == null) {
	    		queryParameter.and();
	    		queryParameter.gt("updateDate", first);
	    		queryParameter.and();
	    		queryParameter.lt("updateDate", last);
	    	}
	    	//城市搜索
	    	
	    	//小组的搜索
	    	
	    	//销售人的条件搜索
	    	if (StringUtils.isNotBlank(salePersonMobile)) {
	    		queryParameter.and();
	    		queryParameter.eq("market", salePersonMobile);
	    	}
	    	
	    	queryCondition.setQueryParameter(queryParameter);
	    	//排序
	    	SortParameter sortParameter = new SortParameter();
	    	sortParameter.add(new SqlSort("updateDate", SqlOrder.DESC));
	    	queryCondition.setSortParameter(sortParameter);
	    	
	    	//查询当前所有的开通账号根据销售人员
	     	QueryParameter queryParameterBymarket0 = new QueryParameter();
    		queryParameterBymarket0.eq("approvalStatus", 2);
    		if (type != null && type.equals("0")){
    			queryParameterBymarket0.eq("isChannel","isqudao");
    		}
    		List<OpenAccount> openAccountsByMarketList0 = openAccountService.searchList(queryParameter);
	    	
    		
    		
    		 //判断店所属的哪个城市的业绩
	          for (int i = 0; i < shopsList.size(); i++) {
	        	  int accountId = shopsList.get(i).getAccountId();
	        	  List<OpenAccount> accountsByAccountId = openAccountsByMarketList0.parallelStream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
	        	  if (accountsByAccountId != null && accountsByAccountId.size() >0) {
	        		  String market = accountsByAccountId.get(0).getMarket();
	        		  List<CrmUserinfo>  userinfosByMobile = crmUserinfoService.searchList(new QueryParameter().eq("mobile", market));
	        		  if (userinfosByMobile != null && userinfosByMobile.size() > 0) {
	        			  CrmUserinfo crmUserinfo = userinfosByMobile.get(0);
	        			  if (crmUserinfo != null && crmUserinfo.getXiaozu().contains("北京")) {
	        				  shopsList.get(i).setBeLongCity("北京业绩");
	        			  }  else if (crmUserinfo != null && crmUserinfo.getXiaozu().contains("上海")) {
	        				  shopsList.get(i).setBeLongCity("上海业绩");
	        			  } else if (crmUserinfo != null && crmUserinfo.getXiaozu().contains("广州")) {
	        				  shopsList.get(i).setBeLongCity("广州业绩");
	        			  } else if (crmUserinfo != null && crmUserinfo.getXiaozu().contains("深圳")) {
	        				  shopsList.get(i).setBeLongCity("深圳业绩");
	        			  } else if (crmUserinfo != null && crmUserinfo.getXiaozu().contains("杭州")) {
	        				  shopsList.get(i).setBeLongCity("杭州业绩");
	        			  }
	        		  }
	        	  }
	          }
	          
	          
	          this.shopList = shopsList; //给全局赋值
	    	//只有通过的
	    	//去重之后的销售
	    	List<String> list = new ArrayList<String>();
	    	List<SalesPersonVO> salesPersonVOs = new ArrayList<SalesPersonVO>();
	    	//条件选择在这期间有业绩的销售人员
	    	List<OpenAccount> openAccounts1 = openAccountService.searchDistinct(queryCondition, "market");
	    	//根据销售人条件的
	    	if (StringUtils.isNotBlank(salePersonMobile)) {
	    		List<SalesPersonVO> salesPersonVOs2 = new ArrayList<SalesPersonVO>();
	    		SalesPersonVO salesPersonVO = null;
	    		List<UserInfo> userInfos = new ArrayList<UserInfo>();
	    		Employee employee = employeeService.searchByUserName(salePersonMobile);
	    		if (openAccounts1 != null && openAccounts1.size()==0) {
	    			QueryParameter  queryParameter3 = new QueryParameter();
	    			queryParameter3.eq("mobile", salePersonMobile);
	    			List<UserInfo> userInfos2 = userInfoService.searchList(queryParameter3);
	    			salesPersonVO = new SalesPersonVO();
	    			salesPersonVO.setPaiji("无牌");
	    			salesPersonVO.setSaleMoney(0);
	    			salesPersonVO.setSalePerson(userInfos2.get(0).getXingming());
	    			setSaleParentAndXiaozuAndSaleParent(userInfos2, userInfosXSZJ, salesPersonVO);
	    			salesPersonVO.setSucessCount(0);
	    			salesPersonVO.setJoinTime(sdf.format(employee.getEntryTime()));//加入时间
	    			salesPersonVOs2.add(salesPersonVO);
	    			setCityName(salesPersonVOs2);
	    			
	    		} else {
	    			
	    			QueryParameter  queryParameter3 = new QueryParameter();
	    			queryParameter3.eq("mobile", salePersonMobile);
	    			List<UserInfo> userInfos2 = userInfoService.searchList(queryParameter3);
	    			if (userInfos2 != null && userInfos2.size() > 0) {
	    				salesPersonVO = new SalesPersonVO();
	    				setpaiji(openAccountsByMarketList0, salesPersonVO, 0,salePersonMobile);//获取店数和牌级和序号
	    				salesPersonVO.setSalePerson(userInfos2.get(0).getXingming());
	    				setSaleParentAndXiaozuAndSaleParent(userInfos2, userInfosXSZJ, salesPersonVO);
	    				salesPersonVO.setJoinTime(sdf.format(employee.getEntryTime()));//加入时间
	    				salesPersonVOs2.add(salesPersonVO);
	    				setCityName(salesPersonVOs2);
	    			}
	    		}
	    		PagedList pagedList = new PagedList();
	    		pagedList.setContent(salesPersonVOs2);
	    		mav.addObject("pagedList", pagedList);
    			mav.addObject("dateList", dateList);
    			mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
    			List<Args> argsXz = argsList.parallelStream().filter(e->e.getArgType().equals("dq")).collect(Collectors.toList());
    			mav.addObject("argsXz", argsXz);
    			return mav;
	    	}
	    	
	    	List<UserInfo> userInfosList = StartupController.getUserInfoListxs();
	    	List<String> list1 = new ArrayList<String>();
	    	List<String> list2 = new ArrayList<String>();
	    	List<String> list3 = new ArrayList<String>();
	    	//所有销售成绩的
	    	for (UserInfo u : userInfosList) {
	    		list1.add(u.getMobile());
	    	}
	    	//有销售成绩的
	    	for (OpenAccount u : openAccounts1) {
	    		list2.add(u.getMarket());
	    		
	    	}
	    	list3 = list1;
	    	//无销售成绩的
	    	list3.removeAll(list2);
	    	for (int i = 0; i < list3.size(); i++) {
	    		OpenAccount openAccount = new OpenAccount();
	    		openAccount.setMarket(list3.get(i));
	    		openAccounts1.add(openAccount);
	    	}
	    	
	    	//处理按小组查询
	    	List<OpenAccount> openAccounts = new ArrayList<OpenAccount>();
	    	if (StringUtils.isNotBlank(xz) && !xz.equals("请选择")) {
	    		QueryParameter queryParameter2 = new QueryParameter();
	    			if (xz.contains("全部")) {
	    				//获取全部的小组
    				   int startIndex = xz.indexOf("("); //str1是想要开始截取的字符。str是被截取的字符。
    				   int endIndex = xz.indexOf(")"); //str1是想要开始截取的字符。str是被截取的字符。
    				   String cssplit = xz.substring(startIndex+1, endIndex);
	    				List<Args> args = argsList.parallelStream().filter(e->e.getArgName().contains(cssplit)).collect(Collectors.toList());
	    				
	    				String xz1[] = args.get(0).getArgValue().split(",");//所选城市的所有的小组
	    	    		for (int i = 0; i < xz1.length; i++) {
	    	    			int csId = Integer.parseInt(xz1[i]);
	    	    			List<Args> argsXz = argsList.parallelStream().filter(e->e.getArgId()==csId).collect(Collectors.toList());
	    	    			queryParameter2.eq("xiaozu", argsXz.get(0).getArgName());
	    	    			
	    	    			if(i==xz1.length-1){
	    	    			} else{
	    	    				queryParameter2.or();
	    	    			}
	    	    		}
	    	    		//一个小组的
	    			} else {
	    				queryParameter2.eq("xiaozu",xz);
	    			}
	    			List<UserInfo> userInfos = userInfoService.searchList(queryParameter2);
    				for (int i = 0; i < userInfos.size(); i++) {
    					OpenAccount openAccount = new OpenAccount();
    					openAccount.setMarket(userInfos.get(i).getMobile());
    					openAccounts.add(openAccount);
    				}
	    			//清空所有
	    			openAccounts1.clear();
	    			openAccounts1.addAll(openAccounts);
	    	}
	    	
	    	for (int i = 0; i < openAccounts1.size(); i++) {
	    		Employee employee = null;
	    		int t = i;
	    		int shopCount = 0;
	    		Double successMoney = 0d;
	    		SalesPersonVO salesPersonVO = new SalesPersonVO();
	    		String market = openAccounts1.get(i).getMarket();
	    		List<Employee> employeeList = employees.parallelStream().filter(e->e.getUserName().equals(openAccounts1.get(t).getMarket())).collect(Collectors.toList());
	    		if (employeeList != null && employeeList.size()> 0) {
	    			employee = employeeList.get(0);
	    		}
	    		
	    		salesPersonVO = setpaiji(openAccountsByMarketList0, salesPersonVO, i,market);//获取店数和牌级和序号
	    		if (employee != null) {
	    			String userName = employee.getUserName();
	    			salesPersonVO.setSalePerson(employee.getEmpName());//销售人员
	    			if (employee.getEntryTime() != null) {
	    				salesPersonVO.setJoinTime(sdf.format(employee.getEntryTime()));//加入时间
	    			}
	    			//获取销售员工的人员对应的小组
	    			List<UserInfo> userInfosByMobile = userInfosAll.parallelStream().filter(e->e.getMobile().equals(userName)).collect(Collectors.toList());
	    			//设置销售人员的总监和小组
	    			setSaleParentAndXiaozuAndSaleParent(userInfosByMobile, userInfosXSZJ, salesPersonVO);
	    			
	    		}
	    		salesPersonVOs.add(salesPersonVO);
	    		list.add(openAccounts1.get(i).getMarket());
	    	}
	    	
	    	this.salesPersonVOs=setCityName(salesPersonVOs);//统计总共的销售人
	    	//分页处理
	    	PagedList<SalesPersonVO> pagedList2 = new PagedList<SalesPersonVO>();
	    	//不进行分页
	    	if (pageInx == 0) {
	    		//入职时间的查询
	    		if (StringUtils.isNotBlank(entryTime)) {
	    			List<SalesPersonVO> salesPersonVOs2 = salesPersonVOs.parallelStream().filter(e->e.getJoinTime().equals(entryTime)).collect(Collectors.toList());
	    			pagedList2.setContent(salesPersonVOs2);
	    		} else {
	    			pagedList2.setContent(salesPersonVOs);
	    		}
	    		sheet1(xz,openDate,endDate);//统计条件的开通账号列表
	    	//进行分页
	    	} else {
	    		//组装数据
	    		List<SalesPersonVO> salesPersonVOsZZ = new ArrayList<SalesPersonVO>();
	    		for (int s = 0; s < salesPersonVOs.size(); s++) {
	    			if (pageInx == 1) {
	    				if (s <= pageSize -1) {
	    					salesPersonVOsZZ.add(salesPersonVOs.get(s));
	    				}
	    			} else if(s>=pageInx*pageSize-pageSize && s <pageInx*pageSize){
	    				salesPersonVOsZZ.add(salesPersonVOs.get(s));
	    			}
	    		}
	    		salesPersonVOsZZ.get(0).setAllMoney(allMoney);
	    		salesPersonVOsZZ.get(0).setAllSuccessCount(allCount);
	    		
	    		pagedList2.setContent(salesPersonVOsZZ);
	    		sheet1(xz,openDate,endDate);//统计条件的开通账号列表
	    	}
	    	if (StringUtils.isNotBlank(xz) && !xz.equals("请选择")){
	    		ListSort<SalesPersonVO> listSort= new ListSort<SalesPersonVO>(); 
	    		listSort.Sort(pagedList2.getContent(), "getSaleParent", "asc"); 
	    		pagedList2.getContent().get(0).setAllMoney(allMoney);
	    		pagedList2.getContent().get(0).setAllSuccessCount(allCount);
	    	}
	    	
	    	
	    	pagedList2.setPageIndex(pageInx);
	    	pagedList2.setPageSize(pageSize);
	    	pagedList2.setRecordCount(salesPersonVOs.size());
	    	int c = salesPersonVOs.size()%pagedList2.getPageSize()==0?salesPersonVOs.size()/pagedList2.getPageSize():salesPersonVOs.size()/pagedList2.getPageSize()+1;
	    	pagedList2.setTotalPage(c);
	    	mav.addObject("pagedList", pagedList2);
	    	mav.addObject("dateList", dateList);
	    	mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
	    	List<Args> argsXz = argsList.parallelStream().filter(e->e.getArgType().equals("dq")).collect(Collectors.toList());
	    	mav.addObject("argsXz", argsXz);
	    	return mav;
	    }
	    /**
	     * 统计总单数的详情
	     * @param request
	     * @param response
	     */
	    public void sheet1(String xz,Date openDate,Date endDate) {
	    	QueryParameter queryParameter = new QueryParameter();
	    	if (StringUtils.isNotBlank(xz)) {
	    		if (xz.contains("全部")) {
    				//获取全部的小组
				   int startIndex = xz.indexOf("("); //str1是想要开始截取的字符。str是被截取的字符。
				   int endIndex = xz.indexOf(")"); //str1是想要开始截取的字符。str是被截取的字符。
				   String cssplit = xz.substring(startIndex+1, endIndex);
				   
    			} else {
    				    
    			}
	    	} else {
	    		queryParameter.eq("approvalStatus", 2);
	    		queryParameter.and();
	    		queryParameter.gt("updateDate", openDate);
	    		queryParameter.and();
	    		queryParameter.lt("updateDate", endDate);
	    		openAccountService.searchList(queryParameter);
	    	}
	    	
	    	
	    }
	    
	    /**
	     * 销售总监的搜素
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value="/userInfoList")
	    public String userInfoList(){
	    	List<UserInfo> userInfosList = StartupController.getUserInfoList();
	    	List<String> mobileList = new ArrayList<String>();
	    	if (userInfosList != null && userInfosList.size() > 0) {
	    		for (UserInfo u : userInfosList) {
	    			if (u.getQuyu().equals("1")) {
	    				mobileList.add(u.getXingming()+"(北京)");	
	    			}
	    			if (u.getQuyu().equals("2")) {
	    				mobileList.add(u.getXingming()+"(上海)");	
	    			}
	    			if (u.getQuyu().equals("3")) {
	    				mobileList.add(u.getXingming()+"(深圳)");	
	    			}
	    		}
	    	}
	    	return com.alibaba.fastjson.JSONArray.toJSONString(mobileList);
	    }
	    
	    
	    /**
	     * 小组的搜索
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value="/Leader")
	    public String Leader(HttpServletRequest request){
	    	String cs = request.getParameter("cs");
	    	List<Args> argList1 = new ArrayList<Args>();
	    	if (StringUtils.isNotBlank(cs)) {
	    		
	    		List<Args> argsList = StartupController.getArgList();
	    		List<Args> argsCs = argsList.parallelStream().filter(e->e.getArgName().equals(cs)).collect(Collectors.toList());
	    		//当前城市下的所有小组
	    		String xz = argsCs.get(0).getArgValue();
	    		String xz1[] = xz.split(",");
	    		for (int i = 0; i < xz1.length; i++) {
	    			int csId = Integer.parseInt(xz1[i]);
	    			List<Args> argsXz = argsList.parallelStream().filter(e->e.getArgId()==csId).collect(Collectors.toList());
	    			argList1.add(argsXz.get(0));
	    		}
	    		
	    	}
	    	return com.alibaba.fastjson.JSONArray.toJSONString(argList1);
	    }
	 
	    /**
	     * 大区的搜索
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value="/bigArea")
	    public String daqu(){
	    	List<Args> argsList = StartupController.getArgList();
	    	List<Args> argsXz = argsList.parallelStream().filter(e->e.getArgType().equals("dq")).collect(Collectors.toList());
	    	
	    	return com.alibaba.fastjson.JSONArray.toJSONString(argsXz);
	    }
	    /**
	     * 城市设置和总金额和总数量
	     * @param salesPersonVOs
	     * @return
	     */
	    public List<SalesPersonVO> setCityName(List<SalesPersonVO> salesPersonVOs){
	    	
	      	int allMoney=0;
	    	int successCount=0;
	    	//设置城市//总签单数和总金额
	    	if (salesPersonVOs != null && salesPersonVOs.size() > 0) {
	    	for (int i = 0; i < salesPersonVOs.size(); i++) {
	    		allMoney+=salesPersonVOs.get(i).getSaleMoney();
    			successCount+=salesPersonVOs.get(i).getSucessCount();
    			String mobile = salesPersonVOs.get(i).getMobile();
    			if (StringUtils.isNotBlank(mobile)) {
    				
    				List<CrmUserinfo> crmUserinfoByMobile = this.crmUserinfosList.parallelStream().filter(e->e.getMobile().equals(mobile)).collect(Collectors.toList());
    				if (crmUserinfoByMobile != null && crmUserinfoByMobile.size() > 0) {
    					
    					if (StringUtils.isNotBlank(crmUserinfoByMobile.get(0).getXiaozu()) && crmUserinfoByMobile.get(0).getXiaozu().contains("北京")) {
    						salesPersonVOs.get(i).setCityName("北京");
    					}
    					if (StringUtils.isNotBlank(crmUserinfoByMobile.get(0).getXiaozu()) && crmUserinfoByMobile.get(0).getXiaozu().contains("上海")) {
    						salesPersonVOs.get(i).setCityName("上海");
    					}
    					if (StringUtils.isNotBlank(crmUserinfoByMobile.get(0).getXiaozu()) && crmUserinfoByMobile.get(0).getXiaozu().contains("广州")) {
    						salesPersonVOs.get(i).setCityName("广州");
    					}
    					if (StringUtils.isNotBlank(crmUserinfoByMobile.get(0).getXiaozu()) && crmUserinfoByMobile.get(0).getXiaozu().contains("深圳")) {
    						salesPersonVOs.get(i).setCityName("深圳");
    					}
    					if (StringUtils.isNotBlank(crmUserinfoByMobile.get(0).getXiaozu()) && crmUserinfoByMobile.get(0).getXiaozu().contains("杭州")) {
    						salesPersonVOs.get(i).setCityName("杭州");
    					}
    					if (StringUtils.isNotBlank(crmUserinfoByMobile.get(0).getXiaozu()) && crmUserinfoByMobile.get(0).getXiaozu().contains("KA")) {
    						salesPersonVOs.get(i).setCityName("KA");
    					}
    				}
    			}
	    		
	    	 }
	    	this.allMoney=allMoney;
	    	this.allCount=successCount;
	    	salesPersonVOs.get(0).setAllMoney(allMoney);
    		salesPersonVOs.get(0).setAllSuccessCount(successCount);
	    	}
	    	
	    	return salesPersonVOs;
	    }
	    /**
	     * 销售人员的小组和销售总监
	     * @param userInfosByMobile
	     * @param userInfosXSZJ
	     * @param salesPersonVO
	     */
	    public void setSaleParentAndXiaozuAndSaleParent(List<UserInfo> userInfosByMobile, List<UserInfo> userInfosXSZJ,SalesPersonVO salesPersonVO){
	    	if (userInfosByMobile != null && userInfosByMobile.size() > 0) {
				List<UserInfo> userInfosByZj = userInfosXSZJ.parallelStream().filter(e->e.getXiaozu().equals(userInfosByMobile.get(0).getXiaozu())).collect(Collectors.toList());
				if (userInfosByZj != null && userInfosByZj .size() > 0) {
					salesPersonVO.setSaleParent(userInfosByZj.get(0).getXingming());//销售总监
					salesPersonVO.setXiaozu(userInfosByZj.get(0).getXiaozu());
				} else {
					salesPersonVO.setSaleParent("");
				}
			}
	    }
	    /**
	     * 牌级
	     */
	    public SalesPersonVO setpaiji(List<OpenAccount> openAccountsByMarketList0,SalesPersonVO salesPersonVO,int i,String market) {
	    	List<Integer> shopIdByMarket = new ArrayList<Integer>();
	    	//
	    	int shopCount = 0;
    		Double successMoney = 0d;
	    	List<OpenAccount> openAccountsByMarketList = openAccountsByMarketList0.stream().filter(e->e.getMarket() != null && e.getMarket().equals(market)).collect(Collectors.toList());
    		if (openAccountsByMarketList != null && openAccountsByMarketList.size() > 0) {
    			
    			for (int s = 0; s < openAccountsByMarketList.size(); s++) {
    				int accountId = openAccountsByMarketList.get(s).getAccountId();
    				List<Contract> contractsByAccountId = contractsList.stream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
    				
    				List<Shop> shopsList = shopList.stream().filter(e->e.getAccountId()==accountId).collect(Collectors.toList());
    				//获取合同的实际支付金额
					if(contractsByAccountId != null && contractsByAccountId.size() > 0) {
						for (int f = 0; f < contractsByAccountId.size(); f++) {
							if (contractsByAccountId.get(f).getPayMoney() != null) {
								successMoney+=Double.parseDouble(contractsByAccountId.get(f).getPayMoney()+"");
							}
						}
					}
    				//
    				for (int f = 0; f < shopsList.size(); f++) {
    					shopIdByMarket.add(shopsList.get(f).getShopId());
    				}
    				shopCount+=openAccountsByMarketList.get(s).getShopCount();
    			}
    		}
    		
	    	List<Args> argsList = StartupController.getArgList();
    		List<Args> argsByPaiji = argsList.parallelStream().filter(e->e.getArgType().equals("paiji")).collect(Collectors.toList());
    		int pjVar = 0;
    		List<Integer> paijiOrder = new ArrayList<Integer>();
    		if (argsByPaiji != null && argsByPaiji.size() > 0 ) {
    			for (int s = 0; s < argsByPaiji.size(); s++) {
    				paijiOrder.add(Integer.parseInt(argsByPaiji.get(s).getArgValue()));
    			}
    			paijiOrder.add(shopCount);
    		}
    		Collections.sort(paijiOrder, (a, b) -> b.compareTo(a));
    		Collections.reverse(paijiOrder);
    		for (int s = 0; s < paijiOrder.size(); s++) {
    			if (paijiOrder.get(s).equals(shopCount)) {
    				if (s > 0) {
    					pjVar = paijiOrder.get(s-1);
    				} else {
    					pjVar = 0;
    				} 
    			}
    		}
    		for (int s = 0; s < argsByPaiji.size(); s++) {
    			if (pjVar == 0){
    				salesPersonVO.setPaiji("无牌");
    			}else if (argsByPaiji.get(s).getArgValue().equals(""+pjVar)) {
    				if (argsByPaiji.get(s).getArgName().equals("jp")){
    	    			salesPersonVO.setPaiji("金牌");
    	    		} else if (argsByPaiji.get(s).getArgName().equals("yp")) {
    	    			salesPersonVO.setPaiji("银牌");
    	    		} else if (argsByPaiji.get(s).getArgName().equals("tp")) {
    	    			salesPersonVO.setPaiji("铜牌");
    	    		} else {
    	    			salesPersonVO.setPaiji("无牌");
    	    		}
    			} 
    		}
    		salesPersonVO.setMobile(market);
    		salesPersonVO.setXuhao(i+1);
    		salesPersonVO.setSucessCount(shopCount);
    		salesPersonVO.setSaleMoney(new Double(successMoney).intValue());//获取成交金额
    		salesPersonVO.setShopIdByMarket(shopIdByMarket);
    		return salesPersonVO;
	    }
	    
	    
		/**
		 * 展示对应人的开通账号列表
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value="/showListOpenAccount")
		public ModelAndView showListOpenAccount(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="pageIndex",defaultValue="1") int pageIndex){
			String openTime = request.getParameter("openTime");
			String endTime = request.getParameter("endTime");
			String market = request.getParameter("market");
			ModelAndView mav = null;
			mav = new ModelAndView("/salesperson/OpenAccountList");
			if (pageIndex <= 0) {
				pageIndex = 1;
			}
			//财务查看的内容可操作
			String finance = request.getParameter("finance");
			PagedList<OpenAccount> openAccountPageList = null;
			Employee employee =  (Employee)request.getSession().getAttribute("loginUser");  
			finance="1";
			if (finance != null && finance.equals("1")) {
				QueryCondition queryCondition = new QueryCondition();
				QueryParameter queryParameter = new QueryParameter();
				mav.addObject("finance", finance);
				queryCondition.setPageIndex(pageIndex);
				queryCondition.setPageSize(10);
				String [] as = new String [] {"3"};
				queryParameter.eq("approvalStatus", 2);//查询不等于退回的，给财务审核看的
				//渠道开通的账号
				if (StringUtils.isNotBlank(openTime)) {
					queryParameter.and();
					queryParameter.gt("updateDate", openTime);
				}
				if (StringUtils.isNotBlank(endTime)) {
					queryParameter.and();
					queryParameter.lt("updateDate", endTime);
				}
				queryParameter.and();
				queryParameter.eq("market", market);
				SortParameter sortParameter = new SortParameter();
				sortParameter.add("updateDate", SqlOrder.DESC);
				queryCondition.setSortParameter(sortParameter);
				queryCondition.setQueryParameter(queryParameter);
				openAccountPageList = openAccountService.searchByPage(queryCondition);
				//获取所有渠道的
				
			} else {
				QueryCondition queryCondition = new QueryCondition();
				QueryParameter queryParameter = new QueryParameter();
				//销售看所有的
				queryCondition.setPageIndex(pageIndex);
				queryCondition.setPageSize(10);
				SortParameter sortParameter = new SortParameter();
				if (employee != null) {
					queryParameter.eq("empId", employee.getEmpId());//当前销售登录人员的列表
					queryParameter.and();
					queryParameter.ne("approvalStatus", "-1");//不等于开通再关闭的
				}
				sortParameter.add("updateDate", SqlOrder.DESC);
				queryCondition.setSortParameter(sortParameter);
				queryCondition.setQueryParameter(queryParameter);
				openAccountPageList = openAccountService.searchByPage(queryCondition);
			}
			
			if (openAccountPageList.getContent() != null && openAccountPageList.getContent().size() > 0) {
				
				for (int i = 0 ;i < openAccountPageList.getContent().size() ; i++) {
					String cityCode = openAccountPageList.getContent().get(i).getCity();
					String provinceCode = openAccountPageList.getContent().get(i).getProvince();
					List<AddressAreaDef>  addressAreaDefs = StartupController.getProvinceAndCity();
					
					 List<AddressAreaDef>  addressAreaDefs2 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(cityCode)).collect(Collectors.toList());
					 if (addressAreaDefs2 != null && addressAreaDefs2.size() > 0 ) {
						 AddressAreaDef addressAreaDefCity = addressAreaDefs2.get(0);
						 openAccountPageList.getContent().get(i).setCityName(addressAreaDefCity.getObjName());
					 }
					 List<AddressAreaDef>  addressAreaDefs3 = addressAreaDefs.parallelStream().filter(e -> e.getCode().equals(provinceCode)).collect(Collectors.toList());
					 if (addressAreaDefs3 != null && addressAreaDefs3.size() > 0) {
						 AddressAreaDef addressAreaDefProvince =  addressAreaDefs3.get(0);
						 openAccountPageList.getContent().get(i).setProvinceName(addressAreaDefProvince.getObjName());
					 }
					 QueryParameter queryParameter = new QueryParameter();
					 queryParameter.eq("userName", openAccountPageList.getContent().get(i).getMarket());
					 List<Employee> employeesList = employeeService.searchList(queryParameter);
					 if (employeesList != null && employeesList.size() >0) {
//						 employeesList.get(0);
						 openAccountPageList.getContent().get(i).setMarket(employeesList.get(0).getEmpName()+"("+openAccountPageList.getContent().get(i).getMarket()+")");
					 }
				}
			}
			mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser"));
			mav.addObject("openAccountPageList", openAccountPageList);
			mav.addObject("openTime", openTime);
			mav.addObject("endTime", endTime);
			mav.addObject("market", market);
			
			return mav;
		}
		
		
		/**
		 * 总金额和总数量的统计
		 * @param request
		 * @param response
		 * @param parameter
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value="/getAll",method={RequestMethod.POST,RequestMethod.GET})
	    public String test(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String,Object> parameter) {
	    	List<Integer>  list = new ArrayList<Integer>();
	    	list.add(allCount);
	    	list.add(allMoney);
	    	return list.toString();
	    }
	   
	    
}
    
    
