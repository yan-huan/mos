package com.myb.framework.caching;

import java.io.File;
import java.io.IOException;

public class CacheDependencyFile implements ICacheDependency {
	
	
	private String fileName;
	
	private File file;
	
	private long fileLength=0;
	
	private long fileLastModified;

	public String getFileName() {
		return fileName;
	}

	public void setFile(String fileName) {
		this.fileName = fileName;
	}
	
	public File getFile() {
		return file;
	}

	public CacheDependencyFile(String fileName) throws IOException
	{
		this.fileName=fileName;
		file=new File(fileName);
		if (!file.getParentFile().exists()) {
			if (file.getParentFile().mkdirs()) {
				
			}
		}
		if(!file.exists())
		{
			file.createNewFile();
		}
		fileLength=file.length();
		fileLastModified=file.lastModified();
		
		
	}
	

	public boolean isTimeOut()
	{
		boolean isTimeOut=true;
		File newFile=new File(fileName);
		if(newFile.length()==fileLength&&newFile.lastModified()==fileLastModified)
		{
			isTimeOut=false;
					
		}
		return isTimeOut;
	}

}
