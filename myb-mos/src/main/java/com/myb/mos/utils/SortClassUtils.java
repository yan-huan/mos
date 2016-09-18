package com.myb.mos.utils;

import java.util.Comparator;

import com.myb.entity.pojo.mos.Args;
import com.myb.entity.pojo.mos.OpenAccount;

public class SortClassUtils<T> implements Comparator{  
	   public int compare(Object arg0,Object arg1){  
		   OpenAccount OpenAccount0 = (OpenAccount)arg0;  
		   OpenAccount OpenAccount1 = (OpenAccount)arg1;  
	        int flag = OpenAccount1.getUpdateDate().compareTo(OpenAccount0.getUpdateDate());  
	        return flag;  
	    }  
	  
}  