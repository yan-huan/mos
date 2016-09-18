package com.myb.framework.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;


public class ConfigFile {
	
	@XStreamAsAttribute
	@XStreamAlias("name")
	private String name;
	
	@XStreamAsAttribute
	@XStreamAlias("path")
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
