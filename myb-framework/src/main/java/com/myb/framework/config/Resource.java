package com.myb.framework.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Resource")
public class Resource
{
    @XStreamAlias("Css")
    private ResourceItem css;
    

    @XStreamAlias("Img")
    private ResourceItem img;
   

    public ResourceItem getCss() {
		return css;
	}


	public void setCss(ResourceItem css) {
		this.css = css;
	}


	public ResourceItem getImg() {
		return img;
	}


	public void setImg(ResourceItem img) {
		this.img = img;
	}


	public ResourceItem getJs() {
		return js;
	}


	public void setJs(ResourceItem js) {
		this.js = js;
	}



	@XStreamAlias("Js")
    private ResourceItem js;
    

 
}