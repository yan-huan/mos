package com.myb.mos.VO;

import java.util.List;

import com.myb.framework.data.EntityBase;

public class ShopList <T extends EntityBase>{
	private List<T> content;
	
	private int recordCount;
	
	private int totalPage;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
