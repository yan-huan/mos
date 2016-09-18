package com.myb.mos.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.VisitRecord;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.dao.VisitRecordDao;
import com.myb.mos.service.VisitRecordService;
import com.myb.framework.data.QueryCondition;


@Service("visitRecordService")
public class VisitRecordServiceImpl implements VisitRecordService{

    @Autowired
    private VisitRecordDao visitRecordDao;

    public int insert(VisitRecord visitRecord)
    {
        return visitRecordDao.insert(visitRecord);
    }
    public int update(VisitRecord visitRecord)
    {
        return visitRecordDao.update(visitRecord);
    }

    public int delete(long id)
    {
        return visitRecordDao.delete(id);
    }

    public VisitRecord searchById(long id) {
        return visitRecordDao.searchById(id);
    }
    public PagedList<VisitRecord> searchByPage(QueryCondition queryCondition)
    {
        return visitRecordDao.searchByPage(queryCondition);
    }
    public List<VisitRecord> searchList(QueryParameter queryParameter)
    {
        return visitRecordDao.searchList(queryParameter);
    }
}

