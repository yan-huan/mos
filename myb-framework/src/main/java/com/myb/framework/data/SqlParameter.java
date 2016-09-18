package com.myb.framework.data;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlParameter {
	
	private Map<String, Object> parameters=new HashMap<String, Object>();
	
	private List<Object> values=null;
	
	public void add(String parameterName,Object value)
	{
		parameters.put(parameterName, value);
	}
	
	public String replaceParameters(String sql) {

		values= new ArrayList<Object>();
	  
	    String patternString = "\\@\\{(?<pname>" + joinParameterName(parameters.keySet()) + ")\\}";

	    Pattern pattern = Pattern.compile(patternString); 
	    Matcher matcher = pattern.matcher(sql); 

	    StringBuffer sb = new StringBuffer(); 
	    
	    while(matcher.find()) { 
	        matcher.appendReplacement(sb,"?"); 
	        values.add(parameters.get(matcher.group("pname")));
	    } 
	    matcher.appendTail(sb); 
 
	    return sb.toString();
	}
	
	public Object[] getValues() {
		return values.toArray();
	}

	public Map<String, Object> getParameters()
	{
		return parameters;
	}

	private String joinParameterName(Set<String> keys) {
		int len=keys.size();
		int i=0;
		StringBuffer sbBuffer=new StringBuffer();
		for (String str : keys) {  
			sbBuffer.append(str);
			if(i!=len-1)
			{
				sbBuffer.append("|");
			}
		    i++;
		}  
		return sbBuffer.toString();
		
	}
		


}
