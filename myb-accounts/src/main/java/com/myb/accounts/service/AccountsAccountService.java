package com.myb.accounts.service;

import com.alibaba.fastjson.JSONObject;
import com.myb.commons.dto.DataTransferObject;
import com.myb.entity.pojo.accounts.AccountsAccount;

public interface AccountsAccountService {

	public DataTransferObject<AccountsAccount> searchUserByJson(JSONObject obj);
}
