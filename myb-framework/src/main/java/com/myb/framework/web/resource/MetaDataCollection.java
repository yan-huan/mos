package com.myb.framework.web.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.myb.framework.config.ConfigManager;
import com.myb.framework.config.FileItem;
import com.myb.framework.config.PageReference;

public class MetaDataCollection {

	private String path;
	
	private MetaDataCss metaDataCss;
	
	public MetaDataCss getMetaDataCss() {
		return metaDataCss;
	}

	public MetaDataJs getMetaDataJs() {
		return metaDataJs;
	}



	private MetaDataJs metaDataJs;
	
	private HttpServletRequest request;


	public MetaDataCollection(HttpServletRequest request) throws IOException {
		this.request=request;
		this.path = request.getServletPath();
		Init();
	}

	public void Init() throws IOException {
		
		loadJS();
		loasCSS();
	}

	private void loasCSS() throws IOException {
		
		metaDataCss=new MetaDataCss(this.request);
		metaDataCss.setItems(new ArrayList<FileItem>());
		
		List<String> cssReferenceList= new ArrayList<String>();
		for (String cssReference : ConfigManager.getRSConfig().getRsCommon().getCssReference()) {
			cssReferenceList.add(cssReference);
		}
		
		for (PageReference pageReference : ConfigManager.getRSConfig().getPages()) {
			if(this.path.equals(pageReference.getPath()))
			{
				if(pageReference.getCssReference()!=null)
				{
					for (String cssReference : pageReference.getCssReference()) {
						cssReferenceList.add(cssReference);
					}
				}
			}
		}
		
		for (String cssReference : cssReferenceList) {
			for (FileItem fileItem : ConfigManager.getRSConfig().getRsFiles().getCssFiles()) {
				if(fileItem.getName().equals(cssReference))
				{
					metaDataCss.getItems().add(fileItem);
				}
			}
		}
        
	}
	
	

	private void loadJS() throws IOException {
		metaDataJs=new MetaDataJs(this.request);
		metaDataJs.setItems(new ArrayList<FileItem>());
		
		List<String> jsReferenceList= new ArrayList<String>();
		for (String jsReference : ConfigManager.getRSConfig().getRsCommon().getJsReference()) {
			jsReferenceList.add(jsReference);
		}
		
		for (PageReference pageReference : ConfigManager.getRSConfig().getPages()) {
			if(this.path.equals(pageReference.getPath()))
			{
				if(pageReference.getJsReference()!=null)
				{
					for (String jsReference : pageReference.getJsReference()) {
						jsReferenceList.add(jsReference);
					}
				}
			}
		}
		
		for (String jsReference : jsReferenceList) {
			for (FileItem fileItem : ConfigManager.getRSConfig().getRsFiles().getJsFiles()) {
				if(fileItem.getName().equals(jsReference))
				{
					metaDataJs.getItems().add(fileItem);
				}
			}
		}

	}

}
