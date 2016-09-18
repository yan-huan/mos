package com.myb.framework.data;

import java.util.ArrayList;
import java.util.List;


import com.myb.framework.util.StringUtil;


public class SortParameter {
	
	private List<SqlSort> sortList;
	
	public SortParameter()
	{
		sortList=new ArrayList<SqlSort>();
	}
	
	public SortParameter add(SqlSort sort)
	{
		this.sortList.add(sort);
		return this;
	}
	
	public SortParameter add(String field,SqlOrder sqlOrder)
	{
		SqlSort sort=new SqlSort(field, sqlOrder);
		this.sortList.add(sort);
		return this;
	}
	
	public String toSql()
	{
		StringBuffer sb =new StringBuffer();
		for(SqlSort sort:sortList)
		{
			sb.append(String.format("%1$s %2$s,", sort.getField(),sort.getSqlOrder().toString()));
		}
		String orderString= StringUtil.trimEnd(sb.toString(), ",");
		if(!StringUtil.isNullOrEmpty(orderString))
		{
			orderString=" ORDER BY "+orderString;
		}
		return  orderString;
	}

	public List<SqlSort> getSortList() {
		return sortList;
	}

}
