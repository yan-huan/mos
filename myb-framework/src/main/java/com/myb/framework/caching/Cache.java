package com.myb.framework.caching;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cache {
	
	private static Map<String, CacheItem> cacheMap=new HashMap<String, CacheItem>();
	
	public static void set(String key, Object value, String fileName) throws IOException
	{
		ICacheDependency cacheDependency=new CacheDependencyFile(fileName);
		CacheItem cacheItem=new CacheItem(key, value, cacheDependency);
		cacheMap.put(key, cacheItem);
	}
	
	public static void set(String key, Object value, Date expires) 
	{
		ICacheDependency cacheDependency=new CacheDependencyTime(expires);
		CacheItem cacheItem=new CacheItem(key, value, cacheDependency);
		cacheMap.put(key, cacheItem);
	}
	
	
	@SuppressWarnings("unchecked")
	public static  <T> T get(String key,Class<T> c)
	{
		CacheItem cacheItem=cacheMap.get(key);
	
		T value=null;
		if(cacheItem!=null)
		{
			if(!cacheItem.getCacheDependency().isTimeOut())
			{
				Object object=cacheItem.getValue();
				if(object!=null)
				{
					value=(T)object;
				}
			}
			else {
				cacheMap.remove(key);
			}
		}
		 
		return value;
	}
	
	public static  Object get(String key)
	{
		CacheItem cacheItem=cacheMap.get(key);
	
		Object value=null;
		if(cacheItem!=null)
		{
			if(!cacheItem.getCacheDependency().isTimeOut())
			{
				value=cacheItem.getValue();
			}
			else {
				cacheMap.remove(key);
			}
		}
		 
		return value;
	}

}
