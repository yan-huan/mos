package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.CrmVisitrecordDao;
import com.myb.accounts.service.CrmVisitrecordService;
import com.myb.entity.pojo.mos.CrmVisitrecord;
import com.myb.framework.data.EntityBase;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("crmVisitrecordService")
public class CrmVisitrecordServiceImpl implements CrmVisitrecordService{

    @Autowired
    private CrmVisitrecordDao crmVisitrecordDao;

    public int insert(CrmVisitrecord crmVisitrecord)
    {
        return crmVisitrecordDao.insert(crmVisitrecord);
    }
    public int update(CrmVisitrecord crmVisitrecord)
    {
        return crmVisitrecordDao.update(crmVisitrecord);
    }

    public int delete(long id)
    {
        return crmVisitrecordDao.delete(id);
    }

    public CrmVisitrecord searchById(long id) {
        return crmVisitrecordDao.searchById(id);
    }
    public PagedList<CrmVisitrecord> searchByPage(QueryCondition queryCondition)
    {
        return crmVisitrecordDao.searchByPage(queryCondition);
    }
    public List<CrmVisitrecord> searchList(QueryParameter queryParameter)
    {
        return crmVisitrecordDao.searchList(queryParameter);
    }
	@Override
	public <T extends EntityBase> List<T> searchListByCondition(
			QueryParameter queryParameter, String tableName, Class<T> t,int empId) {
		
		return crmVisitrecordDao.searchListByCondition(queryParameter, tableName, t,empId);
	}
}

