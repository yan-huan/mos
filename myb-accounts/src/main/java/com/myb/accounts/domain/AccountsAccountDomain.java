package com.myb.accounts.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myb.accounts.dao.AccountsAccountDao;
import com.myb.entity.pojo.accounts.AccountsAccount;

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

	public AccountsAccount searchById(int id) {	
		//具体的业务处理
		AccountsAccount accountsAccount = accountsAccountDao.searchById(id);
		return accountsAccount;
	}

}
