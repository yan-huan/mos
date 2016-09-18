package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.OpenaccountChannel;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface OpenaccountChannelService {


    public int insert(OpenaccountChannel openaccountChannel);

    public int update(OpenaccountChannel openaccountChannel);

    public int delete(long id);

    public OpenaccountChannel searchById(long id);

    public PagedList<OpenaccountChannel> searchByPage(QueryCondition queryCondition);

    public List<OpenaccountChannel> searchList(QueryParameter queryParameter);
}

