package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.ChannelInfo;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface ChannelInfoService {


    public int insert(ChannelInfo channelInfo);

    public int update(ChannelInfo channelInfo);

    public int delete(int channelId);

    public ChannelInfo searchByChannelId(int channelId);

    public PagedList<ChannelInfo> searchByPage(QueryCondition queryCondition);

    public List<ChannelInfo> searchList(QueryParameter queryParameter);
}

