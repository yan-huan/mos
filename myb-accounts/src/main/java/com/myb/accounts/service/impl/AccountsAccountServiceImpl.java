package com.myb.accounts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.domain.AccountsAccountDomain;
import com.myb.accounts.service.AccountsAccountService;
import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.DataTransferObject;
import com.myb.commons.exception.dto.BusinessException;
import com.myb.commons.utils.ValidateUtil;
import com.myb.entity.pojo.accounts.AccountsAccount;

@Service("accountsAccountService")
public class AccountsAccountServiceImpl implements AccountsAccountService{
	
	@Autowired
	private AccountsAccountDomain accountsAccountDomain;

    
	public DataTransferObject<AccountsAccount> searchUserByJson(JSONObject obj) {
		DataTransferObject<AccountsAccount> dto = new DataTransferObject<AccountsAccount>();
		
		String id = obj.getString("id");
		ValidateUtil.validateNullProperty(id, CodeConst.USER_ID_NULL_ERROR, dto);
		
		if(CodeConst.SUCCESS.equals(dto.getCode())) {
			AccountsAccount user = accountsAccountDomain.searchById(Integer.parseInt(id));
			dto.setData(user);
		} else {
			throw new BusinessException(dto.getCode(), dto.getMsg());
		}
		
		return dto;
	}
	
}

