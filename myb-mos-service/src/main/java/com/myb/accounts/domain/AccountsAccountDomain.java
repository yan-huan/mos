package com.myb.accounts.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myb.accounts.dao.AccountsAccountDao;
import com.myb.entity.pojo.accounts.AccountsAccount;
import com.myb.entity.pojo.mos.Area;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

/**
 * Description : 业务逻辑处理层 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年4月14日 下午5:41:33 <br/>
 * @version 1.0
 */
@Component
public class AccountsAccountDomain {
	
	@Autowired
    private AccountsAccountDao accountsAccountDao;

	 public int insert(AccountsAccount accountsAccount){
		 
		 return 0;
	 }

	   public int update(AccountsAccount accountsAccount) {
		   return 0;
	   }

	    public int delete(int areaId) {
	    	  return 0;
	    }

	    public Area searchByAreaId(int areaId){
	    	return null;
	    }

	    public PagedList<AccountsAccount> searchByPage(QueryCondition queryCondition) {
	    	PagedList<AccountsAccount>  pagedList =	accountsAccountDao.searchByPage(queryCondition, AccountsAccount.class);
	    	
	    	return pagedList;
	    }

	    public List<AccountsAccount> searchList(QueryParameter queryParameter) {
	    	return null;
	    }
	

}
