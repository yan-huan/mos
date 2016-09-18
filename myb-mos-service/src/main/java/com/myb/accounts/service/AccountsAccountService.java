package com.myb.accounts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myb.entity.pojo.accounts.AccountsAccount;
import com.myb.entity.pojo.mos.Area;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service
public interface AccountsAccountService {

	
	  public int insert(AccountsAccount accountsAccount);

	    public int update(AccountsAccount accountsAccount);

	    public int delete(int areaId);

	    public Area searchByAreaId(int areaId);

	    public PagedList<AccountsAccount> searchByPage(QueryCondition queryCondition);

	    public List<AccountsAccount> searchList(QueryParameter queryParameter);
	
}
