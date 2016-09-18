package com.myb.framework.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ResourceItem")
public class ResourceItem
{
	@XStreamAsAttribute
    @XStreamAlias("address")
    private String address;
	
	@XStreamAsAttribute
	@XStreamAlias("merge")
	private boolean merge;

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public boolean getMerge() {
		return merge;
	}


	public void setMerge(boolean merge) {
		this.merge = merge;
	}

	
	/*
	@XStreamAsAttribute
    @XStreamAlias("secureAddress")
	private String secureAddress;
    */

	/*
	public String getSecureAddress() {
		return secureAddress;
	}

	public void setSecureAddress(String secureAddress) {
		this.secureAddress = secureAddress;
	}
	 */
	
}