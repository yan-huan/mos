package com.myb.framework.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("AppConfig")
public class AppConfig {

    @XStreamAlias("SiteId")
    private String siteId;
    
    @XStreamAlias("SiteName")
    private String siteName;
    
    //@XStreamAlias("SiteInfo")
    //private SiteInfo SiteInfo;
    
    @XStreamAlias("Resource")
    private Resource resource;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
