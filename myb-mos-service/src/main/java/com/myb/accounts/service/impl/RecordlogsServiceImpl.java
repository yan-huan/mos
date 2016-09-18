package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.RecordlogsDao;
import com.myb.accounts.service.RecordlogsService;
import com.myb.entity.pojo.mos.Recordlogs;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("recordlogsService")
public class RecordlogsServiceImpl implements RecordlogsService{

    @Autowired
    private RecordlogsDao recordlogsDao;

    public int insert(Recordlogs recordlogs)
    {
        return recordlogsDao.insert(recordlogs);
    }
    public int update(Recordlogs recordlogs)
    {
        return recordlogsDao.update(recordlogs);
    }

    public int delete(int logsId)
    {
        return recordlogsDao.delete(logsId);
    }

    public Recordlogs searchByLogsId(int logsId) {
        return recordlogsDao.searchByLogsId(logsId);
    }
    public PagedList<Recordlogs> searchByPage(QueryCondition queryCondition)
    {
        return recordlogsDao.searchByPage(queryCondition);
    }
    public List<Recordlogs> searchList(QueryParameter queryParameter)
    {
        return recordlogsDao.searchList(queryParameter);
    }
}

