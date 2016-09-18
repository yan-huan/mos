package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.OpenAccountDao;
import com.myb.accounts.service.OpenAccountService;
import com.myb.accounts.vo.DistinctVO;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("openAccountService")
public class OpenAccountServiceImpl implements OpenAccountService{

    @Autowired
    private OpenAccountDao openAccountDao;

    public int insert(OpenAccount openAccount)
    {
        return openAccountDao.insert(openAccount);
    }
    
    public int update(OpenAccount openAccount)
    {
        return openAccountDao.update(openAccount);
    }

    public int delete(int accountId)
    {
        return openAccountDao.delete(accountId);
    }

    public OpenAccount searchByAccountId(int accountId) {
        return openAccountDao.searchByAccountId(accountId);
    }
    public PagedList<OpenAccount> searchByPage(QueryCondition queryCondition)
    {
        return openAccountDao.searchByPage(queryCondition);
    }
    public List<OpenAccount> searchList(QueryParameter queryParameter)
    {
        return openAccountDao.searchList(queryParameter);
    }
    public OpenAccount searchByMobile(String mobile)
    {
        return openAccountDao.searchByMobile(mobile);
    }

	@Override
	public List<OpenAccount> searchDistinct(QueryCondition queryCondition, String column) {
		
		return openAccountDao.searchDistinct(queryCondition,column );
	}
	
    
}

