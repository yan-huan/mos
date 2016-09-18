package com.myb.framework.web.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.myb.framework.config.ConfigManager;
import com.myb.framework.config.FileItem;
import com.myb.framework.web.UrlManager;
import com.myb.framework.util.StringUtil;

public class MetaDataJs {
	private List<FileItem> items;
	
	private HttpServletRequest request;
	
	public MetaDataJs(HttpServletRequest request)
	{
		this.request=request;
	}

	public List<FileItem> getItems() {
		return items;
	}

	public void setItems(List<FileItem> items) {
		this.items = items;
	}
	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (this.items != null) {
			try {
				if (ConfigManager.getAppConfig().getResource().getJs()
						.getMerge() == true) {
					sb.append(mergeJs());
				} else {
					for (FileItem fileItem : this.items) {
						MetaDataScript metaDataScript = new MetaDataScript();
						String host="";
						if(fileItem.getPathType()== FileItem.PathType.NETWORK)
						{
							host=ConfigManager.getAppConfig().getResource().getJs().getAddress();
						}
						else {
							host= UrlManager.BuilrHost(request);
						}
						metaDataScript.setSrc(UrlManager.buildResource(fileItem.getPath(), host, fileItem.getVersion()));
						metaDataScript.setType("text/javascript");
						
						sb.append(metaDataScript.toString());
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

	private String mergeJs() throws IOException {
		StringBuilder sb = new StringBuilder();
		StringBuilder jsFileString = new StringBuilder();
		for (FileItem fileItem : this.items) {
			if (fileItem.getPathType() == FileItem.PathType.NETWORK) {
				jsFileString.append(MergeHelper.mergePathVersions(fileItem))
						.append(",");
			} else {
				MetaDataScript metaDataScript = new MetaDataScript();
				metaDataScript.setSrc(UrlManager.buildResource(fileItem.getPath(), UrlManager.BuilrHost(request), fileItem.getVersion()));
				metaDataScript.setType("text/javascript");

				sb.append(metaDataScript.toString());
			}
		}

		MetaDataScript metaDataScript = new MetaDataScript();

		metaDataScript.setSrc(UrlManager.buildResource("/js.ashx?href="
				+ StringUtil.trimEnd(jsFileString.toString(), ","),ConfigManager.getAppConfig().getResource().getJs().getAddress(),""));
		metaDataScript.setType("text/javascript");

		if (jsFileString.length() > 0) {
			sb.append(metaDataScript.toString());
		}
		return sb.toString();
	}


}
