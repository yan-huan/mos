package com.myb.framework.data;

import java.util.List;

public class PagedList<T extends EntityBase> {
	
	private int pageIndex;
	
	private int pageSize;
	
	private List<T> content;
	
	private int recordCount;
	
	private int totalPage;

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
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

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
	
	public PagedList(int pageIndex,int pageSize,int recordCount,List<T> content) {
		this.pageIndex=pageIndex;
		this.pageSize=pageSize;
		this.recordCount=recordCount;
		this.content=content;
		this.totalPage = recordCount%pageSize==0 ? recordCount/pageSize : recordCount/pageSize + 1;
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public PagedList() {

	}

}
