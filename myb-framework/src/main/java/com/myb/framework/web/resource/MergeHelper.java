package com.myb.framework.web.resource;

import com.myb.framework.config.FileItem;
import com.myb.framework.util.StringUtil;

public class MergeHelper {
	
	public static String mergePathVersions(FileItem fileItem) {
		String path="";
	   	if (StringUtil.isNullOrEmpty(fileItem.getVersion()))
        {
	   		path= fileItem.getPath();
        }
        else
        {
            String start=fileItem.getPath().substring(0,fileItem.getPath().lastIndexOf("."));
            String end=fileItem.getPath().substring(fileItem.getPath().lastIndexOf("."));
            path=start+"._V" + fileItem.getVersion() + "_"+end;
        }	
	   	return path;
	}

}
