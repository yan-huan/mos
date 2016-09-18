package com.myb.framework.data;

public class QueryCondition {
	private int pageIndex;
	
	private int pageSize;
	
	private QueryParameter queryParameter;
	
	private SortParameter sortParameter;

	public QueryParameter getQueryParameter() {
		if(queryParameter==null)
		{
			queryParameter=new QueryParameter();
		}
		return queryParameter;
	}

	public void setQueryParameter(QueryParameter queryParameter) {
		this.queryParameter = queryParameter;
	}
	public SortParameter getSortParameter() {
		if(sortParameter==null)
		{
			sortParameter=new SortParameter();
		}
		return sortParameter;
	}

	public void setSortParameter(SortParameter sortParameter) {
		this.sortParameter = sortParameter;
	}


	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
