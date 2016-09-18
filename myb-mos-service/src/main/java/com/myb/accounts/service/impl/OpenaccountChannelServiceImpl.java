package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.OpenaccountChannelDao;
import com.myb.accounts.service.OpenaccountChannelService;
import com.myb.entity.pojo.mos.OpenaccountChannel;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("openaccountChannelService")
public class OpenaccountChannelServiceImpl implements OpenaccountChannelService{

    @Autowired
    private OpenaccountChannelDao openaccountChannelDao;

    public int insert(OpenaccountChannel openaccountChannel)
    {
        return openaccountChannelDao.insert(openaccountChannel);
    }
    public int update(OpenaccountChannel openaccountChannel)
    {
        return openaccountChannelDao.update(openaccountChannel);
    }

    public int delete(long id)
    {
        return openaccountChannelDao.delete(id);
    }

    public OpenaccountChannel searchById(long id) {
        return openaccountChannelDao.searchById(id);
    }
    public PagedList<OpenaccountChannel> searchByPage(QueryCondition queryCondition)
    {
        return openaccountChannelDao.searchByPage(queryCondition);
    }
    public List<OpenaccountChannel> searchList(QueryParameter queryParameter)
    {
        return openaccountChannelDao.searchList(queryParameter);
    }
}

