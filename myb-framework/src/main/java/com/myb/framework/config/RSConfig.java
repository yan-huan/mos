package com.myb.framework.config;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("RSConfig")
public class RSConfig {
	

	@XStreamAlias("RSFiles")
	private RSFiles rsFiles;

	@XStreamAlias("Common")
	private PageReference rsCommon;

	@XStreamAlias("pages")

	private List<PageReference> pages;
	
	public RSFiles getRsFiles() {
		return rsFiles;
	}

	public void setRsFiles(RSFiles rsFiles) {
		this.rsFiles = rsFiles;
	}

	public PageReference getRsCommon() {
		return rsCommon;
	}

	public void setRsCommon(PageReference rsCommon) {
		this.rsCommon = rsCommon;
	}

	public List<PageReference> getPages() {
		return pages;
	}

	public void setPages(List<PageReference> pages) {
		this.pages = pages;
	}
}