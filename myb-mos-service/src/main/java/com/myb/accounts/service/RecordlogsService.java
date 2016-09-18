package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Recordlogs;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface RecordlogsService {


    public int insert(Recordlogs recordlogs);

    public int update(Recordlogs recordlogs);

    public int delete(int logsId);

    public Recordlogs searchByLogsId(int logsId);

    public PagedList<Recordlogs> searchByPage(QueryCondition queryCondition);

    public List<Recordlogs> searchList(QueryParameter queryParameter);
}

