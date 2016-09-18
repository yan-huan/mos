package com.myb.mos.utils;



import org.xutils.x;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

/**
 * Created by dabing on 16/4/11.
 */
public class HttpHelper {
	private static   Callback.CommonCallback callBack;
    
    public static void main(String[] args) {
    	String url = "http://192.168.2.98:8080/myb-mos/contract/test.jhtml";
//    	RequestParams requestParams = new RequestParams("http://192.168.2.98:8080/myb-mos/contract/test.jhtml");
//    	  RequestParams params = new RequestParams(url);
//          params.setMultipart(true);
    	  
//          params.addParameter("address", "北极");
//          params.addBodyParameter("aaa", "2");
          x.http().post(new RequestParams(),callBack );
    	
    	
	}
}
