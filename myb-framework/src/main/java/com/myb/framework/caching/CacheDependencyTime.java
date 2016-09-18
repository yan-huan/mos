package com.myb.framework.caching;

import java.util.Date;

public class CacheDependencyTime implements ICacheDependency {
	
	
	private Date expires;

	public CacheDependencyTime(Date expires) 
	{
		this.expires=expires;
		
		
	}
	

	public boolean isTimeOut()
	{
		boolean isTimeOut=true;
		if(expires.after(new Date()))
		{
			isTimeOut=false;
					
		}
		return isTimeOut;
	}

}
