package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.UpbosslogsDao;
import com.myb.accounts.service.UpbosslogsService;
import com.myb.entity.pojo.mos.Upbosslogs;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("upbosslogsService")
public class UpbosslogsServiceImpl implements UpbosslogsService{

    @Autowired
    private UpbosslogsDao upbosslogsDao;

    public int insert(Upbosslogs upbosslogs)
    {
        return upbosslogsDao.insert(upbosslogs);
    }
    public int update(Upbosslogs upbosslogs)
    {
        return upbosslogsDao.update(upbosslogs);
    }

    public int delete(int upBossId)
    {
        return upbosslogsDao.delete(upBossId);
    }

    public Upbosslogs searchByUpBossId(int upBossId) {
        return upbosslogsDao.searchByUpBossId(upBossId);
    }
    public PagedList<Upbosslogs> searchByPage(QueryCondition queryCondition)
    {
        return upbosslogsDao.searchByPage(queryCondition);
    }
    public List<Upbosslogs> searchList(QueryParameter queryParameter)
    {
        return upbosslogsDao.searchList(queryParameter);
    }
}

