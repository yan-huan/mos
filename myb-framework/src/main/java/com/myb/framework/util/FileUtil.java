package com.myb.framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileUtil {
	
	public static void write(String path, String str,boolean append) {
		File file = new File(path);

		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				System.out.println("exits");
			}
		}

		 try {
	            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path,append),"UTF-8");
	            out.write(str);
	            out.flush();
	            out.close();
	        } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e){
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    
	}
	
	public static String read(String path)  {
		StringBuffer sb=new StringBuffer();
		File file = new File(path);
		if(file.exists())
		{
			try {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");

		        BufferedReader br=new BufferedReader(isr);
		        String s;
		        while((s=br.readLine())!=null){
		            sb.append(s).append("\n");
		        }
		        br.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
