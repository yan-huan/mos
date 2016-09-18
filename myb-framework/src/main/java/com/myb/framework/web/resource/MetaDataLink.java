package com.myb.framework.web.resource;

import java.io.IOException;

import com.myb.framework.config.ConfigManager;
import com.myb.framework.config.FileItem;
import com.myb.framework.util.StringUtil;
import org.apache.commons.lang3.StringEscapeUtils;

public class MetaDataLink {
    private String title;
    private String href ;
    private String rel;
    private String type;
    private String media;
    private FileItem.PathType pathType;
    
    public FileItem.PathType getPathType() {
		return pathType;
	}
	public void setPathType(FileItem.PathType pathType) {
		this.pathType = pathType;
	}

	public String toString()
    {
        StringBuffer sb = new StringBuffer();
  
            sb.append("<link");
            if (!StringUtil.isNullOrEmpty(this.rel))
            {
                sb.append( String.format(" rel=\"%1$s\"", StringEscapeUtils.escapeHtml4(this.rel)));
            }
            if (!StringUtil.isNullOrEmpty(this.type))
            {
            	sb.append( String.format(" type=\"%1$s\"", StringEscapeUtils.escapeHtml4(this.type)));
            }
            if (!StringUtil.isNullOrEmpty(this.title))
            {
                sb.append( String.format(" title=\"%1$s\"", StringEscapeUtils.escapeHtml4(this.title)));
            }
            if (!StringUtil.isNullOrEmpty(this.href))
            {
            	if(pathType== FileItem.PathType.NETWORK)
            	{
            		try {
						sb.append( String.format(" href=\"%2$s/%1$s\"", StringEscapeUtils.escapeHtml4(this.href), ConfigManager.getAppConfig().getResource().getCss().getAddress()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            	else {
            		sb.append( String.format(" href=\"%1$s\"", StringEscapeUtils.escapeHtml4(this.href)));
				}
 
            }
            if (!StringUtil.isNullOrEmpty(this.media))
            {
            	sb.append( String.format(" media=\"%1$s\"", StringEscapeUtils.escapeHtml4(this.media)));
            }
            sb.append(" />");
        
        return sb.toString();
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}

}
