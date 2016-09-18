package com.myb.framework.web.resource;

public class MetaDataScript {
	private String type;
	private String src;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	public String toString()
	{
		return String.format("<script src=\"%1$s\" type=\"%2$s\"></script>",this.src,this.type);
	}

}
