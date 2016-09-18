package com.myb.framework.caching;


public class CacheItem {
	
	private String key;
	
	private Object value;
	
	private ICacheDependency cacheDependency;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ICacheDependency getCacheDependency() {
		return cacheDependency;
	}

	public void setCacheDependency(ICacheDependency cacheDependency) {
		this.cacheDependency = cacheDependency;
	}
	
	public CacheItem(String key,Object value,ICacheDependency cacheDependency) {
		this.key=key;
		this.value=value;
		this.cacheDependency=cacheDependency;
		
	}
	
	public CacheItem(String key,Object value) {
		this.key=key;
		this.value=value;
		this.cacheDependency=null;
	}
	




}
