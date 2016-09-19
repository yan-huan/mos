package com.myb.mos.controller;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.myb.accounts.service.AddressAreaDefService;
import com.myb.accounts.service.ArgsService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.service.RecordlogsService;
import com.myb.accounts.service.ShopService;
import com.myb.accounts.service.UserInfoService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Args;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.entity.pojo.mos.Recordlogs;
import com.myb.entity.pojo.mos.Shop;
import com.myb.entity.pojo.mos.UserInfo;
import com.myb.framework.data.QueryParameter;
 
@Component
public class StartupController implements ApplicationContextAware, ServletContextAware,
        InitializingBean, ApplicationListener<ContextRefreshedEvent> {
 
	public static  List<AddressAreaDef> addressAreaDefList = new ArrayList<AddressAreaDef>();
	public static List<Employee> employeeList = new ArrayList<Employee>();
	public static  Employee employee = new Employee();
	public static  List<Args> argsList = new ArrayList<Args>();
	public static  List<UserInfo> userInfoList = new ArrayList<UserInfo>();
	public static  List<UserInfo> userInfosListAllxs = new ArrayList<UserInfo>();
	@Resource
	private  AddressAreaDefService addressAreaDefService;
	
	@Resource
	private  OpenAccountService openAccountService;
	
	@Resource
	private ShopService shopService;
	
	@Autowired
	private RecordlogsService recordlogsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ArgsService argserService;
	
	@Autowired
	private UserInfoService userInfoService;
	
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        System.out.println("1111111111111");
    }
 
    @Override
    public void setServletContext(ServletContext context) {
        System.out.println("2222222222222");
    }
 
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3333333333333");
        //执行定时任务
        Runnable runnable = new Runnable() {  
            public void run() {  
                // task to run goes here  
            	QueryParameter queryParameter =	new QueryParameter();
            	queryParameter.eq("status", 1);
            	List<Recordlogs> recordlogs = recordlogsService.searchList(queryParameter);
            	
            	List<Recordlogs> openAccountList = recordlogs.parallelStream().filter(e -> e.getType() == 1).collect(Collectors.toList());
            	List<Recordlogs> openShopList = recordlogs.parallelStream().filter(e -> e.getType() == 2).collect(Collectors.toList());
            	QueryParameter queryParameterAccount =	new QueryParameter();
            	queryParameterAccount.eq("status", 1);
            	List<OpenAccount> openAccountsList = openAccountService.searchList(queryParameterAccount);
            	List<Shop> shopsList = shopService.searchList(new QueryParameter());
            	//循环log日志的存入到开通账号表
            	for (int i = 0; i < openAccountList.size(); i++) {
            		String mobile = openAccountList.get(i).getMobile();
            		List<OpenAccount> openAccounts = openAccountsList.parallelStream().filter(e -> e.getOpenNumber().equals(mobile)).collect(Collectors.toList());
            		if (openAccounts != null && openAccounts.size() > 0) {
            			System.out.println("数据库已经存在了此账号了WWWWWWWWWWW");
            			openAccountList.get(i).setStatus(0);
            			recordlogsService.update(openAccountList.get(i));
            			return ;
            		}
            		
            		OpenAccount openAccount = new OpenAccount();
            		openAccount.setBeautifulyard(openAccountList.get(i).getBeautifulYard());
            		openAccount.setCity(String.valueOf(openAccountList.get(i).getCityCode()));
            		openAccount.setProvince(String.valueOf(openAccountList.get(i).getProvinceCode()));
            		openAccount.setCompanyCode(openAccountList.get(i).getCompanyCode());
            		openAccount.setCreateTime(new Date());
//            		openAccount.setKefumobile(openAccountList.get(i).get);
            		openAccount.setMarket(openAccountList.get(i).getMarket());
            		openAccount.setOpenNumber(openAccountList.get(i).getMobile());
            		openAccount.setPayDate(openAccountList.get(i).getPayDate());
            		openAccount.setRemark(openAccountList.get(i).getRemark());
            		openAccount.setShopCount(openAccountList.get(i).getOpenShopAmount());
            		openAccount.setStatus(1);
            		openAccount.setZongbuAddress(openAccountList.get(i).getZongbuAddress());
            		System.out.println("存入开通账号表FFFFFFFFFFFFFFFFFFFF"+openAccount);
            		try {
						openAccountService.insert(openAccount);
						openAccountList.get(i).setStatus(0);
						recordlogsService.update(openAccountList.get(i));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
            	}
            	//循环log日志的存入到店的表
            	for (int s = 0; s < openShopList.size(); s++) {
            		String shopCode = openShopList.get(s).getShopCode();
            		
            		 List<Shop> openShop = shopsList.parallelStream().filter(e -> e.getShopcode().equals(shopCode)).collect(Collectors.toList());
            		
            		if (openShop != null && openShop.size() > 0) {
            			System.out.println("添加店的code已经存在了");
            			openShopList.get(s).setStatus(0);
            			recordlogsService.update(openShopList.get(s));
            			return ;
            		}
            		
            		Shop shop = new Shop();
            		shop.setAccountId(openShopList.get(s).getAccountId());
            		shop.setAddress(openShopList.get(s).getDetailAddressShop());
            		shop.setBeginDate(openShopList.get(s).getStartDate());
            		shop.setCity(String.valueOf(openShopList.get(s).getCityCodeShop()));
            		shop.setContractId(0);
            		shop.setCreateTime(new Date());
            		shop.setDuration(openShopList.get(s).getDuration());
            		shop.setEndDate(openShopList.get(s).getEndDate());
            		shop.setGiveAway(String.valueOf(openShopList.get(s).getGiveAway()));
            		shop.setProvince(String.valueOf(openShopList.get(s).getProvinceCodeShop()));
            		shop.setShopcode(openShopList.get(s).getShopCode());
            		shop.setShopName(openShopList.get(s).getShopName());
            		System.out.println("存入开店GGGGGGGGGGGGGGGGG"+shop);
            		try {
						shopService.insert(shop);
						openShopList.get(s).setStatus(0);
						recordlogsService.update(openShopList.get(s));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
            	}
            	
            }  
        };  
        ScheduledExecutorService service = Executors  
                .newSingleThreadScheduledExecutor();  
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        service.scheduleAtFixedRate(runnable, 1, 60*24, TimeUnit.SECONDS);  
       
    }
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
    	 System.out.println("4444444444444");
    	 //启动获取省市列表
    	 QueryParameter queryParameter = new QueryParameter();
    	 List<AddressAreaDef> addressAreaDefs = addressAreaDefService.searchList(queryParameter);
    	 addressAreaDefList = addressAreaDefs;
    	 getProvinceAndCity();
    	 
    	 //员工的列表
    	 QueryParameter queryParameter1 = new QueryParameter();
     	 queryParameter1.eq("status","1");
     	 List<Employee> employeesList = employeeService.searchList(queryParameter1);
     	 employeeList = employeesList;
     	 //参数列表
     	 argsList = argserService.searchList(queryParameter1);
     	 //销售总监列表
     	 QueryParameter queryParameter2 = new QueryParameter();
     	 queryParameter2.eq("gangwei", "xszj");
     	 List<UserInfo> userInfosList = userInfoService.searchList(queryParameter2);
     	 userInfoList = userInfosList;
     	 //销售所有
     	 QueryParameter queryParameter3 = new QueryParameter();
     	queryParameter3.eq("gangwei", "xszj");
     	queryParameter3.or();
//     	 queryParameter3.eq("gangwei", "xszl");
//     	 queryParameter3.or();
     	queryParameter3.eq("gangwei", "BD");
     	queryParameter3.or();
     	queryParameter3.eq("gangwei", "gjBD");
     	 List<UserInfo> userInfosListxs = userInfoService.searchList(queryParameter3);
     	 userInfosListAllxs = userInfosListxs;
    }
    //省份和城市
    public static  List<AddressAreaDef> getProvinceAndCity(){
    	
    	return addressAreaDefList;
    	
    }
    //员工列表
   public static  List<Employee> getEmployeeList(){
    	
    	return employeeList;
    	
    }
   public static  List<Args> getArgList(){
   	
   	return argsList;
   	
   }
   public static  List<UserInfo> getUserInfoList(){
	   
	   return userInfoList;
	   
   }
   public static  List<UserInfo> getUserInfoListxs(){
	   
	   return userInfosListAllxs;
	   
   }
 
}