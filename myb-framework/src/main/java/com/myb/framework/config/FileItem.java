package com.myb.framework.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class FileItem {
	
	@XStreamAsAttribute
	@XStreamAlias("name")
	private String name;

	@XStreamAsAttribute
	@XStreamAlias("path")
	private String path;

	@XStreamAsAttribute
	@XStreamAlias("version")
	private String version;
	
	
	@XStreamAsAttribute
	@XStreamAlias("pathType")
	private PathType pathType;
	
	public enum PathType {
		LOCAL,
		NETWORK
	}

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


	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public PathType getPathType() {
		return pathType;
	}

	public void setPathType(PathType pathType) {
		this.pathType = pathType;
	}


}
