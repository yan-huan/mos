package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.CrmUserinfoDao;
import com.myb.accounts.service.CrmUserinfoService;
import com.myb.entity.pojo.mos.CrmUserinfo;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("crmUserinfoService")
public class CrmUserinfoServiceImpl implements CrmUserinfoService{

    @Autowired
    private CrmUserinfoDao crmUserinfoDao;

    public int insert(CrmUserinfo crmUserinfo)
    {
        return crmUserinfoDao.insert(crmUserinfo);
    }
    public int update(CrmUserinfo crmUserinfo)
    {
        return crmUserinfoDao.update(crmUserinfo);
    }

    public PagedList<CrmUserinfo> searchByPage(QueryCondition queryCondition)
    {
        return crmUserinfoDao.searchByPage(queryCondition);
    }
    public List<CrmUserinfo> searchList(QueryParameter queryParameter)
    {
        return crmUserinfoDao.searchList(queryParameter);
    }
	@Override
	public int delete(int  id) {
		return crmUserinfoDao.delete(id);
	}
	@Override
	public CrmUserinfo searchById(int id) {
		
		  return crmUserinfoDao.searchById(id);
	}
}

