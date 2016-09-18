package com.myb.framework.config;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("page")
public class PageReference {
	
	@XStreamAsAttribute
    @XStreamAlias("path")
    private String path;
    

    @XStreamImplicit(itemFieldName="js")
    private List<String> JsReference;
    
    @XStreamImplicit(itemFieldName="css")
    private List<String> CssReference;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<String> getJsReference() {
		return JsReference;
	}

	public void setJsReference(List<String> jsReference) {
		JsReference = jsReference;
	}

	public List<String> getCssReference() {
		return CssReference;
	}

	public void setCssReference(List<String> cssReference) {
		CssReference = cssReference;
	}
    
    
}
