package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.RoleChild;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface RoleChildService {


    public int insert(RoleChild roleChild);

    public int update(RoleChild roleChild);

    public int delete(int childId);

    public RoleChild searchByChildId(int childId);

    public PagedList<RoleChild> searchByPage(QueryCondition queryCondition);

    public List<RoleChild> searchList(QueryParameter queryParameter);
}

