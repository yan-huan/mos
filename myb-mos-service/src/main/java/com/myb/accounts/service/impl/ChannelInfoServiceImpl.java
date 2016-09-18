package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.ChannelInfoDao;
import com.myb.accounts.service.ChannelInfoService;
import com.myb.entity.pojo.mos.ChannelInfo;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("channelInfoService")
public class ChannelInfoServiceImpl implements ChannelInfoService{

    @Autowired
    private ChannelInfoDao channelInfoDao;

    public int insert(ChannelInfo channelInfo)
    {
        return channelInfoDao.insert(channelInfo);
    }
    public int update(ChannelInfo channelInfo)
    {
        return channelInfoDao.update(channelInfo);
    }

    public int delete(int channelId)
    {
        return channelInfoDao.delete(channelId);
    }

    public ChannelInfo searchByChannelId(int channelId) {
        return channelInfoDao.searchByChannelId(channelId);
    }
    public PagedList<ChannelInfo> searchByPage(QueryCondition queryCondition)
    {
        return channelInfoDao.searchByPage(queryCondition);
    }
    public List<ChannelInfo> searchList(QueryParameter queryParameter)
    {
        return channelInfoDao.searchList(queryParameter);
    }
}

