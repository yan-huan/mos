package com.myb.framework.config;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class RSFiles {
	
	@XStreamImplicit(itemFieldName="js")
	private List<FileItem> jsFiles;
	
	@XStreamImplicit(itemFieldName="css")
	private List<FileItem> cssFiles;

	public List<FileItem> getJsFiles() {
		return jsFiles;
	}

	public void setJsFiles(List<FileItem> jsFiles) {
		this.jsFiles = jsFiles;
	}

	public List<FileItem> getCssFiles() {
		return cssFiles;
	}

	public void setCssFiles(List<FileItem> cssFiles) {
		this.cssFiles = cssFiles;
	}

}



