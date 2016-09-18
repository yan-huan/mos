package com.myb.framework.web.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.myb.framework.config.ConfigManager;
import com.myb.framework.config.FileItem;
import com.myb.framework.util.StringUtil;
import com.myb.framework.web.UrlManager;

public class MetaDataCss {

	private List<FileItem> items;
	
	private HttpServletRequest request;

	public List<FileItem> getItems() {
		return items;
	}

	public void setItems(List<FileItem> items) {
		this.items = items;
	}
	
	public MetaDataCss(HttpServletRequest request) {
		this.request=request;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (this.items != null) {
			try {
				if (ConfigManager.getAppConfig().getResource().getCss()
						.getMerge() == true) {
					sb.append(mergeCss());
				} else {
					for (FileItem fileItem : this.items) {
						MetaDataLink metaDataLink = new MetaDataLink();
						String host="";
						if(fileItem.getPathType()== FileItem.PathType.NETWORK)
						{
							host=ConfigManager.getAppConfig().getResource().getCss().getAddress();
						}
						else {
							host= UrlManager.BuilrHost(request);
						}
						metaDataLink.setHref(UrlManager.buildResource(fileItem.getPath(), host,fileItem.getVersion()));
						metaDataLink.setMedia("all");
						metaDataLink.setRel("stylesheet");
						metaDataLink.setType("text/css");

						sb.append(metaDataLink.toString());
						// sb.AppendLine(WebReFile.GetMetadataLink(metaDataLink));
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sb.toString();

	}

	private String mergeCss() throws IOException {
		StringBuilder sb = new StringBuilder();
		StringBuilder cssFileString = new StringBuilder();
		for (FileItem fileItem : this.items) {
			if (fileItem.getPathType() == FileItem.PathType.NETWORK) {
				cssFileString.append(MergeHelper.mergePathVersions(fileItem))
						.append(",");
			} else {
				MetaDataLink metaDataLink = new MetaDataLink();
				metaDataLink.setHref(UrlManager.buildResource(fileItem.getPath(), UrlManager.BuilrHost(request),fileItem.getVersion()));
				metaDataLink.setMedia("all");
				metaDataLink.setRel("stylesheet");
				metaDataLink.setType("text/css");

				sb.append(metaDataLink.toString());
			}
		}

		MetaDataLink metaDataLink = new MetaDataLink();

		metaDataLink.setHref(UrlManager.buildResource("/css.ashx?href="
				+ StringUtil.trimEnd(cssFileString.toString(), ","),ConfigManager.getAppConfig().getResource().getCss().getAddress(),""));
		metaDataLink.setMedia("all");
		metaDataLink.setRel("stylesheet");
		metaDataLink.setType("text/css");
		if (cssFileString.length() > 0) {
			sb.append(metaDataLink.toString());
		}
		return sb.toString();
	}

}
