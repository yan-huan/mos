package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Duty;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface DutyService {


    public int insert(Duty duty);

    public int update(Duty duty);

    public int delete(int dutyId);

    public Duty searchByDutyId(int dutyId);

    public PagedList<Duty> searchByPage(QueryCondition queryCondition);

    public List<Duty> searchList(QueryParameter queryParameter);
}

