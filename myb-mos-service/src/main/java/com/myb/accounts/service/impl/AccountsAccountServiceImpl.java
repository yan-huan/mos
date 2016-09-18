package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.dao.AccountsAccountDao;
import com.myb.accounts.domain.AccountsAccountDomain;
import com.myb.accounts.service.AccountsAccountService;
import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.DataTransferObject;
import com.myb.commons.exception.dto.BusinessException;
import com.myb.commons.utils.ValidateUtil;
import com.myb.entity.pojo.accounts.AccountsAccount;
import com.myb.entity.pojo.mos.Area;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("accountsAccountService")
public class AccountsAccountServiceImpl implements AccountsAccountService{
	
	@Autowired
	private AccountsAccountDomain accountsAccountDao;

	@Override
	public int insert(AccountsAccount accountsAccount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AccountsAccount accountsAccount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int areaId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Area searchByAreaId(int areaId) {
		return null;
	}

	@Override
	public PagedList<AccountsAccount> searchByPage(QueryCondition queryCondition) {
		PagedList<AccountsAccount> pagedList = accountsAccountDao.searchByPage(queryCondition);
		return pagedList;
	}

	@Override
	public List<AccountsAccount> searchList(QueryParameter queryParameter) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

