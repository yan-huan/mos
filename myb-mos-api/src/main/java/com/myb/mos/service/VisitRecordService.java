package com.myb.mos.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.VisitRecord;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;
@Service
public interface VisitRecordService {


    public int insert(VisitRecord visitRecord);

    public int update(VisitRecord visitRecord);

    public int delete(long id);

    public VisitRecord searchById(long id);

    public PagedList<VisitRecord> searchByPage(QueryCondition queryCondition);

    public List<VisitRecord> searchList(QueryParameter queryParameter);
}

