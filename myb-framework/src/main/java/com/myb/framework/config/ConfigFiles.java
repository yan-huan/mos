package com.myb.framework.config;

import java.util.List;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("ConfigFiles")
public class ConfigFiles {
	
	public void setItems(List<ConfigFile> items) {
		this.items = items;
	}

	@XStreamImplicit(itemFieldName="ConfigFile")
	private List<ConfigFile> items;
	
	public ConfigFile get(String name) {
		ConfigFile configFile=null;
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().equals(name))
			{
				configFile=items.get(i);
			}
		}
		return configFile;
	}

}
